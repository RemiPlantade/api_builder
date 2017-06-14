# api_builder



The aim of this project is to create a web platform for automatic generation 
of RESTFULL API from datamodel or datasource (commonly database).
The generated API would be be link to the datasource to expose entity from it.


##### This project can be divided into several parts :

- Datamodel analyse from datasource

User give us the database schema and/or the access to his database, 
our system analyse data structure to deduct the list of entity / relation. 

- API generation 

From the list of entities and relations between entities our system generate differents API Request.

- API Request management

The system updates itself to allow the management of request from the analysis of the datamodel.

- API Request to SQL Request

This system will be able to transform an uri to a SQL query to get entities from user's data source.

- Self-contained

User will be able to appropriate the system for itself and use it in his own system.

##### Contributors :

- Plantade Rémi,
- Lariau-Labree Joshua


##### Tech :
- Langage : Java
- Plateform : J2EE
- IDE : Eclipse
- JDK version : Java 1.8


