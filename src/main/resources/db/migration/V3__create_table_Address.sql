create table address(
    id integer primary key auto_increment,
    cep varchar(20),
    neighborhood varchar(20),
    author_id integer references authors (id)
);