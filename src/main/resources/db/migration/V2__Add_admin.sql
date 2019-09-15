insert into usr (id, activation_code, active, address, email, password, phone_number, username)
    values (1, null, true, 'admin', 'admin', 'p', 'admin', 'admin');

insert into user_roles (user_id, roles)
    values (1, 'USER'), (1, 'ADMIN');