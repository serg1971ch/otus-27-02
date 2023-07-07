package ru.otus.bancomat;

public interface Withdrawal {
    int withdrawMoney(int drawMoney);
    void setWithdraw(int withdrawMoneyATM);
    int getWithdraw();
}
