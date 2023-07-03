package ru.otus;

import java.util.Comparator;
import java.util.TreeSet;

public class MoneyBankomatImpl implements MoneyBankomat {
    private final TreeSet<CellImpl> cellList;

    public MoneyBankomatImpl() {
        cellList = new TreeSet<>(Comparator.comparingInt(c -> c.getNominal().getValue()));
    }

    public TreeSet<CellImpl> getCellList() {
        return cellList;
    }

    public void addCellToVault(CellImpl cell) {
        cellList.add(cell);
    }

    public int getMoneyBankomatBalance() {
        return cellList.stream().mapToInt(c -> c.getNominal().getValue() * c.getQuantity()).sum();
    }
}
