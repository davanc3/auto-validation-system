package com.avs.autoValidationSystem.model.repository;

import com.avs.autoValidationSystem.model.entity.ResultWork;
import com.avs.autoValidationSystem.model.entity.UploadedWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultWorkRepository extends JpaRepository<ResultWork, Long> {
    ResultWork getResultWorkByUploadedWork(UploadedWork uploadedWork);

    ResultWork findFirstById(Long id);

}
