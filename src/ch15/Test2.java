package ch15;
import java.util.*;
public class Test2 {

	public static void main(String[] args) {
//		String[] arr1 = {"����", "�ٴ�", "��"};
//		arr1[3] = "�ź���";  //����
		
		ArrayList<String> strList = new ArrayList<>();
		
		for(int i = 0; i<200; i++) {
//			strList.add(String.valueOf(i));
			strList.add("" + i);
		}
		
		for(int i =0; i< strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		
		ArrayList<Student> stdList = new ArrayList<>();
		for(int i=0; i<100; i++) {
			stdList.add(new Student());
		}

	}

}
