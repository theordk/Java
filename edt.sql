-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 07 juin 2020 à 20:56
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `edt`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`ID`, `NOM`) VALUES
(1, 'Mathematiques'),
(2, 'Informatique'),
(3, 'Electronique'),
(4, 'LV2'),
(5, 'Thermodynamique'),
(6, 'Anglais'),
(7, 'Droit du Travail'),
(8, 'POO Java'),
(9, 'Physique'),
(10, 'Web Dynamique');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `ID_UTILISATEUR` int(11) NOT NULL,
  `ID_COURS` int(11) NOT NULL,
  PRIMARY KEY (`ID_UTILISATEUR`,`ID_COURS`),
  KEY `ID_COURS` (`ID_COURS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`ID_UTILISATEUR`, `ID_COURS`) VALUES
(11, 1),
(1, 2),
(3, 2),
(25, 3),
(15, 4),
(10, 5),
(14, 5),
(7, 6),
(9, 7),
(16, 8),
(17, 9),
(18, 10);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_UTILISATEUR` int(11) NOT NULL,
  `NUMERO` int(11) NOT NULL,
  `ID_GROUPE` int(11) NOT NULL,
  PRIMARY KEY (`ID_UTILISATEUR`),
  KEY `ID_GROUPE` (`ID_GROUPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`ID_UTILISATEUR`, `NUMERO`, `ID_GROUPE`) VALUES
(4, 550426, 1),
(5, 550823, 11),
(6, 550964, 12),
(8, 550811, 6),
(12, 550100, 5),
(13, 550132, 7),
(19, 550400, 8),
(20, 550199, 2),
(21, 550203, 9),
(22, 550877, 3),
(24, 550003, 10),
(26, 550069, 4);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID` int(11) NOT NULL,
  `NOM` varchar(20) NOT NULL,
  `ID_PROMOTION` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_PROMOTION` (`ID_PROMOTION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`ID`, `NOM`, `ID_PROMOTION`) VALUES
(1, 'TD1', 4),
(2, 'TD2', 4),
(3, 'TD1', 5),
(4, 'TD2', 5),
(5, 'TD3', 4),
(6, 'TD3', 5),
(7, 'TD1', 6),
(8, 'TD4', 4),
(9, 'TD4', 5),
(10, 'TD2', 6),
(11, 'TD3', 6),
(12, 'TD4', 6);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`ID`, `NOM`) VALUES
(4, '2022'),
(5, '2021'),
(6, '2023');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(30) NOT NULL,
  `CAPACITE` int(11) NOT NULL,
  `ID_SITE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_SITE` (`ID_SITE`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`ID`, `NOM`, `CAPACITE`, `ID_SITE`) VALUES
(1, 'EM009', 300, 1),
(2, 'P440', 100, 2),
(3, '310', 150, 5),
(4, 'G019', 100, 4),
(6, 'P417', 200, 2),
(7, 'C104', 300, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SEMAINE` int(11) NOT NULL,
  `DATE` date NOT NULL,
  `HEURE_DEBUT` time NOT NULL,
  `HEURE_FIN` time NOT NULL,
  `ETAT` int(11) NOT NULL,
  `ID_COURS` int(11) NOT NULL,
  `ID_TYPE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_COURS` (`ID_COURS`),
  KEY `ID_TYPE` (`ID_TYPE`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`ID`, `SEMAINE`, `DATE`, `HEURE_DEBUT`, `HEURE_FIN`, `ETAT`, `ID_COURS`, `ID_TYPE`) VALUES
(1, 23, '2020-06-02', '12:00:00', '13:30:00', 2, 2, 1),
(2, 23, '2020-06-02', '13:45:00', '15:15:00', 1, 2, 1),
(3, 23, '2020-06-04', '08:30:00', '10:00:00', 2, 6, 3),
(4, 23, '2020-06-04', '17:15:00', '18:45:00', 3, 6, 3),
(5, 23, '2020-06-04', '19:00:00', '20:30:00', 3, 5, 3),
(6, 23, '2020-06-03', '10:00:00', '11:30:00', 1, 3, 2),
(7, 22, '2020-05-29', '15:30:00', '18:45:00', 1, 8, 3),
(8, 22, '2020-05-26', '10:00:00', '12:00:00', 1, 9, 3),
(9, 22, '2020-05-27', '08:30:00', '10:00:00', 2, 7, 3),
(10, 22, '2020-06-16', '17:00:00', '18:30:00', 1, 10, 4),
(11, 22, '2020-06-17', '12:00:00', '13:30:00', 3, 4, 3),
(12, 23, '2020-06-02', '08:00:00', '10:00:00', 1, 1, 5),
(13, 22, '2020-06-03', '13:45:00', '15:15:00', 1, 3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignants`
--

DROP TABLE IF EXISTS `seance_enseignants`;
CREATE TABLE IF NOT EXISTS `seance_enseignants` (
  `ID_SEANCE` int(11) NOT NULL,
  `ID_UTILISATEUR` int(11) NOT NULL,
  PRIMARY KEY (`ID_SEANCE`,`ID_UTILISATEUR`),
  KEY `ID_UTILISATEUR` (`ID_UTILISATEUR`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_enseignants`
--

INSERT INTO `seance_enseignants` (`ID_SEANCE`, `ID_UTILISATEUR`) VALUES
(1, 1),
(2, 3),
(3, 7),
(4, 7),
(9, 9),
(5, 10),
(12, 11),
(11, 15),
(7, 16),
(8, 17),
(10, 18),
(6, 25),
(13, 25);

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupes`
--

DROP TABLE IF EXISTS `seance_groupes`;
CREATE TABLE IF NOT EXISTS `seance_groupes` (
  `ID_SEANCE` int(11) NOT NULL,
  `ID_GROUPE` int(11) NOT NULL,
  PRIMARY KEY (`ID_SEANCE`,`ID_GROUPE`),
  KEY `ID_GROUPE` (`ID_GROUPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_groupes`
--

INSERT INTO `seance_groupes` (`ID_SEANCE`, `ID_GROUPE`) VALUES
(1, 1),
(7, 1),
(11, 1),
(5, 2),
(6, 2),
(12, 2),
(2, 3),
(3, 3),
(8, 3),
(4, 6),
(13, 6),
(9, 7);

-- --------------------------------------------------------

--
-- Structure de la table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `ID_SEANCE` int(11) NOT NULL,
  `ID_SALLE` int(11) NOT NULL,
  PRIMARY KEY (`ID_SEANCE`,`ID_SALLE`),
  KEY `ID_SALLE` (`ID_SALLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_salles`
--

INSERT INTO `seance_salles` (`ID_SEANCE`, `ID_SALLE`) VALUES
(1, 1),
(13, 1),
(12, 2),
(6, 3),
(3, 4),
(11, 4),
(4, 6),
(5, 6),
(7, 6),
(9, 6),
(2, 7),
(8, 7);

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`ID`, `NOM`) VALUES
(1, 'E1'),
(2, 'E2'),
(3, 'E3'),
(4, 'E4'),
(5, 'E5');

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_cours`
--

INSERT INTO `type_cours` (`ID`, `NOM`) VALUES
(1, 'TP'),
(2, 'Projet'),
(3, 'Magistral'),
(4, 'Soutien'),
(5, 'TD');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(50) NOT NULL,
  `PASSWD` varchar(50) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) NOT NULL,
  `DROIT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `EMAIL`, `PASSWD`, `NOM`, `PRENOM`, `DROIT`) VALUES
(0, 'mr.boss@ece.fr', 'admin', 'BOSS', 'Henry', 1),
(1, 'jp.segado@gmail.com', 'java', 'Segado', 'Jean Pierre', 3),
(2, 'fab.coudray@ece.fr', 'paris', 'Coudray', 'Fabienne', 2),
(3, 'manolo.hina@gmail.com', 'web', 'Hina', 'Manolo', 3),
(4, 'theophile.tarbe@gmail.com', 'mexico', 'Tarbe', 'Theophile', 4),
(5, 'baptiste.boyer@gmail.com', '123456', 'Boyer', 'Baptiste', 4),
(6, 'diego.colin@gmail.com', 'suze', 'Colin', 'Diego', 4),
(7, 'marie.leonard@ece.fr', 'usa', 'Leonard', 'Marie', 3),
(8, 'etienne.gsl@free.fr', 'lol', 'Geslin', 'Etienne', 4),
(9, 'yves.maupile@ece.fr', 'droit', 'Maupile', 'Yves', 3),
(10, 'm.pullicino@ece.fr', 'energy', 'Pullicino', 'Michel', 3),
(11, 'luclecor@ece.fr', 'chauve', 'Lecor', 'Luc', 3),
(12, 'felipe@gmail.com', 'brazil', 'Luis', 'Felipe', 4),
(13, 'jeannegoss@free.fr', 'cheval', 'Gossard', 'Jeanne', 4),
(14, 'diane@yahoo.fr', 'king', 'Roux', 'Diane', 3),
(15, 'cat.gomez@free.fr', 'argentina', 'Gomez', 'Catrina', 3),
(16, 'ju.palasi@ece.fr', 'juju', 'Palasi', 'Julienne', 3),
(17, 'c.crambes@ece.fr', 'grrr', 'Crambes', 'Christine', 3),
(18, 'e.rendler@inseec.fr', 'cool', 'Rendler', 'Elisabeth', 3),
(19, 'paul.mrq@gmail.com', 'caves', 'Marquereau', 'Paul', 4),
(20, 'vic.quidet@free.fr', 'bangor', 'Quidet', 'Victor', 4),
(21, 'paul.sen@gmail.com', 'muscu', 'Senard', 'Paul', 4),
(22, 'seb.du@yahoo.fr', 'evreux', 'Duschesne', 'Sebastien', 4),
(24, 'alice.cabane@gmail.com', 'cabanus', 'Cabane', 'Alice', 4),
(25, 'titi.minot@ece.fr', 'nasa', 'Minot', 'Thierry', 3),
(26, 'piajoseph@gmail.com', 'perros', 'Joseph', 'Pia', 4);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `enseignant_ibfk_1` FOREIGN KEY (`ID_COURS`) REFERENCES `cours` (`ID`),
  ADD CONSTRAINT `enseignant_ibfk_2` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID`);

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID`),
  ADD CONSTRAINT `etudiant_ibfk_2` FOREIGN KEY (`ID_GROUPE`) REFERENCES `groupe` (`ID`);

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `groupe_ibfk_1` FOREIGN KEY (`ID_PROMOTION`) REFERENCES `promotion` (`ID`);

--
-- Contraintes pour la table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `salle_ibfk_1` FOREIGN KEY (`ID_SITE`) REFERENCES `site` (`ID`);

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `seance_ibfk_1` FOREIGN KEY (`ID_COURS`) REFERENCES `cours` (`ID`),
  ADD CONSTRAINT `seance_ibfk_2` FOREIGN KEY (`ID_TYPE`) REFERENCES `type_cours` (`ID`);

--
-- Contraintes pour la table `seance_enseignants`
--
ALTER TABLE `seance_enseignants`
  ADD CONSTRAINT `seance_enseignants_ibfk_1` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `enseignant` (`ID_UTILISATEUR`),
  ADD CONSTRAINT `seance_enseignants_ibfk_3` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`);

--
-- Contraintes pour la table `seance_groupes`
--
ALTER TABLE `seance_groupes`
  ADD CONSTRAINT `seance_groupes_ibfk_1` FOREIGN KEY (`ID_GROUPE`) REFERENCES `groupe` (`ID`),
  ADD CONSTRAINT `seance_groupes_ibfk_2` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`);

--
-- Contraintes pour la table `seance_salles`
--
ALTER TABLE `seance_salles`
  ADD CONSTRAINT `seance_salles_ibfk_1` FOREIGN KEY (`ID_SALLE`) REFERENCES `salle` (`ID`),
  ADD CONSTRAINT `seance_salles_ibfk_2` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
