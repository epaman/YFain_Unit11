public class NewsProvider extends Thread {
	Updatable caller = null;

	public NewsProvider(Updatable caller) {
		this.caller = caller;
	}

	public void run() {
		caller.setData("The latest news: Dollar price is rising!");

		synchronized (caller) {
			caller.notify();
		}
	}
}
