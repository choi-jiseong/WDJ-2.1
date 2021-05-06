package ch15;

import java.util.*;
import java.util.stream.IntStream;

public class CollectionTest {
	
	public static void main(String[] args) {
//		test2();
//		test3();
//		setTest1();
//		lotto();
		test1();
		
	}
	class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
//	public static void lotto() {
////		Set<Integer> lottoNums = new HashSet<>();
////		Set<Integer> lottoNums = new TreeSet<>();
////		Set<Integer> lottoNums = new LinkedHashSet<>();
//		MyComparator comp = new MyComparator();
//		Set<Integer> lottoNums = new TreeSet<>(comp);
//		while(lottoNums.size() != 6) {
//			int num = (int)(Math.random()*45 +1);
//			if(lottoNums.add(num)) {
//				System.out.print(num + ", ");
//			}
////			lottoNums.add((int)(Math.random()*45+1));
//		}
//		System.out.println();
//		//lottoNums�� ���� ���� 6�� �� �� ����
//		// 1~45������ ������ ���� ������ lottoNums�� ����
//
//		System.out.println(lottoNums);
//		
//		Iterator<Integer> iter = lottoNums.iterator();
//		while(iter.hasNext()) {
//			System.out.print(iter.next() + " ");
//		}
//		System.out.println();
//	}
	
	public static void setTest1() {
		Set<String> set = new HashSet<>();
		String[] strArr = {"�ܾ�", "�ߺ�", "����", "�ߺ�"};
		for(String s : strArr) {
			if(set.add(s) == false) {
				System.out.println(s+"���� �̹� ����!!!");
			}
			set.add(s);
		}
		System.out.println(set);
	}
	
	public static void test3() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Milk");
		list.add("BREAD");
		list.add("BUTTER");
		System.out.println(list);
		list.add(1, "APPLE");
		System.out.println("APPLE�� 1�� �ε����� �߰��� ��: " + list);
		list.set(2, "GRAPE");
		System.out.println("2�� �ε����� ���Ҹ� GRAPE�� ������ ��: " + list);
		list.remove(3);
		System.out.println("3�� �ε����� ���Ҹ� ������ ��: " + list);
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		iter = list.iterator();
		iter.next();
		System.out.println("��...");
	}
	
	public static void test2() {
//		List<Integer> list = new ArrayList<>();
		List<Integer> list = new LinkedList<>();
//		for(int i=0; i<100000; i++) {
//			list.add(i+1);
//		}
		
		IntStream.rangeClosed(1, 100000).forEach(i -> list.add(i));
		
		long start =System.currentTimeMillis();
//		for(int i=0; i<100; i++) {
//			list.add(30, 1000);
//		}
		for(int i=0; i<list.size(); i++) {
			list.get(i);
		}
		long end = System.currentTimeMillis();
		
		System.out.println((end - start) + "ms Elapsed..");
	}
	
	public static void test1() {
		/*
	    List : ������ �ְ� �ߺ� ���Ǵ� �ڷᱸ��
	 */
	List<Integer> list1 = new ArrayList<>();
	List<String> list2 = new LinkedList<>();
	List<Double> list3 = new Vector<>();
	List<Integer> list4 = new Stack<>();
	
	for(int i=0; i<10; i++) {
		list1.add(i+1);
		list2.add(String.valueOf(i+1));
		list3.add((i+1)*1.0);
		list4.add(10-i);
	}
	System.out.println(list1);
	System.out.println(list2);
	System.out.println(list3);
	System.out.println(list4);
	
	for(int i=0; i<list1.size(); i++) {
		System.out.print(list1.get(i) + " ");
	}
	
	for(String s : list2) {
		System.out.print(s+ " ");
	}
	
	Iterator<Double> iter = list3.iterator();
	
	while(iter.hasNext()) {
		Double d = iter.next();
		System.out.print(d+ " ");
	}
	}
	
}
