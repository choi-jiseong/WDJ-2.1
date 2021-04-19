package ch15;
import java.util.*;

public class SetTest2 {

	public static void main(String[] args) {
//		test1();
		test2();

	}
	public static void test1() {
		/*
		  set1 = {2, 3, 4, 5, 6, 8, 9, 10}
		  set2 = {1, 3, 5, 7, 9}
		  ������ : set1.addAll(set2) = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
		  ������ : set1.retainAll(set2) = {3, 5, 9}
		  ������ = set1-set2 : set1.removeAll(set2) => {2, 4, 6, 8, 10}
		   		 set2-set1 : set2.removeAll(set1) => {1,7}
		 */
		// Generic Ŭ���� ��ü�� ������ �� Ÿ�� �Ķ���ʹ� ������Ƽ�� Ÿ���� �� �� ����. ��ü Ÿ�Ը� �� �� �ִ�.
		Set<Integer> set1 = new HashSet<>(); // HashSet, LinkedHashSet : �Է¼������ �����, TreeSet : ���� ���� ���ĵ� ������ �����
		
		// �迭�� Collection��ü�� ������ִ� �޼ҵ尡 �ִ�.
//		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10);
		List<Integer> list = Arrays.asList(10, 9, 8, 6, 5, 4, 3, 2);
		set1.addAll(list);
		
		
		//{1, 3, 5, 7, 9}
		Set<Integer> set2 = new HashSet<>();
		List<Integer> list2 = Arrays.asList(1, 3, 5, 7, 9);
		set2.addAll(list2);
		
		System.out.println("set1: " + set1);
		System.out.println("set2: " + set2);
		
		//������
		Set<Integer> unionSet = new HashSet<>(set1);
		unionSet.addAll(set2);
		// {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
		System.out.println("set1 ������ set2 : " + unionSet);
		
		//������
		Set<Integer> intersectionSet = new HashSet<>(set1);
		intersectionSet.retainAll(set2);
		//{3, 5, 9}
		System.out.println("set1 ������ set2 : " +intersectionSet );
		
		//������
		Set<Integer> diffSet = new HashSet<>(set1);
		diffSet.removeAll(set2);
		//{2, 4, 6, 8, 10}
		System.out.println("set1 - set2 : " + diffSet);
		
//		for(int i=0; i<diffSet.size(); i++) {
//		diffSet.get(i); //����
//		}
		
		
//		for(Integer val : diffSet) {
//			System.out.println(val);
//		}
//		Iterator<Integer> iter = diffSet.iterator();
		Iterator<Integer> iter = set1.iterator();
		while(iter.hasNext()) {
			Integer val = iter.next();
			System.out.println(val);
		}
		
		//������
		Set<Integer> diffSet2 = new HashSet<>(set2);
		diffSet2.removeAll(set1);
		//{1,7}
		System.out.println("set2 - set1 : " + diffSet2);
	}
	
	public static void test2() {
		List<Integer> list = Arrays.asList(10, 9, 8, 6, 5, 4, 3, 2);
//		Set<Integer> set1 = new LinkedHashSet<>();
//		Set<Integer> set1 = new  TreeSet<>();
		
		MyComparator mc = new MyComparator();
		Set<Integer> set1 = new TreeSet<>(mc);
		set1.addAll(list);
		Iterator<Integer> iter = set1.iterator();
		//�Էµ� ������� �������� Ȯ�� : LinkedHashSet
		//�Ǵ� ���� ������� �������� Ȯ�� : TreeSet
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
class MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// �տ� ���ڷ� ���޵� ���� ũ�� ���
		// ������ 0
		// �ڿ� ���ڷ� ���޵� ���� ũ�� ����
		return o2 - o1;
	}

	
	
}
