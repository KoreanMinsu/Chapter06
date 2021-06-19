package echo.ex05;

public class DigitRunnableImpl implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i <= 9; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
