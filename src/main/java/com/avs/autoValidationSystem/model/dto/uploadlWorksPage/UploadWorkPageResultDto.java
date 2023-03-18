package com.avs.autoValidationSystem.model.dto.uploadlWorksPage;

import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.Group;
import com.avs.autoValidationSystem.model.entity.Option;
import com.avs.autoValidationSystem.model.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class UploadWorkPageResultDto {
    private List<ControlWork> controlWorks;
    private List<Group> groups;
    private List<Option> options;
    private List<Student> students;

    public UploadWorkPageResultDto() {
    }
}
