package ch18;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Host2InetAddr {

	public static void main(String[] args) {
		String hostName = "www.naver.com";
		
		InetAddress address;
		try {
			address = InetAddress.getByName(hostName);
			System.out.println("IP аж╪р : " + address.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
