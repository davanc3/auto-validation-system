INSERT INTO `control_work` (`id`, `name`) VALUES (5, 'Контрольная работа № 2');
INSERT INTO `control_option` (`id`, `control_option`,`control_work_id`) VALUES (3, 1, 5);
INSERT INTO `control_option` (`id`, `control_option`,`control_work_id`) VALUES (4, 2, 5);
INSERT INTO `control_option` (`id`, `control_option`,`control_work_id`) VALUES (5, 3, 5);
INSERT INTO `control_option` (`id`, `control_option`,`control_work_id`) VALUES (6, 4, 5);
INSERT INTO `control_option` (`id`, `control_option`,`control_work_id`) VALUES (7, 5, 5);
INSERT INTO `control_option` (`id`, `control_option`,`control_work_id`) VALUES (8, 6, 5);
INSERT INTO `task_to_option` (`id`, `option_id`, `task_id`) VALUES (1, 3, 1);
INSERT INTO `task_to_option` (`id`, `option_id`, `task_id`) VALUES (2, 4, 1);
INSERT INTO `task_to_option` (`id`, `option_id`, `task_id`) VALUES (1, 5, 1);
INSERT INTO `task_to_option` (`id`, `option_id`, `task_id`) VALUES (2, 6, 1);
INSERT INTO `task_to_option` (`id`, `option_id`, `task_id`) VALUES (1, 7, 1);
INSERT INTO `task_to_option` (`id`, `option_id`, `task_id`) VALUES (2, 8, 1);
INSERT INTO `work_to_group` (`id`, `control_work_id`, `group_id`) VALUES (2, 5, 1);