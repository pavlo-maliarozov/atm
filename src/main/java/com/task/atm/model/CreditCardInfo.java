package com.task.atm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "credit_card_info")
public class CreditCardInfo {

    @Id
    @Column(name = "credit_card_number")
    private String cardNumber;

    @Column(name = "pin")
    private String pin;

    @Column(name = "blocked")
    private char blocked;

    @Column(name = "balance")
    private double balance;

    public CreditCardInfo(String cardNumber, char blocked, double balance) {
        this.cardNumber = cardNumber;
        this.blocked = blocked;
        this.balance = balance;
    }

    public CreditCardInfo() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public char getBlocked() {
        return blocked;
    }

    public void setBlocked(char blocked) {
        this.blocked = blocked;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCardInfo that = (CreditCardInfo) o;
        return blocked == that.blocked &&
                Double.compare(that.balance, balance) == 0 &&
                Objects.equals(cardNumber, that.cardNumber) &&
                Objects.equals(pin, that.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, pin, blocked, balance);
    }

    @Override
    public String toString() {
        return "CreditCardInfo{" +
                "cardNumber='" + cardNumber + '\'' +
                ", blocked=" + blocked +
                ", balance=" + balance +
                '}';
    }
}
