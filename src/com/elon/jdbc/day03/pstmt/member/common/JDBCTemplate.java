package com.elon.jdbc.day03.pstmt.member.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "JHJDBC";
	private final String PASSWORD = "JHJDBC";
	
	private static JDBCTemplate instance;
	private JDBCTemplate() {}
	public static JDBCTemplate getInstance() {
		if(instance == null) {
			instance = new JDBCTemplate();
		}
		return instance;
	}
	// 원래는 Connection 싱글톤 패턴을 적용해서 생성된 연결을 재사용해야하지만
	// 몇줄의 코드로 구현할 수 없음.
	// 나중에는 Connection Pool 라이브러리를 사용해서 한번 생성된 연결을 재사용하게됨.
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
