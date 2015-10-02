-- CREACON DE TABLAS

create schema ejemplo2;

-- crear una tabla
create table ejemplo2.ejemplo1(
	campo1 int

);

-- cuando un campo es unicode
create table ejemplo2.ejemplo2(
	campo1  int unique

);

-- cuando el campo es no nulo

create table ejemplo2.ejemplo3(
	campo1  int not null

);

-- cuand el campo es nulo
create table ejemplo2.ejemplo4(
	campo1  int null

);
create table ejemplo2.ejemplo5(
	campo1  int 

);

-- cuando el campo es default

create table ejemplo2.ejemplo6(
	campo1  int primary key,
    sexo varchar(1) default 'M'

);

-- cuando un campo es auto incrementable
create table ejemplo2.ejemplo7(
	campo1  int auto_increment primary key,
    campo2 varchar(10)
);

-- cuando un campo es una llave primaria
create table ejemplo2.ejemplo8(
	campo1  int  primary key
    
);

create table ejemplo2.ejemplo10(
	campo1  int,  
    primary key(campo1)
    
);
-- cuando varios campos son llaves primaria

create table ejemplo2.ejemplo9(
	campo1  int,
    campo2  int,
    campo3  int,
    campo4  int,
    primary key (campo1,campo2,campo3,campo4)
    
);

-- comentariar un campo
create table ejemplo2.ejemplo11(
	campo1  int comment 'este es el campo 1',
    campo2  int comment 'este es el campo 2',
    campo3  int comment 'este es el campo 3',
    campo4  int comment 'este es el campo 4',
    primary key (campo1,campo2,campo3,campo4)
    
);


-- cuando un campo es una llave foranea no identificable

create table ejemplo2.servicios(
NUM_SER integer(2) primary key
);

CREATE TABLE ejemplo2.EMPLEADOS (
    NUM_EMPLEADO INTEGER(4) PRIMARY KEY,
    NOMBRE VARCHAR(30),
    PUESTO VARCHAR(15),
    JEFE INTEGER(4),
    FECH_CONTRAT DATE,
    SALARIO FLOAT(7 , 2 ),
    COMISION FLOAT(7 , 2 ),
    NUM_SERVICIO INTEGER(2) NOT NULL,
    FOREIGN KEY (NUM_SERVICIO)
        REFERENCES ejemplo2.SERVICIOS (NUM_SER)
)
;

-- cuando un campo es una llave idntificale
create table ejemplo2.servicios2(
NUM_SER integer(2) primary key
);

CREATE TABLE ejemplo2.EMPLEADOS2 (
    NUM_EMPLEADO INTEGER(4) ,
    NOMBRE VARCHAR(30),
    PUESTO VARCHAR(15),
    JEFE INTEGER(4),
    FECH_CONTRAT DATE,
    SALARIO FLOAT(7 , 2 ),
    COMISION FLOAT(7 , 2 ),
    NUM_SERVICIO INTEGER(2),
    FOREIGN KEY (NUM_SERVICIO)
        REFERENCES ejemplo2.SERVICIOS2 (NUM_SER),
        PRIMARY KEY(NUM_EMPLEADO, NUM_SERVICIO)
);

-- cuando un campo tienen una restriccion check

create table ejemplo2.ejemplo12(
	campo1 int primary key,
    campo2 int,
    check(campo2>200) -- no sirve en mysql http://stackoverflow.com/questions/2115497/check-constraint-in-mysql-is-not-working
    -- se reemplaza con un trigger
);





