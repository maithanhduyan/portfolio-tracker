-- Database: portfolio

-- DROP DATABASE portfolio;

CREATE DATABASE portfolio
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    
-- CREATE EXTENSION ;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Drop table

-- DROP TABLE public.asset_price_historical;

CREATE TABLE public.asset_price_historical (
    "timestamp" timestamp(20) NULL,
    "open" int8 NULL DEFAULT 0,
    high int8 NULL DEFAULT 0,
    low int8 NULL DEFAULT 0,
    "close" int8 NULL DEFAULT 0,
    volumn int8 NULL,
    weighted_price int8 NULL
);
SELECT  NOW() ;
INSERT INTO public.asset_price_historical ("timestamp", "open", high, low, "close", volumn, weighted_price) VALUES('2021-03-21 10:34:24', 4.39, 4.39, 4.39, 4.39, 2.0000000193,4.39);
-----------------------------------------------------------------

-- Drop table

-- DROP TABLE public.account;

CREATE TABLE public.account (
    id varchar(64) NOT NULL ,
    username varchar(50) NOT NULL,
    "password" varchar(128) NOT NULL,
    active int NULL DEFAULT 1,
    created_date timestamp NULL DEFAULT timezone('UTC'::text, now()),
    updated_date timestamp NULL,
    CONSTRAINT acc_username_key UNIQUE (username),
    CONSTRAINT account_pkey PRIMARY KEY (id)
);
INSERT INTO public.account (id, username, "password", active) VALUES('1', 'admin', 'admin', 1);
SELECT a FROM Account a WHERE a.active = 1
