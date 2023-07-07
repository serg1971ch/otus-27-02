package ru.otus.money;

public class Money {
    private int valueMoney;
    private int countBancnotsOfMoney;
    private NominalBanknote nominalBanknote;

    public Money(int valueMoney, NominalBanknote nominalBanknote, int countBancnotsOfMoney) {
        this.valueMoney = valueMoney;
        this.nominalBanknote = nominalBanknote;
        this.countBancnotsOfMoney = countBancnotsOfMoney;
    }

    public void setValueMoney(int valueMoney) {
        this.valueMoney = valueMoney;
    }

    public int getValueMoney() {
        return valueMoney;
    }

    public int setCountBancnotsOfMoney() {
        return countBancnotsOfMoney = valueMoney / nominalBanknote.getValue();
    }

    public int getCountBancnotsOfMoney() {
        return countBancnotsOfMoney;
    }

    @Override
    public String toString() {
        return   ", стоимостью" + nominalBanknote.toString();
    }
}
