package ch15;
import java.util.*;

public class DequeTest {
	public static void main(String[] args) {
		/*
		  Deque는 인터페이스
		  이 놈을 구현한 구현 클래스는
		  ArrayDeque.
		 */
		Queue<Integer> queue = new ArrayDeque<>();
		/*
		  Queue : a, b 메소드 있다면
		  ArrayDeque : a, b, c, d, e 메소드 가능?
		 */
		
		/*
		  1. 큐에 임의 수 10개 넣고
		  2. 안에 어떤 순서로 들어가 있는지 보고
		  3. 하나씩 인출해보자. <=FIFO 순으로 나오는지 확인
		 */
		
		for(int i=0; i<10; i++) {
			queue.offer(i+1);
			
		}
		System.out.println(queue);
		
		// poll 메소드로 하나씩 인출 FIFO순으로 나와야 한다.
		// 1, 2, 3, ... 10
		// 큐에 원소가 있으면 인출하자
		while(!queue.isEmpty()) {
			Integer val = queue.remove(); // queue의 사이즈가 1씩 감소, 원소가 FIFO순으로 줄어듬
			System.out.println(val);
		}
		System.out.println("큐의 상태...");
		System.out.println(queue);
	}
}
