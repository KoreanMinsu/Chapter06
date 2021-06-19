package echo.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.113", 10001));
		
		System.out.println("<Initiate the server>");
		System.out.println("=====================");
		System.out.println("[Waiting for connection]");
		
		Socket socket = serverSocket.accept();
		System.out.println("[The client has been connected]");
		
		//메세지 받기 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//메세지 보내기 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		
		while(true) {
			
			//메세지 받기
			String msg = br.readLine();
			System.out.println("Received : "+msg);
			
			if(msg == null) { //msg 주소 없을시(받는 게 없을시)
				System.out.println("[Terminating for client connection]");
				break;
			}
			
			//메세지 보내기
			bw.write(msg); // 쓰기
			bw.newLine(); // 즐바꿈
			bw.flush(); // 남은 버퍼 버리기
		}
		
		System.out.println("=====================================");
		System.out.println("<Server closed.>");
		socket.close();
		serverSocket.close();

	}
}
