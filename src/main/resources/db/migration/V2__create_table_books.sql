create table books(
    id integer primary key auto_increment,
    description varchar(20),
    author_id integer references authors (id)
);