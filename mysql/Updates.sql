-- Updates

-- 1. hacer un update del campo timpo de documento de CC C.C a CN

update tienda_online2.tipo_documento td
set td.tipo_documento= 'CN', 
td.DESCRIPCION= 'nueva ciudadania'

where td.TIPO_DOCUMENTO = 'C.C';


DELETE FROM tienda_online2.tipo_documento 
WHERE TIPO_DOCUMENTO = 'RUIP';

1. actulizar el numero de doucmento de dos cuentas
2- actualizar un tipo de documento
3- actualizar los totales de los items
4. actualizar el total de la factura
5 eliminar 5 municipios



