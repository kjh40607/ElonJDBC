package com.elon.jdbc.day03.pstmt.member.model.service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.elon.jdbc.day03.pstmt.member.common.JDBCTemplate;
import com.elon.jdbc.day03.pstmt.member.model.dao.MemberDAO;
import com.elon.jdbc.day03.pstmt.member.model.vo.Member;
public class MemberService {
	
	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDao;
	
	public MemberService() {
		//JDBCTemplate 싱글톤으로 객체 생성
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}
	// 회원 전체 정보 출력
	public List<Member> selectList() {
		// 생성된 연결을 DAO에 전달
		List<Member> mList = null;
		try {
			//서비스에서 연결 생성
			Connection conn = jdbcTemplate.getConnection();
			mList = mDao.selectList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}
	// 아이디로 회원 정보 출력
	public Member selectOneById(String memberId) {
		Member member = null;
		try {
			Connection conn = jdbcTemplate.getConnection();
			member = mDao.selectOneById(memberId, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	// 회원가입
	public int insertMember(Member member) {
		int result = 0;
		try {
			Connection conn = jdbcTemplate.getConnection();
			result = mDao.insertMember(member, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	// 회원 정보 수정
	public int updateMember(Member member) {
		int result = 0;
		try {
			Connection conn = jdbcTemplate.getConnection();
			result = mDao.updateMember(member, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	// 회원 정보 삭제
	public int deleteMember(String memberId) {
		int result = 0;
		try {
			Connection conn = jdbcTemplate.getConnection();
			result = mDao.deleteMember(memberId, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}