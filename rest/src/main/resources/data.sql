insert into user (userno, userid, password)
values (1, 'admin', '$2a$10$H1f/x5E1WQO/5flXKbix9OUFUyK8LtTu65OxqMDwOYLxUl7kxwc1u');

insert into user_role(userno, rolecd) values(1,'ROLE_ADMIN');
insert into user_role(userno, rolecd) values(1,'ROLE_BASIC');

insert into role(rolecd, rolenm) values('ROLE_ADMIN','관리자');
insert into role(rolecd, rolenm) values('ROLE_BASIC','관리자');