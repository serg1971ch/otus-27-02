package ru.otus;

public enum NominalBanknote {
    HUNDRED(100),
    HALF_THOUSAND(500),
    THOUSAND(1000),
    FIFE_THOUSAND(5000);

    private final int value;

    NominalBanknote(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
