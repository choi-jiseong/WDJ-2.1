package ch18;

import java.io.*;
import java.net.*;

public class HttpURLTest {

	public static void main(String[] args) throws Exception {
		URL url = new URL("https://www.google.com/search?g=java");
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String line = "";
		while ((line = reader.readLine()) != null){
			System.out.println(line);
		}
		
	}

}
