package ch15;
import java.util.*;

public class PQTest {
	public static void main(String[] args) {
//		test1();
//		test2();
		MyQueue queue = new MyQueue();
		queue.offer(new Task("작업1", 3));
		queue.offer(new Task("작업2", 2));
		queue.offer(new Task("작업3", 5));
		queue.offer(new Task("작업4", 1));
		queue.offer(new Task("작업5", 4));
		
		//작업4, 작업2, 작업1, 작업5, 작업3
		for (int i=0; i<5; i++) System.out.println(queue.poll());
	}
	public static void test1() {
		Queue<String> q = new PriorityQueue<>(); //우선순위
		q.offer("PinApple");  //q.add();
		q.offer("Banana");
		q.offer("Carrot");
		q.offer("Cherry");
		q.offer("Strawberry");
		
		//엿보기. 인출은 아님
		System.out.println(q.peek());  //q.element();
		System.out.println(q.peek());
		System.out.println(q.peek());
		
		System.out.println(q);
		
		while(q.size() >0 ) {
			System.out.println(q.remove());
		}
		System.out.println(q);
	} 
	public static void test2() {
		/*
		  우선순위큐 객체를 생성하고
		  Task 인스턴스를 삽입, 인출 해보자.
		 */
		
		//기본적으로 오름차순으로 인출된다.
//		Queue<Task> queue = new PriorityQueue<>();
		Queue<Task> queue = new PriorityQueue<>(new TaskComparator());
		queue.offer(new Task("작업1", 3));
		queue.offer(new Task("작업2", 2));
		queue.offer(new Task("작업3", 5));
		queue.offer(new Task("작업4", 1));
		queue.offer(new Task("작업5", 4));
		
		
		while(!queue.isEmpty()) {
			Task task = queue.poll();
			
			System.out.println(task);
		}
		System.out.println(queue);
	}
}

//Task 인스턴스를 비교가능한 객체로 생성하기 위해 Comparable 인터페이스를 구현
class Task implements Comparable<Task>{ 
	String desc; // 설명
	int priority = 5; //이 작업의 우선순위
	
	public Task(String desc, int priority) {
		this.desc = desc;
		this.priority = priority;
	}

	@Override
	public int compareTo(Task o) {
		// 이 객체의 값이 크면 양수, 같으면 0, 작으면 음수를 반환
//		return o.priority - this.priority; //내림차순
		return this.priority - o.priority; //오름차순
	}
	
	@Override
	public String toString() {
		return "[desc:"+desc+", priority:"+ priority+"]";
		
	}

	
}
class MyQueue {
	Task[] tasks = new Task[10];
	int idx = 0;
	int pidx = 0;
	
	public void offer(Task value) {
		tasks[idx++] = value;
		//새로운 객체가 들어올 떄마다 선택정렬로 sorting한다.
		for(int i=idx-1; i>=0; i--) {
			int max = i; // 제일 마지막 원소가 최대값이라 가정
			for(int j=0; j<i; j++) {
				if(tasks[j].compareTo(tasks[max]) > 0) {
					max = j;
				}
			}
			// max, i를 swap
			Task tmp = tasks[max];
			tasks[max] = tasks[i];
			tasks[i] = tmp;
		}
		
	}
	
	public Task poll() {
		return tasks[pidx++];
	}
}

class TaskComparator implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		// TODO Auto-generated method stub
		return o2.priority - o1.priority;
	}
	
}
