package ru.otus;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<NominalBanknote, Integer> moneyMap = new HashMap<>();
        moneyMap.put(NominalBanknote.THOUSAND, 40);
        moneyMap.put(NominalBanknote.FIFE_THOUSAND, 10);
        moneyMap.put(NominalBanknote.HUNDRED, 7);
        moneyMap.put(NominalBanknote.HALF_THOUSAND, 5);

        AtmImpl atm = new AtmImpl(moneyMap);

        System.out.println("Баланс " + atm.getBalance());

        List<BanknoteImpl> money1 = atm.getBanknotes(700);
        System.out.println(money1);
        List<BanknoteImpl> money2 = atm.getBanknotes(1500);
        System.out.println(money2);

        System.out.println("Баланс " + atm.getBalance());

        try {
            atm.getBanknotes(1550);
        } catch (RuntimeException e) {
            System.out.println(e);
        }

        System.out.println("Баланс " + atm.getBalance());
        atm.getBalance();
    }
}
