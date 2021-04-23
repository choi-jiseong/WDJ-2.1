package ch15;
import java.util.*;

public class StackTest3 {
	public static void main(String[] args) {
		/*
		  ( 스택 넣고
		  ) 만나면 pop 해서 스택에서 빼고
		  주어신 식을 다 처리했을 때, 스택이 empty가 된다.
		  만약에 empty가 아니면 잘못된 식이다.
		  ((()) => 처리 후에 스택이 empty가 아니게 되고
	      ()) => pop했을 때 인출되는 원소가 있어야 되는데, 없는
		  경우이고 이 경우도, 잘못된 식이다.
		  2*(3+2)/(3+1)/2*5-1+10
		 */
		/*
		  1. 먼저 수식을 입력받자. 
		 */
		Scanner input = new Scanner(System.in); //콘솔 입력을 위한 Scanner 객체 생성
		System.out.println("수식을 입력하세요.");
		String exp = input.nextLine();
		
		//2. 입력받은 수식을 공백을 기준으로 문자열 토큰으로 분리하자.
		// exp 문자열 변수에 값을 공백을 기준으로 문자열 토큰들로 분리.
		StringTokenizer st = new StringTokenizer(exp); 
		
		//3. 토큰을 하나씩 뜯어 보면서 여는 괄호이면 스택에 push, 닫는 괄호이면 스택에서 pop
		
		Stack<String> stack = new Stack<>();

		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			//token이 여는 괄호이면 stack에 push
			if(token.equals("(")) stack.push("(");
			//token이 닫는 괄호이면 stack에 여는 괄호가 있으면 pop
			else if (token.equals(")")) {
				//근데 stack에 원소가 하나도 없다면...
				//이거는 닫는 괄호에 매칭되는 여는 괄호가 없다는 의미이니까.
				//이거는 잘못된 식이다
				if(stack.isEmpty()) {
					System.out.println("잘못된 식입니다...");
					return;
				}
				stack.pop();
			}
		}
		
		//모든 토큰 처리가 끝났고, 그 때까지 잘못된 괄호가 발견되지 않았다.
		if(stack.isEmpty() != true) {
			System.out.println("잘못된 식입니다.");
			return;
			
		}
		System.out.println("정확한 식입니다.");	
		
	}
}
