package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class sqlconnection {

	public static void main(String[] args) {
		Connection con = null;	//DB 커넥션 연결 객체
		
		try {
				String driver ="com.mysql.cj.jdbc.Driver";
				String url ="jdbc:mysql://localhost:3306/warehouse";
				String username ="root";
				String password ="1234";
				Class.forName(driver);
				con = DriverManager.getConnection(url, username, password);
				
				System.out.println("Connection Succes");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(con != null) con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
}
