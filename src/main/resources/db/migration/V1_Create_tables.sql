CREATE TABLE books (
    isbn      varchar(255) NOT NULL,
    title     varchar(255) NOT NULL,
    author    varchar(255)         ,
    published integer              ,
    PRIMARY KEY (isbn)
)

CREATE TABLE outbox (
    id       uuid NOT NULL,
    headers  jsonb,
    payload  jsonb NOT NULL,
    PRIMARY KEY (id)
)
