CREATE TABLE IF NOT EXISTS users
(
    id    CHAR(36) DEFAULT (UUID()),
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cars
(
    id     BIGINT UNIQUE AUTO_INCREMENT,
    make       VARCHAR(50) NOT NULL,
    model      VARCHAR(50) NOT NULL,
    year       INT         NOT NULL,
    kilometers INT         NOT NULL,
    user_id    CHAR(36)    NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_user_user_id FOREIGN KEY (user_id) REFERENCES users (id)
);