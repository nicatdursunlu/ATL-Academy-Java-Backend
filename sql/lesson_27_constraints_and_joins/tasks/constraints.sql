-- 1. Create a products table with columns: id, price, count. The value of the
-- price and count columns cannot be less than 0 and must have a value.
create table products
(
    id    serial,
    price float4  not null check (price > 0),
    count integer not null check (count > 0)
);

-- 2. We have a client table with columns: id, name, surname, email. The clients
-- may or may not have email. Also, the clients cannot duplicate each other's
-- email.
CREATE TABLE client
(
    id      serial primary key,
    name    varchar(50),
    surname varchar(50),
    email   varchar(50)
);

CREATE UNIQUE INDEX unique_email ON client (email)
    WHERE email is not null;


-- 3. We have a table for storing international money transfers. We can perform
-- it via Swift. So, this table must include a swiftCode. The length of swift
-- code in many countries is 11, but in several countries is 9. Make the
-- column take an only value with 9 or 11 length
CREATE TABLE transfers
(
    id         serial primary key,
    swift_code varchar(11) check ( length(swift_code) in (9, 11) )
);
