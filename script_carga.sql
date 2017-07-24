INSERT INTO `mydb`.`tb_user` (`id`, `username`, `name`, `email`, `password`, `enabled`) VALUES ('1', 'admin', 'Administrator', 'admin@admin', '$2a$10$zA5oWqydScu4h2.Le7hfXeV5hJlKT0c4J5yGEjJslcoo5Ct3TBl/O', '1');

INSERT INTO `mydb`.`tb_role` (`id`, `name`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `mydb`.`tb_role` (`id`, `name`) VALUES ('2', 'ROLE_USER');
INSERT INTO `mydb`.`tb_user_role` (`id`, `user_id`, `role_id`) VALUES ('1', '1', '1');

SET GLOBAL max_allowed_packet=1073741824;