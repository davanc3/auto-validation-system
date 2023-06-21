package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.impl.reviewWork.FileTreeDto;
import com.avs.autoValidationSystem.model.dto.impl.reviewWork.TreeDto;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.StudyGroup;
import com.avs.autoValidationSystem.model.entity.UploadedFile;
import com.avs.autoValidationSystem.model.entity.UploadedWork;
import com.avs.autoValidationSystem.model.repository.GroupRepository;
import com.avs.autoValidationSystem.model.service.GroupService;
import com.sun.source.tree.Tree;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<StudyGroup> getAllGroups() {
        return groupRepository.findAll(Sort.by("name"));
    }
    
    @Override
    public List<TreeDto> getWorksTree() {
        List<TreeDto> worksTreeDtoList = new ArrayList<>();
        List<StudyGroup> studyGroups = groupRepository.findAll();
        for (StudyGroup group: studyGroups) {
            TreeDto groupTree = new TreeDto();
            groupTree.setName(group.getName());
            List<Student> students = group.getStudents();
            if (!students.isEmpty()) {
                for (Student student: students) {
                    TreeDto studentTree = new TreeDto();
                    studentTree.setName(student.getFio());
                    List<UploadedWork> uploadedWorks = student.getUploadedWorks();
                    if (!uploadedWorks.isEmpty()) {
                        for (UploadedWork uploadedWork: uploadedWorks) {
                            TreeDto workTree = new TreeDto();
                            workTree.setName(uploadedWork.getControlWork().getName());
                            List<UploadedFile> uploadedFiles = uploadedWork.getUploadedFiles();
                            if (!uploadedFiles.isEmpty()) {
                                for (UploadedFile uploadedFile: uploadedFiles) {
                                    FileTreeDto fileTree = new FileTreeDto();
                                    fileTree.setChildren(null);
                                    fileTree.setName(uploadedFile.getFileName());
                                    fileTree.setFileId(uploadedFile.getId());
                                    workTree.pushChildren(fileTree);
                                }
                            }
                            studentTree.pushChildren(workTree);
                        }
                    }
                    groupTree.pushChildren(studentTree);
                }
            }
            worksTreeDtoList.add(groupTree);
        }
        return worksTreeDtoList;
    }

}
