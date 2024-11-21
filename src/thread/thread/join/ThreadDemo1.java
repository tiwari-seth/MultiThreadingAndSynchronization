package thread.thread.join;

public class ThreadDemo1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        //main thread calls join on t1, so main thread waits for child thread t1 to complete its execution.
        t1.join();
        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread");
        }
    }
}
