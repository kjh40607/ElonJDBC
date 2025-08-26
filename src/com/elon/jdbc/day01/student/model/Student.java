package com.elon.jdbc.day01.student.model;
public class Student {
	// 필드
	private String name;
	private int firstScore;
	private int secondScore;
	
	// 생성자
	public Student() {}
	
	public Student(String name, int firstScore, int secondScore) {
		this.name = name;
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}
	// 메소드
	// setter/getter
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setFirstScore(int firstScore) {
		this.firstScore = firstScore;
	}
	public int getFirstScore() {
		return firstScore;
	}
	
	public void setSecondScore(int secondScore) {
		this.secondScore = secondScore;
	}
	public int getSecondScore() {
		return secondScore;
	}
	@Override
	public String toString() {
		return "이름 : " + name
				+ ", 1차점수 : " + firstScore
				+ ", 2차점수 : " + secondScore;
	}
}