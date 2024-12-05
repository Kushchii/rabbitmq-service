CREATE TABLE mails
(
    id      UUID PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL,
    email   VARCHAR(255) NOT NULL
);
