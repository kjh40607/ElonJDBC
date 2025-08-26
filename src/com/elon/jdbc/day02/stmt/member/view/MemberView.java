package com.elon.jdbc.day02.stmt.member.view;

import java.util.List;
import java.util.Scanner;

import com.elon.jdbc.day02.stmt.member.controller.MemberController;
import com.elon.jdbc.day02.stmt.member.model.dao.MemberDAO;
import com.elon.jdbc.day02.stmt.member.model.vo.Member;

public class MemberView {
	private MemberController mController;
	
	public MemberView() {
		mController = new MemberController();
	}
	
	// Run에서 시작할 메소드
	public void startProgram() {
		Member member;
		int result;
		String memberId;
		
		finish:
		while(true) {
			int choice = this.printMenu();
			switch(choice) {
			case 1 :
				member = addMember();
				result = mController.registerMember(member);
				if(result > 0) {
					printMessage("회원 가입완료");
				}else {
					printMessage("회원 가입이 완료되지 않았습니다.");
				}
				break;
				
			case 2 :
				List<Member> mList = mController.showMemberList();
				printAllMember(mList);
				break;
				
			case 3 :
				// 아이디 입력받기
				memberId = inputMemberId();
				// 디비에서 회원정보 가져오기
				member = mController.findOneById(memberId);
				// 출력하기
				if(member != null) {
					printOne(member);
				} else {
					printMessage("해당 아이디는 존재하지 않습니다.");
				}
				break;
				
			case 4 :
				// 아이디 입력받기
				memberId = inputMemberId();
				// 수정할 정보 입력받기
				member = modifyMember(memberId);
				// 디비에서 회원정보 수정하도록 요청하기
				result = mController.updateMember(member);
				// 결과에 따른 메시지 출력하기
				if(result > 0) {
					printMessage("회원 정보가 수정되었습니다.");
				}else {
					printMessage("회원 정보가 수정되지 않았습니다.");
				}
				
				break;
			
			case 5 :
				// 아이디 입력받기
				memberId = inputMemberId();
				// 디비에서 정보 삭제하도록 요청하기
				result = mController.deleteMember(memberId);
				// 결과에 따른 메시지 출력하기
				if(result >0 ) {
					printMessage("회원 정보 삭제가 완료되었습니다.");
				} else {
					printMessage("회원 정보 삭제가 완료되지 않았습니다.");
				}
				break;
			
			case 0 : 
				printMessage("프로그램을 종료합니다.");
				break finish;
			default : this.printMessage("1 ~ 5 사이의 수를 입력해주세요.");;
			}
		}
	}
	
	// 아이디 검색시 아이디 입력받기
	private String inputMemberId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력해주세요: ");
		String memberId = sc.nextLine();
		return memberId;
	}
	// 학생 정보 추가시 학생정보 입력받기
	private Member addMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 회원 정보 입력 ======");
		System.out.print("아이디: ");
		String memberId = sc.next();
		System.out.print("비밀번호: ");
		String memberPwd = sc.next();
		System.out.print("이름: ");
		String memberName = sc.next();
		System.out.print("성별: ");
		char gender = sc.next().charAt(0);
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.print("이메일: ");
		String email = sc.next();
		System.out.print("전화번호: ");
		String phone = sc.next();
		System.out.print("주소: ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("취미: ");
		String hobby = sc.next();
		Member member = new Member(memberId, memberPwd, memberName, gender, age, email, phone, address, hobby);
		return member;
	}
	
	// 학생 정보 수정시 수정정보 입력받기
	private Member modifyMember(String memberId) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 비밀번호 입력 : ");
		String memberPwd = sc.next();
		System.out.print("수정할 이메일 입력 : ");
		String email = sc.next();
		System.out.print("수정할 전화번호 입력 : ");
		String phone = sc.next();
		System.out.print("수정할 주소 입력 : ");
		sc.nextLine(); // 개행 제거
		String address = sc.nextLine();
		System.out.print("수정할 취미 입력 : ");
		String hobby = sc.next();
		Member member = new Member(memberId, memberPwd, email, phone, address, hobby);
		return member;
	}
	// 학생 1개 정보 출력
	private void printOne(Member member) {
		System.out.println("====== " + member.getMemberId() +"님의 정보 출력 ======");
		System.out.println("아이디: "+ member.getMemberId());
        System.out.println("비밀번호: "+ member.getMemberPwd());
        System.out.println("이름: "+ member.getMemberName());
        System.out.println("성별: "+ member.getGender());
        System.out.println("나이: "+ member.getAge());
        System.out.println("이메일: "+ member.getEmail());
        System.out.println("연락처: "+ member.getPhone());
        System.out.println("주소: "+ member.getAddress());
        System.out.println("취미: "+ member.getHobby());
        System.out.println("가입일: "+ member.getEnrollDate());
	}
	// 학생 전체 정보 출력
	private void printAllMember(List<Member> mList) {
		System.out.println("====== 회원 전체 정보 출력 ======");
	      for(Member member: mList) {
	         System.out.println("아이디: "+ member.getMemberId());
	         System.out.println("비밀번호: "+ member.getMemberPwd());
	         System.out.println("이름: "+ member.getMemberName());
	         System.out.println("성별: "+ member.getGender());
	         System.out.println("나이: "+ member.getAge());
	         System.out.println("이메일: "+ member.getEmail());
	         System.out.println("연락처: "+ member.getPhone());
	         System.out.println("주소: "+ member.getAddress());
	         System.out.println("취미: "+ member.getHobby());
	         System.out.println("가입일: "+ member.getEnrollDate());
	      }
	}
	// 메시지 출력
	private void printMessage(String message) {
		System.out.println(message);
	}
	// 메뉴 출력
	private int printMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 회원 관리 프로그램 ======");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원 전체 조회");
		System.out.println("3. 회원 검색(아이디)");
		System.out.println("4. 회원 정보 수정");
		System.out.println("5. 회원 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		return sc.nextInt();
		
		// 1. 회원가입
		// 2. 회원 전체 조회
		// 3. 회원 검색(아이디)
		// 4. 회원 정보 수정
		// 5. 회원 정보 삭제
		// 0. 프로그램 종료
	}
}
