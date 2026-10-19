-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-10-2026 a las 01:23:27
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sulp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `apellido` varchar(100) NOT NULL DEFAULT '',
  `nombre` varchar(30) NOT NULL,
  `fecNac` date NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`idAlumno`, `dni`, `apellido`, `nombre`, `fecNac`, `activo`) VALUES
(12, 40485556, 'Gagliano', 'Juan Cruz', '1997-09-13', 1),
(13, 41055197, 'Lopez', 'Melanie', '1998-03-24', 1),
(14, 40111222, 'Gomez', 'Lucia', '2002-04-15', 1),
(15, 41222333, 'Fernandez', 'Mateo', '2003-08-21', 1),
(16, 42333444, 'Rodriguez', 'Sofia', '2004-01-10', 1),
(17, 43444555, 'Lopez', 'Melanie', '2002-11-05', 1),
(18, 44555666, 'Martinez', 'Tomas', '2001-06-18', 1),
(19, 45666777, 'Perez', 'Camila', '2003-03-27', 1),
(20, 46777888, 'Diaz', 'Nicolas', '2004-09-12', 1),
(21, 47888999, 'Torres', 'Valentina', '2002-12-30', 1),
(22, 38999111, 'Acosta', 'Facundo', '2001-07-09', 1),
(23, 39000111, 'Suarez', 'Agustina', '2003-02-14', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idAlumno`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
