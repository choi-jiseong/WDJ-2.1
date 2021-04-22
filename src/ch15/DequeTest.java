package ch15;
import java.util.*;

public class DequeTest {
	public static void main(String[] args) {
		/*
		  Deque�� �������̽�
		  �� ���� ������ ���� Ŭ������
		  ArrayDeque.
		 */
		Queue<Integer> queue = new ArrayDeque<>();
		/*
		  Queue : a, b �޼ҵ� �ִٸ�
		  ArrayDeque : a, b, c, d, e �޼ҵ� ����?
		 */
		
		/*
		  1. ť�� ���� �� 10�� �ְ�
		  2. �ȿ� � ������ �� �ִ��� ����
		  3. �ϳ��� �����غ���. <=FIFO ������ �������� Ȯ��
		 */
		
		for(int i=0; i<10; i++) {
			queue.offer(i+1);
			
		}
		System.out.println(queue);
		
		// poll �޼ҵ�� �ϳ��� ���� FIFO������ ���;� �Ѵ�.
		// 1, 2, 3, ... 10
		// ť�� ���Ұ� ������ ��������
		while(!queue.isEmpty()) {
			Integer val = queue.remove(); // queue�� ����� 1�� ����, ���Ұ� FIFO������ �پ��
			System.out.println(val);
		}
		System.out.println("ť�� ����...");
		System.out.println(queue);
	}
}
