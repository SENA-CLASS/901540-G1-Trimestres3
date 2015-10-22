-- joins

-- producto cartesano tenr cuidado al usarlo

select m.* from tienda_online2.municipio m, tienda_online2.departamento d;

select m.* from tienda_online2.municipio m, tienda_online2.departamento d
where d.ID_DEPARTAMENTO= m.DEPARTAMENTO_ID_DEPARTAMENTO;

SELECT 
    pro.NOMBRE_PRODUCTO, i.CANTIDAD, i.COSTO_UNITARIO, i.COSTO_TOTAL
FROM
    tienda_online2.factura f,
    tienda_online2.pedido p,
    tienda_online2.item i,
    tienda_online2.producto pro
where 
	f.ID_FACTURA = p.FACTURA_ID_FACTURA and
    p.FACTURA_ID_FACTURA = i.PEDIDO_FACTURA_ID_FACTURA and
    i.PRODUCTO_ID_PRODUCTO = pro.ID_PRODUCTO and
    f.ID_FACTURA=1
;

SELECT 
    pro.NOMBRE_PRODUCTO, i.CANTIDAD, i.COSTO_UNITARIO, i.COSTO_TOTAL
FROM
    tienda_online2.factura f
    inner join tienda_online2.pedido p
    on f.ID_FACTURA = p.FACTURA_ID_FACTURA
    inner join tienda_online2.item i
    on p.FACTURA_ID_FACTURA = i.PEDIDO_FACTURA_ID_FACTURA
    inner join tienda_online2.producto pro
    on i.PRODUCTO_ID_PRODUCTO = pro.ID_PRODUCTO
    
where
    f.ID_FACTURA=1
;

1. con el primer nombre del un cliente que facturas a comprado quiero saber el 
total dela factura, impuesto y el subtotal

2. con el numero de la factura quiero saber la direccion del cliente, el municipio 
y departamento

3. que productos tengo en el inventio por medio del nombre de un proovedor 
quiero saber el nombre del producto

4. por el tipo de documento y nuemro de documento como fue el pago de las 
facturas de ese cliente

5. consultar los productos que han traidos los proovedores

-- left y right join

SELECT * FROM tienda_online2.usuario u, tienda_online2.cuenta c 
where u.ID_USUARIO= c.USUARIO_ID_USUARIO;

SELECT * FROM tienda_online2.usuario u
left join tienda_online2.cuenta c 
on u.ID_USUARIO= c.USUARIO_ID_USUARIO;

SELECT * FROM tienda_online2.usuario u
left outer join tienda_online2.cuenta c 
on u.ID_USUARIO= c.USUARIO_ID_USUARIO;


