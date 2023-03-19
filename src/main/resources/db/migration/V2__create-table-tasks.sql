CREATE TABLE task(
    id bigint not null auto_increment,
    description varchar(250),
    completed tinyint,
    date datetime,
    primary key (id));
