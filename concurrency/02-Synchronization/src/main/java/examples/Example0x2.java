package examples;

/**
 * @date 2018.7.3
 */
public class Example0x2 {

	public static void main(String[] args) {
		Counter counter = new SyncCounter();
		Thread t1 = new Thread(new IncrementThread(counter));
		Thread t2 = new Thread(new DecrementThread(counter));
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.format("Counter: %s%n", counter.value());
	}

}

