insert into usr (id, activation_code, active, address, email, password, phone_number, username)
    values
    (3, null, true, 'admin', 'admin', '', 'admin', 'admin'),
    (4, null, true, 'u', 'u', 'p', 'u', 'u');

insert into user_roles (user_id, roles)
    values
    (3, 'USER'),
    (3, 'ADMIN'),
    (4, 'USER');
