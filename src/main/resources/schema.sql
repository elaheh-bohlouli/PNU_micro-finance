CREATE TABLE t_User (
    c_USER_Id BIGINT AUTO_INCREMENT PRIMARY KEY,
    c_USERNAME VARCHAR(128) NOT NULL UNIQUE,
    c_PASSWORD VARCHAR(256) NOT NULL
);