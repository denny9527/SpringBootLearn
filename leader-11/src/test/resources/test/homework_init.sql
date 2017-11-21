DELETE FROM  `group_members`;
DELETE FROM `group_authorities`;
DELETE FROM `authorities`;
DELETE FROM `users`;
DELETE FROM `groups`;
INSERT INTO `users`(username, password, enabled) VALUES ('zhangkui', '123456', 1);
INSERT INTO `users`(username, password, enabled) VALUES ('wangming', '234567', 1);
INSERT INTO `groups`(group_name) VALUES('admin_group');
INSERT INTO `group_members`(username, group_id) VALUES ('zhangkui', (select id from `groups` where group_name = 'admin_group'));
INSERT INTO `group_members`(username, group_id) VALUES ('wangming', (select id from `groups` where group_name = 'admin_group'));
INSERT INTO `group_authorities`(group_id, authority) VALUES ((select id from `groups` where group_name = 'admin_group'), 'manager');
INSERT INTO `group_authorities`(group_id, authority) VALUES ((select id from `groups` where group_name = 'admin_group'), 'op_createuser');

INSERT INTO `groups`(group_name) VALUES('user_group');
INSERT INTO `group_members`(username, group_id) VALUES ('zhangkui', (select id from `groups` where group_name = 'user_group'));
INSERT INTO `group_members`(username, group_id) VALUES ('wangming', (select id from `groups` where group_name = 'user_group'));
INSERT INTO `group_authorities`(group_id, authority) VALUES ((select id from `groups` where group_name = 'user_group'), 'user');
commit;