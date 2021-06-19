package echo.ex02;

public class MultithreadApp {
	public static void main(String[] args) {
		
		DigitalThread thread = new DigitalThread();
		thread.start(); // start() 내부 기동준비 이후 run() 실행
		
		for(char ch='A';ch<='Z';ch++) {
			System.out.println(ch);
		}
	}
}
