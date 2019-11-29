package Operations;
import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import com.mysql.jdbc.*;


public class DBTest {

	private Connection connectDB() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:/home/leadheart/Code/Java/Test/src/BankDB.db");
			
			System.out.println("Connection Established ...\n");
			
		}
		
		catch (SQLException exc){
			exc.printStackTrace();
		}
		
		return conn;
	}
	
	
	public void selectAll() throws SQLException
	{
		String selectQuery = "SELECT * FROM CustomerLogin ";
		
		try {
			Connection conn = this.connectDB();
			Statement select = conn.createStatement();
			ResultSet rs = select.executeQuery(selectQuery);
			
			while(rs.next()) {
				System.out.println(rs.getInt("customerID") + "\t" + 
						rs.getString("customerName")  + "\t" + 
						rs.getString("customerUsername") + "\t" + 
						rs.getString("customerPassword") + "\n");
			}
		}
		
		catch(SQLException exc) {
			exc.printStackTrace();
		}
	}
	
	public boolean bankLogin(String uname, String pass) throws SQLException{
		String passQuery = "SELECT * FROM CustomerLogin WHERE customerUsername = '"+uname+"'";
		System.out.println("Query: "+passQuery);
		
		try {
			Connection conn = this.connectDB();
			Statement getPass = conn.createStatement();
			ResultSet rs = getPass.executeQuery(passQuery);
			
			String xpass = rs.getString(3);
			
			
			if(xpass.equals(pass))
			{
				System.out.println("Login Successful ...");
				System.out.println("Welcome "+rs.getString("customerName")+" ...");
				return true;
			}
			else
			{
				System.out.println("Login Failed ...");
				return false;
			}
		}
		
		catch(SQLException exc) {
			exc.printStackTrace();
		}
		return false;
	}
	
	
	public static void main(String[] args) throws SQLException{
		DBTest db = new DBTest();
		try {
		db.bankLogin("shreyassawai", "KINGShreyas");
		}
		catch(SQLException exc) {
			exc.printStackTrace();
		}
	}

}
