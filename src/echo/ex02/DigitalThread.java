package echo.ex02;

public class DigitalThread extends Thread {

	@Override
	public void run() {
		for(int i=0;i<=9;i++) { //우리 로직 코드 반드시 run()에 작성해야함 - thread 문법 
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
