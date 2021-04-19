package ch15;
import java.util.*;

public class PQTest {
	public static void main(String[] args) {
//		test1();
//		test2();
		MyQueue queue = new MyQueue();
		queue.offer(new Task("�۾�1", 3));
		queue.offer(new Task("�۾�2", 2));
		queue.offer(new Task("�۾�3", 5));
		queue.offer(new Task("�۾�4", 1));
		queue.offer(new Task("�۾�5", 4));
		
		//�۾�4, �۾�2, �۾�1, �۾�5, �۾�3
		for (int i=0; i<5; i++) System.out.println(queue.poll());
	}
	public static void test1() {
		Queue<String> q = new PriorityQueue<>(); //�켱����
		q.offer("PinApple");  //q.add();
		q.offer("Banana");
		q.offer("Carrot");
		q.offer("Cherry");
		q.offer("Strawberry");
		
		//������. ������ �ƴ�
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
		  �켱����ť ��ü�� �����ϰ�
		  Task �ν��Ͻ��� ����, ���� �غ���.
		 */
		
		//�⺻������ ������������ ����ȴ�.
//		Queue<Task> queue = new PriorityQueue<>();
		Queue<Task> queue = new PriorityQueue<>(new TaskComparator());
		queue.offer(new Task("�۾�1", 3));
		queue.offer(new Task("�۾�2", 2));
		queue.offer(new Task("�۾�3", 5));
		queue.offer(new Task("�۾�4", 1));
		queue.offer(new Task("�۾�5", 4));
		
		
		while(!queue.isEmpty()) {
			Task task = queue.poll();
			
			System.out.println(task);
		}
		System.out.println(queue);
	}
}

//Task �ν��Ͻ��� �񱳰����� ��ü�� �����ϱ� ���� Comparable �������̽��� ����
class Task implements Comparable<Task>{ 
	String desc; // ����
	int priority = 5; //�� �۾��� �켱����
	
	public Task(String desc, int priority) {
		this.desc = desc;
		this.priority = priority;
	}

	@Override
	public int compareTo(Task o) {
		// �� ��ü�� ���� ũ�� ���, ������ 0, ������ ������ ��ȯ
//		return o.priority - this.priority; //��������
		return this.priority - o.priority; //��������
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
		//���ο� ��ü�� ���� ������ �������ķ� sorting�Ѵ�.
		for(int i=idx-1; i>=0; i--) {
			int max = i; // ���� ������ ���Ұ� �ִ밪�̶� ����
			for(int j=0; j<i; j++) {
				if(tasks[j].compareTo(tasks[max]) > 0) {
					max = j;
				}
			}
			// max, i�� swap
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
