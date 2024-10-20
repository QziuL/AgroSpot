CREATE TABLE users(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    externalId      UUID NOT NULL,
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
    userId          BIGINT NOT NULL,
    roleId          BIGINT NOT NULL,
    FOREIGN KEY (userId) REFERENCES users (id),
    FOREIGN KEY (roleId) REFERENCES roles (id)
);

CREATE TABLE addresses(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    zipCode         VARCHAR(8),
    street          VARCHAR(255),
    neighborhood    VARCHAR(255),
    city            VARCHAR(255)
);

CREATE TABLE producers(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    userId          BIGINT NOT NULL,
    addressId       BIGINT NOT NULL,
    externalId      UUID NOT NULL,
    cpf             VARCHAR(11) NOT NULL UNIQUE,
    phone           VARCHAR(11) NOT NULL,
    FOREIGN KEY (userId) REFERENCES users (id),
    FOREIGN KEY (addressId) REFERENCES addresses (id)
);

CREATE TABLE products(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            VARCHAR(255),
    description     TEXT,
    externalId      UUID NOT NULL,
    pathImage       VARCHAR(255)
);

-- CREATE TABLE categories(
--     id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--     name            VARCHAR(100)
-- );

-- CREATE TABLE product_category(
--     id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--     product_id      BIGINT NOT NULL,
--     category_id     BIGINT NOT NULL,
--     FOREIGN KEY (product_id) REFERENCES producers (id),
--     FOREIGN KEY (category_id) REFERENCES categories (id)
-- );

CREATE TABLE product_producer(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    productId      BIGINT NOT NULL,
    producerId     BIGINT NOT NULL,
    available       BOOLEAN NOT NULL,
    price           NUMERIC(6,2) NOT NULL,
    FOREIGN KEY (productId) REFERENCES products (id),
    FOREIGN KEY (producerId) REFERENCES producers (id)
);

CREATE TABLE fairs(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    addressId       BIGINT NOT NULL,
    externalId      UUID NOT NULL,
    name            VARCHAR(255),
    description     TEXT,
    FOREIGN KEY (addressId) REFERENCES addresses (id)
);

CREATE TABLE producer_fair(
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    producerId      BIGINT NOT NULL,
    fairId          BIGINT NOT NULL,
    FOREIGN KEY (producerId) REFERENCES producers (id),
    FOREIGN KEY (fairId) REFERENCES fairs (id)
);

