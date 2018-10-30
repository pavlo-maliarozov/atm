package com.task.atm.service;

public interface CreditCardService {
    boolean checkCardIsPresent(String cardNumber);
    boolean checkCardIsBlocked(String cardNumber);
    boolean checkPinIsValid(String cardNumber, String pin);
    double withdrawMoney(String cardNumber, double amount) throws UnsupportedOperationException;
    double balance(String cardNumber);

    void blockCard(String cardNumber);
//    void saveOperation(String cardNumber);
}
