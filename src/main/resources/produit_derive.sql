-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3308
-- Generation Time: Apr 07, 2023 at 09:13 AM
-- Server version: 10.6.9-MariaDB-log
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `produit_derive`
--

-- --------------------------------------------------------

--
-- Table structure for table `adresse`
--

CREATE TABLE `adresse` (
  `id` int(11) NOT NULL,
  `rue` varchar(100) NOT NULL,
  `codePostal` varchar(10) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `idPays` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `adresse`
--

INSERT INTO `adresse` (`id`, `rue`, `codePostal`, `ville`, `idPays`) VALUES
(1, '17 rue de la libération', '69780', 'Mions', 1),
(2, '15 rue Victor Hugo', '6800', 'Saint-Priest', 2),
(3, '03 rue de la mer', '65000', 'Vénissieux', 1),
(4, '17 allée de la bastille', '41000', 'Valence', 3);

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `idModePaiement` int(11) NOT NULL,
  `dateLivraison` date NOT NULL,
  `dateCommande` datetime NOT NULL,
  `isPurchasedOnline` tinyint(1) NOT NULL,
  `idAdresseFacturation` int(11) DEFAULT NULL,
  `idAdresseLivraison` int(11) DEFAULT NULL,
  `isValide` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `commande`
--

INSERT INTO `commande` (`id`, `idUtilisateur`, `idModePaiement`, `dateLivraison`, `dateCommande`, `isPurchasedOnline`, `idAdresseFacturation`, `idAdresseLivraison`, `isValide`) VALUES
(1, 1, 2, '2023-02-12', '2023-02-12 13:00:10', 0, NULL, NULL, 1),
(2, 2, 2, '2023-02-12', '2023-02-12 16:35:12', 0, NULL, NULL, 1),
(3, 3, 1, '2023-02-25', '2023-03-05 10:50:50', 1, 2, 2, 1),
(4, 4, 1, '2023-02-24', '2023-03-03 15:05:54', 1, 2, 3, 1),
(5, 4, 2, '2023-02-28', '2023-03-07 17:12:35', 1, 3, 3, 0);

-- --------------------------------------------------------

--
-- Table structure for table `commandeproduit`
--

CREATE TABLE `commandeproduit` (
  `id` int(11) NOT NULL,
  `idCommande` int(11) NOT NULL,
  `idProduit` int(11) NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `commandeproduit`
--

INSERT INTO `commandeproduit` (`id`, `idCommande`, `idProduit`, `quantite`) VALUES
(1, 1, 1, 5),
(2, 1, 2, 5),
(3, 1, 3, 9),
(4, 2, 2, 15),
(5, 2, 5, 25),
(6, 2, 1, 30),
(7, 2, 3, 45),
(8, 3, 5, 12),
(9, 3, 1, 90),
(10, 4, 5, 90),
(11, 4, 2, 400);

-- --------------------------------------------------------

--
-- Table structure for table `famille`
--

CREATE TABLE `famille` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `code` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `famille`
--

INSERT INTO `famille` (`id`, `nom`, `code`) VALUES
(1, 'Figurines', 'FIG'),
(2, 'Mugs', 'MUG'),
(3, 'Portes-clés', 'POR'),
(4, 'Peluches', 'PEL'),
(5, 'Mini-jeux', 'MIN');

-- --------------------------------------------------------

--
-- Table structure for table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `fournisseur`
--

INSERT INTO `fournisseur` (`id`, `nom`) VALUES
(1, 'Pause doo'),
(2, 'Fabricc');

-- --------------------------------------------------------

--
-- Table structure for table `fraisdeport`
--

CREATE TABLE `fraisdeport` (
  `id` int(11) NOT NULL,
  `montant` decimal(10,0) NOT NULL,
  `idPays` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `fraisdeport`
--

INSERT INTO `fraisdeport` (`id`, `montant`, `idPays`) VALUES
(1, '0', 1),
(2, '5', 3),
(3, '2', 2);

-- --------------------------------------------------------

--
-- Table structure for table `modepaiement`
--

CREATE TABLE `modepaiement` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `modepaiement`
--

INSERT INTO `modepaiement` (`id`, `nom`) VALUES
(1, 'Carte Bancaire'),
(2, 'Paypal');

-- --------------------------------------------------------

--
-- Table structure for table `pays`
--

CREATE TABLE `pays` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `dureeLivraison` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `pays`
--

INSERT INTO `pays` (`id`, `nom`, `dureeLivraison`) VALUES
(1, 'France', 2),
(2, 'Italie', 5),
(3, 'Espagne', 4);

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `code` varchar(10) NOT NULL,
  `idFamille` int(11) NOT NULL,
  `prixAchat` decimal(10,0) NOT NULL,
  `prixVente` decimal(10,0) NOT NULL,
  `idFournisseur` int(11) NOT NULL,
  `dateReaprovisionnementFournisseur` date DEFAULT NULL,
  `quantiteEnStock` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`id`, `nom`, `code`, `idFamille`, `prixAchat`, `prixVente`, `idFournisseur`, `dateReaprovisionnementFournisseur`, `quantiteEnStock`) VALUES
(1, 'Figurine Lol', 'FGILOL', 1, '7', '20', 1, NULL, 10000),
(2, 'Figurine Star Wars', 'FIGSTW', 1, '11', '25', 1, NULL, 4000),
(3, 'Figurine Assassin\'s Creed', 'FIGASC', 1, '9', '22', 1, NULL, 15000),
(4, 'Mini jeu Tetris', 'MINTET', 2, '3', '10', 2, '0000-00-00', 500),
(5, 'Mini jeu Pac-Man', 'MINPAC', 2, '3', '10', 2, '0000-00-00', 29);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `nom`) VALUES
(1, 'admin'),
(2, 'staff'),
(3, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `email` varchar(200) NOT NULL,
  `motDePasse` varchar(20) NOT NULL,
  `idAdresse` int(11) NOT NULL,
  `idPays` int(11) NOT NULL,
  `idRole` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `email`, `motDePasse`, `idAdresse`, `idPays`, `idRole`) VALUES
(1, 'george.te@gmail.com', 'george12', 1, 1, 3),
(2, 'natalieL@laposte.net', 'Natel18', 2, 2, 2),
(3, 'marc14@gmail.com', 'marcymarc78', 2, 2, 1),
(4, 'steve@gmail.com', 'stevyyyy5', 3, 3, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPays` (`idPays`);

--
-- Indexes for table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUtilisateur` (`idUtilisateur`),
  ADD KEY `idModePaiement` (`idModePaiement`),
  ADD KEY `idAdresseFacturation` (`idAdresseFacturation`),
  ADD KEY `idAdresseLivraison` (`idAdresseLivraison`);

--
-- Indexes for table `commandeproduit`
--
ALTER TABLE `commandeproduit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCommande` (`idCommande`),
  ADD KEY `idProduit` (`idProduit`);

--
-- Indexes for table `famille`
--
ALTER TABLE `famille`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fraisdeport`
--
ALTER TABLE `fraisdeport`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPays` (`idPays`);

--
-- Indexes for table `modepaiement`
--
ALTER TABLE `modepaiement`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idFamille` (`idFamille`),
  ADD KEY `idFournisseur` (`idFournisseur`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPays` (`idPays`),
  ADD KEY `idRole` (`idRole`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `commandeproduit`
--
ALTER TABLE `commandeproduit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `famille`
--
ALTER TABLE `famille`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `fraisdeport`
--
ALTER TABLE `fraisdeport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `modepaiement`
--
ALTER TABLE `modepaiement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pays`
--
ALTER TABLE `pays`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `adresse`
--
ALTER TABLE `adresse`
  ADD CONSTRAINT `adresse_ibfk_1` FOREIGN KEY (`idPays`) REFERENCES `pays` (`id`);

--
-- Constraints for table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `commande_ibfk_2` FOREIGN KEY (`idModePaiement`) REFERENCES `modepaiement` (`id`),
  ADD CONSTRAINT `commande_ibfk_3` FOREIGN KEY (`idAdresseFacturation`) REFERENCES `adresse` (`id`),
  ADD CONSTRAINT `commande_ibfk_4` FOREIGN KEY (`idAdresseLivraison`) REFERENCES `adresse` (`id`);

--
-- Constraints for table `commandeproduit`
--
ALTER TABLE `commandeproduit`
  ADD CONSTRAINT `commandeproduit_ibfk_1` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `commandeproduit_ibfk_2` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`id`);

--
-- Constraints for table `fraisdeport`
--
ALTER TABLE `fraisdeport`
  ADD CONSTRAINT `fraisdeport_ibfk_1` FOREIGN KEY (`idPays`) REFERENCES `pays` (`id`);

--
-- Constraints for table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `produit_ibfk_1` FOREIGN KEY (`idFamille`) REFERENCES `famille` (`id`),
  ADD CONSTRAINT `produit_ibfk_2` FOREIGN KEY (`idFournisseur`) REFERENCES `fournisseur` (`id`);

--
-- Constraints for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`idPays`) REFERENCES `pays` (`id`),
  ADD CONSTRAINT `utilisateur_ibfk_2` FOREIGN KEY (`idRole`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
