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
		//수용할 수 없으면 arr 배열의 크기를 늘려야한다.
		capacity += capacity/2;
		Object[] tmp = new Object[capacity];
		
		for(int i =0; i< size; i++) {
			tmp[i] = arr[i];
		}
		arr = tmp;
	}
	
	public void add(T value) {
		// 현재 용량으로 추가되는 값을 수용할 수 있으면
		if(size >= capacity){
			increaseCapacity();
			
		}
		arr[size++] = value;
		
	}
	
	public void add(int idx, T value) {
		// 용량이 이미 꽉차있으면 용량을 50% 늘리고
		// 아래 코드를 실행한다.
		
		if(size == capacity) {
			//용량을 늘리자...
			increaseCapacity();
		}
		//맨 뒤에 있는 원소부터 오른쪽으로 한 칸씩 민다.
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
			if((i+1)%10 == 0) result += "\n";  //10개 찍고 엔터
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
		
		list.add(3, 100);  //원래 index3번의 값은 뒤로 밀린다.
		
		System.out.println(list);
		
		list.remove(3);
//		list.remove(Integer.valueOf(100));  
		
		System.out.println(list);
		
//		MyArrayList2<String> list2 = new MyArrayList2<>();
//		list2.add("홍길동");
//		list2.add("아쉽네");
//		
//		System.out.println(list2);
//		
//		MyArrayList2<Student> list3 = new MyArrayList2<>();
//		list3.add(new Student("홍길동", 123));
//		list3.add(new Student("일지매", 124));
//		list3.add(new Student("이몽룡", 125));
//		
//		System.out.println(list3);
	}
}
