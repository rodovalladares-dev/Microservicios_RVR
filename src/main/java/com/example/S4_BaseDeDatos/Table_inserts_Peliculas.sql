drop table peliculas;
CREATE TABLE peliculas (
  id         INTEGER PRIMARY KEY,
  titulo     VARCHAR2(100) NOT NULL,
  ano       INTEGER CHECK (ano >= 1888), -- Primer a�o de cine
  director   VARCHAR2(100),
  genero     VARCHAR2(50),
  sinopsis   VARCHAR2(200)
);


SELECT * FROM PELICULAS;
INSERT INTO peliculas (id, titulo, ano, director, genero, sinopsis)
VALUES (
  1,
  'El laberinto del fauno',
  2006,
  'Guillermo del Toro',
  'Fantas�a',
  'Una ni�a descubre un mundo m�gico en medio de la posguerra espa�ola.'
);

INSERT INTO peliculas (id, titulo, ano, director, genero, sinopsis) VALUES
(2, 'La vida es bella', 1997, 'Roberto Benigni', 'Drama', 'Un padre usa el humor para proteger a su hijo de los horrores del Holocausto.');

INSERT INTO peliculas (id, titulo, ano, director, genero, sinopsis) VALUES
(3, 'Inception', 2010, 'Christopher Nolan', 'Ciencia ficci�n', 'Un ladr�n especializado en robar secretos del subconsciente debe realizar una misi�n imposible.');

INSERT INTO peliculas (id, titulo, ano, director, genero, sinopsis) VALUES
(4, 'Parasite', 2019, 'Bong Joon-ho', 'Thriller', 'Una familia pobre se infiltra en la vida de una familia rica con consecuencias inesperadas.');

INSERT INTO peliculas (id, titulo, ano, director, genero, sinopsis) VALUES
(5, 'Am�lie', 2001, 'Jean-Pierre Jeunet', 'Comedia rom�ntica', 'Una joven parisina decide cambiar la vida de quienes la rodean con peque�os actos de bondad.');

INSERT INTO peliculas (id, titulo, ano, director, genero, sinopsis) VALUES
(6, 'El Padrino', 1972, 'Francis Ford Coppola', 'Crimen', 'La historia de una poderosa familia mafiosa en Nueva York.');

INSERT INTO peliculas (id, titulo, ano, director, genero, sinopsis) VALUES
(7, 'Forrest Gump', 1994, 'Robert Zemeckis', 'Drama', 'Un hombre con bajo coeficiente intelectual vive momentos clave de la historia estadounidense.');

INSERT INTO peliculas (id, titulo, ano, director, genero, sinopsis) VALUES
(8, 'Interstellar', 2014, 'Christopher Nolan', 'Ciencia ficci�n', 'Un grupo de astronautas viaja a trav�s de un agujero de gusano en busca de un nuevo hogar para la humanidad.');

INSERT INTO peliculas (id, titulo, ano, director, genero, sinopsis) VALUES
(9, 'La La Land', 2016, 'Damien Chazelle', 'Musical', 'Una aspirante a actriz y un m�sico luchan por sus sue�os en Los �ngeles.');

INSERT INTO peliculas (id, titulo, ano, director, genero, sinopsis) VALUES
(10, 'Titanic', 1997, 'James Cameron', 'Romance', 'Una historia de amor prohibido a bordo del famoso barco condenado.');


select * from peliculas;