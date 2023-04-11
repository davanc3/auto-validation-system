package com.avs.autoValidationSystem.model.utils;

import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.StudentToWork;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArchiveCreator {
    public static void createArchiveToGroup(String archivePath, List<StudentToWork> studentToWorks, String studyGroup) throws IOException {
        // Создаем архив
        FileOutputStream fos = new FileOutputStream(archivePath);
        ZipOutputStream zos = new ZipOutputStream(fos);

        // Добавляем файлы в новую структуру папок
        for (StudentToWork studentToWork: studentToWorks) {
            String filePath = studentToWork.getUploadPath();
            if (filePath == null) {
                continue;
            }
            String[] filePathArray = filePath.split("/");

            addFileToZip(zos, studentToWork.getUploadPath(),
                    Translator.convertCyrToLat(studyGroup) + "/" +
                            Translator.convertCyrToLat(studentToWork.getControlWork().getName()) + "/" +
                            studentToWork.getOption().getOption() + "/" +
                            studentToWork.getStudent().getLastName() + "_" +
                            studentToWork.getStudent().getName() + "_" +
                            studentToWork.getStudent().getSurname() + "/" +
                            studentToWork.getTask().getName() + "/" +
                    filePathArray[filePathArray.length - 1]);
        }

        // Закрываем архив
        zos.close();
        fos.close();
    }

    public static void createArchiveToStudent(String archivePath, List<StudentToWork> studentToWorks) throws IOException {
        // Создаем архив
        FileOutputStream fos = new FileOutputStream(archivePath);
        ZipOutputStream zos = new ZipOutputStream(fos);

        // Добавляем файлы в новую структуру папок
        for (StudentToWork studentToWork: studentToWorks) {
            String filePath = studentToWork.getUploadPath();
            if (filePath == null) {
                continue;
            }
            String[] filePathArray = filePath.split("/");

            Student student = studentToWork.getStudent();

            addFileToZip(zos, studentToWork.getUploadPath(),
                    Translator.convertCyrToLat(student.getLastName() + " "
                            + student.getName() + " "
                            + student.getSurname()) + "/" +
                            Translator.convertCyrToLat(studentToWork.getControlWork().getName()) + "/" +
                            filePathArray[filePathArray.length - 1]);
        }

        // Закрываем архив
        zos.close();
        fos.close();
    }

    private static void addFileToZip(ZipOutputStream zos, String filePath, String zipPath) throws IOException {
        byte[] buffer = new byte[1024];

        // Создаем новый элемент архива и добавляем его в архив


        // Читаем файл и записываем его содержимое в архив

        FileInputStream fis = null;
        ZipEntry ze = new ZipEntry(zipPath);
        try {
            zos.putNextEntry(ze);
            fis = new FileInputStream(filePath);
            int len;
            while ((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            fis.close();
            zos.closeEntry();
        } catch (IOException e) {
            //System.out.println(e.getMessage());
        }
    }
}
