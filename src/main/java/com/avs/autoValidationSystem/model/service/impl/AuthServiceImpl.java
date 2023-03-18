package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.RegistrationDto;
import com.avs.autoValidationSystem.model.entity.Role;
import com.avs.autoValidationSystem.model.entity.User;
import com.avs.autoValidationSystem.model.repository.RoleRepository;
import com.avs.autoValidationSystem.model.repository.UserRepository;
import com.avs.autoValidationSystem.model.service.AuthService;
import com.avs.autoValidationSystem.model.service.UserService;
import com.avs.autoValidationSystem.security.jwt.JwtAuthentication;
import com.avs.autoValidationSystem.security.jwt.JwtRequest;
import com.avs.autoValidationSystem.security.jwt.JwtResponse;
import com.avs.autoValidationSystem.security.jwt.JwtProvider;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;
import java.util.*;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    // Todo убрать мапу (возможно на базуданных или redis)
    private final Map<String, String> refreshStorage = new HashMap<>();
    private final JwtProvider jwtProvider;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserService userService, JwtProvider jwtProvider, RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Сначала мы находим пользователя по логину в базе данных.
     * Если пользователь найден, и присланный пароль совпадает с паролем пользователя, то передаем объект пользователя в JwtProvider и получаем от него токены.
     * Далее сохраняем выданный рефреш токен в мапу refreshStorage и возвращаем объект JwtResponse с токенами.
     * @param authRequest - JwtRequest
     * @return JwtResponse
     * @throws AuthException пользователь не найден или неправильный пароль
     */
    @Override
    public JwtResponse login(JwtRequest authRequest) throws AuthException {
        final User user = userService.findByLogin(authRequest.getLogin())
                .orElseThrow(() -> new AuthException("Пользователь не найден"));
        if (passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            final String accessToken = jwtProvider.createToken(user.getLogin(), user.getRoles());
            final String refreshToken = jwtProvider.createRefreshToken(user.getLogin());
            refreshStorage.put(user.getLogin(), refreshToken);
            return new JwtResponse(accessToken, refreshToken);
        } else {
            throw new AuthException("Неправильный пароль");
        }
    }

    /**
     * Создание пользователя и добавление его базу данных.
     * Роль по умолчанию ставится ROLE_USER.
     * Время ставиться текущие через класс Date().
     * Производится проверка не занят логин и почта.
     *
     * @param user объект пользователя
     * @return вернет созданого пользователя
     */
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        user.setRoles(userRoles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    /**
     * Принимает refresh токен, а возвращает новый access токен.
     * Сначала мы проверяем, что присланный rehresh токен валиден.
     * Если валиден, то получаем claims и оттуда получаем логин пользователя.
     * Далее по логину находим выданный пользователю refresh токен в мапе refreshStorage, и сверяем его с присланным пользователем.
     * Если токены одинаковые, то получаем объект User, который отправляем в JwtProvider и получаем новый access токен, без обновления refresh токена.
     * @param refreshToken refresh токен
     * @return JwtResponse
     * @throws AuthException пользователь не найден
     */
    @Override
    public JwtResponse getAccessToken(String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final User user = userService.findByLogin(login)
                        .orElseThrow(() -> new AuthException("Пользователь не найден"));
                final String accessToken = jwtProvider.createToken(user.getLogin(),user.getRoles());
                return new JwtResponse(accessToken, null);
            }
        }
        return new JwtResponse(null, null);
    }

    /**
     * Обновление access и refresh token.
     * Допустимо только если был передан правильный accessToken.
     * @param refreshToken refresh token
     * @return новый access и refresh token
     * @throws AuthException Пльзователь не найден
     */
    @Override
    public JwtResponse refresh(String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final User user = userService.findByLogin(login)
                        .orElseThrow(() -> new AuthException("Пользователь не найден"));
                final String accessToken = jwtProvider.createToken(user.getLogin(),user.getRoles());
                final String newRefreshToken = jwtProvider.createRefreshToken(user.getLogin());
                refreshStorage.put(user.getLogin(), newRefreshToken);
                return new JwtResponse(accessToken, newRefreshToken);
            }
        }
        throw new AuthException("Невалидный JWT токен");
    }

    /**
     * Все идентифицированые пользователи
     * @return все идентифицированые пользователи
     */
    @Override
    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}
