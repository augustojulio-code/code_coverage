CREATE TABLE IF NOT EXISTS tb_message (
    id UUID NOT NULL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    date_time_now TIMESTAMP(6),
    likes INTEGER NOT NULL
);

