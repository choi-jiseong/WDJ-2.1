package ch15;
import java.util.*;
public class StackTest {
	public static void main(String[] args) {
		/*
		  Stack : LIFO(last in first out)
		  
		  Generic : Ŭ���� ���ο��� ����� ������ Ÿ���� ������ ���� 
		  �ƴϰ� �� Ŭ������ ��ü�� ������ �� ������ Ÿ���� ������ �� �ֵ���, 
		  ����� ������ Ÿ���� �Ķ���ͷ� �޾Ƽ� ��ü�� �����ϴ� ��
		  Ÿ�� �Ķ����(Type Parameter)
		 */
		
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i< 10; i++) {
			stack.push(i+1);
		}
		System.out.println(stack);
		
		while(!stack.isEmpty()) {
			Integer val = stack.pop();
			System.out.println(val);
		}
		System.out.println(stack);
		
	}
}
