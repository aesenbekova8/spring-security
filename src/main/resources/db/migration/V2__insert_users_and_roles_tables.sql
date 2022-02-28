INSERT INTO roles(id, name)
VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

INSERT INTO users ("username", "password")
VALUES ('Admin', '$2a$10$PeSqJMZBC64oDhh.6yTTrOZP/iOMtL.7GKFyatjC.tzDc2rOBUcem');

INSERT INTO user_role(user_id, role_id)
VALUES (1, 2);