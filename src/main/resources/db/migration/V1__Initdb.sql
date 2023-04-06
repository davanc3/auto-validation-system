CREATE TABLE `control_work` (
                                `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                                `name` VARCHAR(25) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
                                PRIMARY KEY (`id`) USING BTREE
)
    COLLATE='utf8mb4_unicode_ci'
    ENGINE=InnoDB
    AUTO_INCREMENT=4
;

INSERT INTO `control_work` (`id`, `name`) VALUES (4, 'Контрольная работа № 1');

CREATE TABLE `control_option` (
                                  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                                  `control_option` INT(10) NULL DEFAULT NULL,
                                  `control_work_id` BIGINT(19) NULL DEFAULT NULL,
                                      PRIMARY KEY (`id`) USING BTREE,
                                      CONSTRAINT `FK__control_work234` FOREIGN KEY (`control_work_id`) REFERENCES `control_work` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
    COLLATE='utf8mb4_unicode_ci'
    ENGINE=InnoDB
    AUTO_INCREMENT=4
;

INSERT INTO `control_option` (`id`, `control_option`,`control_work_id`) VALUES (1, 1, 4);
INSERT INTO `control_option` (`id`, `control_option`,`control_work_id`) VALUES (2, 2, 4);
INSERT INTO `control_option` (`id`, `control_option`,`control_work_id`) VALUES (3, 3, 4);


CREATE TABLE `role` (
                        `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                        `name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
                        PRIMARY KEY (`id`) USING BTREE
)
    COLLATE='utf8mb4_unicode_ci'
    ENGINE=InnoDB
    AUTO_INCREMENT=2
;

INSERT INTO `role` (`id`, `name`) VALUES (1, 'ROLE_USER');
INSERT INTO `role` (`id`, `name`) VALUES (2, 'ROLE_ADMIN');

CREATE TABLE `study_group` (
                               `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                               `name` VARCHAR(15) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
                               PRIMARY KEY (`id`) USING BTREE
)
    COLLATE='utf8mb4_unicode_ci'
    ENGINE=InnoDB
    AUTO_INCREMENT=4
;

INSERT INTO `study_group` (`id`, `name`) VALUES (1, 'ПИН-13');

CREATE TABLE `student` (
                           `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                           `name` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
                           `surname` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
                           `last_name` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
                           `study_group_id` BIGINT(19) NULL DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE,
                           INDEX `FK_student_group` (`study_group_id`) USING BTREE,
                           CONSTRAINT `FK_student_group` FOREIGN KEY (`study_group_id`) REFERENCES `study_group` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
    COLLATE='utf8mb4_unicode_ci'
    ENGINE=InnoDB
    AUTO_INCREMENT=3
;

INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (1, 'Кирилл', 'Алексеевич', 'Антонов', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (2, 'Эмин', 'Эльбрусович', 'Асланов', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (3, 'Руслан', 'Алексеевич', 'Батталов', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (4, 'Илья', 'Николаевич', 'Бех', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (5, 'Пётр', 'Иванович', 'Василенко', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (6, 'Дмитрий', 'Сергеевич', 'Голубев', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (7, 'Тимофей', 'Валерьевич', 'Ермаков', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (8, 'Иван', 'Сергеевич', 'Ершов', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (9, 'Саида', 'Магомедовна', 'Жанатаева', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (10, 'Иван', 'Александрович', 'Заводов', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (11, 'Алексей', 'Константинович', 'Зотенко', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (12, 'Степан', 'Владимирович', 'Ковальчук', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (13, 'Елизавета', 'Владимировна', 'Костоусова', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (14, 'Артём', 'Владимирович', 'Крупенькин', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (15, 'Илья', 'Алексеевич', 'Куликов', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (16, 'Данил', 'Александрович', 'Малахов', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (17, 'Вадим', 'Вадимович', 'Малюга', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (18, 'Зураб', 'Борисович', 'Минахи', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (19, 'Андрей', 'Романович', 'Морозович', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (20, 'Руслан', 'Александрович', 'Новиков', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (21, 'Иван', 'Вячеславович', 'Носков', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (22, 'Саид-Хусен', 'Саидович', 'Садаев', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (23, 'Шарлит', 'Евгеньевна', 'Самойлова', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (24, 'Александр', 'Кириллович', 'Самохин', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (25, 'Евгений', NULL, 'Стратьев', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (26, 'Степан', 'Евгеньевич', 'Титов', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (27, 'Анастасия', 'Андреевна', 'Тихонова', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (28, 'Андрей', 'Сергеевич', 'Уткин', 1);
INSERT INTO `student` (`id`, `name`, `surname`, `last_name`, `study_group_id`) VALUES (29, 'Евгений', 'Андреевич', 'Федотов', 1);

CREATE TABLE `student_to_work` (
                                   `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                                   `student_id` BIGINT(19) NOT NULL,
                                   `control_work_id` BIGINT(19) NOT NULL,
                                   `control_option_id` BIGINT(19) NOT NULL,
                                   `upload_path` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
                                   PRIMARY KEY (`id`) USING BTREE,
                                   INDEX `FK_student_to_work_student123` (`student_id`) USING BTREE,
                                   INDEX `FK_student_to_work_control_work` (`control_work_id`) USING BTREE,
                                   INDEX `FK_student_to_work_control_option` (`control_option_id`) USING BTREE,
                                   CONSTRAINT `FK_student_to_work_control_option` FOREIGN KEY (`control_option_id`) REFERENCES `control_option` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
                                   CONSTRAINT `FK_student_to_work_control_work` FOREIGN KEY (`control_work_id`) REFERENCES `control_work` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
                                   CONSTRAINT `FK_student_to_work_student123` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
    COLLATE='utf8mb4_unicode_ci'
    ENGINE=InnoDB
    AUTO_INCREMENT=7
;

CREATE TABLE `task` (
                        `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                        `name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
                        PRIMARY KEY (`id`) USING BTREE
)
    COLLATE='utf8mb4_unicode_ci'
    ENGINE=InnoDB
;

INSERT INTO `task` (`id`, `name`) VALUES (1, 'Задание 1');

CREATE TABLE `task_to_option` (
                                  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                                  `option_id` BIGINT(19) NOT NULL,
                                  `task_id` BIGINT(19) NOT NULL,
                                  PRIMARY KEY (`id`) USING BTREE,
                                  INDEX `FK__control_option` (`option_id`) USING BTREE,
                                  INDEX `FK__task` (`task_id`) USING BTREE,
                                  CONSTRAINT `FK__control_option` FOREIGN KEY (`option_id`) REFERENCES `control_option` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
                                  CONSTRAINT `FK__task` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
    COLLATE='utf8mb4_unicode_ci'
    ENGINE=InnoDB
;

INSERT INTO `task_to_option` (`id`, `option_id`, `task_id`) VALUES (1, 1, 1);
INSERT INTO `task_to_option` (`id`, `option_id`, `task_id`) VALUES (2, 2, 1);

CREATE TABLE `user` (
                        `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                        `login` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
                        `password` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
                        PRIMARY KEY (`id`) USING BTREE
)
    COLLATE='utf8mb4_unicode_ci'
    ENGINE=InnoDB
    AUTO_INCREMENT=4
;

CREATE TABLE `users_roles` (
                               `user_id` BIGINT(19) NOT NULL,
                               `role_id` BIGINT(19) NOT NULL,
                               INDEX `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`) USING BTREE,
                               INDEX `FKgd3iendaoyh04b95ykqise6qh` (`user_id`) USING BTREE,
                               CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
                               CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
    COLLATE='utf8mb4_unicode_ci'
    ENGINE=InnoDB
;

CREATE TABLE `work_to_group` (
                                 `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                                 `control_work_id` BIGINT(19) NOT NULL,
                                 `group_id` BIGINT(19) NOT NULL,
                                 PRIMARY KEY (`id`) USING BTREE,
                                 INDEX `FK__control_work1` (`control_work_id`) USING BTREE,
                                 INDEX `FK__group` (`group_id`) USING BTREE,
                                 CONSTRAINT `FK__control_work1` FOREIGN KEY (`control_work_id`) REFERENCES `control_work` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
                                 CONSTRAINT `FK__group` FOREIGN KEY (`group_id`) REFERENCES `study_group` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
    COLLATE='utf8mb4_unicode_ci'
    ENGINE=InnoDB
;

INSERT INTO `work_to_group` (`id`, `control_work_id`, `group_id`) VALUES (1, 4, 1);
