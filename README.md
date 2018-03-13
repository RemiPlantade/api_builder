# api_builder



The aim of this project is to create a java application for automatic generation 
of RESTFULL API from various database.
The generated API would be be link to the datasource to expose entities from it.


This project can be divided into several parts :

- Datamodel analyse from datasource
    With a custom implemetation of the Hibernate Tools library the program analyse the database and deduct the relations between entities from tables structure.
- API generation 
    With the list of entities / relations the program generate a full Spring Restfull API to expose data from provided database.
- API management
    A user management system is embedded to permit User creation, autorization and quota management.
- Self-contained
    The program contains everything is needed to run, including the Java virtual machine, an Tomcat application server and all libraries in single one package.
    
Contributors :

Plantade Rémi,
Lariau-Labree Joshua


Tech :
    Langage : Java
    Tech : Spring / JPA / JDBC
    IDE : Eclipse
    JDK version : Java 1.8
