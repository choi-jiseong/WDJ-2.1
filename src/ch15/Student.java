package ch15;

public class Student {
	private String name;
	private String dept;
	private int grade;
	public Student() {
		this.name = name;
		this.dept = dept;
		this.grade = grade;
	}
	public Student(String name, int std) {
		this.name = name;
		this.grade = std;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "["+ this.getName() + " : " + this.getGrade() + "]";
	}
	
}
