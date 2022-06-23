-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 21-Jun-2022 às 22:03
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `tabelas_pokemon`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `pokemon`
--

CREATE TABLE `pokemon` (
  `id` int(11) NOT NULL,
  `num` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `img` varchar(200) NOT NULL,
  `type` varchar(200) NOT NULL,
  `height` varchar(200) NOT NULL,
  `weight` varchar(200) NOT NULL,
  `candy` varchar(200) NOT NULL,
  `candy_count` int(11) NOT NULL,
  `egg` varchar(200) NOT NULL,
  `spawn_chance` double NOT NULL,
  `avg_spawns` int(11) NOT NULL,
  `spawn_time` varchar(200) NOT NULL,
  `multipliers` varchar(200) NOT NULL,
  `weaknesses` varchar(200) NOT NULL,
  `next_evolution` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pokemon2`
--

CREATE TABLE `pokemon2` (
  `id` int(11) NOT NULL,
  `num` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `img` varchar(200) NOT NULL,
  `type` varchar(200) NOT NULL,
  `height` varchar(200) NOT NULL,
  `weight` varchar(200) NOT NULL,
  `candy` varchar(200) NOT NULL,
  `candy_count` int(11) NOT NULL,
  `egg` varchar(200) NOT NULL,
  `spawn_chance` double NOT NULL,
  `avg_spawns` double NOT NULL,
  `spawn_time` varchar(200) NOT NULL,
  `multipliers` varchar(200) NOT NULL,
  `weaknesses` varchar(200) NOT NULL,
  `prev_evolution` varchar(200) NOT NULL,
  `next_evolution` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `pokemon2`
--

INSERT INTO `pokemon2` (`id`, `num`, `name`, `img`, `type`, `height`, `weight`, `candy`, `candy_count`, `egg`, `spawn_chance`, `avg_spawns`, `spawn_time`, `multipliers`, `weaknesses`, `prev_evolution`, `next_evolution`) VALUES
(1, '001', 'Ivysaur', 'http://www.serebii.net/pokemongo/pokemon/002.png', 'Grass,Poison', '0.99 m', '0.99 m', 'Bulbasaur Candy', 100, 'Not in Eggs', 0.042, 4.2, '07:00', '1.2,1.6', 'Fire,Ice,Flying,Psychic', '001,Bulbasaur', '003,Venusaur'),
(2, '002', 'Ivysaur', 'http://www.serebii.net/pokemongo/pokemon/002.png', 'Grass,Poison', '0.99 m', '0.99 m', 'Bulbasaur Candy', 100, 'Not in Eggs', 0.042, 4.2, '07:00', '1.2,1.6', 'Fire,Ice,Flying,Psychic', '001,Bulbasaur', '003,Venusaur'),
(3, '003', 'Ivysaur', 'http://www.serebii.net/pokemongo/pokemon/002.png', 'Grass,Poison', '0.99 m', '0.99 m', 'Bulbasaur Candy', 100, 'Not in Eggs', 0.042, 4.2, '07:00', '1.2,1.6', 'Fire,Ice,Flying,Psychic', '001,Bulbasaur', '003,Venusaur'),
(4, '004', 'Ivysaur', 'http://www.serebii.net/pokemongo/pokemon/002.png', 'Grass,Poison', '0.99 m', '0.99 m', 'Bulbasaur Candy', 100, 'Not in Eggs', 0.042, 4.2, '07:00', '1.2,1.6', 'Fire,Ice,Flying,Psychic', '001,Bulbasaur', '003,Venusaur');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pokemon3`
--

CREATE TABLE `pokemon3` (
  `id` int(11) NOT NULL,
  `num` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `img` varchar(200) NOT NULL,
  `type` varchar(200) NOT NULL,
  `height` varchar(200) NOT NULL,
  `weight` varchar(200) NOT NULL,
  `candy` varchar(200) NOT NULL,
  `egg` varchar(200) NOT NULL,
  `spawn_chance` double NOT NULL,
  `avg_spawns` double NOT NULL,
  `spawn_time` varchar(200) NOT NULL,
  `multipliers` varchar(200) NOT NULL,
  `weaknesses` varchar(200) NOT NULL,
  `prev_evolution` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pokemon4`
--

CREATE TABLE `pokemon4` (
  `id` int(11) NOT NULL,
  `num` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `img` varchar(200) NOT NULL,
  `type` varchar(200) NOT NULL,
  `height` varchar(200) NOT NULL,
  `weight` varchar(200) NOT NULL,
  `candy` varchar(200) NOT NULL,
  `candy_count` int(11) NOT NULL,
  `egg` varchar(200) NOT NULL,
  `spawn_chance` double NOT NULL,
  `avg_spawns` double NOT NULL,
  `spawn_time` varchar(200) NOT NULL,
  `multipliers` varchar(200) NOT NULL,
  `weaknesses` varchar(200) NOT NULL,
  `next_evolution` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `pokemon2`
--
ALTER TABLE `pokemon2`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `pokemon3`
--
ALTER TABLE `pokemon3`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `pokemon4`
--
ALTER TABLE `pokemon4`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
