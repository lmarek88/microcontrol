CREATE TABLE MC_IMAGE_CATEGORY (
    ID serial NOT NULL PRIMARY KEY,
    CODE VARCHAR(255),
    NAME VARCHAR(255),
    ACTIVE boolean default true
) WITH ( OIDS = FALSE );

Insert into MC_IMAGE_CATEGORY (CODE, NAME) values ('ELECTRONICS', 'Elektronika');
Insert into MC_IMAGE_CATEGORY (CODE, NAME) values ('AUTOMATION', 'Automatyka i budowa maszyn');
Insert into MC_IMAGE_CATEGORY (CODE, NAME) values ('ELECTRICS', 'Elektryka, sieci strukturalne i CCTV');
Insert into MC_IMAGE_CATEGORY (CODE, NAME) values ('SAPDSO', 'SAP i DSO');

CREATE TABLE MC_IMAGE_DATA_M (
    ID serial NOT NULL PRIMARY KEY,
    IMAGE bytea 
) WITH ( OIDS = FALSE );

CREATE TABLE MC_IMAGE_DATA (
    ID serial NOT NULL PRIMARY KEY,
    IMAGE bytea 
) WITH ( OIDS = FALSE );


CREATE TABLE MC_IMAGE (
    ID serial NOT NULL PRIMARY KEY,
    DESCRIPTION VARCHAR(255),
    NAME VARCHAR(255),
    ACTIVE boolean default true,
    SEQ integer,
    IMAGE_CATEGORY_ID bigint,
    IMAGE_DATA_ID bigint,
    IMAGE_DATA_M_ID bigint,
    foreign key (IMAGE_CATEGORY_ID) REFERENCES MC_IMAGE_CATEGORY (ID),
    foreign key (IMAGE_DATA_ID) REFERENCES MC_IMAGE_DATA (ID),
    foreign key (IMAGE_DATA_M_ID) REFERENCES MC_IMAGE_DATA_M (ID)
) WITH (OIDS = FALSE);

CREATE TABLE MC_REFERENCE_DATA (
    ID serial NOT NULL PRIMARY KEY,
    FILE bytea 
) WITH ( OIDS = FALSE );

CREATE TABLE MC_REFERENCE (
    ID serial NOT NULL PRIMARY KEY,
    DESCRIPTION VARCHAR(255),
    NAME VARCHAR(255),
    ACTIVE boolean default true,
    SEQ integer,
    REFERENCE_DATA_ID bigint,   
    foreign key (REFERENCE_DATA_ID) REFERENCES MC_REFERENCE_DATA(ID)
) WITH (OIDS = FALSE);
