package echo.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket();
		
		System.out.println("<Initiating the client>");
		System.out.println("=======================");
		
		System.out.println("[Requesting to connect to server]");
		socket.connect(new InetSocketAddress("192.168.0.113", 10001));
		
		System.out.println("Connected to the server]");
		
		//메세지 보내기 스트림
		// ex01 OutputStream out = new FileOutputStream("file address"); 배운거
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//메세지 받기 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//스캐너
		Scanner sc = new Scanner(System.in);
		
		//스캐너 스트림 - 스트림 원리 알아보기위한
		/*InputStream in = System.in;
		InputStreamReader sisr = new InputStreamReader(in);
		BufferedReader sbr = new BufferedReader(sisr);
		*/
		
		while(true) {
			//메세지 보내기
			//Keyboard input
			String str = sc.nextLine(); //new String("안녕");
			
		//	String str = sbr.readLine();
			if("/q".equals(str)) { //NullpointException 해결위해서 - 아니면 try-catch 사용
				System.out.println("[The connection has been terminated]");
				break;
			}
			//보내기
			bw.write(str);
			bw.newLine();
			bw.flush();
			
			//메세지 받기
			String reMsg = br.readLine();
			System.out.println("Server : [" + reMsg+ "]");
			}
		
		System.out.println("=====================================");
	//printLn() 스트림
		/*OutputStream out = System.out;
		OutputStreamWriter sosw = new OutputStreamWriter(out);
		BufferedWriter sbw = new BufferedWriter(sosw);
		
		sbw.write("클라이언트종료");
		sbw.newLine();
		sbw.flush();
		*/
		
		System.out.println("<Client closed.>");
		
		//sc.close();
		//sbr.close();
		socket.close();
	}
}
