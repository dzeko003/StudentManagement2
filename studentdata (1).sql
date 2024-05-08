-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 09 mai 2023 à 15:08
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `studentdata`
--

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id_cl` int(100) NOT NULL AUTO_INCREMENT,
  `code_cl` varchar(100) NOT NULL,
  `libelle_cl` varchar(100) NOT NULL,
  PRIMARY KEY (`id_cl`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id_cl`, `code_cl`, `libelle_cl`) VALUES
(1, 'L1', 'licence 1'),
(2, 'L2', 'licence 2');

-- --------------------------------------------------------

--
-- Structure de la table `composer`
--

DROP TABLE IF EXISTS `composer`;
CREATE TABLE IF NOT EXISTS `composer` (
  `id_com` int(100) NOT NULL AUTO_INCREMENT,
  `natureEval` varchar(100) NOT NULL,
  `noteEval` double NOT NULL,
  `anneAc` int(100) NOT NULL,
  `id_et` int(100) NOT NULL,
  `id_mat` int(100) NOT NULL,
  `id_cl` int(100) NOT NULL,
  PRIMARY KEY (`id_com`),
  KEY `id_et` (`id_et`),
  KEY `id_mat` (`id_mat`),
  KEY `id_cl` (`id_cl`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `id_et` int(100) NOT NULL AUTO_INCREMENT,
  `matri_et` varchar(100) NOT NULL,
  `nom_et` varchar(100) NOT NULL,
  `mail_et` varchar(100) NOT NULL,
  `photo_et` varchar(500) NOT NULL,
  `sexe_et` varchar(100) NOT NULL,
  PRIMARY KEY (`id_et`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id_et`, `matri_et`, `nom_et`, `mail_et`, `photo_et`, `sexe_et`) VALUES
(1, 'AAL', 'Massengo', 'massego@gmail.com', 'C:\\Users\\Berenis\\eclipse-workspace\\StudentManagement - 2\\src\\img\\HN.jpg', 'femme'),
(2, 'AAK', 'bb', 'bb@gmail.com', 'C:\\Users\\Berenis\\eclipse-workspace\\StudentManagement - 2\\src\\img\\HN.jpg', 'femme'),
(3, 'ABC', 'nnnn', 'nnnnn', 'dnvjadhj@hhhh', 'C:/nnnnnn/'),
(4, 'ABC', 'nnnn', 'nnnnn', 'dnvjadhj@hhhh', 'C:/nnnnnn/'),
(5, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(6, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(7, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(8, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(9, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(10, 'BBK', 'kilou', 'jjjjj', 'llllllll', 'hhhhhhhhh'),
(11, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(12, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(13, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(14, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(15, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(16, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(17, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(18, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(19, 'fst-etud--23041215', 'Massamba', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\ESP_6799.JPG', 'Masculin'),
(20, 'fst-etud-23180214', 'jojo', 'bxchxbch@.com', 'C:\\Users\\Berenis\\Pictures\\SIAT\\DZEKO.JPG', 'Masculin'),
(21, '', '', '', 'C:\\Users\\Berenis\\Pictures\\SIAT\\DZEKO.JPG', 'null'),
(22, '', '', '', 'C:\\Users\\Berenis\\Pictures\\SIAT\\DZEKO.JPG', 'null');

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE IF NOT EXISTS `matiere` (
  `id_mat` int(100) NOT NULL AUTO_INCREMENT,
  `code_mat` varchar(100) NOT NULL,
  `libelle_mat` varchar(100) NOT NULL,
  `id_cl` varchar(100) NOT NULL,
  PRIMARY KEY (`id_mat`),
  KEY `fk_cl_mat` (`id_cl`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `username`, `password`) VALUES
(1, 'berenis', 'u28t39hYhC+WYFtsHtw9Zg=='),
(2, 'christ', 'u28t39hYhC+WYFtsHtw9Zg==');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
