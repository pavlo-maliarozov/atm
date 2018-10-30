package com.task.atm.model;

import java.util.NoSuchElementException;

public enum OperationCode {

    BALANCE(0),
    WITHDRAW(1),
    ERROR(2),
    NOT_PRESENT(3),
    BLOCKED(4);

    OperationCode(int id) {
        this.id = id;
    }

    public static OperationCode valueOf(int id) {
        switch (id) {

            case 0:
                return BALANCE;
            case 1:
                return WITHDRAW;

            default:
                throw new NoSuchElementException("Operation not found!");
        }

    }

    public int getId() {
        return id;
    }

    private final int id;
}
