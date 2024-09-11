CREATE TABLE users(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    external_id     UUID NOT NULL,
    name            VARCHAR(255) NOT NULL,
    email           VARCHAR(255) NOT NULL UNIQUE,
    password        VARCHAR(255) NOT NULL
);

CREATE TABLE roles(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            VARCHAR(100) NOT NULL
);

CREATE TABLE users_roles(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id         BIGINT NOT NULL,
    role_id         BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE addresses(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    zip_code        VARCHAR(8),
    street          VARCHAR(255),
    neighborhood    VARCHAR(150),
    city            VARCHAR(255)
);

CREATE TABLE producers(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id         BIGINT NOT NULL,
    address_id      BIGINT NOT NULL,
    external_id     UUID NOT NULL,
    cpf             VARCHAR(11) NOT NULL,
    phone           VARCHAR(11) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (address_id) REFERENCES addresses (id)
);

CREATE TABLE products(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            VARCHAR(255),
    description     TEXT,
    external_id     UUID NOT NULL,
    pathImage       VARCHAR(255)
);

CREATE TABLE categories(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            VARCHAR(100)
);

CREATE TABLE product_category(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    product_id      BIGINT NOT NULL,
    category_id     BIGINT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES producers (id),
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE product_producer(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    product_id      BIGINT NOT NULL,
    producer_id     BIGINT NOT NULL,
    available       BOOLEAN NOT NULL,
    price           NUMERIC(6,2) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (producer_id) REFERENCES producers (id)
);

CREATE TABLE fairs(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    address_id      BIGINT NOT NULL,
    external_id     UUID NOT NULL,
    name            VARCHAR(255),
    description     TEXT,
    FOREIGN KEY (address_id) REFERENCES addresses (id)
);

CREATE TABLE producer_fair(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    producer_id     BIGINT NOT NULL,
    fair_id    BIGINT NOT NULL,
    FOREIGN KEY (producer_id) REFERENCES producers (id),
    FOREIGN KEY (fair_id) REFERENCES fairs (id)
);