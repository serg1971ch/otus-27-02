package ru.otus;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import ru.otus.TestLogging;


public class Ioc extends ClassLoader {
    private Ioc() {
    }

    public static TestLogging createMyClass() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLoggingImpl());
        return (TestLogging) Proxy.newProxyInstance(new Ioc(),
                new Class[]{TestLogging.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLoggingImpl testLogging;

        DemoInvocationHandler(TestLoggingImpl testLogging) {
            this.testLogging = testLogging;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(testLogging, args);
        }
    }
}
