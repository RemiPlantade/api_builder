-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Sam 27 Mai 2017 à 11:19
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `api_builder`
--

--
-- Contenu de la table `api`
--

INSERT INTO `api` (`id`, `name`, `dataSource_id`, `owner_id`) VALUES
(1, 'first', 1, 1);

--
-- Contenu de la table `data_source`
--

INSERT INTO `data_source` (`id`, `address`, `login`, `name`, `port`, `pwd`, `sourceType_id`) VALUES
(1, 'localhost', 'root', 'api_builder', 3306, '', 1);

--
-- Contenu de la table `parameter`
--

INSERT INTO `parameter` (`id`, `name`) VALUES
(1, 'id');

--
-- Contenu de la table `request`
--

INSERT INTO `request` (`id`, `method`, `uri`, `api_id`) VALUES
(1, 'GET', 'api', 1);

--
-- Contenu de la table `source_type`
--

INSERT INTO `source_type` (`id`, `driver_class`, `sgbd_name`) VALUES
(1, 'com.mysql.jdbc.Driver', 'Mysql');

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `login`, `mail`, `password`, `user_id`) VALUES
(1, 'doremus', 'd0r3mu5@gmail.com', 'pwd', '0001X');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
