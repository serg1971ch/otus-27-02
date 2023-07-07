package ru.otus;

import ru.otus.bancomat.ATM;
import ru.otus.bancomat.Account;
import ru.otus.bancomat.Cells;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(22830);
        Cells cells = new Cells();
        ATM atm = new ATM(account, cells);
        atm.fitCells();
        System.out.println("Сначала в бакномате загрузили " + account.getMoneyAccount() + " рублей" + "\n" + ", то есть в лотке для банкнот расклад следующий: \n" + cells.getSlots());
        atm.withdrawMoney(1340);
        System.out.println("В банкомате сняли " + account.getWithdrawMoney() + " рублей " + "\n" + "после чего в лотке для банкнот осталось: \n" + cells.withdrawCashToCells(account));
        atm.withdrawMoney(240);
        System.out.println("В банкомате сняли еще " + account.getWithdrawMoney() + " рублей " + "\n" + "после чего в лотке для банкнот осталось: \n" + cells.withdrawCashToCells(account));
    }
}
