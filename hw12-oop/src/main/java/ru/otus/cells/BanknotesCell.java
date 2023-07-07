package ru.otus.cells;

import ru.otus.money.Money;

public abstract class BanknotesCell {
    private Money money;

    public BanknotesCell(Money money) {
        this.money = money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "BanknoteCell{" +
                "количество купюр" + " = " + money.getValueMoney() +
                money.toString() + '}';
    }
}
