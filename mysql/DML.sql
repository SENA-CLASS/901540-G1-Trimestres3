-- Sentencias DML

-- insert, update, delete, select

CREATE SCHEMA EJEMPLO3;

CREATE TABLE EJEMPLO3.ANIMAL(
ID_ANIMAL INT NOT NULL AUTO_INCREMENT,
NOMBRE_ANIMAL VARCHAR(40),
EDAD INT,
FECHA_NACIMIENTO DATE,
TIPO_ANIMAL ENUM ('PERRO', 'GATO'),
PRIMARY KEY(ID_ANIMAL)
);

CREATE TABLE EJEMPLO3.ANIMAL2(
ID_ANIMAL INT NOT NULL AUTO_INCREMENT,
NOMBRE_ANIMAL VARCHAR(40),
EDAD INT,
FECHA_NACIMIENTO DATE,
TIPO_ANIMAL ENUM ('PERRO', 'GATO'),
PRIMARY KEY(ID_ANIMAL)
);


-- CUANDO QUIERO LLENAR TODOS LOS CAMPOS

INSERT INTO EJEMPLO3.ANIMAL VALUES (2, 'PLILI2', 20, '2011-11-11', 'GATO');

-- CUANDO QUIERO INSERTAR DATOS ESPECIFICOS

INSERT INTO EJEMPLO3.ANIMAL (ID_ANIMAL,NOMBRE_ANIMAL, TIPO_ANIMAL) VALUES (1,'PILI','PERRO');
INSERT INTO EJEMPLO3.ANIMAL (NOMBRE_ANIMAL, TIPO_ANIMAL) VALUES ('PILI','PERRO');

-- ALTER PARA METER UN CAMPO LONBLOG PARA UNA IMAGEN

ALTER TABLE EJEMPLO3.ANIMAL ADD COLUMN FOTO longblob;

INSERT INTO EJEMPLO3.ANIMAL (NOMBRE_ANIMAL, TIPO_ANIMAL, FOTO) 
VALUES ('PILI','PERRO', load_file('C:/imagen/maxresdefault.jpg'));

INSERT INTO EJEMPLO3.ANIMAL2  (ID_ANIMAL, NOMBRE_ANIMAL, EDAD, FECHA_NACIMIENTO, TIPO_ANIMAL)
SELECT A.ID_ANIMAL, A.NOMBRE_ANIMAL, A.EDAD, A.FECHA_NACIMIENTO, A.TIPO_ANIMAL FROM EJEMPLO3.ANIMAL A WHERE A.ID_ANIMAL=34;

ALTER TABLE EJEMPLO3.ANIMAL2 ADD COLUMN FOTO longblob;

INSERT INTO EJEMPLO3.ANIMAL2  
SELECT * FROM EJEMPLO3.ANIMAL A WHERE A.ID_ANIMAL=34;

-- cuando necesito insertar varios registros en una sola sentencia insert
INSERT INTO EJEMPLO3.ANIMAL (NOMBRE_ANIMAL, TIPO_ANIMAL, FOTO) 
VALUES ('PILI','PERRO', load_file('C:/imagen/maxresdefault.jpg')),
('PILI','PERRO', load_file('C:/imagen/maxresdefault.jpg')),
('PILI','PERRO', load_file('C:/imagen/maxresdefault.jpg')),
('PILI','PERRO', load_file('C:/imagen/maxresdefault.jpg')),
('PILI','PERRO', load_file('C:/imagen/maxresdefault.jpg'));


-- replace

REPLACE INTO EJEMPLO3.ANIMAL (ID_ANIMAL,NOMBRE_ANIMAL, TIPO_ANIMAL, FOTO)
VALUES (50,'PILI','PERRO', load_file('C:/imagen/maxresdefault.jpg'));

-- UPDATE ACTUALIZAR

UPDATE EJEMPLO3.ANIMAL SET NOMBRE_ANIMAL= 'JAJAJAJA', TIPO_ANIMAL= 'GATO'  WHERE ID_ANIMAL =1;

UPDATE EJEMPLO3.ANIMAL SET  TIPO_ANIMAL= 'GATO'  WHERE ID_ANIMAL<10 AND ID_ANIMAL>5 LIMIT 2;

UPDATE EJEMPLO3.ANIMAL SET  TIPO_ANIMAL= 'GATO'  WHERE ID_ANIMAL<51  ORDER BY ID_ANIMAL ASC LIMIT 5;

-- DELETE BORRAR 

DELETE FROM EJEMPLO3.ANIMAL WHERE ID_ANIMAL=1;

DELETE FROM EJEMPLO3.ANIMAL WHERE ID_ANIMAL>=5 AND ID_ANIMAL<=10;

DELETE FROM EJEMPLO3.ANIMAL WHERE ID_ANIMAL>=1 ORDER BY ID_ANIMAL DESC LIMIT 5;

-- SELECT CONSULTAR

SELECT * FROM EJEMPLO3.ANIMAL;

SELECT NOMBRE_ANIMAL, TIPO_ANIMAL FROM EJEMPLO3.ANIMAL;
SELECT NOMBRE_ANIMAL, TIPO_ANIMAL FROM EJEMPLO3.ANIMAL WHERE ID_ANIMAL = 11;

-- SENTENCIA WHERE

SELECT DISTINCT TIPO_ANIMAL FROM EJEMPLO3.ANIMAL;

SELECT now() FROM dual;

INSERT INTO tienda_online2.factura
(ID_FACTURA,
CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO,
CUENTA_NUMERO_DOCUMENTO,
FECHA_FACTURA,
FORMA_PAGO,
ESTADO)
VALUES
(11,
'C.C',
'177947678',
(SELECT now() FROM dual),
'Efectivo',
'Activo');

-- condiciones del where

-- igual

select * from tienda_online2.factura f where f.ID_FACTURA=1;

-- diferente
select * from tienda_online2.factura f where f.ID_FACTURA!=1;

-- mayor
select * from tienda_online2.factura f where f.ID_FACTURA>2;


-- menor
select * from tienda_online2.factura f where f.ID_FACTURA<2;


-- mayor o igual
select * from tienda_online2.factura f where f.ID_FACTURA>2;


-- menor o igual
select * from tienda_online2.factura f where f.ID_FACTURA<=2;

select i.PEDIDO_FACTURA_ID_FACTURA from tienda_online2.item i where i.PRODUCTO_ID_PRODUCTO='11';
select m.NOMNBRE_MUNICIPIO from tienda_online2.municipio m where m.DEPARTAMENTO_ID_DEPARTAMENTO=10;

select count(m.DEPARTAMENTO_ID_DEPARTAMENTO)
from tienda_online2.municipio m where m.DEPARTAMENTO_ID_DEPARTAMENTO=15 || m.DEPARTAMENTO_ID_DEPARTAMENTO=18;

select * from tienda_online2.cuenta cu where cu.SEGUNRO_NOMBRE is null;
select * from tienda_online2.cuenta cu where cu.SEGUNRO_NOMBRE is not null;

-- BETWEEN

select * from tienda_online2.producto p where p.ID_PRODUCTO >2 and p.ID_PRODUCTO<10;
select * from tienda_online2.producto p where p.ID_PRODUCTO BETWEEN 3 and 9;

-- is
select p.precio_detal,p.precio_detal > 50000 is true as "precio alto", 
p.precio_detal <= 50000 is true as "precio bajo"  
from tienda_online2.producto p ;

select f.ID_FACTURA,f.ESTADO, f.ESTADO = 'Activo' is false as "Estado Binario" from tienda_online2.factura f;

-- like


select * from tienda_online2.municipio m where m.NOMNBRE_MUNICIPIO like 'a%'; 
select * from tienda_online2.municipio m where m.NOMNBRE_MUNICIPIO like '%papa%'; 
select * from tienda_online2.municipio m where m.NOMNBRE_MUNICIPIO like '%z';
select * from tienda_online2.municipio m where m.NOMNBRE_MUNICIPIO like 'a%z';
select * from tienda_online2.municipio m where m.NOMNBRE_MUNICIPIO like '%a%z%';

-- in

select * from tienda_online2.municipio m 
where m.NOMNBRE_MUNICIPIO='OTANCHE' OR m.NOMNBRE_MUNICIPIO='pacho';
select * from tienda_online2.municipio m 
where m.NOMNBRE_MUNICIPIO in ('OTANCHE','pacho');

select case t.TIPO_DOCUMENTO 
when 'C.C' then 'Cedulita' end as "tipo"   from tienda_online2.tipo_documento t;

-- NOT

select * 
from tienda_online2.municipio m 
where NOT(m.NOMNBRE_MUNICIPIO='OTANCHE' OR m.NOMNBRE_MUNICIPIO='pacho');

-- BINARY

select * 
from tienda_online2.municipio m 
where  binary(M.NOMNBRE_MUNICIPIO)='pacho';

-- COLLAGE NO EXISTE EN ESTA VERSION DE MYSQL

select * 
from tienda_online2.municipio m 
where  COLLAGE(M.NOMNBRE_MUNICIPIO)='pacho';

select sum(i.CANTIDAD) from tienda_online2.item i;

select * from tienda_online2.item i;
select p.PRECIO_DETAl from tienda_online2.producto p where p.ID_PRODUCTO=3; 

UPDATE tienda_online2.item i 
SET 
    i.COSTO_UNITARIO = (SELECT 
            p.PRECIO_DETAl
        FROM
            tienda_online2.producto p
        WHERE
            p.ID_PRODUCTO = 8)
WHERE
    i.PRODUCTO_ID_PRODUCTO = 8 and i.PEDIDO_FACTURA_ID_FACTURA=4;
    
    
    
select * from tienda_online2.item;
    
 -- precio unitario   
select * from tienda_online2.item t2
where t2.PEDIDO_FACTURA_ID_FACTURA=1 and t2.PRODUCTO_ID_PRODUCTO=1
;    

update tienda_online2.item t1
inner join (select * from tienda_online2.item) t2
on t1.PEDIDO_FACTURA_ID_FACTURA= t2.PEDIDO_FACTURA_ID_FACTURA and t1.PRODUCTO_ID_PRODUCTO=t2.PRODUCTO_ID_PRODUCTO
set t1.costo_Total= (t2.COSTO_UNITARIO*t2.CANTIDAD)
where  t1.PEDIDO_FACTURA_ID_FACTURA=1 and t1.PRODUCTO_ID_PRODUCTO=2;
-- 
    
    

