delete from user_roles;
delete from usr;

insert into usr(id, username, password, active)
    values (101, 'sam', 'p', true );

insert into user_roles(user_id, roles)
    values (101, 'USER'), (101, 'ADMIN');