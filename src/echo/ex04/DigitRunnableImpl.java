package echo.ex04;

public class DigitRunnableImpl implements Runnable {
//field

//constructors

//method-g/s

//method-generid
	@Override
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
