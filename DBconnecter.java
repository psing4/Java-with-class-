package 최종발표;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconnecter {
	String jdbcDriver = "com.mysql.jdbc.Driver";	//jdbc 드라이버
	String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/company?useSSL=false"; //mysql 디비 위치
	String id= "root"; //mysql 사용자 아이디
	String pwd="dmstkd20441!"; //mysql 사용자 비번
	Connection conn; //jdbc 연결 
	PreparedStatement pstmt; //jdbc sql 생성 객제
	ResultSet rs;  //jdbc 에서 DB 데이터 가져오는 객체
	
	
public void connectDB() { // DB연결 메서드
		try {
			Class.forName(jdbcDriver); // 1단계: JDBC드라이버 로드
			// 2단계: 데이터베이스 연결
			conn = DriverManager.getConnection(jdbcUrl,id,pwd);
		} catch (Exception e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}
	}
	
	
public void closeDB() { // DB 연결 종료 메서드
		try {
			// 6단계: 연결 해제
			pstmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
