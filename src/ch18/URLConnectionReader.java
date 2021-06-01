package ch18;

import java.io.*;
import java.net.URL;
import java.net.*;

public class URLConnectionReader {

	public static void main(String[] args) {
		BufferedReader  reader = null;
		
		try {
			// 1. URL ��ü
			URL site = new URL("https://www.naver.com/");
			//2. URL ��ü�κ��� �� ����Ʈ�� ������ �õ��Ѵ�. openConnection();
			URLConnection url = site.openConnection();
			reader = new BufferedReader(new InputStreamReader(url.getInputStream()));
			
			String line = "";
			while ((line = reader.readLine()) != null){
				System.out.println(line);
			}
			System.out.println();
			reader.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {reader.close();} catch(Exception ignore) {}
		}
	}

}
