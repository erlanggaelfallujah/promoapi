CREATE TABLE IF NOT EXISTS campaign (
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(45),
    mid VARCHAR(20),
    tid VARCHAR(20),
    start_date DATE,
    end_date DATE,
    min_amount DOUBLE,
    max_amount DOUBLE
 );