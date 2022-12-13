insert into course (id, name, created_date, last_updated_date)
values (10001, 'JPA in 50 steps', current_timestamp, current_timestamp);
insert into course (id, name, created_date, last_updated_date)
values (10003, 'Spring in 50 steps', current_timestamp, current_timestamp);
insert into course (id, name, created_date, last_updated_date)
values (10004, 'Spring Boot in 100 steps', current_timestamp, current_timestamp);
insert into course (id, name, created_date, last_updated_date)
values (10005, 'Dummy1', current_timestamp, current_timestamp);
insert into course (id, name, created_date, last_updated_date)
values (10006, 'Dummy2', current_timestamp, current_timestamp);
insert into course (id, name, created_date, last_updated_date)
values (10007, 'Dummy3', current_timestamp, current_timestamp);
insert into course (id, name, created_date, last_updated_date)
values (10008, 'Dummy4', current_timestamp, current_timestamp);
insert into course (id, name, created_date, last_updated_date)
values (10009, 'Dummy5', current_timestamp, current_timestamp);
insert into course (id, name, created_date, last_updated_date)
values (10010, 'Dummy6', current_timestamp, current_timestamp);
insert into course (id, name, created_date, last_updated_date)
values (10011, 'Dummy7', current_timestamp, current_timestamp);

insert into passport (id, number) values (40001, 'AA3257845');
insert into passport (id, number) values (40002, 'AS6956654');
insert into passport (id, number) values (40003, 'AL8700623');

insert into student (id, name, passport_id) values (20001, 'Farhad', 40001);
insert into student (id, name, passport_id) values (20002, 'Asgard', 40002);
insert into student (id, name, passport_id) values (20003, 'Alexander', 40003);

insert into review (id, rating, description, course_id) values (50001, '5', 'Great Course!', 10001);
insert into review (id, rating, description, course_id) values (50002, '4', 'Wonderful Course', 10001);
insert into review (id, rating, description, course_id) values (50003, '5', 'Awesome Course', 10003);

insert into student_course (student_id, course_id) values (20001, 10001);
insert into student_course (student_id, course_id) values (20002, 10001);
insert into student_course (student_id, course_id) values (20003, 10001);
insert into student_course (student_id, course_id) values (20001, 10003);