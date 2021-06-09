package ch18;
import java.net.*;

import com.google.gson.Gson;

import java.io.*;
import java.sql.*;

public class PostJson {
	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();
		
		String site = "https://jsonplaceholder.typicode.com/posts";
		URL url = new URL(site);
		
		URLConnection con = url.openConnection();
		
		InputStream stream = con.getInputStream();
		
		InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
		
		BufferedReader bufReader = new BufferedReader(reader);
		
		String line = null;
		String jsonString = "";
		while ((line = bufReader.readLine()) != null) {
//			System.out.println(line);
			jsonString += line;
		}
//		System.out.println(jsonString);
		
//		String json = "[{\"userId\" : 1, \"id\" : 1, \"title\" : \"test\", \"body\" : \"boo\" }]"; 
		Post[] posts = gson.fromJson(jsonString, Post[].class);
		/*
		 * Post post = new Post();
		 * post.setUserId(1);
		 * post.setId(1);
		 * post.setTitle("title");
		 * post.setBody("body");
		 */
		
		
//		System.out.println("userid = " + posts[0].getUserId());
//		System.out.println("id = " + posts[0].getId());
//		System.out.println("title= " + posts[0].getTitle());
//		System.out.println("body = " + posts[0].getBody());
		
		for(Post post : posts) {
			System.out.println("userid = " + post.getUserId());
			System.out.println("id = " + post.getId());
			System.out.println("title= " + post.getTitle());
			System.out.println("body = " + post.getBody());
			System.out.println("***********************");
		}
		
		insertIntoDB(posts);
			
		
	}
	private static void insertIntoDB (Post[] posts) throws Exception {
		/*
		 * ---------------------------한번만 해주면된다-------------------
		 * 1. Class.forName(...); // JDBC 드라이버 메모리에 적재
		 * 2. Connection con = DriverManager.getConnection(...); DB 서버에 연결
		 * 3. String sql = "insert into posts(userId, id, title, body) values (?, ?, ?, ?);
		 * 		con.prepareStatement(sql);
		 * ----------------------------------------------------------
		 * 4. ? 자리에 들어갈 값을 설정한다.
		 * 		pstmt.setInt(1, post.getUserId());
		 * 		pstmt.setInt(2, post.getId());
		 * 		pstmt.setString(3, post.getTitle());
		 * 		pstmt.setString(4, post.getBody());
		 * 5. 서버에 실행요청
		 * 		pstmt.executeUpdate();
		 * 6. con.close();
		 */
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "root", "cjseong98");
		String sql = "insert into posts(userId, id, title, body) values(?, ?, ?, ?);";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		for(Post post : posts) {
			pstmt.setInt(1, post.getUserId());
			pstmt.setInt(2, post.getId());
			pstmt.setString(3, post.getTitle());
			pstmt.setString(4, post.getBody());
			pstmt.executeUpdate();
			
		}
		con.close();
		
	}
}
 