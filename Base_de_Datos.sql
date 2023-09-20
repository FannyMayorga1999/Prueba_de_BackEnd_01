--CREACION DE LA BASE DE DATOS
CREATE DATABASE prueba01;

--TABLA CLIENTES
DROP TABLE IF EXISTS adm_client CASCADE;
CREATE TABLE adm_client (
	"id" serial PRIMARY KEY,
	"identification" Text UNIQUE NOT NULL,
	"name" TEXT,
	"email" TEXT CHECK (email ~* '^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$' || email ~* ''),
	"phone" TEXT,
	"benefit" text,
	"deleted" boolean NOT NULL DEFAULT false
);
   
--CREACION DE LOS CLIENTES

INSERT INTO adm_client( identification, name, email, phone) VALUES ( '1726679093', 'Fanny Mayorga', 'fannymayorga@gmail.com', '09999912142');
INSERT INTO adm_client( identification, name, email, phone) VALUES ( '1726679200', 'Vanessa Mayorga', 'vanessamayorga@gmail.com', '09999912141');
INSERT INTO adm_client( identification, name, email, phone) VALUES ( '1726679520', 'Elizabeth Mayorga', 'elizabethmayorga@gmail.com', '09999912122');