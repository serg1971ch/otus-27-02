package ru.otus.bancomat;

public class Account {
    private int moneyAccount;
    //   сколько денег снимается со счета
    private int withdrawMoney;

    public Account(int moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

    public void setMoneyAccount(int moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

    public int getMoneyAccount() {
        return moneyAccount;
    }

    public void setWithdrawMoney(int withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
    }

    public int getWithdrawMoney() {
        return withdrawMoney;
    }
}
