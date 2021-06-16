package aa.spring.task.a_threadPoolTaskExecutor;

public class MessagePrinterTask implements Runnable {

	private String message;

	public MessagePrinterTask(String message) {
		this.message = message;
	}

	public void run() {
		System.out.println(message);
	}
}