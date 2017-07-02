CREATE TABLE REMINDER (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    remindContent VARCHAR(255) NOT NULL,
    dueDate DATE NOT NULL,
    status_id BIGINT NOT NULL,
    createdOn TIMESTAMP NOT NULL,
    updatedOn TIMESTAMP
);

CREATE TABLE REMINDER_STATUS(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(255) NOT NULL,
    createdOn TIMESTAMP NOT NULL,
    updatedOn TIMESTAMP,

    UNIQUE KEY unique_code (code)
);
