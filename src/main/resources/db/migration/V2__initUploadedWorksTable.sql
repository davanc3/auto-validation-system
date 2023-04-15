CREATE TABLE uploaded_work (
                                 id BIGINT(19) NOT NULL AUTO_INCREMENT,
                                 student_id BIGINT(19) NOT NULL,
                                 control_work_id BIGINT(19) NOT NULL,
                                 control_option_id BIGINT(19) NOT NULL,
                                 task_id BIGINT(19) NOT NULL,
                                 load_date_time TIMESTAMP NULL DEFAULT NULL,
                                 PRIMARY KEY (id) USING BTREE,
                                 INDEX FK_student_to_work_student123 (student_id) USING BTREE,
                                 INDEX FK_student_to_work_control_work (control_work_id) USING BTREE,
                                 INDEX FK_student_to_work_control_option (control_option_id) USING BTREE,
                                 INDEX FK_student_to_work_task (task_id) USING BTREE,
                                 CONSTRAINT FK_student_to_work_control_option FOREIGN KEY (control_option_id) REFERENCES control_option (id) ON UPDATE NO ACTION ON DELETE NO ACTION,
                                 CONSTRAINT FK_student_to_work_control_work FOREIGN KEY (control_work_id) REFERENCES control_work (id) ON UPDATE NO ACTION ON DELETE NO ACTION,
                                 CONSTRAINT FK_student_to_work_student123 FOREIGN KEY (student_id) REFERENCES student (id) ON UPDATE NO ACTION ON DELETE NO ACTION,
                                 CONSTRAINT FK_student_to_work_task FOREIGN KEY (task_id) REFERENCES task (id) ON UPDATE NO ACTION ON DELETE NO ACTION
)
    COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB
;

CREATE TABLE uploaded_file (
                               id BIGINT(19) NOT NULL AUTO_INCREMENT,
                               file_name VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
                               upload_path VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
                               uploaded_file_id BIGINT(19) NOT NULL,
                               PRIMARY KEY (id) USING BTREE,
                               INDEX FK_uploaded_work_to_file (uploaded_file_id) USING BTREE,
                               CONSTRAINT FK_uploaded_work_to_file FOREIGN KEY (uploaded_file_id) REFERENCES uploaded_work (id) ON UPDATE NO ACTION ON DELETE NO ACTION
)
    COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB
;
