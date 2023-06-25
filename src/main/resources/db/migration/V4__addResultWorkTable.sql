CREATE TABLE result_work (
                       id BIGINT(19) NOT NULL AUTO_INCREMENT,
                       teacher_evaluation INT,
                       compilation BIT,
                       byte_leak int,
                       allocations INT,
                       uploaded_work_id BIGINT(19),
                       PRIMARY KEY (`id`) USING BTREE,
                       INDEX `FK_resultWork_uploadedWork` (`uploaded_work_id`) USING BTREE,
                       CONSTRAINT `FK_resultWork_uploadedWork` FOREIGN KEY (`uploaded_work_id`) REFERENCES `uploaded_work` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION

)
    COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB
;
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,2);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,3);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,4);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,5);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,6);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,7);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,9);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,1,120,1,10);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,13);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,1,0,0,11);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,1,0,0,17);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,12);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,1,0,0,18);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,14);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,19);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,20);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,16);
INSERT INTO `result_work` (`teacher_evaluation`,`compilation`,`byte_leak`,`allocations`,`uploaded_work_id`) VALUES (null,0,0,0,21);