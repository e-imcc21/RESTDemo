drop database if exists restdemo;
create database restdemo;
use restdemo;
drop table if exists Employee cascade;
/*==============================================================*/
/* Table: Employee */
/*==============================================================*/
create table Employee (
   id                   int   auto_increment  not null,
   fistName             VARCHAR(50)          not null,
   lastName             VARCHAR(50)          not null,
   ldapUserName         VARCHAR(50)          not null,
   gender               VARCHAR(1)           null,
   birthDate            VARCHAR(8)           null,
   title                VARCHAR(50)          not null,
   grade                VARCHAR(50)          not null,
   departmentId         int	not null,
   constraint PK_Employee primary key (id)
);

drop table if exists Department cascade;
/*==============================================================*/
/* Table: Department                                           */
/*==============================================================*/
create table Department (
   id                   int   auto_increment   not null,
   name                 VARCHAR(100)         not null,
   location             VARCHAR(256)         null,
   manager              int              null,
   openPositions        int              null,
   parentDeptId         int              null,
   constraint PK_DEPARTMENT primary key (id),
   constraint FK_ID FOREIGN KEY(manager) REFERENCES Employee(id)
);

insert into Employee values
(
    1,
    'qq',
    'Yu',
    'Elsa',
    '0',
    '19880328',
    '',  
    'P7',
    '1'
);
insert into Employee values
( 
    2,
    'ying',
    'Li',
    'Amily',
    '0',
    '19880618',
    '',  
    'P8',
    '1'
);
insert into Department values
(
    1,
    'overall system',
    '16th',
    1,
    45 ,
    null
);
insert into Department  values
(    2,
    'settle system',
    '16th',
    2,
    4,
    1   
);
insert into Department values
(
    3,
    'trade system',
    '16th',
    1,
    45,
    1  
);

