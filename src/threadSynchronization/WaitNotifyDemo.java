package threadSynchronization;

public class WaitNotifyDemo {

	private static final Object LOCK = new Object();

	public static void main(String[] args) {
		Thread threadOne = new Thread(() -> {
			try {
				one();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread threadTwo = new Thread(() -> {
			try {
				two();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		threadOne.start();
		threadTwo.start();
	}

	private static void one() throws InterruptedException {
		synchronized (LOCK) {
			System.out.println("Hello from method one ...");
			LOCK.wait();
			System.out.println("Back again in method one!");
		}
	}

	private static void two() throws InterruptedException {
		synchronized (LOCK) {
			System.out.println("Hello from method two ...");
			LOCK.notify();
			System.out.println("Hello from method two - even after notifying ...");
		}
	}
}
