create table provinces (ProvinceId Number (2), ProvinceName Varchar2(4));

insert into provinces values (11, 'ON');
insert into provinces values (12, 'AB');
insert into provinces values (13, 'BC');
insert into provinces values (14, 'MN');
insert into provinces values (15, 'NB');
insert into provinces values (16, 'NF');
insert into provinces values (17, 'NS');
insert into provinces values (18, 'QC');
insert into provinces values (19, 'SK');
insert into provinces values (20, 'NL');
insert into provinces values (21, 'PE');
insert into provinces values (22, 'NT');
insert into provinces values (23, 'NU');
insert into provinces values (24, 'YT');

SELECT * FROM PROVINCES ORDER BY PROVINCENAME;