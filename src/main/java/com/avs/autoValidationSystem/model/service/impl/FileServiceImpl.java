package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.ArchiveFilterDto;
import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.UploadWorkDto;
import com.avs.autoValidationSystem.model.entity.*;
import com.avs.autoValidationSystem.model.repository.*;
import com.avs.autoValidationSystem.model.service.FileService;

import com.avs.autoValidationSystem.model.service.StudentsService;
import com.avs.autoValidationSystem.model.utils.ArchiveCreator;
import com.avs.autoValidationSystem.model.utils.Translator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.io.File;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class FileServiceImpl implements FileService {
    @Value("${path.workUploadFile}")
    private String rootPath;
    private final StudentRepository studentRepository;
    private final OptionRepository optionRepository;
    private final ControlWorkRepository controlWorkRepository;
    private final UploadedWorkRepository uploadedWorkRepository;
    private final TaskRepository taskRepository;
    private final GroupRepository groupRepository;
    private final StudentsService studentsService;
    private final UploadedFileRepository uploadedFileRepository;

    public FileServiceImpl(StudentRepository studentRepository, OptionRepository optionRepository, ControlWorkRepository controlWorkRepository, UploadedWorkRepository uploadedWorkRepository, TaskRepository taskRepository, GroupRepository groupRepository, StudentsService studentsService, UploadedFileRepository uploadedFileRepository) {
        this.studentRepository = studentRepository;
        this.optionRepository = optionRepository;
        this.controlWorkRepository = controlWorkRepository;
        this.uploadedWorkRepository = uploadedWorkRepository;
        this.taskRepository = taskRepository;
        this.groupRepository = groupRepository;
        this.studentsService = studentsService;
        this.uploadedFileRepository = uploadedFileRepository;
    }

    @Override
    public void uploadWork(UploadWorkDto uploadWorkDto) throws IOException {
        Student student = studentsService.getStudentByFio(uploadWorkDto.getStudent());
        ControlWork controlWork = controlWorkRepository.findFirstByName(uploadWorkDto.getWork());
        Option option = optionRepository.findFirstByOptionAndControlWorks(uploadWorkDto.getOption(),controlWork);
        Task task = taskRepository.findFirstByName(uploadWorkDto.getTask());
        if (student == null || option == null || controlWork == null || task == null) {
            throw new IllegalArgumentException("В запросе переданы некорректные информационные данные");
        }

        String directorySaveFiles = rootPath +
                "/" + uploadWorkDto.getGroup() +
                "/" + uploadWorkDto.getWork() +
                "/" + uploadWorkDto.getStudent();
        String directorySaveFilesLatin = Translator.convertCyrToLat(directorySaveFiles);

        new File(directorySaveFilesLatin).mkdirs();

        MultipartFile[] files = uploadWorkDto.getFiles();

        UploadedWork uploadedWork = new UploadedWork();
        uploadedWork.setControlWork(controlWork);
        uploadedWork.setOption(option);
        uploadedWork.setStudent(student);
        uploadedWork.setTask(task);
        uploadedWork.setLoadDateTime(OffsetDateTime.now());

        //todo подумать над try catch пользователь не получет сообщение об ошибке
        try {
            uploadedWork = uploadedWorkRepository.save(uploadedWork);
        } catch (InvalidDataAccessResourceUsageException e) {
            e.printStackTrace();
        }
        for (MultipartFile multipartFile : files) {
            String uploadPath = saveFile(directorySaveFilesLatin, multipartFile);
            UploadedFile uploadedFile = new UploadedFile();
            uploadedFile.setUploadPath(uploadPath);
            uploadedFile.setFileName(multipartFile.getOriginalFilename());
            uploadedFile.setUploadedWork(uploadedWork);
            uploadedFileRepository.save(uploadedFile);
        }
    }

    @Override
    public void uploadValidateResult(MultipartFile file) throws IOException {
        String directorySaveFiles = rootPath
                + "/validateResult--"
                + OffsetDateTime.now().toString().replaceAll(":", "\\.");
        File directory = new File(directorySaveFiles);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        saveFile(directorySaveFiles, file);
    }

    private String saveFile(String fileDirectoryPath, MultipartFile file) throws IOException {
        String uploadPath = fileDirectoryPath + "/" + file.getOriginalFilename();
        File convFile = new File(uploadPath);
        file.transferTo(convFile);

        return uploadPath;
    }

    @Override
    public String getArchivePathByFilter(ArchiveFilterDto filterDto) throws IOException {

        String archivePath = "";

        if (filterDto.getGroup() != null) {
            StudyGroup studyGroup = groupRepository.findFirstByName(filterDto.getGroup());
            List<UploadedWork> uploadedFiles = uploadedWorkRepository.findAllByStudents(studyGroup.getStudents());

            archivePath = Translator.convertCyrToLat(filterDto.getGroup()) + "_" +
                    OffsetDateTime.now().toString().replaceAll(":", "\\.")  + ".tar.gz";

            ArchiveCreator.createArchiveToGroup(archivePath, uploadedFiles, filterDto.getGroup());


        } else if (filterDto.getStudent() != null) {
            String[] studentFio = filterDto.getStudent().split(" ");

            Student student = studentRepository.findFirstByLastNameAndNameAndSurname(studentFio[0], studentFio[1], studentFio[2]);

            List<Student> students = new ArrayList<>();
            students.add(student);

            List<UploadedWork> uploadedFiles = uploadedWorkRepository.findAllByStudents(students);

            archivePath = Translator.convertCyrToLat(filterDto.getStudent()) + "_" +
                    OffsetDateTime.now().toString().replaceAll(":", "\\.") + ".tar.gz";
            ArchiveCreator.createArchiveToStudent(archivePath, uploadedFiles);
        }

        return archivePath;
    }

    @Override
    public File getFileById(long id) {
        UploadedFile uploadedFile = uploadedFileRepository.findById(id);

        return new File(uploadedFile.getUploadPath());
    }
}
