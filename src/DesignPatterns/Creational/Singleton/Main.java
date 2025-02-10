package DesignPatterns.Creational.Singleton;

import DesignPatterns.Creational.Builder.UserExam;

public class Main {
    // singleton pattern is a creational pattern that ensures that a class has only one instance and provides a global point of access to that instance
    // singleton pattern is used for logging, driver objects, caching, thread pool, database connections
    // singleton pattern is used in a scenario when there is a need to limit the number of instances that can be created
    // reflection can be used to destroy the singleton pattern
    // serialization can be used to destroy the singleton pattern
    // singletonenum is the best way to create a singleton class
    // singletonenum is thread safe and it is guaranteed that only one instance of the singleton class is created
    public static void main(String[] args) throws InterruptedException {
//        Singleton singleton = Singleton.getInstance();
//        Singleton singleton2 = Singleton.getInstance();
//        System.out.println(singleton == singleton2);


        Runnable r = () -> {
            SingletonClass singletonInstance = SingletonClass.getInstance();
            System.out.println(singletonInstance);
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();


        // user Exam Builder
        UserExam UserExam = DesignPatterns.Creational.Builder.UserExam.getBuilder()
                .setId(1)
                .setName("Naman")
                .setAge(20)
                .setEnglishMarks(50).setMathsMarks(50)
                .setScienceMarks(50)
                .build();

        // singleton enum
        SingletonEnum instance1 = SingletonEnum.INSTANCE;
        SingletonEnum instance2 = SingletonEnum.INSTANCE;
        System.out.println(instance2==instance1);
        instance2.displayMessage();
    }
}

// to prevent