package com.avs.autoValidationSystem.model.exceptions;

import com.avs.autoValidationSystem.model.dto.ErrorDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (JwtException ex) {
            ErrorDto errorResponse = new ErrorDto(HttpStatus.UNAUTHORIZED,ex.getMessage());
            response.setStatus(errorResponse.getHttpStatus().value());
            response.getWriter().write(convertObjectToJson(errorResponse));
        } catch (Exception e) {
            ErrorDto errorResponse = new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
            response.setStatus(errorResponse.getHttpStatus().value());
            response.getWriter().write(errorResponse.toString());
        }
    }
    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
