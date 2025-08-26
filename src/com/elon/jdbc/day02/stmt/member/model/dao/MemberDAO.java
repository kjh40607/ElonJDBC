package com.elon.jdbc.day02.stmt.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elon.jdbc.day02.stmt.member.model.vo.Member;

public class MemberDAO {
	
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "JHJDBC";
	private final String PASSWORD = "JHJDBC";
	
	public List<Member> selectList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<Member> mList = null;
		String query = "SELECT * FROM MEMBER_TBL ORDER BY MEMBER_ID ASC";
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			mList = new ArrayList<Member>();
			// 후처리
			while(rset.next()) {
				String memberId = rset.getString("MEMBER_ID");
				String memberPwd = rset.getString("MEMBER_PWD");
				String memberName = rset.getString("MEMBER_NAME");
				char gender = rset.getString("GENDER").charAt(0);
				int age = rset.getInt("AGE");
				String email = rset.getString("EMAIL");
				String phone = rset.getString("PHONE");
				String address = rset.getString("ADDRESS");
				String hobby = rset.getString("HOBBY");
				Date enrollDate = rset.getDate("ENROLL_DATE");
				Member member = new Member(memberId, memberPwd, memberName, gender, age, email, phone, address, hobby, enrollDate);
				mList.add(member);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}
	public Member selectOneById(String memberId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = '" + memberId + "'";
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			// 후처리 (rset -> Member || List<Member>)
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setGender(rset.getString("GENDER").charAt(0));
				member.setAge(rset.getInt("AGE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setHobby(rset.getString("HOBBY"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}
	public int insertMember(Member member) {
		Connection conn = null;
		Statement stmt = null;
		String query = "INSERT INTO MEMBER_TBL VALUES('"+ member.getMemberId() + "', '"
																				+ member.getMemberPwd() + "', '"
																				+ member.getMemberName() + "', '"
																				+ member.getGender() + "', '"
																				+ member.getAge() + "', '"
																				+ member.getEmail() + "', '"
																				+ member.getPhone() + "', '"
																				+ member.getAddress() + "', '"
																				+ member.getHobby() + "', "
																				+ "DEFAULT)";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int updateMember(Member member) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		String query = "UPDATE MEMBER_TBL SET MEMBER_PWD = '" + member.getMemberPwd() + "', "
																+ "EMAIL = '" + member.getEmail() + "', "
																+ "PHONE = '" + member.getPhone() + "', "
																+ "ADDRESS = '" + member.getAddress() + "', "
																+ "HOBBY = '" + member.getHobby() + "' "
																+ "WHERE MEMBER_ID = '" + member.getMemberId() + "'";
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int deleteMemter(String memberId) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = '" + memberId + "'";
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
