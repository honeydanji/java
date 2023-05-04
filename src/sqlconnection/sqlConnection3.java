package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class sqlConnection3 {

	// 데이터 베이스 연결이 첫번째!
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

	// DB 연결 객체
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	// select
	private void selectContact() {
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from contact");

			while (rs.next()) {
				System.out.println(String.format("%d,%s,%s,%s,%s", rs.getInt("CID"), rs.getString("name"),
						rs.getString("class1"), rs.getString("address"), rs.getString("rectal")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// insert
	private void insertContact(int CID, String name, String class1, String address, String rectal) {
		String sql = "insert into contact values(?, ?, ?, ?, ?) ";
		System.out.println("데이터를 입력받았습니다.");
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, CID);
			ps.setString(2, name);
			ps.setString(3, class1);
			ps.setString(4, address);
			ps.setString(5, rectal);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (rs != null)
					st.close();
				if (rs != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// DB 연결 해제
	private void closeDB() {
		try {
			con.close();
			System.out.println("데이터베이스가 닫혔습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// main 함수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sqlConnection3 tt = new sqlConnection3();

		if (tt.connectDB()) {
			while (true) {
				System.out.println(" 1.select or 2.insert ");
				int SorI = sc.nextInt();
				if (SorI == 1) {
					tt.selectContact();
					System.out.println("계속 조회하시겠습니까? ");
					int YoN = sc.nextInt();
					if (YoN < 0) {
						tt.closeDB();
						break;
					}
				} else if (SorI == 2) {
					System.out.print("ID를 입력 하세요 : ");
					int a = sc.nextInt();
					System.out.print("이름 : ");
					String s1 = sc.next();
					System.out.print("구분 : ");
					String s2 = sc.next();
					System.out.print("주소 : ");
					String s3 = sc.next();
					System.out.print("직업 : ");
					String s4 = sc.next();

					// tt.insertContact(1, "홍길동", "friends", "조선", "자원봉사자");
					tt.insertContact(a, s1, s2, s3, s4);

					System.out.println("데이터를 계속 입력하시겠습니까 ? ");
					int YoN = sc.nextInt();

					if (YoN < 0) {
						tt.closeDB();
						break;
					}

				}
			}
		}
	}

}
