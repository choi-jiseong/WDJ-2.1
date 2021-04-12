package ch15;
import java.util.*;

public class ListTest {
	public static void main(String[] args) {
		test1();
	}
	public static void test1() {
		List<String> list = new ArrayList<>();
		String[] sArr = {"�ڵ���", "���", "��ġ��", "�б�", "��äȯ"};
		for (String s : sArr) list.add(s);
		
		System.out.println(list); //ArrayList�� toString() �޼ҵ尡 �̿��
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		for(String s : list) System.out.print(s + " ");
		System.out.println();
		
		Iterator<String> iter = list.iterator();
		//unchecked exception�� ���״�
		//�̷� deception ��ü�� �߻����� �ʰ� �ڵ��ض�..
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		//overloading�� add �޼ҵ�� ���Ҹ� �߰��� ������ �� �ִ�.
		list.add(1, "����");
		
		iter = list.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
//		list.remove(list.size()-1); //������ ���� ���� �ϰ�ʹ�. ���Ҽ� -1
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
