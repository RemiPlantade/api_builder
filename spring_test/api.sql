

CREATE TABLE user_conf(
        id            Int NOT NULL ,
        firstname     Varchar (255) ,
        lastname      Varchar (255) ,
        mail          Varchar (255) ,
        token         Varchar (255) ,
        maxquota      Int ,
        actualquota   Int ,
        id_group_conf Int ,
        PRIMARY KEY (id ),
        FOREIGN KEY (id_group_conf) REFERENCES group_conf(id)
);

CREATE TABLE entity_conf(
        id      Int NOT NULL ,
        name    Varchar (255) ,
        managed Bool ,
        PRIMARY KEY (id )
);

CREATE TABLE group_conf(
        id   Int NOT NULL ,
        name Varchar (255) ,
        PRIMARY KEY (id )
);


CREATE TABLE user_permission_conf(
 		id      Int NOT NULL ,
        selection      Bool ,
        deletion       Bool ,
        creation       Bool ,
        updating       Bool ,
        id_user_conf  Int NOT NULL ,
        id_entity_conf Int NOT NULL ,
        PRIMARY KEY (id),
        FOREIGN KEY (id_user_conf) REFERENCES user_conf(id),
        FOREIGN KEY (id_entity_conf) REFERENCES entity_conf(id)
        
);

CREATE TABLE group_permission_conf(
		id      Int NOT NULL ,
        selection      Bool ,
        deletion       Bool ,
        creation       Bool ,
        updating       Bool ,
        id_group_conf   Int NOT NULL ,
        id_entity_conf Int NOT NULL ,
        PRIMARY KEY (id),
        FOREIGN KEY (id_group_conf) REFERENCES group_conf(id),
        FOREIGN KEY (id_entity_conf) REFERENCES entity_conf(id)
);
