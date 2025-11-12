package basicMultithreading;

public class ThreadPriorityExample {

	public static void main(String[] args) {
		printThreadInfo();

		Thread one = new Thread(() -> {
			printThreadInfo();
		});

		one.setName("Thread-One");
		one.setPriority(Thread.MAX_PRIORITY);
		one.start();
	}

	private static void printThreadInfo() {
		System.out.printf("Thread (%s) with priority (%d) says Hi!\n", Thread.currentThread().getName(),
				Thread.currentThread().getPriority());
	}
}
