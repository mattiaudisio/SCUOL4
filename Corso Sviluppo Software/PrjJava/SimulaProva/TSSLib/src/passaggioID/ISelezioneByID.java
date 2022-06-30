package passaggioID;
/**
 * interfaccia che consente all'oggetto che la implementa di ricevere da 
 * un form di ricerca un ID che generalmente è la key per ricercare un record 
 * su una tabella 
 */
public interface ISelezioneByID {
	void selezione (int pID);
}

