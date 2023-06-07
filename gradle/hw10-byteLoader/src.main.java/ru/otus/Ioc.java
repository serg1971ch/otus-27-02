package otus;

import ru.otus.TestLogging;
import ru.otus.TestLoggingImpl;

import java.lang.reflect.*;


public class Ioc {
    private Ioc() {
    }

    public static ru.otus.TestLogging createMyClass() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLoggingImpl());
        return (ru.otus.TestLogging) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class[]{ru.otus.TestLogging.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLogging testLogging;

        DemoInvocationHandler(TestLogging testLogging) {
            this.testLogging = testLogging;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(testLogging, args);
        }
    }
}
