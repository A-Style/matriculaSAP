/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.6.36-cll-lve : Database - db_erpSAP
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_erpSAP` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;

USE `db_erpSAP`;

/*Table structure for table `CRM_Alumno` */

DROP TABLE IF EXISTS `CRM_Alumno`;

CREATE TABLE `CRM_Alumno` (
  `idAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apPaterno` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apMaterno` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dni` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `fecnacimiento` date DEFAULT NULL,
  `idEmpleado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAlumno`,`dni`),
  KEY `tAlumno_ibfk_1` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `CRM_Alumno` */

/*Table structure for table `CRM_Matricula` */

DROP TABLE IF EXISTS `CRM_Matricula`;

CREATE TABLE `CRM_Matricula` (
  `idMatricula` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `nivel` tinyint(1) DEFAULT NULL,
  `anio` tinyint(1) DEFAULT NULL,
  `seccion` char(1) CHARACTER SET latin1 DEFAULT NULL,
  `procedencia` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `idEmpleado` int(11) DEFAULT NULL,
  `idAlumno` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMatricula`),
  KEY `tMatricula_ibfk_2` (`nivel`),
  KEY `idEmpleado` (`idEmpleado`),
  KEY `idAlumno` (`idAlumno`),
  CONSTRAINT `CRM_Matricula_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `CRM_Alumno` (`idAlumno`),
  CONSTRAINT `CRM_Matricula_ibfk_2` FOREIGN KEY (`idEmpleado`) REFERENCES `HRM_Empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `CRM_Matricula` */

/*Table structure for table `CRM_aluIncidencias` */

DROP TABLE IF EXISTS `CRM_aluIncidencias`;

CREATE TABLE `CRM_aluIncidencias` (
  `idIncidencia` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `descripcion` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `categoria` tinyint(4) DEFAULT NULL,
  `idEmpleado` int(11) DEFAULT NULL,
  `idAlumno` int(11) DEFAULT NULL,
  PRIMARY KEY (`idIncidencia`),
  KEY `idAlumno` (`idAlumno`),
  KEY `idEmpleado` (`idEmpleado`),
  CONSTRAINT `CRM_aluIncidencias_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `CRM_Alumno` (`idAlumno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `CRM_aluIncidencias` */

/*Table structure for table `CRM_aluPadres` */

DROP TABLE IF EXISTS `CRM_aluPadres`;

CREATE TABLE `CRM_aluPadres` (
  `idPadre` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apPaterno` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apMaterno` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dni` char(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecNacimiento` date DEFAULT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telFijo` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `celular` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `numEmergencia` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idEmpleado` int(11) DEFAULT NULL,
  `idDistrito` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPadre`),
  KEY `idDistrito` (`idDistrito`),
  KEY `idEmpleado` (`idEmpleado`),
  CONSTRAINT `CRM_aluPadres_ibfk_1` FOREIGN KEY (`idDistrito`) REFERENCES `tDistrito` (`idDistrito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `CRM_aluPadres` */

/*Table structure for table `CRM_aluParentesco` */

DROP TABLE IF EXISTS `CRM_aluParentesco`;

CREATE TABLE `CRM_aluParentesco` (
  `idAlumno` int(11) DEFAULT NULL,
  `idPadre` int(11) DEFAULT NULL,
  `parentesco` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apoderado` tinyint(1) DEFAULT NULL,
  KEY `idPadres` (`idPadre`),
  KEY `idAlumno` (`idAlumno`),
  CONSTRAINT `CRM_aluParentesco_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `CRM_Alumno` (`idAlumno`),
  CONSTRAINT `CRM_aluParentesco_ibfk_2` FOREIGN KEY (`idPadre`) REFERENCES `CRM_aluPadres` (`idPadre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `CRM_aluParentesco` */

/*Table structure for table `CRM_matRequisitos` */

DROP TABLE IF EXISTS `CRM_matRequisitos`;

CREATE TABLE `CRM_matRequisitos` (
  `copiaDniAlu` tinyint(1) DEFAULT NULL,
  `copiaDniApo` tinyint(1) DEFAULT NULL,
  `certificadoEstudio` tinyint(1) DEFAULT NULL,
  `fichaBoleta` tinyint(1) DEFAULT NULL,
  `partNacimiento` tinyint(1) DEFAULT NULL,
  `fotos` tinyint(1) DEFAULT NULL,
  `recibos` tinyint(1) DEFAULT NULL,
  `idMatricula` int(11) DEFAULT NULL,
  KEY `idMatricula` (`idMatricula`),
  CONSTRAINT `CRM_matRequisitos_ibfk_1` FOREIGN KEY (`idMatricula`) REFERENCES `CRM_Matricula` (`idMatricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `CRM_matRequisitos` */

/*Table structure for table `HRM_Conocimientos` */

DROP TABLE IF EXISTS `HRM_Conocimientos`;

CREATE TABLE `HRM_Conocimientos` (
  `conocimiento` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Nivel` tinyint(4) DEFAULT NULL,
  `idEmpleado` int(11) DEFAULT NULL,
  KEY `idEmpleado` (`idEmpleado`),
  CONSTRAINT `HRM_Conocimientos_ibfk_1` FOREIGN KEY (`idEmpleado`) REFERENCES `HRM_Empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `HRM_Conocimientos` */

/*Table structure for table `HRM_Contratos` */

DROP TABLE IF EXISTS `HRM_Contratos`;

CREATE TABLE `HRM_Contratos` (
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `Salario` float DEFAULT NULL,
  `idEmpleado` int(11) DEFAULT NULL,
  KEY `idEmpleado` (`idEmpleado`),
  CONSTRAINT `HRM_Contratos_ibfk_1` FOREIGN KEY (`idEmpleado`) REFERENCES `HRM_Empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `HRM_Contratos` */

/*Table structure for table `HRM_Empleado` */

DROP TABLE IF EXISTS `HRM_Empleado`;

CREATE TABLE `HRM_Empleado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `apPaterno` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `apMaterno` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `dni` char(8) CHARACTER SET latin1 DEFAULT NULL,
  `fecNacimiento` date DEFAULT NULL,
  `telefono` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `email` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `direccion` varchar(150) CHARACTER SET latin1 DEFAULT NULL,
  `idDistrito` int(11) DEFAULT NULL,
  `pass` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `idDistrito` (`idDistrito`),
  CONSTRAINT `HRM_Empleado_ibfk_1` FOREIGN KEY (`idDistrito`) REFERENCES `tDistrito` (`idDistrito`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `HRM_Empleado` */

insert  into `HRM_Empleado`(`idEmpleado`,`nombre`,`apPaterno`,`apMaterno`,`dni`,`fecNacimiento`,`telefono`,`email`,`direccion`,`idDistrito`,`pass`) values (4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'Jose','ARANDA','CORAS','45268054','0000-00-00','991488514','ing.sis.aranda@gmail.com','calle 4',15,'123'),(7,'','','','','0000-00-00','','','',16,''),(8,'Xxx','','','','2017-02-28','','','',15,''),(9,'','','','','0000-00-00','','','jddj',18,''),(10,'','','','','0000-00-00','','','',2,'');

/*Table structure for table `HRM_Estudios` */

DROP TABLE IF EXISTS `HRM_Estudios`;

CREATE TABLE `HRM_Estudios` (
  `lugar` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `curso` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idEmpleado` int(11) DEFAULT NULL,
  KEY `idEmpleado` (`idEmpleado`),
  CONSTRAINT `HRM_Estudios_ibfk_1` FOREIGN KEY (`idEmpleado`) REFERENCES `HRM_Empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `HRM_Estudios` */

/*Table structure for table `HRM_Experiencias` */

DROP TABLE IF EXISTS `HRM_Experiencias`;

CREATE TABLE `HRM_Experiencias` (
  `lugar` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cargo` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `idEmpleado` int(11) DEFAULT NULL,
  KEY `idEmpleado` (`idEmpleado`),
  CONSTRAINT `HRM_Experiencias_ibfk_1` FOREIGN KEY (`idEmpleado`) REFERENCES `HRM_Empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `HRM_Experiencias` */

/*Table structure for table `tDepartamento` */

DROP TABLE IF EXISTS `tDepartamento`;

CREATE TABLE `tDepartamento` (
  `idDepartamento` int(11) NOT NULL,
  `departamento` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `tDepartamento` */

insert  into `tDepartamento`(`idDepartamento`,`departamento`) values (1,'Lima');

/*Table structure for table `tDistrito` */

DROP TABLE IF EXISTS `tDistrito`;

CREATE TABLE `tDistrito` (
  `idDistrito` int(11) NOT NULL AUTO_INCREMENT,
  `distrito` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idDepartamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDistrito`),
  KEY `idDepartamento` (`idDepartamento`),
  CONSTRAINT `tDistrito_ibfk_1` FOREIGN KEY (`idDepartamento`) REFERENCES `tDepartamento` (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `tDistrito` */

insert  into `tDistrito`(`idDistrito`,`distrito`,`idDepartamento`) values (1,'Cercado de Lima',1),(2,'Ate',1),(3,'Barranco',1),(4,'Breña',1),(5,'Comas',1),(6,'Chorrillos',1),(7,'El Agustino',1),(8,'Jesús Maria',1),(9,'La Molina',1),(10,'La Victoria',1),(11,'Lince',1),(12,'Magdalena del mar',1),(13,'Miraflores',1),(14,'Pueblo Libre',1),(15,'Carabayllo',1),(16,'San Juan de Lurigancho',1),(17,'Puente Piedra',1),(18,'Santa Anita',1),(19,'Los Olivos',1),(20,'Rimac',1);

/* Procedure structure for procedure `spCRM_actualizarAlumno` */

/*!50003 DROP PROCEDURE IF EXISTS  `spCRM_actualizarAlumno` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`db_userErpSap`@`%` PROCEDURE `spCRM_actualizarAlumno`(
    nomAlu varchar(30),
    patAlu varchar(20),
    matAlu varchar(20),
    nuevoDniAlu char(8),
    fecnacAlu date,
    
  
    antiguoDniAlu char(8)
   
    )
BEGIN
	
	
	update CRM_Alumno set 
	nombre=(CONCAT(UPPER(LEFT(TRIM(nomAlu),1)),LOWER(SUBSTRING(TRIM(nomAlu),2)))),
	apPaterno=UPPER(TRIM(patAlu)),
	apMaterno=UPPER(TRIM(matAlu)),
	dni=nuevoDniAlu,
	fecnacimiento=fecnacAlu
	where dni=antiguoDniAlu;
	
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spCRM_actualizarPadre` */

/*!50003 DROP PROCEDURE IF EXISTS  `spCRM_actualizarPadre` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`db_userErpSap`@`%` PROCEDURE `spCRM_actualizarPadre`(
    nomPat varchar(30),
    apPaternoPat varchar(20),
    apMaternoPat varchar(20),
    dniPat char(8),
    fecNacimiento date,
    direccionPat varchar(100),
    telPat varchar(10),
    celPat varchar(10),
    telEmerPat varchar(10),
    emailPat varchar(50),
    
    dniAntiguoPat char(8)
    )
BEGIN
update CRM_aluPadres set 
	nombre=(CONCAT(UPPER(LEFT(TRIM(nomPat),1)),LOWER(SUBSTRING(TRIM(nomPat),2)))),
	apPaterno=UPPER(TRIM(apPaternoPat)),
	apMaterno=UPPER(TRIM(apMaternoPat)),
	dni=dniPat,
	fecNacimiento=fecNacimiento,
	direccion=direccionPat,
	telFijo=telPat,
	celular=celPat,
	numEmergencia=telEmerPat,
	email=emailPat
where dni=dniAntiguoPat;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spCRM_actualizarRequisitos` */

/*!50003 DROP PROCEDURE IF EXISTS  `spCRM_actualizarRequisitos` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`db_userErpSap`@`%` PROCEDURE `spCRM_actualizarRequisitos`(dniAlumno char(8),
    anio int,
	requisito tinyint,
	valor tinyint
	
	
    )
BEGIN
case requisito
when 0 then
	UPDATE CRM_matRequisitos req INNER JOIN CRM_Matricula mat ON req.idMatricula=mat.idMatricula
	SET req.copiaDniAlu=valor
	WHERE mat.idAlumno=(SELECT idAlumno FROM CRM_Alumno WHERE dni=dniAlumno) AND YEAR(mat.fecha)=anio ;
when 1 then
	UPDATE CRM_matRequisitos req INNER JOIN CRM_Matricula mat ON req.idMatricula=mat.idMatricula
	SET req.copiaDniApo=valor
	WHERE mat.idAlumno=(SELECT idAlumno FROM CRM_Alumno WHERE dni=dniAlumno) AND YEAR(mat.fecha)=anio ;
WHEN 2 THEN
	UPDATE CRM_matRequisitos req INNER JOIN CRM_Matricula mat ON req.idMatricula=mat.idMatricula
	SET req.certificadoEstudio=valor
	WHERE mat.idAlumno=(SELECT idAlumno FROM CRM_Alumno WHERE dni=dniAlumno) AND YEAR(mat.fecha)=anio ;
WHEN 3 THEN
	UPDATE CRM_matRequisitos req INNER JOIN CRM_Matricula mat ON req.idMatricula=mat.idMatricula
	SET req.fichaBoleta=valor
	WHERE mat.idAlumno=(SELECT idAlumno FROM CRM_Alumno WHERE dni=dniAlumno) AND YEAR(mat.fecha)=anio ;
WHEN 4 THEN
	UPDATE CRM_matRequisitos req INNER JOIN CRM_Matricula mat ON req.idMatricula=mat.idMatricula
	SET req.partNacimiento=valor
	WHERE mat.idAlumno=(SELECT idAlumno FROM CRM_Alumno WHERE dni=dniAlumno) AND YEAR(mat.fecha)=anio ;
WHEN 5 THEN
	UPDATE CRM_matRequisitos req INNER JOIN CRM_Matricula mat ON req.idMatricula=mat.idMatricula
	SET req.fotos=valor
	WHERE mat.idAlumno=(SELECT idAlumno FROM CRM_Alumno WHERE dni=dniAlumno) AND YEAR(mat.fecha)=anio ;
WHEN 5 THEN
	UPDATE CRM_matRequisitos req INNER JOIN tMatricula mat ON req.idMatricula=mat.idMatricula
	SET req.recibos=valor
	WHERE mat.idAlumno=(SELECT idAlumno FROM CRM_Alumno WHERE dni=dniAlumno) AND YEAR(mat.fecha)=anio ;
end case;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spCRM_registroAlumno` */

/*!50003 DROP PROCEDURE IF EXISTS  `spCRM_registroAlumno` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`db_userErpSap`@`%` PROCEDURE `spCRM_registroAlumno`(
    nomAlumno varchar(30),
	apPatAlumno VARCHAR(20),	
	apMatAlumno VARCHAR(20),
	dniAlumno CHAR(8),	
	fecNacAlumno varchar(10),
	dniEmpleado CHAR(8)
    )
BEGIN
INSERT INTO CRM_Alumno(nombre,apPaterno,apMaterno,dni,fecnacimiento,idEmpleado)
VALUES(
(CONCAT(UPPER(LEFT(TRIM(nomAlumno),1)),LOWER(SUBSTRING(TRIM(nomAlumno),2)))),
UPPER(TRIM(apPatAlumno)),
UPPER(TRIM(apMatAlumno)),
dniAlumno,
fecNacAlumno,(SELECT idEmpleado FROM HRM_Empleado WHERE dni=dniEmpleado));
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spCRM_registroMatricula` */

/*!50003 DROP PROCEDURE IF EXISTS  `spCRM_registroMatricula` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`db_userErpSap`@`%` PROCEDURE `spCRM_registroMatricula`(
    mNivel tinyint(1),
    mAnio tinyint(1),
    mSeccion char(1),
    mProcedencia varchar(100),
    mDniEmpleado char(8),
    mDniAlumno char(8),
    
    reqDniAlu tinyint(1),
    reqDniApo tinyint(1),
    reqCert TINYINT(1),
    reqBoleta TINYINT(1),
    reqPartida TINYINT(1),
    reqFotos TINYINT(1),
    reqRecibos TINYINT(1)
    )
BEGIN
SET @anioMatricula=YEAR(NOW());
IF NOT EXISTS(SELECT mat.`idMatricula` FROM CRM_Matricula mat INNER JOIN CRM_Alumno alu ON mat.`idAlumno`=alu.`idAlumno`
WHERE alu.`dni`=mDniAlumno AND YEAR(mat.`fecha`)=@anioMatricula)
 THEN
 
	INSERT INTO CRM_Matricula(fecha,nivel,anio,seccion,procedencia,idEmpleado,idAlumno)
	VALUES(NOW(),mNivel,mAnio,mSeccion,mProcedencia,(SELECT idEmpleado FROM HRM_Empleado WHERE dni=mDniEmpleado),(SELECT idAlumno FROM CRM_Alumno WHERE dni=mDniAlumno));
 
	INSERT INTO CRM_matRequisitos(copiaDniAlu,copiaDniApo,certificadoEstudio,fichaBoleta,partNacimiento,fotos,recibos,idMatricula)
	VALUES(reqDniAlu,reqDniApo,reqCert,reqBoleta,reqPartida,reqFotos,reqRecibos,(SELECT idMatricula FROM CRM_Matricula ORDER BY idMatricula DESC LIMIT 1));
	
	select 1;-- Nueva Matricula del año agregada
ELSE
	SELECT 0;-- La Matricula ya existe
END IF;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spCRM_registroPadres` */

/*!50003 DROP PROCEDURE IF EXISTS  `spCRM_registroPadres` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`db_userErpSap`@`%` PROCEDURE `spCRM_registroPadres`(
    nom varchar(30),
paterno VARCHAR(30),
materno VARCHAR(30),
dniPadre char(8),
nacimientoPadre date,
direccionPadre varchar(100),
fijo varchar(10),
cel VARCHAR(10),
nEmergencia varchar(10),
mail VARCHAR(50),
dniEmpleado char(8),
departamento varchar(30),
distrito varchar(30),
parent varchar(20),
dniAlumno char(8),
apo TINYINT(1)
    )
BEGIN
INSERT INTO CRM_aluPadres(nombre,apPaterno,apMaterno,dni,fecnacimiento,direccion,telFijo,celular,numEmergencia,email,idEmpleado,idDistrito)
VALUES(
(CONCAT(UPPER(LEFT(TRIM(nom),1)),LOWER(SUBSTRING(TRIM(nom),2)))),
UPPER(TRIM(paterno)),
UPPER(TRIM(materno)),
dnipadre,
nacimientoPadre,
direccionPadre,
fijo,
cel,
nEmergencia,
mail,
(SELECT idEmpleado FROM HRM_Empleado WHERE dni=dniEmpleado),
(SELECT dis.idDistrito FROM tDistrito dis INNER JOIN tDepartamento dep
ON dis.idDepartamento=dep.idDepartamento
WHERE dep.departamento=departamento AND dis.distrito=distrito)
);
insert into CRM_aluParentesco(idAlumno,idPadre,parentesco,apoderado)
values((select idAlumno from CRM_Alumno where dni=dniAlumno),(SELECT idPadre FROM CRM_aluPadres WHERE dni=dniPadre),parent,apo);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spHRM_registroEmpleado` */

/*!50003 DROP PROCEDURE IF EXISTS  `spHRM_registroEmpleado` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`db_userErpSap`@`%` PROCEDURE `spHRM_registroEmpleado`(
    inNombre varchar(30),
    inApPaterno varchar(20),
    inApMaterno varchar(20),
    inDni char(8),
    inFechaNac date,
    inTelefono varchar(10),
    inEmail varchar(50),
    
    inDepartamento varchar(30),
    inDistrito varchar(30),
    inDireccion VARCHAR(150),
    
    inPass varchar(50)
    
    )
BEGIN
INSERT INTO HRM_Empleado (nombre,apPaterno,apMaterno,dni,fecNacimiento,telefono,email,direccion,idDistrito,pass)
VALUES(
(CONCAT(UPPER(LEFT(TRIM(inNombre),1)),LOWER(SUBSTRING(TRIM(inNombre),2)))),
UPPER(TRIM(inApPaterno)),
UPPER(TRIM(inApMaterno)),
inDni,
inFechaNac,
inTelefono,
inEmail,
inDireccion,
(SELECT idDistrito FROM tDistrito dis INNER JOIN tDepartamento dep ON dep.idDepartamento=dis.idDepartamento
WHERE dis.distrito=inDistrito AND dep.departamento=inDepartamento),
inPass
);
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
