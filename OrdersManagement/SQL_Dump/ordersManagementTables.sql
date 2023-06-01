create database if not exists ordersmanagement;
use ordersmanagement;

drop table if exists Clients;
create table Clients(
id int UNIQUE NOT NULL auto_increment,
name varchar(255),
address varchar(255),
email varchar(255),
Primary Key(id)
);

drop table if exists Products;
create table Products(
id int UNIQUE NOT NULL auto_increment,
name varchar(255) unique,
quantity int,
Primary Key(id)
);

drop table if exists Orders;
create table Orders(
id int UNIQUE NOT NULL auto_increment,
idClient int,
idProduct int,
quantity int,
FOREIGN KEY (idClient) REFERENCES Clients(id),
FOREIGN KEY (idProduct) REFERENCES Products(id)
);

drop table if exists Bill;
create table Bill(
id int UNIQUE NOT NULL auto_increment,
idOrder int,
idClient int,
idProduct int,
quantity int
);

Select * from Clients;
Select * from Products;
Select * from Orders;
Select * from Bill;

#drop database ordersManagement;