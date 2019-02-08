CREATE TABLE IF NOT EXISTS campaign (
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(45),
    mid VARCHAR(20),
    tid VARCHAR(20),
    start_date DATE,
    end_date DATE,
    min_amount DOUBLE,
    max_amount DOUBLE,
    reward_type INT
 );

CREATE TABLE IF NOT EXISTS discount (
  id int IDENTITY PRIMARY KEY,
  name varchar(45) NOT NULL,
  percentage INT(3) NOT NULL
);

CREATE TABLE IF NOT EXISTS promo_map (
  campaign_id INT(10),
  discount_id int(10),
  foreign key (CAMPAIGN_ID) references campaign(id),
  foreign key (DISCOUNT_ID) references discount(id)
);

CREATE TABLE IF NOT EXISTS txn_log (
  mid varchar(20) NOT NULL,
  tid varchar(20) NOT NULL,
  transaction_date datetime NOT NULL,
  amount double NOT NULL,
  nett_amount double NOT NULL,
  response_code varchar(2) DEFAULT NULL,
  ref_number varchar(45) NOT NULL,
  txn_log_id int(10) IDENTITY PRIMARY KEY
  );

CREATE TABLE IF NOT EXISTS txn_log_detail (
  txn_log_detail_id int(10) IDENTITY PRIMARY KEY,
  discount_id int(10)  DEFAULT NULL,
  response_code varchar(2) NOT NULL,
  campaign_id int(10)  NOT NULL,
  remaining_amount double  DEFAULT NULL,
  txn_log_id int(10)  DEFAULT NULL,
  foreign key (CAMPAIGN_ID) references campaign(id),
  foreign key (DISCOUNT_ID) references discount(id),
  foreign key (TXN_LOG_ID) references txn_log(txn_log_id)
);
