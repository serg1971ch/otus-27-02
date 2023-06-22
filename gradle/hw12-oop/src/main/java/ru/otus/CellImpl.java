package ru.otus;

public class CellImpl{
    private final BanknoteImpl banknote;
    private int quantity;

    public CellImpl(NominalBanknote nominalBanknote, int quantity) {
        this.banknote = new BanknoteImpl(nominalBanknote);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }else {
            throw new RuntimeException("Количество в ячейке не может быть меньше нуля!");
        }
    }

    public NominalBanknote getNominal(){
        return banknote.getNominal();
    }

    public BanknoteImpl getBanknote(){
        return banknote;
    }


}
