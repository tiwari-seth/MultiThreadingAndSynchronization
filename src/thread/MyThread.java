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
        MyThreadOverload thread = new MyThreadOverload();
        thread.start();
        int i=0;
        while(true){
            System.out.println(i+"Main Thread");
            i++;
        }
    }
}
