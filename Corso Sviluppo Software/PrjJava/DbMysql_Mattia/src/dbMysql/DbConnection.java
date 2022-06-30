/*
 * Questa è la classe con connessioni per DbMySQL
 * 
 * getDriverWithoutDbName()
 * getDriver()
 * get/set nomeDb
 * get/set password
 * get/set username
 * 
 */



package dbMysql;

public class DbConnection {
	private static DbConnection MyDbConnection=null;
	private String nomeDb = ""; //definisce nomeDb imposta il default
	private String username = "root"; //definisce username imposta il default
	private String password = "qwerty.1"; //defiisce la password imposta il default
	
	
	//il costruttore privato mi impedisce di creare l'oggetto al di fuori da questa classe
	//fa' sempre parte del pattern SINGLETON
	private DbConnection() {}
	
	
	/**
	 * 
	 * implementa pattern SINGLETON dell classe DbConnection torna solo una istanza,
	 * SEMPRE la stessa istanza
	 */
	public static DbConnection getDb() {
		/**
		 * verifiva se esiste la istanza MyDbConnection della classe DbConnection,
		 * se non esiste la crea. La creazione viene eseguita SOLO UNA volta,
		 * perchè MyDbConnection è una variabile di CLASSE, ovvero "static"
		 */
		//DbConnection dbcon=new DbConnection();
		if(MyDbConnection==null) {
			MyDbConnection= new DbConnection();
		}
		//torna oggetto di classe MyDbConnection
		return MyDbConnection;
	}
	
	/*** getDrive mi ritorna una stringa utilizzata per creare un oggetto
	 * JDBC di tipo connessione con il database da utilizzare. 
	 *** QUindi il database deve già esistere in MySQL
	 *** nomeDb è il nome del database
	 *** jadbc:mysql sta a indicare che viene utliizzato un db Mysql
	 *** localhost è il nome del pc server, in questo caso 127.0.0.1, 
	 * ovvero il PC locale dove risiede sia il server Mysql che l'applicazione java
	 *** 3306 è la porta utilizzata per default da Mysql
	 *** serverTimezone=UTC è necessario a causa del firewall AFP
	 *** allowMultiQueries=true lo avevo messo per permettere che una query possa contenere
	 * multiple istruzioni Mysql, ad esempio per inserire in un unica stringa da inviare
	 * a Mysql più istruzioni INSERT INTO separate da un ;
	 * 
	 */
	public String getDriver() throws Exception{
		if(nomeDb==null|| nomeDb=="") {
		Exception e= new Exception("Database non definito in DbConnection.getDriver()"
				+ "\nImpostare il nomeDb prima di richiamare il getDriver");
		throw (e);
		}
		return "jdbc:mysql://localhost:3306/" + nomeDb + "?serverTimezone=UTC&allowMultiQueries=true";
	}
	
	/**
	 * getDriverWithoutDbName mi ritorna una stringa utilizzata per creare un oggetto
	 * JDBC di tipo connessione (java.sql) SENZA il nome del database. Da utilizzare per
	 * esempio con CREATE DATABASE
	 * quindi il database non è ancora creato in MySQL e non può far parte della stringa
	 * di connessione
	 * 
	 */
	public String getDriverWithoutDbName() {
		return "jdbc:mysql://localhost:3306/?serverTimezone=UTC&allowMultiQueries=true";
	}

	/*
	 * ritorna l'username utilizzata per l'accesso a MySQL
	 * il default in questo caso è: "root"
	 */
	public String getUsername() {
		return username;
	}
	
	/*
	 * permette di impostare lo username per l'accesso MySQL
	 */
	public void setUsername(String value) {
		username=value;
	}
	
	/*
	 * torna la password utilizzata per l'accesso. Il default in questo 
	 * caso è "qwerty.01"
	 */
	public String getPassword() {
		return password;
	}
	
	/*
	 * permette di impostare la password per l'accesso MySQL
	 */
	public void setPassword(String PASSWORD) {
		this.password=PASSWORD;
	}
	
	/*
	 * ritorna il nome DB in uso
	 */
	public String getNomeDb() {
		return nomeDb;
	}

	
	/* 
	 * imposta il database da utilizzare
	 * 
	 */
	public void setNomeDb(String value) {
		nomeDb = value;
	}
}