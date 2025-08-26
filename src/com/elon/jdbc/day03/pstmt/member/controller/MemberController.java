package com.elon.jdbc.day03.pstmt.member.controller;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.elon.jdbc.day03.pstmt.member.model.dao.MemberDAO;
import com.elon.jdbc.day03.pstmt.member.model.service.MemberService;
import com.elon.jdbc.day03.pstmt.member.model.vo.Member;
public class MemberController {
	private MemberDAO mDao;
	private MemberService mService;
	
	public MemberController() {
		mDao = new MemberDAO();
		mService = new MemberService();
	}
	public Member findOneById(String memberId) {
		Member member = mService.selectOneById(memberId);
		return member;
	}
	public List<Member> showMemberList() {
		List<Member> mList = mService.selectList();
		return mList;
	}
	
	public int registerMember(Member member) {
		int result = mService.insertMember(member);
		return result;
	}
	
	public int updateMember(Member member) {
		int result = mService.updateMember(member);
		return result;
	}
	
	public int deleteMember(String memberId) {
		int result = mService.deleteMember(memberId);
		return result;
	}
	
	private Member rsetToMember(ResultSet rset) throws SQLException {
		String memberId   = rset.getString("MEMBER_ID");
		String memberPwd  = rset.getString("MEMBER_PWD");
		String memberName = rset.getString("MEMBER_NAME");
		char gender		  = rset.getString("GENDER").charAt(0);
		int age			  = rset.getInt("AGE");
		String email	  = rset.getString("EMAIL");
		String phone	  = rset.getString("PHONE");
		String address	  = rset.getString("ADDRESS");
		String hobby	  = rset.getString("HOBBY");
		Date enrollDate	  = rset.getDate("ENROLL_DATE");
		Member member = new Member(memberId, memberPwd, memberName
				, gender, age, email, phone, address, hobby, enrollDate);
		return member;
	}
}