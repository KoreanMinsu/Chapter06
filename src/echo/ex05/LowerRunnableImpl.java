package echo.ex05;

public class LowerRunnableImpl implements Runnable{

	@Override
	public void run() {
		for(char ch='a';ch<='z';ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
