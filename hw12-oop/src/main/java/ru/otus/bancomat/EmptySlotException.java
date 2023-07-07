package ru.otus.bancomat;

public class EmptySlotException extends Exception{

    public EmptySlotException(String message) {
        super(message);
    }
}
