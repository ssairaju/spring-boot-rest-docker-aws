create table user (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), password varchar(255), username varchar(255), email varchar(255), sex varchar(255), primary key (id));
INSERT INTO user (first_name, last_name, password, email, sex) values ('user', 'user','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u', 'test@test.com', 'm');
