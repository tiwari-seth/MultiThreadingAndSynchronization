package thread;

public class YeildExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            int i=0;
            while(true){
                System.out.println(i++ + "MyThread");
            }
        });

        t1.start();
        int i=0;
        while(true){
            System.out.println(i++ + "Main Thread");
            Thread.yield();//this will give more time for thread 1 to run
        }
    }
}
