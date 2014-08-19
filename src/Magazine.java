public class Magazine implements Updatable {

	public void requestNews() {
		// create and start thread to get last news
		NewsProvider newsThread = new NewsProvider(this);
		newsThread.start();

		// wait for notify from news thread
		synchronized (this) {
			try {
				wait();
			} catch (InterruptedException ie) {
				System.out.println("InterruptedException occurs. Message: " + ie.getMessage());
			}
		}
	}

	public void setData(String news) {
		System.out.println(news);
	}
}
