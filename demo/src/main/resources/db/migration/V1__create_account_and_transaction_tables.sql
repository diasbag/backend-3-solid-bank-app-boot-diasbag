CREATE TABLE Account(
    id INT NOT NULL,
  account_id VARCHAR(20) NOT NULL ,
  accountType VARCHAR(20) NOT NULL ,
  client_id VARCHAR(20) NOT NULL ,
  balance DECIMAL default 0,
  withdrawAllowed BIT,
  CONSTRAINT PK_account PRIMARY KEY (id)
);

CREATE TABLE Transaction(
    transaction_id INT NOT NULL ,
    amount DECIMAL,
    CONSTRAINT PK_transaction PRIMARY KEY (transaction_id)
);
