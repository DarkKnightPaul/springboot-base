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
