package com.avs.autoValidationSystem.model.utils;

import com.avs.autoValidationSystem.model.entity.UploadedFile;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.UploadedWork;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArchiveCreator {
    public static void createArchiveToGroup(String archivePath, List<UploadedWork> uploadedWorks, String studyGroup) throws IOException {
        // Создаем архив
        FileOutputStream fos = new FileOutputStream(archivePath);
        ZipOutputStream zos = new ZipOutputStream(fos);

        // Добавляем файлы в новую структуру папок
        for (UploadedWork uploadedWork : uploadedWorks) {
            for (UploadedFile uploadedFile : uploadedWork.getUploadedFiles()) {
                String filePath = uploadedFile.getUploadPath();
                if (filePath == null) {
                    continue;
                }
                String[] filePathArray = filePath.split("/");

                addFileToZip(zos, uploadedFile.getUploadPath(),
                        Translator.convertCyrToLat(studyGroup) + "/" +
                                Translator.convertCyrToLat(uploadedWork.getControlWork().getName()) + "/" +
                                uploadedWork.getOption().getOption() + "/" +
                                uploadedWork.getStudent().getLastName() + "_" +
                                uploadedWork.getStudent().getName() + "_" +
                                uploadedWork.getStudent().getSurname() + "/" +
                                uploadedWork.getTask().getName() + "/" +
                                filePathArray[filePathArray.length - 1]);
            }
        }

        // Закрываем архив
        zos.close();
        fos.close();
    }

    public static void createArchiveToStudent(String archivePath, List<UploadedWork> uploadedWorks) throws IOException {
        // Создаем архив
        FileOutputStream fos = new FileOutputStream(archivePath);
        ZipOutputStream zos = new ZipOutputStream(fos);

        // Добавляем файлы в новую структуру папок
        for (UploadedWork uploadedWork : uploadedWorks) {
            Student student = uploadedWork.getStudent();
            for (UploadedFile uploadedFile : uploadedWork.getUploadedFiles()) {
                String filePath = uploadedFile.getUploadPath();
                if (filePath == null) {
                    continue;
                }
                String[] filePathArray = filePath.split("/");
                addFileToZip(zos, uploadedFile.getUploadPath(),
                                Translator.convertCyrToLat(student.getLastName() + " "
                                        + student.getName() + " "
                                        + student.getSurname()) + "/" +
                                        Translator.convertCyrToLat(uploadedWork.getControlWork().getName()) + "/" +
                filePathArray[filePathArray.length - 1]);
            }
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
