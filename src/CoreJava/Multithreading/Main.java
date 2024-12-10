package CoreJava.Multithreading;

public class Main {
    public static void main(String[] args) {
//        ThreadExample t1 = new ThreadExample();
//        ThreadExample t2 = new ThreadExample();
//        t1.start();
//        t2.start();
//        MyRunnable myRunnable = new MyRunnable();
//        Thread t1 = new Thread(myRunnable);
//        Thread t2 = new Thread(myRunnable);
//        t1.start();
//        t2.start();

        Runnable printThredName = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("count :" + i + " \t" + Thread.currentThread().getName());
            }
        };
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(printThredName);
            t.start();
        }
    }
}
