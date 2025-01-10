package CoreJava.Multithreading;

public class MyRunnable implements Runnable {

    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// runnable interface in java is used to represent a task that can be executed by a thread
