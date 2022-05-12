-- VISUALIZZARE L'ELENCO DI TUTTI GLI ESEMPLARI DI FAUNA, ORDINATI PER SPECIE, PRESENTI NEI VARI PARCHI--
SELECT Fauna.specie, Parchi.nomeParco
FROM Fauna, Parchi, Vivono
WHERE Vivono.codiceFauna = Fauna.codiceFauna
AND Parchi.codiceParco = Vivono.codiceParco
ORDER BY Fauna.specie;

-- VISUALIZZARE QUANTE SPECIE DIVERSE DI PINO SONO PRESENTI IN CIASCUN PARCO --
SELECT Parchi.nomeParco, count(Flora.codiceFlora) as numPini
FROM Flora, Parchi, Trovano
WHERE Trovano.codiceFlora = Flora.codiceFlora
AND Parchi.codiceParco = Trovano.codiceParco
AND Flora.nome = "pino"
GROUP BY Parchi.nomeParco;

-- VISUALIZZARE IL NOME DELLA SPECIE DI ANIMALE CON IL PIÙ ALTO NUMERO DI ESEMPLARI CENSITI NEI VARI PARCHI DELLA REGIONE --
CREATE VIEW numeroEsemplari(parco,specie,numero) AS
SELECT Parchi.nomeParco, Fauna.specie, COUNT(Parchi.nomeParco)
FROM Fauna, Parchi, Vivono
WHERE Vivono.codiceFauna = Fauna.codiceFauna
AND Parchi.codiceParco = Vivono.codiceParco
GROUP BY Parchi.nomeParco, Fauna.specie;

SELECT specie,parco
FROM numeroEsemplari
WHERE numero = (SELECT MAX(numero))
FROM (numeroEsemplari));
