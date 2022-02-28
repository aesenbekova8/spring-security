CREATE TABLE roles(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(25),
    password VARCHAR(500)
);

CREATE TABLE user_role(
    user_id BIGSERIAL REFERENCES users(id),
    role_id BIGSERIAL REFERENCES roles(id)
);