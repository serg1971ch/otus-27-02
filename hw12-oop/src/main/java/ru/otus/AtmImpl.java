package ru.otus;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AtmImpl implements ATM{

    private final MoneyBankomatImpl moneyBankomatImpl;

    public AtmImpl(Map<NominalBanknote, Integer> money) {
        moneyBankomatImpl = new MoneyBankomatImpl();
        money.forEach(this::putBanknotes);
    }

    @Override
    public void putBanknotes(NominalBanknote denomination, int quantity) {
        CellImpl atmCell = new CellImpl(denomination, quantity);
        moneyBankomatImpl.addCellToVault(atmCell);
    }

    @Override
    public List<BanknoteImpl> getBanknotes(int amount) {
        if (amount == 0) {
            throw new RuntimeException("Запрашиваемая сумма должна быть больше 0");
        }
        return getMoneyFromAtmRecursively(new ArrayList<>(), amount);
    }

    @Override
    public int getBalance() {
        return moneyBankomatImpl.getMoneyBankomatBalance();
    }

    private List<BanknoteImpl> getMoneyFromAtmRecursively(List<BanknoteImpl> money, int resultAmount) {
        if (resultAmount == 0) {
            return money;
        } else if (resultAmount < 0) {
            recoverMoneyBack(money);
            throw new RuntimeException("Данная сумма не может быть выдана банкоматом");
        }
        if (getBalance() <= 0) {
            throw new RuntimeException("В банкомате нет денег");
        }

        BanknoteImpl finalTempBanknote = getClosestToAmountBanknote(resultAmount);
        if (finalTempBanknote == null) {
            recoverMoneyBack(money);
            throw new RuntimeException("Данная сумма не может быть выдана банкоматом");
        }

        resultAmount = decreaseBanknoteQuantityAndAddItIntoList(money, finalTempBanknote, resultAmount);

        return getMoneyFromAtmRecursively(money, resultAmount);
    }

    private int decreaseBanknoteQuantityAndAddItIntoList(List<BanknoteImpl> money, BanknoteImpl finalTempBanknote, int resultAmount) {
        for (CellImpl cell : moneyBankomatImpl.getCellList()) {
            if (cell.getBanknote().equals(finalTempBanknote)) {
                money.add(finalTempBanknote);
                cell.setQuantity(cell.getQuantity() - 1);
                resultAmount = resultAmount - finalTempBanknote.getNominal().getValue();
            }
        }
        return resultAmount;
    }

    private void recoverMoneyBack(List<BanknoteImpl> money) {
        for (BanknoteImpl banknote : money) {
            moneyBankomatImpl.getCellList().stream()
                    .filter(c -> c.getBanknote().equals(banknote))
                    .findFirst()
                    .ifPresent(cell -> cell.setQuantity(cell.getQuantity() + 1));
        }
    }

    private BanknoteImpl getClosestToAmountBanknote(int amount) {
        BanknoteImpl tempBanknote = null;
        for (CellImpl cell : moneyBankomatImpl.getCellList()) {
            if (cell.getNominal().getValue() <= amount && cell.getQuantity() > 0) {
                tempBanknote = cell.getBanknote();
            }
        }
        return tempBanknote;
    }
}
