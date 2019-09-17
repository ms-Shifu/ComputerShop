create sequence hibernate_sequence start 1 increment 1;

create table laptops (
    id int8 not null,
    cpu varchar(255),
    file_name varchar(255),
    manufacturer varchar(255),
    model varchar(255),
    monitor int4 not null,
    price float8,
    ram int4 not null,
    storage_size int4,
    storage_type varchar(255),
    video_card varchar(255),
    primary key (id)
);

create table orders (
    id int8 not null,
    date date,
    payed boolean,
    user_id int8,
    primary key (id)
);

create table orders_laptops (
    orders_id int8 not null,
    laptops_id int8 not null,
    laptops_order int4 not null,
    primary key (orders_id, laptops_order)
);

create table orders_phones (
    orders_id int8 not null,
    phones_id int8 not null,
    phones_order int4 not null,
    primary key (orders_id, phones_order)
);

create table orders_tablets (
    orders_id int8 not null,
    tablets_id int8 not null,
    tablets_order int4 not null,
    primary key (orders_id, tablets_order)
);

create table orders_completed (
    id int8 not null,
    date date, user_id int8,
    primary key (id)
);

create table orders_completed_laptops (
    orders_completed_id int8 not null,
    laptops_id int8 not null,
    laptops_order int4 not null,
    primary key (orders_completed_id, laptops_order)
);

create table orders_completed_phones (
    orders_completed_id int8 not null,
    phones_id int8 not null,
    phones_order int4 not null,
    primary key (orders_completed_id, phones_order)
);

create table orders_completed_tablets (
    orders_completed_id int8 not null,
    tablets_id int8 not null,
    tablets_order int4 not null,
    primary key (orders_completed_id, tablets_order)
);

create table phones (
    id int8 not null,
    cpu varchar(255),
    dual_sim boolean not null,
    file_name varchar(255),
    flash_card boolean not null,
    manufacturer varchar(255),
    model varchar(255),
    monitor int4 not null,
    price float8,
    ram int4 not null,
    storage_size int4,
    primary key (id)
);

create table tablets (
    id int8 not null,
    cpu varchar(255),
    file_name varchar(255),
    flash_card boolean not null,
    manufacturer varchar(255),
    model varchar(255),
    monitor int4 not null,
    os varchar(255),
    price float8,
    ram int4 not null,
    storage_size int4,
    primary key (id)
);

create table user_roles (
    user_id int8 not null,
    roles varchar(255)
);

create table usr (
    id int8 not null,
    activation_code varchar(255),
    active boolean not null,
    address varchar(255),
    email varchar(255),
    password varchar(255) not null,
    phone_number varchar(255),
    username varchar(255) not null,
    primary key (id)
);

create table usr_laptops (
    users_id int8 not null,
    laptops_id int8 not null
);

create table usr_phones (
    users_id int8 not null,
    phones_id int8 not null,
    orderphone_id int4 not null,
    primary key (users_id, orderphone_id)
);

create table usr_tablets (
    users_id int8 not null,
    tablets_id int8 not null,
    tablets_order int4 not null,
    primary key (users_id, tablets_order)
);

alter table if exists orders
    add constraint FK7ncuqw9n77odylknbo8aikc9w
    foreign key (user_id) references usr;

alter table if exists orders_laptops
    add constraint FKnmk65m9j8g2ka3x9n6yvsqimp
    foreign key (laptops_id) references laptops;

alter table if exists orders_laptops
    add constraint FKvhthmhmm14oaqtmjchins493
    foreign key (orders_id) references orders;

alter table if exists orders_phones
    add constraint FKerkbon3lnc91b604h54ybnvws
    foreign key (phones_id) references phones;

alter table if exists orders_phones
    add constraint FKmnbj2ulmfjl2mewjw19g26vqk
    foreign key (orders_id) references orders;

alter table if exists orders_tablets
    add constraint FKg014thrqotyelnyl4dansrymy
    foreign key (tablets_id) references tablets;

alter table if exists orders_tablets
    add constraint FKppedjiuacvjvud1bovaolig3
    foreign key (orders_id) references orders;

alter table if exists orders_completed
    add constraint FKmdeofrqm11iesuyc3x5g2d1g8
    foreign key (user_id) references usr;

alter table if exists orders_completed_laptops
    add constraint FKmxhk7dip4epmwe4dwlv7vrt5n
    foreign key (laptops_id) references laptops;

alter table if exists orders_completed_laptops
    add constraint FKk74a84yh8p04p6xdyqo2haji8
    foreign key (orders_completed_id) references orders_completed;

alter table if exists orders_completed_phones
    add constraint FKbnnoev5k7mc5l8om8ffimhfh5
    foreign key (phones_id) references phones;

alter table if exists orders_completed_phones
    add constraint FKdbqywdbqj064dyvj6jupsysh2
    foreign key (orders_completed_id) references orders_completed;

alter table if exists orders_completed_tablets
    add constraint FKkx10gthd1gme0mflt0ug6eyn0
    foreign key (tablets_id) references tablets;

alter table if exists orders_completed_tablets
    add constraint FK7rjtp7nhat3bb0697o7j4iqeg
    foreign key (orders_completed_id) references orders_completed;

alter table if exists user_roles
    add constraint FKg6agnwreityp2vf23bm2jgjm3
    foreign key (user_id) references usr;

alter table if exists usr_laptops
    add constraint FKa9gvt1tk7sxlo6kopggta4qtm
    foreign key (laptops_id) references laptops;

alter table if exists usr_laptops
    add constraint FKjlwcl1vtub0w1uervh32pw0xe
    foreign key (users_id) references usr;

alter table if exists usr_phones
    add constraint FKhtf4uh1ta48vepl5okng2q7ot
    foreign key (phones_id) references phones;

alter table if exists usr_phones
    add constraint FKg0fj6g5icq7tvm31gbfxi1df4
    foreign key (users_id) references usr;

alter table if exists usr_tablets
    add constraint FKoiqkndedcxvemsr37s0rcjlwn
    foreign key (tablets_id) references tablets;

alter table if exists usr_tablets
    add constraint FK3xifo10qrf6jbyqskvnwg0f0h
    foreign key (users_id) references usr;

