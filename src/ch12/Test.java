package ch12;

public class Test {
	public static void main(String[] args) {
		String s = "���ع��� ��λ��� ������ �⵵�� �ϴ����� �����ϻ� �츮���� ����";
//		for(int i =0; i<s.length(); i++) {
//			System.out.println(s.charAt(i));
//		}
		
		int idx = s.indexOf("��λ�");
//		System.out.println(idx);
		
		String subs = s.substring(idx, idx+"��λ�".length());
		
		System.out.println(subs);
		
		subs = s.substring(idx, s.indexOf("������"));
		System.out.println("["+subs+"]");
		
	}
}
