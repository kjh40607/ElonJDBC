package com.elon.jdbc.day01.student.view;

import java.util.List;

import com.elon.jdbc.day01.student.model.Student;

public interface ViewInterface {
	/**
	 * 메뉴 출력 메소드
	 * @return 입력받은 메뉴번호
	 */
	int printMenu();
	/**
	 * 메시지 출력 메소드
	 * @param msg 입력받은 메시지
	 */
	void displayMsg(String msg);
	/**
	 * 이름 입력 받는 메소드
	 * @return 
	 */
	String inputName();
	/**
	 * 학생 정보 입력 메소드
	 * @return 입력받은 정보가 저장된 Student객체
	 */
	Student inputStudent();
	/**
	 * 학생 전체 정보 출력 메소드
	 */
	void printStudents(List<Student> sList);
	/**
	 * 학생 1명 정보 출력 메소드
	 * @param student 출력할 Student 객체
	 */
	void printStudent(Student student);
	/**
	 * 수정할 정보 입력
	 * @param name 학생이름
	 * @return student 객체
	 */
	Student modifyStudent(String name);
}