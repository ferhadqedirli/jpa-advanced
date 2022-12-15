insert into course (id, name, created_date, last_updated_date, is_deleted)
values (10001, 'JPA in 50 steps', current_timestamp, current_timestamp, false);
insert into course (id, name, created_date, last_updated_date, is_deleted)
values (10003, 'Spring in 50 steps', current_timestamp, current_timestamp, false);
insert into course (id, name, created_date, last_updated_date, is_deleted)
values (10004, 'Spring Boot in 100 steps', current_timestamp, current_timestamp, false);

insert into passport (id, number) values (40001, 'AA3257845');
insert into passport (id, number) values (40002, 'AS6956654');
insert into passport (id, number) values (40003, 'AL8700623');

insert into student (id, name, passport_id) values (20001, 'Farhad', 40001);
insert into student (id, name, passport_id) values (20002, 'Asgard', 40002);
insert into student (id, name, passport_id) values (20003, 'Alexander', 40003);

insert into review (id, rating, description, course_id) values (50001, 'FIVE', 'Great Course!', 10001);
insert into review (id, rating, description, course_id) values (50002, 'FOUR', 'Wonderful Course', 10001);
insert into review (id, rating, description, course_id) values (50003, 'FIVE', 'Awesome Course', 10003);

insert into student_course (student_id, course_id) values (20001, 10001);
insert into student_course (student_id, course_id) values (20002, 10001);
insert into student_course (student_id, course_id) values (20003, 10001);
insert into student_course (student_id, course_id) values (20001, 10003);