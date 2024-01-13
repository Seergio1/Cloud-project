-- create database g_stock
CREATE TABLE out_method 
{
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
};

INSERT INTO out_method (id, name) VALUES (20,'FIFO');
INSERT INTO out_method (id, name) VALUES (21,'LIFO');

CREATE TABLE location (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

INSERT INTO location (id, name) VALUES (20,'Ambatomanga');
INSERT INTO location (id, name) VALUES (21,'Amboanjobe');
INSERT INTO location (id, name) VALUES (22,'Analakely');
INSERT INTO location (id, name) VALUES (23,'67 ha');

CREATE TABLE magasin (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    id_location VARCHAR(100) REFERENCES location (id) ON DELETE CASCADE 
);

INSERT INTO magasin (id, name, id_location) VALUES (20,'Carrefour',20);
INSERT INTO magasin (id, name, id_location) VALUES (21,'Carrefour',23);
INSERT INTO magasin (id, name, id_location) VALUES (22,'Kibo',20);
INSERT INTO magasin (id, name, id_location) VALUES (23,'Supermaki',21);
INSERT INTO magasin (id, name, id_location) VALUES (24,'Super U',22);

CREATE TABLE article (
    id SERIAL PRIMARY KEY ,
    code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL ,
    id_out_method INT REFERENCES out_method (id) ON DELETE CASCADE
);

INSERT INTO article (code,name,id_out_method) VALUES ("R-11","riz blanc simple",20);
INSERT INTO article (code,name,id_out_method) VALUES ("R-12","riz blanc stock tompan",21);
INSERT INTO article (code,name,id_out_method) VALUES ("R-21","riz rouge simple",20);
INSERT INTO article (code,name,id_out_method) VALUES ("R-22","riz rouge stock tompan",21);

CREATE TABLE article_magasin(
    id SERIAL PRIMARY KEY,
    id_article INT REFERENCES article (id) ON DELETE CASCADE ,
    id_magasin INT REFERENCES magasin (id) ON DELETE CASCADE
);

-- juste oe liste ana mouvement 
CREATE TABLE movement(
    id SERIAL PRIMARY KEY,
    status_direction VARCHAR(50) NOT NULL,-- in || out
    id_article INT REFERENCES article (id) ON DELETE CASCADE,
    quantity NUMERIC(15) NOT NULL,
    price_unity NUMERIC(15) NOT NULL,
    date TIMESTAMP NOT NULL,
    id_magasin INT REFERENCES magasin (id) ON DELETE CASCADE
);

-- ato ny eto anleh article en stock
-- na manao entré na sortie de mampiditra ato
CREATE TABLE article_in_stock (
    id SERIAL PRIMARY KEY,
    id_article INT REFERENCES article (id) ON DELETE CASCADE,
    quantity NUMERIC(15) NOT NULL,
    id_magasin INT REFERENCES magasin (id) ON DELETE CASCADE ,
    date TIMESTAMP NOT NULL ,
    price NUMERIC(15) -- prix anleh izy ao // prix moyenne calculena,
    id_movement INT REFERENCES movement (id) ON DELETE CASCADE
);

CREATE TABLE movement_out_details(
    id SERIAL PRIMARY KEY,
    -- lay mivoka
    id_movement_out INT REFERENCES movement (id) ON DELETE CASCADE DELETE,
    -- lay analana anlay mivoka
    id_movement_in INT REFERENCES movement (id) ON DELETE CASCADE,
    quantity NUMERIC(15) NOT NULL
);


-- etat de stock denormaliser .. a revoir
INSERT INTO out_method  VALUES (1,'FIFO');
INSERT INTO out_method VALUES (2,'LIFO');

INSERT INTO location VALUES (1,'Ambatomanga');

INSERT INTO magasin  VALUES (1,'Super U',1); 
INSERT INTO magasin  VALUES (2,'Leader price',1); 


INSERT INTO article  VALUES (1,'R-11','riz blanc simple',1);
INSERT INTO article  VALUES (2,'R-12','riz blanc stock tompan',2);

INSERT INTO mouvement VALUES(1,'in',1,1000.0,250.0,NOW(),1);
INSERT INTO mouvement VALUES(2,'in',1,500.0,300.0,NOW(),1);



{
    "status_direction":"in",
    "article":{
        "id":2
    },
    "quantity":13200.0,
    "price_unity":300.0,
    "date":"2023-11-19T00:00:18.0",
    "magasin":{
        "id":1
    },
    "etat":20
}



-- drop all table and sequence

drop sequence article_magasin_sequence;
drop sequence mouvement_out_details_sequence;
drop sequence article_in_stock_sequence;
drop sequence etat_stock_sequence;
drop sequence validation_sequence;
drop sequence mouvement_sequence;
drop sequence article_sequence;
drop sequence out_method_sequence;
drop sequence magasin_sequence;
drop sequence location_sequence;

drop table article_magasin;
drop table mouvement_out_details;
drop table article_in_stock;
drop table etat_stock;
drop table validation;
drop table mouvement;
drop table article;
drop table out_method;
drop table magasin;
drop table location;

