create table movie (movie_id int primary key, title varchar(256), release_date timestamp, duration int);
create table city (city_id int primary key, name varchar(250));
create table cinema (cinema_id int primary key, name varchar(250), no_of_halls int, city_id int, foreign key(city_id) references city(city_id) );
create table cinema_hall (cinema_hall_id int primary key, name varchar(250), no_of_seats int, cinema_id int, foreign key(cinema_id) references cinema(cinema_id) );
create table movie_show (show_id int primary key, show_date timestamp, start_time timestamp, end_time timestamp, movie_id int, cinema_hall_id int, foreign key (movie_id) references movie (movie_id),  foreign key (cinema_hall_id) references cinema_hall(cinema_hall_id));
create table cinema_seat (cinema_seat_id int primary key, seat_number int, type int, cinema_hall_id int, foreign key (cinema_hall_id) references cinema_hall (cinema_hall_id));
create table user(user_id int primary key, name varchar(100), password varchar(100));
CREATE TABLE `booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `no_of_seats` int DEFAULT NULL,
  `time_stamp` timestamp NULL DEFAULT NULL,
  `status` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `show_id` int DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `user_id` (`user_id`),
  KEY `show_id` (`show_id`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`show_id`) REFERENCES `movie_show` (`show_id`)
) ;
create table show_seat (show_seat_id int primary key, status int, price int, cinema_seat_id int, show_id int, booking_id int, foreign key (cinema_seat_id) references cinema_seat (cinema_seat_id), foreign key (show_id) references movie_show(show_id), foreign key (booking_id) references booking(booking_id)) ;
create table payment (payment_id int primary key, amount int, time_stamp timestamp, payment_method int, booking_id int, foreign key (booking_id) references booking (booking_id));

alter table show_seat drop primary key, add primary key(show_seat_id, show_id);
alter table payment drop column transaction_id, drop timestamp;

insert into city values(100, "Bangalore");
insert into city values(200, "Hyderabad");

insert into cinema values(100, "PVR", 2, 100);
insert into cinema values(101, "Inox", 3, 100);
insert into cinema values(102, "BigCinemas", 1, 100);
insert into cinema values(103, "BigCinemas", 2, 200);
insert into cinema values(104, "PVR", 1, 200);

insert into movie values (100, "Jungle Book", str_to_date('20-01-2017','%d-%m-%Y'), 2);
insert into movie values (101, "Cars", str_to_date('20-01-2014','%d-%m-%Y'), 2);
insert into movie values (102, "Bahubali", str_to_date('20-01-2018','%d-%m-%Y'), 3);

insert into cinema_hall values(100, "Priemer - Hall1", 20, 100);
insert into cinema_hall values(101, "Standard - Hall1", 25, 100);

INSERT INTO movie_show VALUES (100, timestamp('2021-11-27'), timestamp('2021-11-27 14:00:00'), timestamp('2021-11-27 16:00:00'), 100, 100);

insert into cinema_seat values (100, 1, 1, 100);
insert into cinema_seat values (101, 2, 1, 100);
insert into cinema_seat values (102, 3, 1, 100);
insert into cinema_seat values (103, 4, 1, 100);
insert into cinema_seat values (104, 5, 1, 100);
insert into cinema_seat values (105, 1, 2, 101);
insert into cinema_seat values (106, 2, 2, 101);
insert into cinema_seat values (107, 3, 2, 101);
insert into cinema_seat values (108, 4, 2, 101);
insert into cinema_seat values (109, 5, 2, 101);

insert into show_seat values(100, 0, 100, 100, 100, null);
insert into show_seat values(101, 0, 100, 101, 100, null);
insert into show_seat values(102, 0, 100, 102, 100, null);
insert into show_seat values(103, 0, 100, 103, 100, null);
insert into show_seat values(104, 0, 100, 104, 100, null);
insert into show_seat values(105, 0, 100, 105, 100, null);