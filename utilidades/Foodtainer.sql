create database foodtainer_db;

use foodtainer_db;

create table departament(
 id_departament int(12) not null auto_increment,
 name_departament varchar(200) not null default 'NN',
 constraint de_departament_pk primary key (id_departament)
) engine=InnoDB default charset=latin1 collate=latin1_spanish_ci;

create table city(
 id_city int(12) not null auto_increment,
 name_city varchar(200) not null default '',
 id_departament int(12) not null,
constraint ci_city_pk primary key (id_city),
constraint ci_departament_fk foreign key (id_departament) 
references departament(id_departament) on delete cascade
) engine=InnoDB default charset=latin1 collate=latin1_spanish_ci;

create table location(
 id_location int(12) not null auto_increment,
 url varchar(200) not null default 'NN',
 constraint lo_location_pk primary key (id_location)
) engine=InnoDB default charset=latin1 collate=latin1_spanish_ci;

create table picture(
 id_picture int(12) not null auto_increment,
 name_picture varchar(200) not null default 'NN',
 description_picture varchar(500) not null default 'NN',
 picture blob,
 constraint pi_picture_pk primary key (id_picture)
) engine=InnoDB default charset=latin1 collate=latin1_spanish_ci;

create table user_ft(
 email_user varchar(200) not null,
 password_user varchar(200) not null ,
 type_user varchar(200) not null default 'NN',
 constraint us_user_pk primary key (email_user)
) engine=InnoDB default charset=latin1 collate=latin1_spanish_ci;

create table customer(
 id_customer int(12) not null auto_increment,
 name_customer varchar(200) not null ,
 email_customer varchar(200) not null default 'NN',
 constraint cu_customer_pk primary key (id_customer),
 constraint cu_user_fk foreign key (email_customer) 
 references user_ft(email_user) on delete cascade
) engine=InnoDB default charset=latin1 collate=latin1_spanish_ci;

create table contact(
 id_contact int(12) not null auto_increment,
 phone_contact int(13) not null default 0,
 email_contact varchar(200) not null default 'NN',
 url_facebook varchar(200) not null default 'NN',
 url_instagram varchar(200) not null default 'NN',
 url_webpage varchar(200) not null default 'NN',
 constraint co_contact_pk primary key (id_contact),
 constraint co_user_fk foreign key (email_contact) 
 references user_ft(email_user) on delete cascade
) engine=InnoDB default charset=latin1 collate=latin1_spanish_ci;

create table restaurant(
 id_restaurant int(12) not null auto_increment,
 name_restaurant varchar(200) not null ,
 email_restaurant varchar(200) not null default 'NN',
 constraint re_restaurant_pk primary key (id_restaurant),
 constraint re_user_fk foreign key (email_restaurant) 
 references user_ft(email_user) on delete cascade
) engine=InnoDB default charset=latin1 collate=latin1_spanish_ci;

create table calification(
 id_calification int(12) not null auto_increment,
 score_calification float not null default 0,
 comment_calification varchar(500) not null default 'NN',
 id_restaurant int(12) not null,
 id_customer int(12) not null,
constraint ca_calification_pk primary key (id_calification),
constraint ca_restaurant_fk foreign key (id_restaurant) 
references restaurant(id_restaurant) on delete cascade,
constraint ca_customer_fk foreign key (id_customer) 
references customer(id_customer) on delete cascade
) engine=InnoDB default charset=latin1 collate=latin1_spanish_ci;

create table product(
 id_product int(12) not null auto_increment,
 name_product varchar(200) not null default 'NN',
 description_product varchar(500) not null default 'NN',
 type_product varchar(500) not null default 'NN',
 id_restaurant int(12) not null,
 id_picture int(12) not null,
constraint pro_product_pk primary key (id_product),
constraint pro_restaurant_fk foreign key (id_restaurant) 
references restaurant(id_restaurant) on delete cascade,
constraint pro_picture_fk foreign key (id_picture) 
references picture(id_picture) on delete cascade
) engine=InnoDB default charset=latin1 collate=latin1_spanish_ci;

create table presentation(
 id_presentation int(12) not null auto_increment,
 name_presentation varchar(200) not null default 'NN',
 description_presentation varchar(500) not null default 'NN',
 id_product int(12) not null,
constraint pre_presentation_pk primary key (id_presentation),
constraint pre_product_fk foreign key (id_product) 
references product(id_product) on delete cascade
) engine=InnoDB default charset=latin1 collate=latin1_spanish_ci;

create table headquater(
 id_headquater int(12) not null auto_increment,
 name_headquater varchar(200) not null default 'NN',
 description_headquater varchar(500) not null default 'NN',
 schedule_headquater varchar(200) not null default 'NN',
 type_headquater varchar(200) not null default 'NN',
 id_picture int(12) not null,
 id_city int(12) not null,
 id_location int(12) not null,
 id_restaurant int(12) not null,
 id_contact int(12) not null,
constraint hq_headquater_pk primary key (id_headquater),
constraint hq_picture_fk foreign key (id_picture) 
references picture(id_picture) on delete cascade,
constraint hq_city_fk foreign key (id_city) 
references city(id_city) on delete cascade,
constraint hq_location_fk foreign key (id_location) 
references location(id_location) on delete cascade,
constraint hq_restaurant_fk foreign key (id_restaurant) 
references restaurant(id_restaurant) on delete cascade,
constraint hq_contact_fk foreign key (id_contact) 
references contact(id_contact) on delete cascade
) engine=InnoDB default charset=latin1 collate=latin1_spanish_ci;

commit;
