DROP DATABASE IF EXISTS  appDB;
CREATE DATABASE appDB;
DROP ROLE IF EXISTS "user";
CREATE ROLE "user" LOGIN PASSWORD 'password';

GRANT CONNECT ON DATABASE appdb TO "user";
GRANT USAGE ON SCHEMA public TO "user";
GRANT SELECT, UPDATE, INSERT ON ALL TABLES IN SCHEMA public TO "user";


--
--
-- CREATE TABLE IF NOT EXISTS users (
--     id serial NOT NULL,
--     name VARCHAR(20) NOT NULL,
--     surname VARCHAR(40) NOT NULL,
--     PRIMARY KEY (ID)
-- );
--
--
-- INSERT INTO users (name, surname)
-- SELECT * FROM (SELECT 'Alex', 'Rover') AS tmp
-- WHERE NOT EXISTS (
--         SELECT name FROM users WHERE name = 'Alex' AND surname = 'Rover'
--     ) LIMIT 1;
--
-- INSERT INTO users (name, surname)
-- SELECT * FROM (SELECT 'Bob', 'Marley') AS tmp
-- WHERE NOT EXISTS (
--         SELECT name FROM users WHERE name = 'Bob' AND surname = 'Marley'
--     ) LIMIT 1;
--
-- INSERT INTO users (name, surname)
-- SELECT * FROM (SELECT 'Alex', 'Rover') AS tmp
-- WHERE NOT EXISTS (
--         SELECT name FROM users WHERE name = 'Alex' AND surname = 'Rover'
--     ) LIMIT 1;
--
-- INSERT INTO users (name, surname)
-- SELECT * FROM (SELECT 'Kate', 'Yandson') AS tmp
-- WHERE NOT EXISTS (
--         SELECT name FROM users WHERE name = 'Kate' AND surname = 'Yandson'
--     ) LIMIT 1;
--
-- INSERT INTO users (name, surname)
-- SELECT * FROM (SELECT 'Lilo', 'Black') AS tmp
-- WHERE NOT EXISTS (
--         SELECT name FROM users WHERE name = 'Lilo' AND surname = 'Black'
--     ) LIMIT 1;