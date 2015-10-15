create schema ejemplo;

DROP TABLE EJEMPLO.EJEMPLO1;


-- LOS TIPOS DE DATOS NUMERICOS----------------------------------------------------------------------

-- ENTEROS
-- creacion de tabla ejemplo1 para enteros
CREATE TABLE ejemplo.ejemplo1 (
    campo1 TINYINT NOT NULL,
    campo2 TINYINT UNSIGNED,
    
    campo3 SMALLINT,
    campo4 SMALLINT UNSIGNED,
    
    campo5 MEDIUMINT,
    campo6 MEDIUMINT UNSIGNED,
    
    campo7 INT,
    campo8 INT UNSIGNED,
    
    campo9 BIGINT,
    campo10 BIGINT UNSIGNED,
    
    PRIMARY KEY (CAMPO1)
);

-- REALES
-- creacion de tabla ejemplo1 para reales
create table ejemplo.ejemplo2 (
	campo1 decimal not null primary key,
    campo2 decimal(8,2),
    
    campo3 float,
    campo4 float(8,3),
    
    campo5 double,
    campo6 double(6,5),
    
    campo7 real,
    campo8 real(5,5)
   -- falta llave primaria para poder insertar datos
);

-- LOGICOS
-- creacion de tabla ejemplo1 para logicos
create table ejemplo.ejemplo3 (
	campo1 bit not null primary key,
    campo2 bool,
    campo3 boolean
	-- falta llave primaria para poder insertar datos
);

-- LOS TIPOS DE DATOS TEMPORALES----------------------------------------------------------------------

create table ejemplo.ejemplo4 (
	campo1 date not null primary key,
    campo2 datetime,
    campo3 timestamp,
    campo4 time,
    campo5 year
    
	-- falta llave primaria para poder insertar datos
);

-- LOS TIPOS DE DATOS CADENA DE CARACTERES----------------------------------------------------------------------
-- el tamaño es de 255
create table ejemplo.ejemplo5 (
	CAMPO1 char not null primary key,
    campo2 varchar(10),
    campo3 TINYBLOB,
    campo4 TINYTEXT,
    
    campo5 char(2)
	-- falta llave primaria para poder insertar datos
);

-- mayores de 255 hasta 
create table ejemplo.ejemplo6 (
	llave int not null primary key,
	CAMPO1 text,
    campo2 blob,
    campo3 	mediumblob,
    campo4 mediumtext,
    
    campo5 longblob,
    campo6 longtext,
    campo7 enum('Femenino','Masculino'),
    campo8 set('sfdasdfasdf','asdfadfasdf','asdfasdfasdfasd')
    
	-- falta llave primaria para poder insertar datos
);



