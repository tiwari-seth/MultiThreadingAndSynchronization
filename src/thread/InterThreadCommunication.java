package thread;
class MyData{
    int value;

    boolean flag=true;
    synchronized public void setValue(int x){
        while(flag!=true) try{wait();} catch (Exception e){};
        this.value=x;
        flag=false;
        notify();
    }
    synchronized public int getValue(){
        while(flag!=false) try{wait();} catch (Exception e){};
        int x=value;
        flag=true;
        notify();
        return x;
    }
}
class Producer extends Thread{
    MyData data;
    Producer(MyData data){
        this.data=data;
    }
    @Override
    public void run(){
        int count=1;
        while (true){
            data.setValue(count);
            System.out.println("Producer: "+count);
            count++;
        }
    }
}
class Consumer extends Thread{
    MyData data;
    Consumer(MyData data){
        this.data=data;
    }
    @Override
    public void run(){
        while(true){
            int x = data.getValue();
            System.out.println("Consumer: "+x);
        }
    }
}
public class InterThreadCommunication {
    public static void main(String[] args) {
        MyData data = new MyData();
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);
        producer.start();
        consumer.start();
    }
}
