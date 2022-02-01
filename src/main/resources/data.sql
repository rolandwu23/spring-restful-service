insert into user values(1001, sysDate(), 'AB');
insert into user values(1002, sysDate(), 'Roland');
insert into user values(1003, sysDate(), 'Hazel');
insert into post values(1001, 'Hazel post', 1003);
insert into post values(1002, 'AB post', 1001);
insert into post values(1003, 'Roland post', 1002);