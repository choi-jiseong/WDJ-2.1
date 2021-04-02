package ch15;
import java.util.*;

public class MyArrayList2<T> {
	private Object [] arr;
	private int capacity = 10;
	private int size = 0;
	
	public MyArrayList2() {
		arr = new Object [capacity];
	}
	
	private void increaseCapacity() {
		//������ �� ������ arr �迭�� ũ�⸦ �÷����Ѵ�.
		capacity += capacity/2;
		Object[] tmp = new Object[capacity];
		
		for(int i =0; i< size; i++) {
			tmp[i] = arr[i];
		}
		arr = tmp;
	}
	
	public void add(T value) {
		// ���� �뷮���� �߰��Ǵ� ���� ������ �� ������
		if(size >= capacity){
			increaseCapacity();
			
		}
		arr[size++] = value;
		
	}
	
	public void add(int idx, T value) {
		// �뷮�� �̹� ���������� �뷮�� 50% �ø���
		// �Ʒ� �ڵ带 �����Ѵ�.
		
		if(size == capacity) {
			//�뷮�� �ø���...
			increaseCapacity();
		}
		//�� �ڿ� �ִ� ���Һ��� ���������� �� ĭ�� �δ�.
		for(int i = size-1; i>= idx; i--) {
			arr[i+1] = arr[i];
		}
		arr[idx] = value;
		size++;
	}
	public void remove(int idx) {
		if(size >0 ) {
			for(int i = idx; i<size; i++) {
				arr[i] = arr[i+1];
			}
			size--;
		}
		
	}
	
	public int size() {
		return size;
	}
	
	public T get(int idx) {
		return (T)arr[idx];
	}
	
	@Override
	public String toString() {
		if (size == 0) return "[]";
		String result = "[";
		for(int i=0; i<size-1; i++) {
			result += arr[i] + ",";
			if((i+1)%10 == 0) result += "\n";  //10�� ��� ����
		}
		result += arr[size-1];
		result += "]";
		return result;
	}
	
	
	
	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<>();
		MyArrayList2 list = new MyArrayList2();
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		
//		for(int i=0; i< list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		
//		System.out.println(list);
//		list.add(3, 100);
//		System.out.println(list);
//		list.remove(3);
//		System.out.println(list);
		
		list.add(3, 100);  //���� index3���� ���� �ڷ� �и���.
		
		System.out.println(list);
		
		list.remove(3);
//		list.remove(Integer.valueOf(100));  
		
		System.out.println(list);
		
//		MyArrayList2<String> list2 = new MyArrayList2<>();
//		list2.add("ȫ�浿");
//		list2.add("�ƽ���");
//		
//		System.out.println(list2);
//		
//		MyArrayList2<Student> list3 = new MyArrayList2<>();
//		list3.add(new Student("ȫ�浿", 123));
//		list3.add(new Student("������", 124));
//		list3.add(new Student("�̸���", 125));
//		
//		System.out.println(list3);
	}
}
