create sequence hibernate_sequence start 1 increment 1;

create table laptops (
    id int8 not null, cpu varchar(255),
    file_name varchar(255),
    manufacturer varchar(255),
    model varchar(255),
    monitor int4 not null,
    ram int4 not null,
    storage_size int4,
    storage_type varchar(255),
    video_card varchar(255),
    primary key (id));
