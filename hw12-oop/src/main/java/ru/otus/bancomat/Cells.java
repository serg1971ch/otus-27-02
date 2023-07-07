package ru.otus.bancomat;

import ru.otus.cells.*;
import ru.otus.money.Money;
import ru.otus.money.NominalBanknote;

import java.util.HashMap;

public class Cells implements ReceivingBancnotes {
    private BanknotesCell[] banknotesCells;
    private HashMap<Integer, Integer> slots = new HashMap<>();

    @Override
    public BanknotesCell[] getCashFromCells() {
        return banknotesCells;
    }

    public HashMap<Integer, Integer> getSlots() {
        return slots;
    }

    @Override
    public HashMap<Integer, Integer> CashToCells(Account accountCells) {
        banknotesCells = new BanknotesCell[4];
        int[] numbersList = getAmountBancnoteList(accountCells.getMoneyAccount());
        slots = formCellsBanknotes(numbersList);
        return slots;
    }

    @Override
    public HashMap<Integer, Integer> withdrawCashToCells(Account account) {
        int[] numbersSubList = getAmountBancnoteList(account.getWithdrawMoney());
        try {
            slots = subOperationCellsBanknotes(numbersSubList);
        } catch (EmptySlotException e) {
            e.printStackTrace();
        }
        return slots;
    }

    private HashMap<Integer, Integer> formCellsBanknotes(int[] list) {
        int countBancnotes = 0;
        for (int i = 0; i < list.length; i++) {
            if (i == 0) {
                countBancnotes = list[0];
                banknotesCells[0] = new OneHundredCell(new Money(list[0], NominalBanknote.HUNDRED, countBancnotes));
                slots.put(100, countBancnotes);
            }
            if (i == 1) {
                countBancnotes = list[1];
                banknotesCells[1] = new FiveHundreCell(new Money(list[1], NominalBanknote.HALF_THOUSAND, countBancnotes));
                slots.put(500, countBancnotes);
            }
            if (i == 2) {
                countBancnotes = list[2];
                banknotesCells[2] = new OneThousandCell(new Money(list[2], NominalBanknote.THOUSAND, countBancnotes));
                slots.put(1000, countBancnotes);
            }
            if (i == 3) {
                countBancnotes = list[3];
                banknotesCells[3] = new OneThousandCell(new Money(list[3], NominalBanknote.FIFE_THOUSAND, countBancnotes));
                slots.put(5000, countBancnotes);
            }
        }
        return slots;
    }

    private HashMap<Integer, Integer> subOperationCellsBanknotes(int[] list) throws EmptySlotException {
        int countBancnotes = 0;
        for (int i = 0; i < list.length; i++) {
            if (i == 0) {
                countBancnotes = list[0];
                int newCountBancnotes = slots.get(100) - countBancnotes;
                if (newCountBancnotes >= 0) {
                    slots.put(100, newCountBancnotes);
                } else {
                    throw new EmptySlotException("Empty 100 rub slot!");
                }
            }
            if (i == 1) {
                countBancnotes = list[1];
                int newCountBancnote = slots.get(500) - countBancnotes;
                if (newCountBancnote >= 0) {
                    slots.put(500, newCountBancnote);
                } else {
                    throw new EmptySlotException("Empty 500 rub slot!");
                }
            }
            if (i == 2) {
                countBancnotes = list[2];
                int newCountBancnote = slots.get(1000) - countBancnotes;
                if (newCountBancnote >= 0) {
                    slots.put(1000, newCountBancnote);
                } else {
                    throw new EmptySlotException("Empty 1000 rub slot!");
                }
            }
            if (i == 3) {
                countBancnotes = list[3];
                int newCountBancnote = slots.get(5000) - countBancnotes;
                if (newCountBancnote >= 0) {
                    slots.put(5000, newCountBancnote);
                } else {
                    throw new EmptySlotException("Empty 5000 rub slot!");
                }
            }
        }
            return slots;
        }

        private int[] getAmountBancnoteList ( int number){
            int fives = number / 5000;
            int thousands = (number % 5000) / 1000;
            int fiveHundreds = (number % 1000) / 500;
            int hundreds = (number % 500) / 100;
            int[] listBancnotes = new int[4];
            listBancnotes[0] = hundreds;
            listBancnotes[1] = fiveHundreds;
            listBancnotes[2] = thousands;
            listBancnotes[3] = fives;
            return listBancnotes;
        }
    }
