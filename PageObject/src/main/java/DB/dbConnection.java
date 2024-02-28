package DB;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

///Sample DB code to refer///
public class dbConnection {

	public PreparedStatement pst;
	java.sql.Connection conn = null;
	ResultSet result = null;

	public ResultSet databaseConnection(String query) {

		try {

			String url = "jdbc:sqlserver://192.168.1.222;" + "databaseName=wbc-mp-convert; ";

			String username = "sa";
			String password = "etxadmin_1";

			// Initialize Sqldriver instance
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Creating the connection providing URL and username password
			conn = DriverManager.getConnection(url, username, password);

			// Checking for the connection( returns boolean false if connected)
			System.out.println(conn.isClosed());

			// For Print
			System.out.println("Data values getting displayed below");
			// Sql Query to dispaly all the values under xxxxxxxx table
			// String query = "SELECT * from mp_icd_codes";
			// Providing the query under prepareStatement parameter
			PreparedStatement pst = conn.prepareStatement(query);
			result = pst.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void DB(String pagename, String query,String[] UIvalues) throws Exception {
		// Command to execute query and capturing all the result under Result set

		ResultSet re=databaseConnection(query);

		while (result.next()) {
			// System.out.println(result.getString(1)+ " "+ result.getString(2) +" "
			// +result.getString(6));

			if (pagename == "ICD") {
				String ICD_codnum = re.getString("icd_code_number");
				String ICD_cod_type = re.getString("icd_code_type");
				String ICD_cod_name = re.getString("icd_code_name");
				
				 String[] DBvalues = {ICD_codnum, ICD_cod_type,ICD_cod_name};
				 
				 
				  if (!Arrays.equals(UIvalues, DBvalues)) 
				 throw new Exception("Arrays mismatched");
				  
				  
			}
		}

	}
}
