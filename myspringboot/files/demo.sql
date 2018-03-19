use mysql;

drop database if exists demo;

create database demo default charset utf8 collate utf8_general_ci;

use demo;

create table TbTest
(
	tid integer auto_increment primary key not null comment '主键',
	tinfo varchar(50)  not null comment '测试信息',
	createdTime timestamp default now() not null comment '创建时间',
	modifyTime long comment '信息修改时间'
)comment '测试信息表';

insert into TbTest(tinfo) values('测试信息');

select * from TbTest;

create table TbDept
(
	deptId integer auto_increment primary key not null comment '部门编号',
	deptName varchar(50) unique not null comment '部门名称'
);

insert into TbDept(deptName) values('测试部门');

select * from TbDept;

create table TbEmployee
(
	empId integer auto_increment primary key not null comment '员工编号',
	empName varchar(50) not null comment '员工姓名',
	deptId integer not null comment '所属部门',
	foreign key(deptId) references TbDept(deptId) 
);

insert into TbEmployee(empName,deptId) values('张三',1);
insert into TbEmployee(empName,deptId) values('李四',1);

select * from TbEmployee;


