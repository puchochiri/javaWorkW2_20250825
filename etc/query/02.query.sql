
CREATE DATABASE webdb;

create user 'webuser'@'localhost' IDENTIFIED by 'webuser';

grant all privileges on webdb.* to 'webuser'@'localhost';

flush privileges;




select now();

create table tbl_todo (
                          tno int auto_increment primary key,
                          title varchar(100) not null,
                          dueDate date not null,
                          finished tinyint default 0
);

insert into tbl_todo (title, dueDate, finished)
values ('Test...', '2022-12-31', 1);

select * from tbl_todo;

select * from tbl_todo where tno = '5';

select * from tbl_todo where tno < '10';

update tbl_todo set finished = 0, title = 'Not Yet...1' where tno = '5';

delete from tbl_todo where tno > '6';



create table tbl_member (
  mid varchar(50) primary key,
  mpw varchar(50) not null,
  mname varchar(100) not null
);

alter table tbl_member add column uuid varchar(50);

insert into tbl_member(mid, mpw, mname) values ('user00','1111','사용자0');
insert into tbl_member(mid, mpw, mname) values ('user01','1111','사용자0');
insert into tbl_member(mid, mpw, mname) values ('user02','1111','사용자0');

select * from tbl_member where mid = 'user00' and mpw = '1111';

fde7c952-5650-4a24-a871-b81786e34342

    4d26b01b-3ac1-438b-a3e6-63c2347f0cd9