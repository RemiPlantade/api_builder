#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: user_conf
#------------------------------------------------------------

CREATE TABLE user_conf(
        id            Int NOT NULL ,
        firstname     Varchar (255) ,
        lastname      Varchar (255) ,
        mail          Varchar (255) ,
        token         Varchar (255) ,
        maxquota      Int ,
        actualquota   Int ,
        id_group_conf Int ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: entity_conf
#------------------------------------------------------------

CREATE TABLE entity_conf(
        id      Int NOT NULL ,
        name    Varchar (255) ,
        managed Bool ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: group_conf
#------------------------------------------------------------

CREATE TABLE group_conf(
        id   Int NOT NULL ,
        name Varchar (255) ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: user_permission_conf
#------------------------------------------------------------

CREATE TABLE user_permission_conf(
        selection      Bool ,
        deletion       Bool ,
        creation       Bool ,
        updating       Bool ,
        id_user_conf  Int NOT NULL ,
        id_entity_conf Int NOT NULL ,
        PRIMARY KEY (id ,id_entity_conf )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: group_permission_conf
#------------------------------------------------------------

CREATE TABLE group_permission_conf(
        selection      Bool ,
        deletion       Bool ,
        creation       Bool ,
        updating       Bool ,
        id_group_conf   Int NOT NULL ,
        id_entity_conf Int NOT NULL ,
        PRIMARY KEY (id ,id_entity_conf )
)ENGINE=InnoDB;

ALTER TABLE user_conf ADD CONSTRAINT FK_user_conf_id_group_conf FOREIGN KEY (id_group_conf) REFERENCES group_conf(id);
ALTER TABLE user_permission_conf ADD CONSTRAINT FK_user_permission_conf_id FOREIGN KEY (id_user_conf) REFERENCES user_conf(id);
ALTER TABLE user_permission_conf ADD CONSTRAINT FK_user_permission_conf_id_entity_conf FOREIGN KEY (id_entity_conf) REFERENCES entity_conf(id);
ALTER TABLE group_permission_conf ADD CONSTRAINT FK_group_permission_conf_id FOREIGN KEY (id_group_conf) REFERENCES group_conf(id);
ALTER TABLE group_permission_conf ADD CONSTRAINT FK_group_permission_conf_id_entity_conf FOREIGN KEY (id_entity_conf) REFERENCES entity_conf(id);
