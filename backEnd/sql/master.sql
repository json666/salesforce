/*
SALESFORCE CLASIF_CATEGORIAS
 */
insert into SALESFORCE.CLASIF_CATEGORIAS (DESABILITADO, DESCRIPCION_CATEGORIA, FECHA_DESDE, FECHA_HASTA, USUARIOA_ACT) values (FALSE, 'JOYAS', now(), now(), 'JSON');
insert into SALESFORCE.CLASIF_CATEGORIAS (DESABILITADO, DESCRIPCION_CATEGORIA, FECHA_DESDE, FECHA_HASTA, USUARIOA_ACT) values (FALSE, 'BOJOUTERIA', now(), now(), 'JSON');
insert into SALESFORCE.CLASIF_CATEGORIAS (DESABILITADO, DESCRIPCION_CATEGORIA, FECHA_DESDE, FECHA_HASTA, USUARIOA_ACT) values (FALSE, 'INSUMOS', now(), now(), 'JSON');

/*
SALESFORCE CLASIF_CLASES
 */
insert into SALESFORCE.CLASIF_CLASES (DESABILITADO, DESCRIPCION_CLASE, FECHA_DESDE, FECHA_HASTA, USUARIOA_ACT, CLASIF_CATEGORIA_ID) values (FALSE, 'ANILLO', now(), now(), 'JSON',2);
insert into SALESFORCE.CLASIF_CLASES (DESABILITADO, DESCRIPCION_CLASE, FECHA_DESDE, FECHA_HASTA, USUARIOA_ACT, CLASIF_CATEGORIA_ID) values (FALSE, 'ARETES', now(), now(), 'JSON',2);
insert into SALESFORCE.CLASIF_CLASES (DESABILITADO, DESCRIPCION_CLASE, FECHA_DESDE, FECHA_HASTA, USUARIOA_ACT, CLASIF_CATEGORIA_ID) values (FALSE, 'PULSERA', now(), now(), 'JSON',2);
insert into SALESFORCE.CLASIF_CLASES (DESABILITADO, DESCRIPCION_CLASE, FECHA_DESDE, FECHA_HASTA, USUARIOA_ACT, CLASIF_CATEGORIA_ID) values (FALSE, 'DIJE', now(), now(), 'JSON',2);
insert into SALESFORCE.CLASIF_CLASES (DESABILITADO, DESCRIPCION_CLASE, FECHA_DESDE, FECHA_HASTA, USUARIOA_ACT, CLASIF_CATEGORIA_ID) values (FALSE, 'GARANTILLA', now(), now(), 'JSON',2);
insert into SALESFORCE.CLASIF_CLASES (DESABILITADO, DESCRIPCION_CLASE, FECHA_DESDE, FECHA_HASTA, USUARIOA_ACT, CLASIF_CATEGORIA_ID) values (FALSE, 'ANILLO', now(), now(), 'JSON',3);
insert into SALESFORCE.CLASIF_CLASES (DESABILITADO, DESCRIPCION_CLASE, FECHA_DESDE, FECHA_HASTA, USUARIOA_ACT, CLASIF_CATEGORIA_ID) values (FALSE, 'PULSERA', now(), now(), 'JSON',3);
insert into SALESFORCE.CLASIF_CLASES (DESABILITADO, DESCRIPCION_CLASE, FECHA_DESDE, FECHA_HASTA, USUARIOA_ACT, CLASIF_CATEGORIA_ID) values (FALSE, 'GRANALLA', now(), now(), 'JSON',1);
insert into SALESFORCE.CLASIF_CLASES (DESABILITADO, DESCRIPCION_CLASE, FECHA_DESDE, FECHA_HASTA, USUARIOA_ACT, CLASIF_CATEGORIA_ID) values (FALSE, 'POST', now(), now(), 'JSON',1);

/*
SALESFORCE CLASIF_UNIDAD
 */
INSERT INTO salesforce.clasif_unidades(desabilitado, codigo_unidad, descripcion_unidad, fecha_desde,fecha_hasta, usuario_act) VALUES (false, '1000', 'UNIDAD', now(),now(), 'JSON');
INSERT INTO salesforce.clasif_unidades(desabilitado, codigo_unidad, descripcion_unidad, fecha_desde,fecha_hasta, usuario_act) VALUES (false, '1001', 'GRAMOS', now(),now(), 'JSON');
/*
SALESFORCE CLASIF_MARCA
 */
INSERT INTO salesforce.clasif_marcas(desabilitado, codigo_marca, descripcion_marca, fecha_desde,fecha_hasta, usuario_act) VALUES (FALSE, '0001', 'AFRODITA', now(),now(), 'JSON');
INSERT INTO salesforce.clasif_marcas(desabilitado, codigo_marca, descripcion_marca, fecha_desde,fecha_hasta, usuario_act) VALUES (FALSE, '0002', 'AFRODITA 2', now(),now(), 'JSON');
INSERT INTO salesforce.clasif_marcas(desabilitado, codigo_marca, descripcion_marca, fecha_desde,fecha_hasta, usuario_act) VALUES (FALSE, '0003', 'AUGUSTA FERRIER', now(),now(), 'JSON');
INSERT INTO salesforce.clasif_marcas(desabilitado, codigo_marca, descripcion_marca, fecha_desde,fecha_hasta, usuario_act) VALUES (FALSE, '0004', 'PROVEEDOR NACIONAL', now(),now(), 'JSON');
INSERT INTO salesforce.clasif_marcas(desabilitado, codigo_marca, descripcion_marca, fecha_desde,fecha_hasta, usuario_act) VALUES (FALSE, '0005', 'RIO GRANDE', now(),now(), 'JSON');

/*
SALESFORCE CLASIF_MOVIMIENTO
 */
 INSERT INTO salesforce.clasif_movimientos(desabilitado, clasif_movimientos, descripcion_movimiento,fecha_desde, fecha_hasta, usuario_act) VALUES (false, 'COMPRA','COMPRA DE MERCANCIA',now(),now(), 'JSON');
 INSERT INTO salesforce.clasif_movimientos(desabilitado, clasif_movimientos, descripcion_movimiento,fecha_desde, fecha_hasta, usuario_act) VALUES (false, 'VENTA','VENTA DE MERCANCIA',now(),now(), 'JSON');

/*
SALESFORCE USUARIOS
 */

INSERT INTO salesforce.usuarios(desabilitado, estado, materno, nombre_usuario, nombre, password, paterno, rol, email) VALUES (false, 'AC', 'admin', 'admin', 'admin', 'admin','admin', 'ADMINISTRADOR', 'admin@afrodita.com');
INSERT INTO salesforce.usuarios(desabilitado, estado, materno, nombre_usuario, nombre, password, paterno, rol, email) VALUES (false, 'AC', 'CUISI', 'acuisi', 'CUISI', 'acuisi','CUISI', 'VENDEDOR', 'acuisi@afrodita.com');
INSERT INTO salesforce.usuarios(desabilitado, estado, materno, nombre_usuario, nombre, password, paterno, rol, email) VALUES (false, 'AC', 'vendedor', 'vendedor', 'VENDEDOR', 'vendedor','VENDEDOR', 'VENDEDOR', 'vendedor@afrodita.com');

