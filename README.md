# RESTDemo

## Overview:
- RestDemo project uses java implements a set of RESTful API based on HTTP/JSON to serve CRUD functionalities.

## Instructions 
- Before start, make sure MYSQL5.1.3 or higher、JDK1.7 or higher、Elipse with maven plugin are installed and configurated property in  local development environment.

####to get the code:
- Clone the repository: git clone git://github.com/e-imcc21/RESTDemo.git

- If this is your first time using Github, review http://help.github.com to learn the basics.
####to initialise the Database
- run "..\RestDemo\src\main\resource\table.sql" in mysql : mysql>source 【the whole directory of tables.sql 】
eg.```mysql> source d:\RestDemo\src\main\resource\table.sql```

####to run the application
1. Import the project as a maven project into your IDE of choice. 
2. check /RestDemo/src/main/resource/jdbc.properties.xml. change the username/password into local mysql username/psssword
3. run as maven build. fill the goal:jetty:run 
4. the application running at http://localhost:8080/restdemo/ 

* getAllDepts:              ```localhost:8080/restdemo/departments```
* getDeptById:              ```localhost:8080/restdemo/departments/1```
* getSubDepts:              ```localhost:8080/restdemo/departments/1/subDepts/```
* getParentDept:            ```localhost:8080/restdemo/departments/2/parentDept/```
* getAllEmployeeOfOneDept:  ```localhost:8080/restdemo/departments/1/employees```
* getEmployees:             ```localhost:8080/restdemo/employees```
* getEmployeeById:          ```localhost:8080/restdemo/employees/1```
* getDempartOfOneEmployee:  ```localhost:8080/restdemo/employees/1/department```

##TODO
- use restclient to show other functionalities


weekend work
