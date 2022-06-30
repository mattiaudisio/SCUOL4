SELECT * 
FROM asl.pazienti, asl.medici 
WHERE asl.medici.codice = 1 
AND Medici_codice = asl.medici.codice;
