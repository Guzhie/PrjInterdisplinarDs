-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 04-Set-2024 às 19:56
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bancosql`
--
create DATABASE `bancosql`;
use `bancosql`;
-- --------------------------------------------------------

--
-- Estrutura da tabela `acesso`
--

CREATE TABLE `acesso` (
  `usuario` varchar(15) NOT NULL,
  `senha` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `acesso`
--

INSERT INTO `acesso` (`usuario`, `senha`) VALUES
('coordenador', 'clayton1'),
('diretor', 'eupi1234');

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `nome_aluno` varchar(150) NOT NULL,
  `cpf_Aluno` varchar(12) NOT NULL,
  `dtNasc_Aluno` date NOT NULL,
  `Tel_Aluno` varchar(20) NOT NULL,
  `email_Aluno` varchar(80) NOT NULL,
  `cod_Aluno` int(11) NOT NULL,
  `endereco_Aluno` varchar(50) NOT NULL,
  `cep_Aluno` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno_turma`
--

CREATE TABLE `aluno_turma` (
  `cod_Aluno` int(11) NOT NULL,
  `Cod_turma` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `dif_instrumento`
--

CREATE TABLE `dif_instrumento` (
  `Descricao` varchar(40) NOT NULL,
  `Dif_instrumento` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `instrumento`
--

CREATE TABLE `instrumento` (
  `nome_Instrumento` varchar(40) NOT NULL,
  `Dif_instrumento` int(11) NOT NULL,
  `modelo_Instrumento` varchar(30) NOT NULL,
  `cod_Instrumeto` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `Nome_Prof` varchar(150) NOT NULL,
  `DataNasc_Prof` date NOT NULL,
  `cpf_Prof` varchar(12) NOT NULL,
  `email_prof` varchar(80) NOT NULL,
  `telefone_Prof` varchar(20) NOT NULL,
  `cep_prof` varchar(10) NOT NULL,
  `endereco_prof` varchar(40) NOT NULL,
  `Id_Prof` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sala`
--

CREATE TABLE `sala` (
  `id_Sala` int(11) NOT NULL,
  `caps_Sala` int(11) NOT NULL,
  `Desc_Sala` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_instrumento`
--

CREATE TABLE `tipo_instrumento` (
  `Categ_instrumentos` varchar(20) NOT NULL,
  `Id_Prof` int(11) NOT NULL,
  `cod_Instrumeto` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

CREATE TABLE `turma` (
  `cod_Instrumeto` varchar(11) NOT NULL,
  `Cod_turma` int(11) NOT NULL,
  `id_Sala` int(11) NOT NULL,
  `Turno` varchar(11) NOT NULL,
  `Serie` char(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `acesso`
--
ALTER TABLE `acesso`
  ADD PRIMARY KEY (`usuario`);

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`cod_Aluno`),
  ADD UNIQUE KEY `DominioCPF` (`cpf_Aluno`),
  ADD UNIQUE KEY `email_Aluno` (`email_Aluno`);

--
-- Índices para tabela `dif_instrumento`
--
ALTER TABLE `dif_instrumento`
  ADD PRIMARY KEY (`Dif_instrumento`);

--
-- Índices para tabela `instrumento`
--
ALTER TABLE `instrumento`
  ADD PRIMARY KEY (`cod_Instrumeto`),
  ADD UNIQUE KEY `modelo_Instrumento` (`modelo_Instrumento`);

--
-- Índices para tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`Id_Prof`),
  ADD UNIQUE KEY `cpf_Prof` (`cpf_Prof`),
  ADD UNIQUE KEY `email_prof` (`email_prof`),
  ADD UNIQUE KEY `telefone_Prof` (`telefone_Prof`);

--
-- Índices para tabela `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`id_Sala`);

--
-- Índices para tabela `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`Cod_turma`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `cod_Aluno` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `dif_instrumento`
--
ALTER TABLE `dif_instrumento`
  MODIFY `Dif_instrumento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `instrumento`
--
ALTER TABLE `instrumento`
  MODIFY `cod_Instrumeto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `Id_Prof` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `sala`
--
ALTER TABLE `sala`
  MODIFY `id_Sala` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `turma`
--
ALTER TABLE `turma`
  MODIFY `Cod_turma` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
