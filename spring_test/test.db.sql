BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `user_permission_conf` (
	`selection`	Bool,
	`deletion`	Bool,
	`creation`	Bool,
	`updating`	Bool,
	`id_user_conf`	Int NOT NULL,
	`id_entity_conf`	Int NOT NULL,
	FOREIGN KEY(`id_user_conf`) REFERENCES `user_conf`(`id`),
	PRIMARY KEY(`id_user_conf`,`id_entity_conf`),
	FOREIGN KEY(`id_entity_conf`) REFERENCES `entity_conf`(`id`)
);
CREATE TABLE IF NOT EXISTS `user_conf` (
	`id`	Int NOT NULL,
	`firstname`	Varchar ( 255 ),
	`lastname`	Varchar ( 255 ),
	`mail`	Varchar ( 255 ),
	`token`	Varchar ( 255 ),
	`maxquota`	Int,
	`actualquota`	Int,
	`id_group_conf`	Int,
	PRIMARY KEY(`id`),
	FOREIGN KEY(`id_group_conf`) REFERENCES `group_conf`(`id`)
);
CREATE TABLE IF NOT EXISTS `group_permission_conf` (
	`selection`	Bool,
	`deletion`	Bool,
	`creation`	Bool,
	`updating`	Bool,
	`id_group_conf`	Int NOT NULL,
	`id_entity_conf`	Int NOT NULL,
	FOREIGN KEY(`id_group_conf`) REFERENCES `group_conf`(`id`),
	PRIMARY KEY(`id_group_conf`,`id_entity_conf`),
	FOREIGN KEY(`id_entity_conf`) REFERENCES `entity_conf`(`id`)
);
CREATE TABLE IF NOT EXISTS `group_conf` (
	`id`	Int NOT NULL,
	`name`	Varchar ( 255 ),
	PRIMARY KEY(`id`)
);
CREATE TABLE IF NOT EXISTS `entity_conf` (
	`id`	Int NOT NULL,
	`name`	Varchar ( 255 ),
	`managed`	Bool,
	PRIMARY KEY(`id`)
);
CREATE TABLE IF NOT EXISTS `api_conf` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`param_name`	TEXT UNIQUE,
	`param_value`	TEXT,
	`param_type`	TEXT
);
COMMIT;
