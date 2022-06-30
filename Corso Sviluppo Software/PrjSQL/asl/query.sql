SELECT asl.pazienti.cognome, asl.pazienti.nome, asl.medici.cognome
FROM asl.pazienti
INNER JOIN asl.medici ON asl.pazienti.Medici_codice = asl.medici.codice;
