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

insert into MyFlixerJr.GeneralUser (username, email, password, role)
VALUES ('Moderator','admin@gmail.com','Moderator','Moderator');

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
    movieID int,
    username varchar(50),
    score   int check ( score in (1, 2, 3, 4, 5)),
    comment text,
    foreign key (movieID) references MyFlixerJr.movie(movieID),
    foreign key (username) references  MyFlixerJr.generaluser(username)
);

create function MyFlixerJr.movie_review()
returns trigger
    language plpgsql
as $$
    begin
--        MyFlixerJr.movie.averageRating = avg(score) from MyFlixerJr.Review where MyFlixerJr.review.movieid in(select movieid from MyFlixerJr.movie);
    declare
        avg_rate double precision;
        begin
        select avg(score)
        into avg_rate
        from MyFlixerJr.review where review.movieid in (select movieid from MyFlixerJr.movie);
        insert into MyFlixerJr.movie (averageRating) values (avg_rate);
    end;


return new;
    end

    $$;

create trigger movie_rating
    before update
        on MyFlixerJr.movie
    for each row
    execute function MyFlixerJr.movie_review();

CREATE TABLE MyFlixerJr.Movie
(
    imageURL       text,
    title         varchar(50) ,
    year          varchar (10),
    movieID serial PRIMARY KEY,
    averageRating DOUBLE PRECISION,
    description   text
);







drop table MyFlixerJr.movie cascade ;

DROP TABLE MyFlixerJr.Movie;

CREATE TABLE MyFlixerJr.Actors(
  movieID int,
  actor varchar(50),
  FOREIGN KEY (movieID) references MyFlixerJr.movie(movieID)
);


CREATE TABLE MyFlixerJr.GenreRelationship
(
    movieID int,
    genre   varchar(20),
    FOREIGN KEY (movieID) references MyFlixerJr.Movie (movieID),
    foreign key (genre) references MyFlixerJr.Genre(genre)

);
drop table MyFlixerJr.GenreRelationship cascade;

create table MyFlixerJr.Genre(
    genre varchar(30) PRIMARY KEY
);






CREATE TABLE MyFlixerJr.FavoriteList
(
    movieID  int,
    username varchar(50),
    FOREIGN KEY (movieID) references MyFlixerJr.Movie (movieID),
    FOREIGN KEY (username) references MyFlixerJr.GeneralUser (username)
);

INSERT  into MyFlixerJr.FavoriteList (movieID, username)
values (1, 'andrei');
INSERT  into MyFlixerJr.FavoriteList (movieID, username)
values (2, 'andrei');
INSERT  into MyFlixerJr.FavoriteList (movieID, username)
values (3, 'andrei');



select distinct genre
from MyFlixerJr.genrerelationship, MyFlixerJr.movie
    where genrerelationship.movieid in (select movie.movieid  where movie.movieid = 1);

select distinct actor
from MyFlixerJr.actors
    where actors.movieid = 1;







CREATE TABLE MyFlixerJr.WatchLaterList
(
    movieID  int,
    username varchar(50),
    FOREIGN KEY (movieID) references MyFlixerJr.Movie (movieID),
    FOREIGN KEY (username) references MyFlixerJr.GeneralUser (username)
);

CREATE TABLE MyFlixerJr.AlreadyWatchedList
(
    movieID  int,
    username varchar(50),
    FOREIGN KEY (movieID) references MyFlixerJr.Movie (movieID),
    FOREIGN KEY (username) references MyFlixerJr.GeneralUser (username)
);

CREATE TABLE MyFlixerJr.SelectedGenres
(
    genre varchar(20),
    username varchar(50),
    FOREIGN KEY (genre) references MyFlixerJr.Genre(genre),
    FOREIGN KEY (username) references MyFlixerJr.GeneralUser (username)
);

select distinct title
from MyFlixerJr.movie, MyFlixerJr.selectedgenres, MyFlixerJr.genrerelationship
where (MyFlixerJr.SelectedGenres.genre in(select MyFlixerJr.GenreRelationship.genre from MyFlixerJr.GenreRelationship)) and (MyFlixerJr.GenreRelationship.movieid in (select MyFlixerJr.movie.movieid from MyFlixerJr.movie)) and (MyFlixerJr.SelectedGenres.username = 'dum');

select distinct movie.movieid, movie.imageurl, movie.title, movie.year, movie.description
from MyFlixerJr.movie, MyFlixerJr.selectedgenres, MyFlixerJr.genrerelationship
where (MyFlixerJr.SelectedGenres.genre = MyFlixerJr.GenreRelationship.genre ) and (MyFlixerJr.GenreRelationship.movieid = MyFlixerJr.movie.movieid) and (MyFlixerJr.SelectedGenres.username = 'qwe');

select genre
from MyFlixerJr.genrerelationship
where movieid = 1;

select distinct genre
             from MyFlixerJr.genrerelationship, MyFlixerJr.movie
            where genrerelationship.movieid in (select movie.movieid  where movie.movieid = 3);

SELECT actor from MyFlixerJr.Actors where movieid = 3;



-- insert into MyFlixerJr.favoritelist(movieid, username)
-- values(movieid, username)
-- where username = 'bog' and movieid in (select movie.movieid from MyFlixerJr.movie where title='King Kong' and description = 'About a big monkey');

select movieid
from MyFlixerJr.movie
where title='King Kong' and description='About a big monkey';

insert into MyFlixerJr.WatchLaterList(movieid, username)
values(1, 'bog');
