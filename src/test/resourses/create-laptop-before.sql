delete from laptops;

insert into laptops(id, cpu, manufacturer, model, monitor, price, ram, storage_size,
  storage_type, video_card, file_name)
    values (1, 'Intel Core i5', 'Apple', 'MackBook Pro 13', 13, 1099, 8, 250, 'SSD', 'NVIDIA', '123');

alter sequence hibernate_sequence restart with 10;