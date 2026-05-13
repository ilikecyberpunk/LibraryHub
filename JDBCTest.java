import java.sql.*;
public class JDBCTest {
	public static void main(String[] args) {
		//1.필요한 변수 선언 및 초기화
		String driver = "oracle.jdbc.driver.OracleDriver"; //드라이버 
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //접속정보
		String userid = "SYS"; //접속계정
		String passwd = "a93686351@"; //패스워드 

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try { //2.JDBC 드라이버 로딩
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");

			//3.DB 접속 - Connection
			con = DriverManager.getConnection(url, userid, passwd);
			System.out.println("DB 접속 성공");

			//4.SQL 문 작성
			String sql = "select * from B";

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //7.자원 반납
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
				System.out.println("자원반납 완료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}