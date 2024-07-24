package thread;

public class MyThread extends Thread{
    @Override
    public void run() {
        int i=0;
        while(true){
            System.out.println(i+"MyThread");
            i++;
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        int i=0;
        while(true){
            System.out.println(i+"Main Thread");
            i++;
        }
    }
}
