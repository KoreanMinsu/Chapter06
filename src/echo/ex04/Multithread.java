package echo.ex04;

public class Multithread {
	public static void main(String[] args) {
		Thread thread01 = new Thread(new DigitRunnableImpl());

		thread01.start();

		for ( char ch = 'A'; ch <= 'Z'; ch++ ) {
			System.out.println(ch);
			try {
				Thread.sleep(350);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}