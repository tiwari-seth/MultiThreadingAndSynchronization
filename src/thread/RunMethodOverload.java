package thread;

class MyThreadOverload extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Main run method");
        }

    }
    public void run(int k) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Overloaded run method"+k);
        }
    }
}
public class RunMethodOverload {
    public static void main(String[] args) {
        MyThreadOverload t = new MyThreadOverload();
        t.start();
        t.run(5);
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside main threads");
        }
    }
}
