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