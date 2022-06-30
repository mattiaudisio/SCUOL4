package dbMysql;

import java.sql.ResultSet;

/** interface ISelectPassResultSet
 * interfaccia  utilizzata per passare a agli oggetti che la implementano un 
 * oggetto di tipo ResultSet definito in java.sql
 * 
 * il metodo executeQuery della classe QueryDbExecute richiede come parametro
 * un oggetto che implementi questa interfaccia 
 */
public interface ISelectPassResultSet {
	
	public void passResultSet(ResultSet rows);
}
