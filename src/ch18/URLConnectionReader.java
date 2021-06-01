package ch18;

import java.io.*;
import java.net.URL;
import java.net.*;

public class URLConnectionReader {

	public static void main(String[] args) {
		BufferedReader  reader = null;
		
		try {
			// 1. URL 객체
			URL site = new URL("https://www.naver.com/");
			//2. URL 객체로부터 저 사이트로 연결을 시도한다. openConnection();
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
