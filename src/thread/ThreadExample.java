package thread;

public class ThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
         int i=0;
         while(true){
             System.out.println(i+"Thread1");
             i++;
             try{
                 Thread.sleep(20);
             }
             catch (Exception e){
                 e.printStackTrace();
             }
         }
        }, "My Thread 1");
        Thread t2 = new Thread(() -> {
            int i=0;
            while(true){
                System.out.println(i+"Thread2");
                i++;
            }
        });
        Thread t3 = new Thread("My Thread 3");
//        t1.start();
//        t2.start();

        System.out.println("Thread Name -> "+t3.getName());
        System.out.println("Id ->"+t3.getId());
        t3.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Priority ->"+t3.getPriority());
        t3.start();
        System.out.println("State ->"+t3.getState());
        System.out.println("IsAlive ->"+t3.isAlive());

        t1.start();
        t1.interrupt();
    }
}
