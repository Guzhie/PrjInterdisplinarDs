-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 25-Set-2024 às 11:58
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.0.15

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

create database `bancosql`;
use `bancosql`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `acesso`
--

CREATE TABLE `acesso` (
  `usuario` varchar(15) NOT NULL,
  `senha` varchar(8) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

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

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`nome_aluno`, `cpf_Aluno`, `dtNasc_Aluno`, `Tel_Aluno`, `email_Aluno`, `cod_Aluno`, `endereco_Aluno`, `cep_Aluno`) VALUES
('Enzo Costa paz', '49689599828', '2008-04-11', '11-98368-2322', 'enzocostapaz10@gmail.com', 1, 'caetano pinto,252', '0031,450'),
('Jhonatan Alves', '48453513828', '2007-06-26', '1196331-4458', 'jhownatanalvesnascimento@gmail.com', 2, 'Rua foda,3456', '5657-75666');

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno_turma`
--

CREATE TABLE `aluno_turma` (
  `cod_Aluno` int(11) NOT NULL,
  `Cod_turma` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `aluno_turma`
--

INSERT INTO `aluno_turma` (`cod_Aluno`, `Cod_turma`) VALUES
(1, 2),
(2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `dif_instrumento`
--

CREATE TABLE `dif_instrumento` (
  `Descricao` varchar(40) NOT NULL,
  `Dif_instrumento` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `dif_instrumento`
--

INSERT INTO `dif_instrumento` (`Descricao`, `Dif_instrumento`) VALUES
('Dificil', 1),
('médio', 2);

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

--
-- Extraindo dados da tabela `instrumento`
--

INSERT INTO `instrumento` (`nome_Instrumento`, `Dif_instrumento`, `modelo_Instrumento`, `cod_Instrumeto`) VALUES
('violão', 2, 'Antigo', 1),
('piano', 1, 'recente', 2);

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

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`Nome_Prof`, `DataNasc_Prof`, `cpf_Prof`, `email_prof`, `telefone_Prof`, `cep_prof`, `endereco_prof`, `Id_Prof`) VALUES
('Edna Pittner', '1950-05-23', '545678123876', 'ednapitnner@gmail.com', '(11)9825573', '5674874567', 'rua capivara dos santos', 1),
('Clayton pinheiro', '1990-02-21', '543.564.678-', 'clay@gmail.com', '1198234567', '4665655', 'rua catinga palmas', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `sala`
--

CREATE TABLE `sala` (
  `id_Sala` int(11) NOT NULL,
  `caps_Sala` int(11) NOT NULL,
  `Desc_Sala` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `sala`
--

INSERT INTO `sala` (`id_Sala`, `caps_Sala`, `Desc_Sala`) VALUES
(1, 30, 'Sala de aula com cortinas'),
(2, 20, 'sala com porta azu');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_instrumento`
--

CREATE TABLE `tipo_instrumento` (
  `Categ_instrumentos` varchar(20) NOT NULL,
  `Id_Prof` int(11) NOT NULL,
  `cod_Instrumeto` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tipo_instrumento`
--

INSERT INTO `tipo_instrumento` (`Categ_instrumentos`, `Id_Prof`, `cod_Instrumeto`) VALUES
('Corda', 2, 1),
('mecânico', 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

CREATE TABLE `turma` (
  `cod_Instrumento` varchar(11) NOT NULL,
  `Cod_turma` int(11) NOT NULL,
  `id_Sala` int(11) NOT NULL,
  `Turno` varchar(11) NOT NULL,
  `Serie` char(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `turma`
--

INSERT INTO `turma` (`cod_Instrumento`, `Cod_turma`, `id_Sala`, `Turno`, `Serie`) VALUES
('1', 1, 2, 'manhã', '2°'),
('2', 2, 1, 'tarde', '1°');

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
  MODIFY `cod_Aluno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `dif_instrumento`
--
ALTER TABLE `dif_instrumento`
  MODIFY `Dif_instrumento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `instrumento`
--
ALTER TABLE `instrumento`
  MODIFY `cod_Instrumeto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `Id_Prof` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `sala`
--
ALTER TABLE `sala`
  MODIFY `id_Sala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `turma`
--
ALTER TABLE `turma`
  MODIFY `Cod_turma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
