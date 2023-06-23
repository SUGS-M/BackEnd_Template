create database if not exists test;
use test;

create table if not exists user(
    id int unsigned primary key  auto_increment comment 'ID',
    username varchar(20) not null unique comment '用户名',
    password varchar(20) default '11111111' comment '密码',
    is_delete int default 0  not null comment '逻辑删除'
)comment '用户表';