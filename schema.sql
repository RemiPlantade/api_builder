BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `api_user_perm` (
	`selection`	Bool,
	`deletion`	Bool,
	`creation`	Bool,
	`updating`	Bool,
	`api_user`	Int NOT NULL,
	`api_bean`	Int NOT NULL,
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	FOREIGN KEY(`api_bean`) REFERENCES `api_bean`(`id`),
	FOREIGN KEY(`api_user`) REFERENCES `api_user`(`id`)
);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (0,0,1,0,32,1,84);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (0,0,1,0,32,2,85);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (0,0,1,0,32,3,86);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (0,0,1,0,32,4,87);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (0,0,0,0,32,5,88);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (0,0,0,0,32,6,89);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,33,1,90);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,33,2,91);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,33,3,92);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,33,4,93);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,33,5,94);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,33,6,95);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,34,1,96);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,34,2,97);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,34,3,98);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,34,4,99);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,34,5,100);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,34,6,101);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,35,1,102);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,35,2,103);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,35,3,104);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,35,4,105);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,35,5,106);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,35,6,107);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,36,1,108);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,36,2,109);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,36,3,110);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,36,4,111);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,36,5,112);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,36,6,113);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,37,1,114);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,37,2,115);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,37,3,116);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,37,4,117);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,37,5,118);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,37,6,119);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,38,1,120);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,38,2,121);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,38,3,122);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,38,4,123);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,38,5,124);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,38,6,125);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,39,1,126);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,39,2,127);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,39,3,128);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,39,4,129);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,39,5,130);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,39,6,131);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,40,1,132);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,40,2,133);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,40,3,134);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,40,4,135);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,40,5,136);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,40,6,137);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,41,1,138);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,41,2,139);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,41,3,140);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,41,4,141);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,41,5,142);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,41,6,143);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,42,1,144);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,42,2,145);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,42,3,146);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,42,4,147);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,42,5,148);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,42,6,149);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,43,1,150);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,43,2,151);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,43,3,152);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,43,4,153);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,43,5,154);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,43,6,155);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,44,1,156);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,44,2,157);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,44,3,158);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,44,4,159);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,44,5,160);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,44,6,161);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,45,1,162);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,45,2,163);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,45,3,164);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,45,4,165);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,45,5,166);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,45,6,167);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,47,1,168);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,47,2,169);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,47,3,170);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,47,4,171);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,47,5,172);
INSERT INTO `api_user_perm` (selection,deletion,creation,updating,api_user,api_bean,id) VALUES (1,1,1,1,47,6,173);
CREATE TABLE IF NOT EXISTS `api_user` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`username`	Varchar ( 255 ) UNIQUE,
	`mail`	Varchar ( 255 ),
	`token`	Varchar ( 255 ) UNIQUE,
	`maxquota`	NUMERIC,
	`actquota`	NUMERIC,
	`idgroup`	Int,
	FOREIGN KEY(`idgroup`) REFERENCES `api_group`(`id`)
);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (32,'fhnghhjjhfg','d0r3mu5@gmail.com','46e0dafea33d3d27',0,0,10);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (33,'lmmlmlk','sdfsdf@sdf.com','1168ab814a1294be',0,20,9);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (34,'Test','d0r3mu5@gmail.com','4093b2919879b17',0,20,9);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (35,'Test2','d0r3mu5@gmail.com','dfc1ceadd43515d',0,20,NULL);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (36,'Test44','d0r3mu5@gmail.com','119c65002cf23ef',0,20,NULL);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (37,'Test4','d0r3mu5@gmail.com','66b7e02b11737f7a',0,20,NULL);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (38,'Test5','d0r3mu5@gmail.com','55ac944c395d54f8',0,20,NULL);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (39,'Test6','d0r3mu5@gmail.com','47cd6bbafbcda652',0,20,NULL);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (40,'Test7','d0r3mu5@gmail.com','3739f5bc44bbb61',0,20,NULL);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (41,'ssdfsdfsdf','d0r3mu5@gmail.com','172074f6e42c338f',0,20,NULL);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (42,'sdfsdfsdf','d0r3mu5@gmail.com','ba4c483d2ba8f7b',0,20,NULL);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (43,'AnusDus','d0r3mu5@gmail.com','5dce6bb65c1004b9',666,20,NULL);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (44,'Bite','d0r3mu5@gmail.com','16fd2fa7f69c45af',0,20,NULL);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (45,'Test222','d0r3mu5@gmail.com','6d3246bbe0f431f0',0,20,10);
INSERT INTO `api_user` (id,username,mail,token,maxquota,actquota,idgroup) VALUES (47,'QuotaUser','d0r3mu5@gmail.com','2249b3b2a769938f',123,99,9);
CREATE TABLE IF NOT EXISTS `api_group_perm` (
	`selection`	Bool,
	`deletion`	Bool,
	`creation`	Bool,
	`updating`	Bool,
	`api_group`	Int NOT NULL,
	`api_bean`	Int NOT NULL,
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	FOREIGN KEY(`api_bean`) REFERENCES `api_bean`(`id`),
	FOREIGN KEY(`api_group`) REFERENCES `api_group`(`id`)
);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,0,1,0,9,1,13);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,0,1,0,9,2,14);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,0,1,0,9,3,15);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,0,1,0,9,4,16);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,0,1,0,9,5,17);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,0,1,0,9,6,18);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,1,1,1,10,1,19);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,1,1,1,10,2,20);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,1,1,1,10,3,21);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,1,1,1,10,4,22);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,1,1,1,10,5,23);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,1,1,1,10,6,24);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,1,1,1,11,1,25);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,1,1,1,11,2,26);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,1,1,1,11,3,27);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,1,1,1,11,4,28);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,1,1,1,11,5,29);
INSERT INTO `api_group_perm` (selection,deletion,creation,updating,api_group,api_bean,id) VALUES (1,1,1,1,11,6,30);
CREATE TABLE IF NOT EXISTS `api_group` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`name`	Varchar ( 255 ) UNIQUE
);
INSERT INTO `api_group` (id,name) VALUES (9,'Default');
INSERT INTO `api_group` (id,name) VALUES (10,'GroupYo');
INSERT INTO `api_group` (id,name) VALUES (11,'Test');
CREATE TABLE IF NOT EXISTS `api_conf` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`param_name`	TEXT NOT NULL UNIQUE,
	`param_value`	NUMERIC NOT NULL,
	`param_type`	NUMERIC NOT NULL,
	`param_key`	TEXT NOT NULL UNIQUE,
	`modifiable`	Bool NOT NULL,
	`param_category`	TEXT NOT NULL,
	`added`	Bool
);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (1,'Admin username','admin','text','api.admin.username',1,'security',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (2,'Admin password','admin','text','api.admin.password',1,'security',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (3,'Server Port',8080,'number','server.port',0,'general',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (4,'Quota management','true','boolean','api.quota.managed',1,'general',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (6,'API datasource URL','jdbc:mysql://localhost:3306/api_builder','text','spring.api.url',1,'datasource',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (7,'API Driver class name','com.mysql.jdbc.Driver','text','spring.api.driver-class-name',1,'datasource',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (8,'API Datasource username','root','text','spring.api.username',1,'datasource',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (9,'Api Datasource password','D0r3Mu52012','text','spring.api.password',1,'datasource',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (10,'Web server max wait',20000,'number','spring.api.tomcat.max-wait',1,'web_server',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (11,'Web server max connection number',50,'number','spring.api.tomcat.max-active',1,'web_server',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (12,'Web server max idle',20,'number','spring.api.tomcat.max-idle',1,'web_server',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (13,'Web server min idle',15,'number','spring.api.tomcat.min-idle',1,'web_server',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (14,'Api Hibernate Dialect','org.hibernate.dialect.MySQLDialect','text','spring.api.jpa.properties.hibernate.dialect',1,'datasource',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (15,'Force HTTPS','false','boolean','security.require-ssl',1,'security',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (16,'Conf Datasource URL','jdbc:sqlite:src/main/resources/test.db','text','spring.conf.url',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (17,'Conf Datasource Driver','org.sqlite.JDBC','text','spring.conf.driver-class-name',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (18,'Conf Hibernate Dialect','org.hibernate.dialect.SQLiteDialect','text','spring.conf.jpa.properties.hibernate.dialect',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (19,'Conf Hibernate Mode','update','text','spring.conf.jpa.hibernate.ddl-auto',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (20,'Conf Show SQL','true','boolean','spring.conf.jpa.show-sql',0,'general',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (21,'Thymeleaf prefix','classpath:/templates/','text','spring.thymeleaf.prefix',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (22,'Thymeleaf check Template','true','boolean','spring.thymeleaf.check-template',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (23,'Thymeleaf check Template location','true','boolean','spring.thymeleaf.check-template-location',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (24,'Thymeleaf suffix','.html','text','spring.thymeleaf.suffix',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (25,'Thymeleaf enabled','true','boolean','spring.thymeleaf.enabled',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (26,'Thymeleaf mode','HTML','text','spring.thymeleaf.mode',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (27,'Thymeleaf cache','false','boolean','spring.thymeleaf.cache',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (28,'Hibernate id mapping generation','false','text','spring.jpa.properties.hibernate.id.new_generator_mappings',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (29,'Hibernate Format SQL','true','boolean','spring.jpa.properties.hibernate.format_sql',0,'general',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (30,'Jackson FAIL ON EMPTY BEAN','false','boolean','spring.jackson.serialization.FAIL_ON_EMPTY_BEANS',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (31,'Jackson Serialization Inclusion','non_null','text','spring.jackson.serialization-inclusion',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (32,'Security Enabled','true','boolean','security.basic.enabled',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (33,'Management Security Enabled','false','boolean','management.security.enabled',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (34,'Endpoint Restart Enabled','true','boolean','endpoints.restart.enabled',0,'internal',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (35,'Logging level Hibernate','DEBUG','text','logging.level.org.hibernate.SQL',1,'general',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (36,'Logging Level Hibernate Binder','DEBUG','text','logging.level.org.hibernate.type.descriptor.sql.BasicBinder',1,'general',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (37,'Api Keystore','keystore.p12','text','server.ssl.key-store',1,'security',0);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (38,'Api Keystore Password','changeit','text','server.ssl.key-store-password',1,'security',0);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (39,'Api Keystore Type','PKCS12','text','server.ssl.keyStoreType',1,'security',0);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (40,'Api Keystore Key Alias','api_builder','text','server.ssl.keyAlias',1,'security',0);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (42,'Https Server Port',8080,'number','api.port.https',1,'web_server',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (45,'Http Server Port',8080,'number','api.port.http',1,'web_server',1);
INSERT INTO `api_conf` (id,param_name,param_value,param_type,param_key,modifiable,param_category,added) VALUES (46,'Previous Server Port',8080,'number','previous.api.port',0,'web_server',1);
CREATE TABLE IF NOT EXISTS `api_bean` (
	`id`	Int NOT NULL,
	`name`	Varchar ( 255 ),
	`managed`	Bool,
	PRIMARY KEY(`id`)
);
INSERT INTO `api_bean` (id,name,managed) VALUES (1,'Voiture',1);
INSERT INTO `api_bean` (id,name,managed) VALUES (2,'Conducteur',1);
INSERT INTO `api_bean` (id,name,managed) VALUES (3,'Roue',1);
INSERT INTO `api_bean` (id,name,managed) VALUES (4,'VoitureRoue',1);
INSERT INTO `api_bean` (id,name,managed) VALUES (5,'Test',1);
INSERT INTO `api_bean` (id,name,managed) VALUES (6,'TestEntityNomTresLong',1);
COMMIT;
