package ch15;
import java.util.*;

public class ListTest {
	public static void main(String[] args) {
		test1();
	}
	public static void test1() {
		List<String> list = new ArrayList<>();
		String[] sArr = {"자동차", "운동장", "유치원", "학교", "임채환"};
		for (String s : sArr) list.add(s);
		
		System.out.println(list); //ArrayList의 toString() 메소드가 이용됨
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		for(String s : list) System.out.print(s + " ");
		System.out.println();
		
		Iterator<String> iter = list.iterator();
		//unchecked exception은 버그다
		//이런 deception 자체가 발생하지 않게 코딩해라..
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		//overloading된 add 메소드로 원소를 중간에 삽입할 수 있다.
		list.add(1, "벚꽃");
		
		iter = list.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
//		list.remove(list.size()-1); //마지막 원소 삭제 하고싶다. 원소수 -1
//		while (list.size() > 0) {
//			list.remove(0);
//		}
		
		list.remove(3);
		iter = list.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		
	}
}
