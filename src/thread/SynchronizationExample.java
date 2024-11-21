package thread;

class Apple{
    synchronized public void print(String s){
        for (char ch:s.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Thread1 extends Thread{
    Apple apple;
    Thread1(Apple apple){
        this.apple=apple;
    }
    @Override
    public void run(){
        apple.print("Thread1 Apple");
    }
}
class Thread2 extends Thread{
    Apple apple;
    Thread2(Apple apple){
        this.apple=apple;
    }
    @Override
    public void run(){
        apple.print("Thread2 Apple");
    }
}
public class SynchronizationExample {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Thread1 t1  = new Thread1(apple);
        Thread2 t2  = new Thread2(apple);
        t1.start();
        t2.start();
    }
}
