# desafio-techlead

Cargo: Analista de Desenvolvimento de Sistemas
Senioridade: Nível 1 (Junior)
Linguagem: Java

Foi utilizada a linguagem Java e o banco de dados MySQL para a resolução do desafio. 

Foi utilizada a versão 8.0.18. do DB, disponível em https://dev.mysql.com/downloads/installer/

Foi utilizada a biblioteca Java "mysql-connector-java-8.0.17", a qual foi adicionada no IDE Eclipse. 

Abaixo encontra-se o dump do banco de dados:
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id1` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `tipoConta` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `senha` int(11) NOT NULL,
  PRIMARY KEY (`id1`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (2,'adm',23,5378755,123456),(52,'hugo',2,5378756,123456),(53,'iarley',2,7894561,741741);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livro`
--

DROP TABLE IF EXISTS `livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `ano` int(11) NOT NULL,
  `editora` varchar(100) NOT NULL,
  `codigoCadastro` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livro`
--

LOCK TABLES `livro` WRITE;
/*!40000 ALTER TABLE `livro` DISABLE KEYS */;
INSERT INTO `livro` VALUES (22,'aaa',111,'eee',5378756),(23,'bbb',222,'eee',5378755),(38,'livroIarley',2003,'paysandu',7894561);
/*!40000 ALTER TABLE `livro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-13 14:39:08


--> CARGA INICIAL DO BANCO DE DADOS:
select * from cliente;
 +-----+--------+-----------+---------+--------+
| id1 | nome   | tipoConta | id      | senha  |
+-----+--------+-----------+---------+--------+
|   2 | adm    |        23 | 5378755 | 123456 |
|  52 | hugo   |         2 | 5378756 | 123456 |
|  53 | iarley |         2 | 7894561 | 741741 |
+-----+--------+-----------+---------+--------+

select * from livro;
+----+-------------+------+----------+----------------+
| id | nome        | ano  | editora  | codigoCadastro |
+----+-------------+------+----------+----------------+
| 22 | aaa         |  111 | eee      |        5378756 |
| 23 | bbb         |  222 | eee      |        5378755 |
| 38 | livroIarley | 2003 | paysandu |        7894561 |
+----+-------------+------+----------+----------------+

Para fazer a conexão com o banco de dados: "jdbc:mysql://localhost/biblioteca?useTimezone=true&serverTimezone=UTC", "root", "mysqlroot"
