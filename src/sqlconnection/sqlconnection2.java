// Statement : 완결된 Query 문장을 실행할 때
// PreparedStatment : 변수로 값을 추가할 수 있는 Query문을 실행할 떄.
// execute Query ==> select ....반환타입 : ResultSet
// execute Update ==> insert, delete, update ....반환타입 : int

package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlconnection2 {

	Connection con = null;

//	private void insertDeptStatement(String dno, String dname, int budget) {
//
//		try {
//			Statement ps = con.createStatement();
//			String sql = String.format("insert into dept (dno, dname, budget) values ('%s', '%s', '%d')", dno, dname, budget);
//			System.out.println("데이터베이스가 입력되었습니다.");
//			int a = ps.executeUpdate(sql);
//		}catch (SQLException e){
//			e.printStackTrace();
//		}finally {
//			
//		}
//		
//	}

//	private void insertDept(String dno, String dname, int budget) {
//		
//		String sql = "insert into dept (dno, dname, budget) values (?, ?, ?)";
//		System.out.println("데이터베이스가 입력되었습니다.");
//	
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, dno);
//			ps.setString(2, dname);
//			ps.setInt(3, budget);
//			ps.executeUpdate();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println("데이터베이스가 입력되었습니다.");
//	}

	private boolean connectDB() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse", "scott", "tiger");
			System.out.println("데이터베이스가 연결되었습니다.");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private void closeDB() {
		try {
			con.close();
			System.out.println("데이터베이스가 닫혔습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private void deleteDepttriggerStatement(int from, int to) {
//		try {
//			Statement ps = con.createStatement();
//			
//			String sql = String.format("delete from depttrigger where %d <= id and id <= %d", from, to);
//			
//			System.out.println("데이터 " + sql + "개가 삭제되었습니다.");
//			int a = ps.executeUpdate(sql);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//		}
//	}

//	private void deleteDepttriggerPrepared(int from, int to) {
//		String sql = "delete from depttrigger where ? <= id and id <= ?";
//		
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1, from);
//			ps.setInt(2, to);
//			ps.executeUpdate();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println("데이터베이스가 삭제되었습니다.");
//	}

//	private void updateDeptPrepared(String dno, int budget, String dname) {
//		try {
//			PreparedStatement ps = con.prepareStatement("update dept set dname=?, budget=? where dno=?");
//			ps.setString(1, dname);
//			ps.setInt(2, budget);
//			ps.setString(3, dno);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	private void updateDeptStatement(String dno, int budget, String dname) {
		String sql = String.format("update dept set dname = '%s', budget=%d where dno = '%s'", dname, budget, dno);
		// 파라미터와 출력 위치 맞춰주기
		// 숫자타입의 출력은 '' 필요없다.
		
		try {
			Statement ps = con.createStatement();
			int a = ps.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		sqlconnection2 tt = new sqlconnection2();
		if (tt.connectDB()) {
			// tt.insertDept("d990", "dname10", 123);
			// tt.insertDeptStatement("d990", "dname10", 123);
			//tt.deleteDepttriggerStatement(1, 3);
			//tt.deleteDepttriggerPrepared(4, 6);
			//tt.updateDeptPrepared("d10", 5000, "my");
			tt.updateDeptStatement("d10", 500000, "mymy");
			tt.closeDB();
		}
	}

}
