package com.task.atm.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "operation_info")
public class OperationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_id")
    private long operationId;

    @Column(name = "operation_code")
    private OperationCode code;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "balance")
    private double balance;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    public OperationInfo(OperationCode code, String cardNumber, double withdraw, LocalDate date, LocalTime time) {
        this.code = code;
        this.cardNumber = cardNumber;
        this.balance = withdraw;
        this.date = date;
        this.time = time;
    }

    public OperationInfo() {
    }

    public void setOperationId(long operationId) {
        this.operationId = operationId;
    }

    public void setCode(OperationCode code) {
        this.code = code;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getId() {
        return operationId;
    }

    public OperationCode getCode() {
        return code;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationInfo that = (OperationInfo) o;
        return operationId == that.operationId &&
                Double.compare(that.balance, balance) == 0 &&
                code == that.code &&
                Objects.equals(cardNumber, that.cardNumber) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId, code, cardNumber, balance, date, time);
    }

    @Override
    public String toString() {
        return "OperationInfo{" +
                "operationId=" + operationId +
                ", code=" + code +
                ", cardNumber='" + cardNumber + '\'' +
                ", balance=" + balance +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
