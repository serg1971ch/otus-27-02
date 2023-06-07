package otus;

import ru.otus.TestLoggingImpl;

public class Demo {
    public void action() {
        new TestLoggingImpl().calculation(6);
    }

    public static void main(String[] args) {
        new Demo().action();
    }
}

