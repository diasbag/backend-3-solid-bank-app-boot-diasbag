create table ROLE_ENTITY
(
    id   INTEGER  not null AUTO_INCREMENT,
    name varchar(20) not null,
    CONSTRAINT PK_ROLE_ENTITY primary key (id)
);
insert into ROLE_ENTITY(name) values ('ROLE_ADMIN');
insert into ROLE_ENTITY(name) values ('ROLE_USER');

create table USER_ENTITY
(
    id  INTEGER not null AUTO_INCREMENT UNIQUE,
    login    varchar(50) NOT NULL UNIQUE ,
    password varchar(500) NOT NULL,
    role  varchar(20)  not null,
    CONSTRAINT PK_USER_ENTITY primary key (id)
);


CREATE TABLE Account(
  id VARCHAR(20) NOT NULL ,
  account_type VARCHAR(20) NOT NULL ,
  client_id VARCHAR(20) NOT NULL ,
  balance DECIMAL default 0,
  withdraw_allowed BIT,
  CONSTRAINT PK_account PRIMARY KEY (id)
);

CREATE TABLE Transaction(
    transaction_id INT NOT NULL AUTO_INCREMENT,
    amount DECIMAL,
    account_id VARCHAR (20),
    CONSTRAINT PK_transaction PRIMARY KEY (transaction_id)
);
