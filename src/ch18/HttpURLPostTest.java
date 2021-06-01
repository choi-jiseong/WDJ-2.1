package ch18;
import java.io.*;
import java.net.*;

public class HttpURLPostTest {

	public static void main(String[] args) throws Exception {
		String site = "http://localhost:8000/test";
		URL url = new URL(site);
		
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("content-type", "application/x-www-form-urlencoded");
		
		//id=scpark & pw=1111
		
		OutputStream stream = con.getOutputStream();
		
		OutputStreamWriter owriter = new OutputStreamWriter(stream, "UTF-8");
		
		PrintWriter writer = new PrintWriter(owriter);
		writer.println("id=scpark&pw=1111");
		
	}

}
