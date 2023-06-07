package otus;

import java.util.Arrays;
public class TestLoggingImpl implements ru.otus.TestLogging {
    @ru.otus.LogTest
    @Override
    public TestLogging calculation(Object... param){
        System.out.println(Arrays.toString(param).replace("[", "").replace("]", ""));
        return null;
    }
}
