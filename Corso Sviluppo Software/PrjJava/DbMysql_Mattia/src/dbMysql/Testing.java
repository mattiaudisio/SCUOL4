package dbMysql;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DbConnection.getDb().getDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
