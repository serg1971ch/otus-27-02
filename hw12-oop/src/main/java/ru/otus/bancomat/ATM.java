package ru.otus.bancomat;

public class ATM implements Withdrawal {
    public Account accountATM;
    public Cells cellsATM;

    public ATM(Account accountATM, Cells cellsATM) {
        this.accountATM = accountATM;
        this.cellsATM = cellsATM;
    }

    public void fitCells() {
        cellsATM.CashToCells(accountATM);
    }

    public void setWithdraw(int withdrawMoneyATM) {
        accountATM.setWithdrawMoney(withdrawMoneyATM);
    }

    @Override
    public int getWithdraw() {
        return accountATM.getWithdrawMoney();
    }

    @Override
    public int withdrawMoney(int drawMoneyATM) {
        int leftMoney = accountATM.getMoneyAccount() - drawMoneyATM;
        if (leftMoney>=100) {
            accountATM.setMoneyAccount(leftMoney);
            accountATM.setWithdrawMoney(drawMoneyATM);
        } else {
            System.out.println("У вас недостаточно средств");
        }

        return leftMoney;
    }
}
