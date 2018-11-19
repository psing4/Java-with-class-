package ������ǥ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconnecter {
	String jdbcDriver = "com.mysql.jdbc.Driver";	//jdbc ����̹�
	String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/company?useSSL=false"; //mysql ��� ��ġ
	String id= "root"; //mysql ����� ���̵�
	String pwd="dmstkd20441!"; //mysql ����� ���
	Connection conn; //jdbc ���� 
	PreparedStatement pstmt; //jdbc sql ���� ����
	ResultSet rs;  //jdbc ���� DB ������ �������� ��ü
	
	
public void connectDB() { // DB���� �޼���
		try {
			Class.forName(jdbcDriver); // 1�ܰ�: JDBC����̹� �ε�
			// 2�ܰ�: �����ͺ��̽� ����
			conn = DriverManager.getConnection(jdbcUrl,id,pwd);
		} catch (Exception e) {
			System.out.println("DB���� ����");
			e.printStackTrace();
		}
	}
	
	
public void closeDB() { // DB ���� ���� �޼���
		try {
			// 6�ܰ�: ���� ����
			pstmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
