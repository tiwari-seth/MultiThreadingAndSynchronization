package thread;

public class DaemonThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           int i=0;
           while(true){
               System.out.println(i++);
           }
        });
        t1.setDaemon(true);
        t1.start();

//        try {
//            Thread.sleep(10); //Makes the main thread to sleep for 10 ms
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Thread currentThread = Thread.currentThread();
        try {
            currentThread.join(); //main thread joins the thread t1, although it is a Deamon threads and waits for it to get over
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
