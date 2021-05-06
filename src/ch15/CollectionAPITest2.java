package ch15;
import java.util.*;

public class CollectionAPITest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		shuffleTest();
		binarySearchTest(); // 이진탐색
	}
	
	public static void binarySearchTest() {
		//1. 무작위 정수를 저장한 리스트에 대해 이진탐색 <= 잘못된 결과가 나오는 경우.
		//2. 정렬된 리스트에 대해 이진탐색 <= 이렇게 사용해야 함.
		
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<20; i++) {
			list.add(random.nextInt(100)+1);
		}
		Collections.sort(list);
		System.out.println(list);
		int idx = Collections.binarySearch(list, 73);
		if(idx >=0) {
			System.out.println((idx+1) + "번쨰에 있습니다.");
		}else {
			System.out.println("찾고자 하는 값은 리스트에 없습니다.");
			System.out.println(idx);
		}
			
	}
	
	public static void shuffleTest() {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<10; i++) {
			list.add((i+1)*2);
		}
		
		ArrayList<Student2> list2 = new ArrayList<>();
		for(int i=0; i<10; i++) {
			Student2 std = new Student2();
			std.grade = (i+1)*100;
			list2.add(std);
		}
		System.out.println("섞기 전");
		System.out.println(list2);
		
		Collections.shuffle(list2);
		System.out.println("섞기 후");
		System.out.println(list2);
	}

}

class Student2{
	int grade;
	public String toString() {
		return String.valueOf(grade);
	}
}
