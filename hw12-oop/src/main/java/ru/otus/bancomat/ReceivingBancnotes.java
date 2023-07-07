package ru.otus.bancomat;

import ru.otus.cells.BanknotesCell;

import java.util.HashMap;

public interface ReceivingBancnotes {
    //  информармация  о содержании банкомата
    BanknotesCell[] getCashFromCells();

    //  внесение денежных средств в банкомат
    HashMap<Integer, Integer> CashToCells(Account account);

    //  снятие денежных средств с банкомата
    HashMap<Integer, Integer> withdrawCashToCells(Account account);
}
