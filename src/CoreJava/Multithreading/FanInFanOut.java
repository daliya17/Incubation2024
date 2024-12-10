package CoreJava.Multithreading;

import java.util.ArrayList;
import java.util.List;

public class FanInFanOut {
    int i=1;
    List<Thread> threads = new ArrayList<>(4);
    public static void main(String[] args) throws InterruptedException {
       new FanInFanOut().run();
    }

    public void run() throws InterruptedException {
        while (i<=10)
            print();
        for(int j=0;j<4;j++){
            threads.add(new Thread(()->{
                synchronized(this){
                    while(i<=40)
                        print();
                }
            }));
        }
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
        while (i<=50){
            print();
        }
    }

    public synchronized void print(){
        System.out.println(Thread.currentThread().getName() + " " + i);
        i++;
    }
}
