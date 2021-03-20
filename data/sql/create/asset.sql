-- Drop table

-- DROP TABLE public.asset;

CREATE TABLE public.asset (
    id varchar(64) NOT NULL ,
    "name" varchar(20) NOT NULL,
    "code" varchar(20) NOT NULL,
    price bigint  NOT NULL DEFAULT 0,
    "description" varchar(100) NOT NULL,
    created_date timestamp(0) NULL DEFAULT timezone('UTC'::text, now()),
    updated_date timestamp(0) NULL,
    CONSTRAINT asset_pkey PRIMARY KEY (id),
    CONSTRAINT asset_code_key UNIQUE (code),
    CONSTRAINT asset_name_key UNIQUE (name)
);

INSERT INTO public.asset (id, "name", code, price, description) VALUES('1', 'Bitcoin', 'BTC', 58000, '');

