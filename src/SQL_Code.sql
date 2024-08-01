CREATE DATABASE EBS;
use EBS;
create table login(meter_no varchar(20), username varchar(30),name varchar(30),password varchar(20),
user varchar (20));
select * from login;

create table customer(name varchar(20),meter_no varchar(20),address varchar(50),city varchar(20),
state varchar(20),email varchar(50),phone varchar(20));

create table meter_info(meter_no varchar(20),meter_location varchar(20),meter_type varchar(20),phase_code varchar(20),
bill_type varchar(20), days varchar(20));

select * from meter_info;
select * from customer;
select * from login;

create table tax(cost_per_unit varchar(20), meter_rent varchar(20), service_charge varchar(20), service_tax varchar(20), swacch_bharat_cess varchar(20), fixed_tax varchar(20));
insert into tax values('9','47','22','57','6','18');
select * from tax;
drop table bill; 

create table bill(meter_no varchar(10),month varchar(20),units varchar(20),totalbill varchar(30), status varchar(20));
select * from bill;
select * from login;