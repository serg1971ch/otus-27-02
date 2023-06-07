package ru.otus;

import java.util.ArrayList;
import java.util.List;

public class Summator {
    private int sum = 0;
    private int  prevValue = 0;
    private int prevPrevValue = 0;
    private int sumLastThreeValues = 0;
    private int someValue = 0;
    private  Data[] listValues = new Data[100000000];

    //!!! сигнатуру метода менять нельзя
    public void calc(ru.otus.Data data) {
        listValues[listValues.length-100000000]=data;
        if (listValues.length % 6_600_000 == 0) {
            listValues=null;;
        }
        sum += data.getValue();

        sumLastThreeValues = data.getValue() + prevValue + prevPrevValue;

        prevPrevValue = prevValue;
        prevValue = data.getValue();

        for (var idx = 0; idx < 3; idx++) {
            someValue += (sumLastThreeValues * sumLastThreeValues / (data.getValue() + 1) - sum);
            someValue = Math.abs(someValue) + listValues.length;
        }
    }

    public int  getSum() {
        return sum;
    }

    public int  getPrevValue() {
        return prevValue;
    }

    public int  getPrevPrevValue() {
        return prevPrevValue;
    }

    public int  getSumLastThreeValues() {
        return sumLastThreeValues;
    }

    public int  getSomeValue() {
        return someValue;
    }
}
