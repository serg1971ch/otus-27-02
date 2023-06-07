package ru.otus;


public class Demo {
    public void action() {
//        TestLogging testLogging = Ioc.createMyClass();
//        testLogging.calculation(6);
        new TestLoggingImpl().calculation(6);
    }

    public static void main(String[] args) {
        new Demo().action();
    }
}

