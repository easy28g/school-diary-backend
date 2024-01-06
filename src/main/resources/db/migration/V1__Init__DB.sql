create sequence usr_seq start with 1 increment by 50;

create table user_roles (
    user_id bigint not null, 
    roles varchar(255) check (roles in ('ADMIN', 'MANAGER', 'TEACHER', 'PARENT', 'STUDENT')));

create table usr (
    active boolean not null, 
    id bigint not null, 
    password varchar(255) not null, 
    username varchar(255) not null, 
    primary key (id));