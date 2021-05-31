# Test용 MariaDB 계정 생성

cmd에서 진행



## 접속

```mariadb
mariadb -u root -p

ID : root
pw : root
```



## 사용중인 계정 조회

```mariadb
use mysql;	
select host, user, password from user;
```



## DB 확인

```mariadb
show databases;
```



## DB 생성

```mariadb
DROP DATABASE earlykross;
CREATE DATABASE earlykross;
```



## 계정 생성

```mariadb
USE earlykross;

-- 사용자 확인
SELECT host, user, password FROM user;

-- 사용자 계정 생성
-- CREATE USER '아이디'@'%' IDENTIFIED BY '비밀번호';
-- CREATE USER 계정이름@localhost identified by '비밀번호'; -- 로컬에서만 접속가능
-- CREATE USER 'elkt'@'%' IDENTIFIED BY 'elkt';
DROP USER ek@localhost;
CREATE USER 'ek'@localhost IDENTIFIED BY 'ek';
```



## 권한 부여

```mariadb
-- 사용자 권한 주기
-- GRANT ALL PRIVILEGES ON elktest.* TO 'elkt'@'%';
-- GRANT SELECT ON db스키마.* TO `계정이름`@`%` identified by '비밀번호';
GRANT ALL PRIVILEGES ON earlykross.* TO 'ek'@'localhost';
GRANT SELECT ON earlykross.* TO `ek`@`localhost` identified by 'ek';

-- 새로고침
FLUSH PRIVILEGES;
```


