CREATE TABLE IF NOT EXISTS products
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(60)                             NOT NULL,
    description  VARCHAR(512)                            NOT NULL,
    price        DOUBLE PRECISION,
    productTypes VARCHAR(60)                             NOT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name      VARCHAR(60)                             NOT NULL,
    email     VARCHAR(60)                             NOT NULL,
    balance   DOUBLE PRECISION,
    basket_id INTEGER REFERENCES users (id),
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT UQ_USER_EMAIL UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS basket
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    product_id INTEGER REFERENCES products (id),
    CONSTRAINT pk_basket PRIMARY KEY (id)
);