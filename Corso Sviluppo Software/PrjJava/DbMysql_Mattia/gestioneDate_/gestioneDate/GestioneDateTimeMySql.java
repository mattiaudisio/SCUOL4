package gestioneDate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import dbMysql.DbConnection;
import dbMysql.QueryDbExecute;

public class GestioneDateTimeMySql {

	public static void main(String[] args) {
		DbConnection.getDb().setNomeDb("veicoli");
		// -- yyyy-mm-dd formato data di default (US)
		String sql;
		sql = "INSERT INTO tbdataora (dt) VALUES ('2021-03-08')";
		QueryDbExecute.executeUpdate(sql);
		// -- ora HH:mm
		sql = "INSERT INTO tbdataora (dt,tm) VALUES ('2021-03-08','22:05')";
		QueryDbExecute.executeUpdate(sql);
		// -- yyyy-mm-dd formato data europeo (IT)
		sql = "INSERT INTO tbdataora (dt,tm) VALUES (STR_TO_DATE('31/12/2050','%d/%m/%Y'),'22:05')";
		QueryDbExecute.executeUpdate(sql);

		// ****************
		sql = "UPDATE tbdataora SET dt = '1999-01-15', tm = '15:00:45' WHERE ID = 6;";
		QueryDbExecute.executeUpdate(sql);
		sql = "UPDATE tbdataora SET dt = STR_TO_DATE('31/12/2050','%d/%m/%Y'), tm = '16:34:27' WHERE ID = 4;";
		QueryDbExecute.executeUpdate(sql);

		// ****************
		sql = "SELECT * FROM tbdataora WHERE ID = 6";
		executeQuery(sql);
	}

	public static void executeQuery(String pQuery) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rows = null;

		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUsername(),
					DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			rows = stmt.executeQuery(pQuery);
			// lettura di tutte le righe
			while (rows.next()) {
				// ****** da tabella a localDate

				// **** legge l'ora ma prima esegue controllo che campo nel db non sia null
				LocalDate ldt = null;
				LocalTime ltm = null;
				// verifico che il campo nella tabella non sia nulla
				if (rows.getTime("tm") != null && rows.getDate("dt") != null) {
					// ** campo tabella diverso da null
					// ** converto il campo tabella in oggetto classe java.sql.date che 
					// ** converto in LocalDate
					ldt = rows.getDate("dt").toLocalDate();
					ltm = rows.getTime("tm").toLocalTime();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// return result;
		} finally {
			/* 3 */try {
				if (rows != null)
					rows.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/* 2 */try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/* 1 */try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
