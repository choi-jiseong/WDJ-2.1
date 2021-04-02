package ch15;

public class GenericTest {
	public static void main(String[] args) {
		GenericBox<String> box1 = new GenericBox<>();
		box1.setContent("동해물과");
		String s = box1.getContent();
		System.out.println(s);
		
		GenericBox<Integer> box2 = new GenericBox<>();
		box2.setContent(100);
		int n = box2.getContent();
		System.out.println(n);
		
		GenericBox<Student> box3 = new GenericBox<>();
		box3.setContent(new Student());
		Student std = box3.getContent();
		std.setName("홍길동");
		std.setDept("컴정");
		std.setGrade(3);
		System.out.println(std.getName() + ":" + std.getDept() + ":" + std.getGrade());
	}
}
