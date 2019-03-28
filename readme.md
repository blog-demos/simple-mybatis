## simple-mybatis

| package | version |
|:--------|:--------|
| mysql-connector-java | 8.0.15 |
| mybatis | 3.4.1 |

Database
```mysql
CREATE DATABASE test;

CREATE TABLE `student_info`(
    id INT (11) AUTO_INCREMENT NOT NULL,
    school_code INT(10) NOT NULL,
    name VARCHAR (20),
    create_time DATETIME NOT NULL,
    PRIMARY KEY (id)
);
```

```mysql
INSERT INTO `student_info` (school_code, name, create_time) VALUES (10001, 'xiaoming', '2019-02-26 15:17:17');
INSERT INTO `student_info` (school_code, name, create_time) VALUES (10002, 'xiaoming2', '2019-02-26 16:17:17');
INSERT INTO `student_info` (school_code, name, create_time) VALUES (10004, 'xiaoming3', '2019-02-26 17:17:17');
```
