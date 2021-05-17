DROP SCHEMA IF EXISTS MyFlixerJr CASCADE;
Create SCHEMA MyFlixerJr;

SET SCHEMA 'MyFlixerJr';


CREATE TABLE MyFlixerJr.GeneralUser
(
    username varchar(50) PRIMARY KEY,
    email    varchar(50),
    password varchar(50),
    role     varchar(15) not null check ( role in ('SimpleUser', 'Moderator', 'Admin'))
);

insert into MyFlixerJr.GeneralUser (username, email, password, role)
VALUES ('Admin','admin@gmail.com','admin123','Admin');

drop table MyFlixerJr.GeneralUser cascade ;



CREATE TABLE MyFlixerJr.Follows
(
    usernameFollower varchar(50),
    follower         varchar(50),
    FOREIGN KEY (usernameFollower) references MyFlixerJr.GeneralUser (username),
    FOREIGN KEY (follower) references MyFlixerJr.GeneralUser (username)
);


CREATE TABLE MyFlixerJr.Review
(
    score   int check ( score in (1, 2, 3, 4, 5)),
    comment text
);

DROP TABLE Review;

CREATE TABLE Movie
(
    title         varchar(50),
    movieID       int PRIMARY KEY,
    averageRating DOUBLE PRECISION,
    description   text
);

DROP TABLE Movie;

CREATE TABLE Image
(
    imageName text,
    img       bytea,
    movieID   int,
    FOREIGN KEY (movieID) references Movie (movieID)
);

DROP TABLE Image;

CREATE TABLE Genre
(
    movieID int,
    genre   varchar(20) PRIMARY KEY,
    FOREIGN KEY (movieID) references Movie (movieID)
);

DROP TABLE Genre;

CREATE TABLE FavoriteList
(
    movieID  int,
    username varchar(50),
    FOREIGN KEY (movieID) references Movie (movieID),
    FOREIGN KEY (username) references GeneralUser (username)
);

CREATE TABLE WatchLaterList
(
    movieID  int,
    username varchar(50),
    FOREIGN KEY (movieID) references Movie (movieID),
    FOREIGN KEY (username) references GeneralUser (username)
);

CREATE TABLE AlreadyWatchedList
(
    movieID  int,
    username varchar(50),
    FOREIGN KEY (movieID) references Movie (movieID),
    FOREIGN KEY (username) references GeneralUser (username)
);

CREATE TABLE SelectedGenres
(
    genre varchar(20),
    username varchar(50),
    FOREIGN KEY (genre) references Genre(genre),
    FOREIGN KEY (username) references GeneralUser (username)
);

