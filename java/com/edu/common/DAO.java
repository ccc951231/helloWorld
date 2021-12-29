package com.edu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;
	

	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	      
	      //2. DBMS서버와 접속하기 
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";    // 고정되어있음 @localhost는 ip 1521은 리스너 포트 번호 xe는 SID를 의미
	      String id = "hr";
	      String password = "hr";
	     
	      try {
			conn = DriverManager.getConnection(url, id, password);
			System.out.println("연결 성공!!");
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	public void disconnect() {
		if( rs != null) {
			try {
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(psmt != null) {
			try {
				psmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}