/** DbConnection **
 * Classe per la connessione a db MySql
 * E' permessa la creazione di una sola istanza di questa classe (pattern SINGLETON)
 * 
 * static getDb() : torna istanza di questa classe
 *  
 * getDriver()
 * getDriverWithoutDbName()
 * 
 * get/set nomeDb
 * get/set userName (è impostato username di default )
 * get/set password (è impostato username di default )
 * 
*/
package dbMysql;

public class DbConnection {
	private static DbConnection MyDbConnection = null; // connessione che viene creata e toranta dal metodo getDB
	private String nomeDb = ""; 
	private String userName = "root"; // per comodità viene impostato userName di default
	private String password = "qwerty.1"; // per comodità viene impostato password di default

	/**
	 * siccome si desidera avera una sola istanza di questa classe
	 * il costruttore ha visibilità private.
	 * Essendo private non è possibile creare questo oggetto da una classe esterna.
	 * --> 	Quindi solo un metodo statico presente in questa classe 
	 * --> 	permette di creare l'istanza/oggetto 
	 * --> 	(pattern SINGLETON)
	 */
	private DbConnection() {
	}
	
	/**
	 * Implementa pattern SINGLETON
	 * della classe DbConnection torna solo una istanza, sempre la stessa
	 * 
	 */
	public static DbConnection getDb() {
		/* ** verifica se esiste l'istanza MyDbConnection
		 * della classe DbConnection
		 * Se non esiste la crea 
		 * La creazione viene eseguita solo un volta (pattern SINGLETON)
		 * MyDbConnection è una variabile di classe (ovvero STATIC)
		 */
		if (MyDbConnection == null) {
			MyDbConnection = new DbConnection();
		}
		//**  torna oggetto di classe DbConnection
		return MyDbConnection;
	}


	/**
	 * torna Stringa utilizzata per creare oggetto JDBC (java.sql)
	 * di tipo connessione SENZA nome del database da utilizzare
	 * da utilizzare per es. con CREATE DATABASE.
	 * quindi il db non è ancora creato in MySql e non può far parte 
	 * della stringa di connessione.
	 */
	public String getDriverWithoutDbName() {
		//return "jdbc:mysql:" + "//localhost:3306/?serverTimezone=UTC&allowMultiQueries=true";
		return "jdbc:mysql:" + "//localhost:3306/?allowMultiQueries=true";
	}

	/**
	 * torna Stringa utilizzata per creare oggetto JDBC (java.sql)
	 * di tipo connessione CON IL  nome del database da utilizzare.
	 * Quindi il db deve già esistere in MySql
	 * @throws Exception 
	 */
	public String getDriver() throws Exception {
		//** nomDb è il nome del database
		//** jdbc:mysql sta a indicare che viene utilizzaro un db mysql
		//** localhost è il nome del pc server in questo 127.0.0.1
		//	 ovvero il PC locale dove risiede sia il server mysql
		//	 che l'applicazione java
		//** 3306 è la porta utilizzata per default da MySql
		//** serverTimezone=UTC necessario probabilmente 
		//	 a causa del firewall AFP
		//** allowMultiQueries=true per permettere che una stringa query possa 
		//	 contenere multiple istruzioni SQL
		//	 ad es. per inserire in un unica stringa da inviare a mysql più
		//	 istruzioni INSERT INTO separate da ; 
		
		if (nomeDb == null || nomeDb=="") {
			Exception e = new Exception("Database non definito in DbConnection.getDriver \n"
										+ "Impostare nome db prima di richiamare getDriver");
			throw (e);
		}
		//return "jdbc:mysql:" + "//localhost:3306/" + nomeDb + "?serverTimezone=UTC&allowMultiQueries=true";
		return "jdbc:mysql:" + "//localhost:3306/" + nomeDb + "?allowMultiQueries=true "
				+ "&useLegacyDatetimeCode=false&serverTimezone=Europe/Rome";
	}
	/**
	 * imposta Database da utilizzare
	 */
	public void setNomeDb(String value) {
		nomeDb = value;
	}
	
	/**
	 * Torna nome db in uso
	 */
	public String getNomeDb() {
		return nomeDb;
	}

	/**
	 * torna user name utilizzata per accesso a Mysql
	 * default : root
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * permette di impostare user name per accesso Mysql
	 */
	public void setUserName(String pUserName) {
		userName = pUserName;
	}

	/**
	 * torna password utilizzata per accesso a Mysql
	 * default : qwerty.1
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * permette di impostare password per accesso Mysql
	 */
	public void setPassword(String pPassword) {
		this.password = pPassword;
	}

}
