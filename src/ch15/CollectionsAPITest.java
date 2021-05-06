package ch15;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
public class CollectionsAPITest {
	private String name;
	public CollectionsAPITest(String name) {
		this.name = name;
		
	}
	
	
	public String getName() {
		return name;
	}
	public static void main(String[] args) {
		
		String [] sample = {"i", "walk", "the", "line"};
		List<String> list = Arrays.asList(sample);
		
		System.out.println("변경 전 :" +list);
		//Collections의 sort 메서드는 List 타입을 인자로 가진다.
		Collections.sort(list);
		System.out.println("변경 후 :" +list);
		//원소의 타입 클래스를 내가 변경할 수 있으면
		//Comparable 인터베이스를 구현해서 정렬 방법을 변경할 수 있다.
		//원소의 타입 클래스를 내가 변경할 수 없으면(예를 들어, String, Integer...)
		//Comparator 클래스를 구현해서 정렬 방법을 알려줘야 한다.
		//또는 원소의 타입 클래스를 변경할 수 있지만, 그 클래스를 변경하지 않고 정렬 방법을 변경하고자 할 때도
		//Comparator 클래스를 구현해 준다.
		Collections.sort(list, new MyStringComparator());
		System.out.println("내림차순 정렬 후"+ list);
		
		
	}

}
class MyStringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
				}
		
	}