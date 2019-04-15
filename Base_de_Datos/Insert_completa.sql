INSERT INTO `mydb`.`series`
(`NDeSerie`,
`Descripcion`)
VALUES
(1,
"p");


INSERT INTO `mydb`.`suelas`
(`Referencia`,
`Descripcion`,
`Precio`)
VALUES
(1,
"d",
23.3);


INSERT INTO `mydb`.`herrajes`
(`Referencia`,
`Descripcion`,
`Precio`)
VALUES
(1,
"d",
3.3);

INSERT INTO `mydb`.`materiales`
(`Referencia`,
`Descripcion`,
`Precio`)
VALUES
(1,
"d",
2.2);


INSERT INTO `mydb`.`articulos`
(`Referencia`,
`Serie`,
`Descripcion`,
`CantidadMaterial`,
`CantidadHerraje`,
`Precio`,
`Suelas_Referencia`)
VALUES
(1,
1,
"d",
3,
3,
32.3,
1);

INSERT INTO `mydb`.`clientes`
(`NCliente`,
`NombreYApellidos`,
`DNI_NIF`,
`DireccionDeCliente`,
`Provincia`,
`Telefono`,
`Email`)
VALUES
(1,
"p",
"2",
"2",
"2",
2,
"2");


INSERT INTO `mydb`.`pedidos`
(`NPedido`,
`Fecha_de_pedido`,
`Fecha_de_entrega`,
`Entregado`,
`Clientes_NCliente`,
`NombreYApellidos`)
VALUES
(1,
"2019-04-02",
"2019-07-02",
0,
1,
"j");


INSERT INTO `mydb`.`envios`
(`NEnvio`,
`NombreCliente`,
`DireccionDeEnvio`,
`PoblacionDeEnvio`,
`CPDeEnvio`,
`ProvinciaDeEnvio`,
`TelefonoDeEnvio`,
`Clientes_NCliente`)
VALUES
(1,
"j",
"2",
"2",
2,
"2",
2,
1);


INSERT INTO `mydb`.`desglosedepedidos`
(`NPedidoD`,
`Serie`,
`Color`,
`Articulos_Referencia`,
`P5`,
`P6`,
`P7`,
`P8`,
`P9`,
`P0`,
`P1`,
`P2`,
`P3`,
`P4`,
`CantidadTotalPies`,
`Pedidos_NPedido`)
VALUES
(1,
1,
1,
1,
1,
1,
1,
1,
1,
1,
1,
1,
1,
1,
10,
1);