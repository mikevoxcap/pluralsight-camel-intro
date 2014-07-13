/*
 * PostgreSQL DML for creating the role and database for Pluralsight's 
 * course Apache Camel Introduction to Integration. This should be run 
 * for initial setup or when the database needs to be re-loaded. 
 */

-- Role: orders
-- Password: orders
CREATE ROLE orders LOGIN
  ENCRYPTED PASSWORD 'md55f038b5aa5a392661ff3a8494829bd9e'
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;
COMMENT ON ROLE orders IS 'Orders role';

-- Database: orders
CREATE DATABASE orders
  WITH OWNER = orders
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;

-- Schema: orders
CREATE SCHEMA orders AUTHORIZATION orders;
