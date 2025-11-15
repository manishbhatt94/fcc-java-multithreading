package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {

	public static void main(String[] args) {
		try (ExecutorService service = Executors.newSingleThreadExecutor()) {
			for (int i = 0; i < 5; i++) {
				service.execute(new Task(i));
			}
		}
	}
}

class Task implements Runnable {

	private final int taskId;

	public Task(int taskId) {
		super();
		this.taskId = taskId;
	}

	@Override
	public void run() {
		System.out.printf("Task with ID %d being executed by Thread %s.\n", taskId, Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
