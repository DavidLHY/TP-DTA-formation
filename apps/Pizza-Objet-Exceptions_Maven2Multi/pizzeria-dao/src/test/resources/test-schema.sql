CREATE TABLE `pizza` (
  `id` int(11) auto_increment NOT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `reference` varchar(5) NOT NULL,
  `libelle` varchar(25) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `url_image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `pizza` (`categorie`, `reference`, `libelle`, `prix`, `url_image`) VALUES
( 'VIANDE', 'TOT', 'toto', 45, NULL);