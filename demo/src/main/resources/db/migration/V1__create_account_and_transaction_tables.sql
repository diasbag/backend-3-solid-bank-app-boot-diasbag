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
