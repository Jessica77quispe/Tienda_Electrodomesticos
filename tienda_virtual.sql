-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-12-2021 a las 00:19:01
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda_virtual`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCategoria` (IN `_descripcion` VARCHAR(50), IN `_imagen` VARCHAR(500))  BEGIN
INSERT INTO categoria(descripcion,imagen)VALUE (_descripcion, _imagen);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProductos` (IN `_nombre_producto` VARCHAR(100), IN `_imagen_1` VARCHAR(200), IN `_imagen_2` VARCHAR(200), IN `_precio` FLOAT(50), IN `_descripcion` VARCHAR(50), IN `_marca` VARCHAR(50), IN `_stock` INT(10), IN `_estado` VARCHAR(50), IN `_id_proveedores` INT(50), IN `_id_categoria` INT(21))  BEGIN
INSERT INTO productos(nombre_producto ,imagen_1,imagen_2,precio,descripcion,marca,stock, estado,id_proveedores, id_categoria)VALUE (_nombre_producto , _imagen_1,_imagen_2,_precio,_descripcion,_marca,_stock, _estado,_id_proveedores, _id_categoria);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `imagen` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `descripcion`, `imagen`) VALUES
(1, 'Celulares', 'img/calulares.jpg'),
(2, 'Laptop', 'img/laptops.jpg'),
(3, 'Impresoras', 'img/impresoras.jpg'),
(4, 'Cocina', 'img/cocina.jpg'),
(5, 'Refrigeradores', 'img/refrigerador.jpg'),
(6, 'Televisores', 'img/televisores.jpg'),
(7, 'Lavadoras', 'img/lavadora.jpg'),
(8, 'Camaras', 'img/microondas.jpg'),
(9, 'Accesorios', 'img/accesorios.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `ci` varchar(20) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombre`, `apellido`, `ci`, `correo`, `telefono`, `direccion`, `password`) VALUES
(1, 'Ramiro', 'Guzman', '9950242', 'Alejandromartines@gmail.com', '78526934', 'Av. bolivia Calle 3', 'Alejandro123'),
(2, 'Alex', 'Ramos', '8524369', 'Alexra@gmail.com', '75325542', 'c/ Brazil nro 434', 'alex852');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_compra`
--

CREATE TABLE `detalle_compra` (
  `id_detalle` int(10) NOT NULL,
  `id_factura` int(10) DEFAULT NULL,
  `id_producto` int(10) DEFAULT NULL,
  `cantidad` int(20) DEFAULT NULL,
  `precio` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturacion`
--

CREATE TABLE `facturacion` (
  `id_factura` int(10) NOT NULL,
  `id_cliente` int(10) DEFAULT NULL,
  `fecha` varchar(10) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `localidad` varchar(20) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `codigo_postal` varchar(10) DEFAULT NULL,
  `observaciones` varchar(50) DEFAULT NULL,
  `modo_pago` int(10) DEFAULT NULL,
  `Titular_tarjeta` varchar(30) NOT NULL,
  `numero_tarjeta` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modo_pago`
--

CREATE TABLE `modo_pago` (
  `id_pago` int(10) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `modo_pago`
--

INSERT INTO `modo_pago` (`id_pago`, `descripcion`) VALUES
(1, 'Tarjeta De Credito'),
(3, 'Transferencia Bancaria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id_pedido` int(10) NOT NULL,
  `num_factura` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(10) NOT NULL,
  `nombre_producto` varchar(100) DEFAULT NULL,
  `imagen_1` varchar(500) NOT NULL,
  `imagen_2` varchar(500) NOT NULL,
  `precio` double DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `stock` int(100) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `id_proveedores` int(50) DEFAULT NULL,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre_producto`, `imagen_1`, `imagen_2`, `precio`, `descripcion`, `marca`, `stock`, `estado`, `id_proveedores`, `id_categoria`) VALUES
(2, 'Aspiradora EINHELL', 'img/aspiradora EINHELL.jpg', 'img/Aspiradora EINHELL2.jpg', 469, 'El aspirador seco y hÃºmedo TC-VC 1820 S ', 'EINHELL', 25, 'promocion', 3, 9),
(3, 'aspiradora inalambrica 18v MAKITA', 'img/aspiradora inalambrica 18v MAKITA.jpg', 'img/aspiradora inalambrica USB.jpg', 999.5, 'aspiradora inalambrica\r\n', 'Makita', 55, 'disponible', 3, 9),
(4, 'Equipo-de-sonido-lg', 'img/Equipo-de-sonido-lg-ok55-500w_20030.jpg', 'img/Equipo-De-Sonido-Parlantes-PC-TV-40w-Bluetooth-Usb-Sd-Rca-Aux.jpg', 695.6, 'Equipo de sonido LG OK55 \r\n', 'LG', 9, 'disponible', 4, 9),
(5, 'Cocina de piso 76', 'img/imagen 1.1.jpeg', 'img/imagen 1.jpeg', 995.6, 'Cocina de piso 76 acero inoxidable\r\n', 'Tramontina', 0, 'agotado', 4, 4),
(6, 'Cocina de piso 76 ambe', 'img/imagen 2.1.jpeg', 'img/imagen 2.jpeg', 1500, 'Cocina de piso 76 Silver mabe acero inoxidable\r\n', 'Silver', 5, 'promocion', 3, 4),
(7, 'Cocina de piso 55cm', 'img/imagen 3.1.jpeg', 'img/imagen 3.jpeg', 1350.2, 'Cocina de piso 76 Gris mabe\r\n', 'Mabe', 2, 'disponible', 3, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id_proveedor` int(10) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `cantidad` int(15) DEFAULT NULL,
  `precio` float(11,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id_proveedor`, `descripcion`, `telefono`, `direccion`, `cantidad`, `precio`) VALUES
(1, 'distribuidora Asp', '22256584', 'cochabamba Av. tocop', 100, 59100.00),
(3, 'Distribuidora bolivia s.a', '22454575', 'Dep. Cochabamba Av. tocopilla', 50, 15000.00),
(4, 'Distribuidora Elec S.A', '22225454', 'Dep. La Paz  Av. Buenos Aires', 10, 35000.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(10) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `ci` varchar(20) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `ci`, `correo`, `telefono`, `password`) VALUES
(2, 'Nadia', 'Guzman', '7854215', 'Nadia@gmail.com', '75236942', 'NadiaGuz');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ci` (`ci`);

--
-- Indices de la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  ADD PRIMARY KEY (`id_detalle`),
  ADD KEY `num_factura` (`id_factura`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `facturacion`
--
ALTER TABLE `facturacion`
  ADD PRIMARY KEY (`id_factura`),
  ADD KEY `modo_pago` (`modo_pago`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `modo_pago`
--
ALTER TABLE `modo_pago`
  ADD PRIMARY KEY (`id_pago`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `num_factura` (`num_factura`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_proveedores` (`id_proveedores`),
  ADD KEY `for_cat` (`id_categoria`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  MODIFY `id_detalle` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `facturacion`
--
ALTER TABLE `facturacion`
  MODIFY `id_factura` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `modo_pago`
--
ALTER TABLE `modo_pago`
  MODIFY `id_pago` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id_pedido` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id_proveedor` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  ADD CONSTRAINT `detalle_compra_ibfk_1` FOREIGN KEY (`id_factura`) REFERENCES `facturacion` (`id_factura`),
  ADD CONSTRAINT `detalle_compra_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`);

--
-- Filtros para la tabla `facturacion`
--
ALTER TABLE `facturacion`
  ADD CONSTRAINT `facturacion_ibfk_1` FOREIGN KEY (`modo_pago`) REFERENCES `modo_pago` (`id_pago`),
  ADD CONSTRAINT `facturacion_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`num_factura`) REFERENCES `facturacion` (`id_factura`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `for_cat` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_proveedores`) REFERENCES `proveedores` (`id_proveedor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
