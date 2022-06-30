/*
 * Classe con dati per connessione a db MySql
 * getDriverWithoutDbName()
 * getDriver()
 * get/set nomeDb
 * get/set password
 * get/set username
*/

package dbMysql;

public class DbConnection {
	private static DbConnection MyDbConnection = null;
	private String nomeDb = "sakila";
	private String userName = "root"; // definisce userName e imposta Default
	private String password = "qwerty.1"; // definisce password e imposta Default

	/*
	 * Implementa pattern SINGLETON (pattern: danno la traccia per come implementare
	 * del codice di situazioni che si verificano molto spesso SINGLETON: è un
	 * pattern che ci mostra come fare per far tornare da una classe un solo
	 * oggetto) della classe DbConncetion torna solo una istanza, sempre la stessa
	 */
	public static DbConnection getDb() {
		/*
		 * ** verifica se esiste l'istanza MyDBConnection della classe DbConnection, se
		 * non esiste la crea. La creazione viene eseguita solo una volta (pattern
		 * SINGLETON) MyDbConnection è una variaile di classe (ovvero STATIC)
		 */
		if (MyDbConnection == null) {
			MyDbConnection = new DbConnection();
		}
		// ** Torna oggetti di classe MyDbConnection
		return MyDbConnection;
	}

	/*
	 * costruttore privato mi inpedisce di creare l'oggetto al di fuori di questa
	 * classe (pattern SINGLETON)
	 */
	private DbConnection() {
	}

	/*
	 * Torna Stringa utilizzata per creare oggetto JDBC di tipo Connessione
	 * (java.sql) SENZA nome del database da utilizzare. Da utilizzare per esempio
	 * con CREATE DATABASE quindi il db non è ancora creato in MySql e non può far
	 * parte della stringa di connessione
	 */
	public String getDriverWithoutDbName() {
		// ** nomeDb è il nome del database.
		// ** jdbc:mysql sta ad indicare che viene utilizzato un db mysql
		// ** localhost è il nome del pc server in questo caso 127.0.0.1
		// ovvero il PC locale dove risiede sia il server mysql che l'applicazione Java
		// ** 3306 è la porta utilizzata per default da MySql
		// ** serverTimeZone=UTC necessario probabilmente a causa del firewall AFP che
		// blocca l'accesso a internet
		// ** allowMultiQueries=true per permettere che una stringa query possa
		// contenere multiple istruzioni SQL ad esemepio per inserire in un unica
		// stringa da inviare a MySql più istruzioni INSERT INTO separate da ;
		return "jdbc:mysql://localhost:3306/?serverTimezone=UTC&allowMultiQueries=true";
	}

	/*
	 * Torna Stringa utilizzata per creare oggetto JDBC di tipo Connessione
	 * (java.sql) CON nome del database da utilizzare. Quindi il db deve già
	 * esistere in MySql
	 */
	public String getDriver() throws Exception {
		// ** nomeDb è il nome del database.
		// ** jdbc:mysql sta ad indicare che viene utilizzato un db mysql
		// ** localhost è il nome del pc server in questo caso 127.0.0.1
		// ovvero il PC locale dove risiede sia il server mysql che l'applicazione Java
		// ** 3306 è la porta utilizzata per default da MySql
		// ** serverTimeZone=UTC necessario probabilmente a causa del firewall AFP che
		// blocca l'accesso a internet
		// ** allowMultiQueries=true per permettere che una stringa query possa
		// contenere multiple istruzioni SQL ad esemepio per inserire in un unica
		// stringa da inviare a MySql più istruzioni INSERT INTO separate da ;
		if (nomeDb == null || nomeDb == "") {
			Exception e = new Exception("Database non definito in DbConnection.getDriver\n"
					+ "Impostare nome db prima di richiamare getDriver");
			throw (e);
		}
		return "jdbc:mysql:" + "//localhost:3306/" + nomeDb + "?serverTimezone=UTC&allowMultiQueries=true";
	}

	/*
	 * imposta Databse da utilizzare
	 */
	public void setNomeDb(String value) {
		nomeDb = value;
	}

	/*
	 * torna nome db in uso
	 */
	public String getNomeDb() {
		return nomeDb;
	}

	/*
	 * torna user name utilizzata per accesso a Mysql default : root
	 */
	public String getUserName() {
		return userName;
	}

	/*
	 * permette di impostare user name per accesso MySql
	 */
	public void setUserName(String pUserName) {
		userName = pUserName;
	}

	/*
	 * torna password utilizzata per accesso a Mysql default : root
	 */
	public String getPassword() {
		return password;
	}

	/*
	 * permette di impostare password per accesso MySql
	 */
	public void setPassword(String PASSWORD) {
		this.password = PASSWORD;
	}

}
