
package context;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContext {
	static String hostName = "DESKTOP-US9F04C";
	static String sqlInstanceName = "";
	static String database = "ShopHoa";
	static	String userName = "sa";
	static	String password = "123";
	public static Connection getConnection() throws SQLException,
    ClassNotFoundException {
String hostName = "DESKTOP-US9F04C";
String sqlInstanceName = "SQLEXPRESS2012";
String database = "ShopHoa";
String userName = "sa";
String password = "123";

return getSQLServerConnection_JTDS(hostName, sqlInstanceName, database,
        userName, password);
}



private static Connection getSQLServerConnection_JTDS(String hostName,
    String sqlInstanceName, String database, String userName,
    String password) throws ClassNotFoundException, SQLException {

Class.forName("net.sourceforge.jtds.jdbc.Driver");

// Cấu trúc URL Connection dành cho SQLServer
// Ví dụ:
// jdbc:jtds:sqlserver://localhost:1433/simplehr;instance=SQLEXPRESS
String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/"
        + database + ";instance=" + sqlInstanceName;

Connection conn = DriverManager.getConnection(connectionURL, userName,
        password);
return conn;
}
public static void main(String[] args) {
	try {
		getConnection();
		System.out.println("Thanh Cong");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
 