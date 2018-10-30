package com.task.atm.service;


import com.task.atm.model.CreditCardInfo;
import com.task.atm.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Qualifier("mysql-credit-card-service")
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository atmRepository;

    @Override
    public boolean checkCardIsPresent(String cardNumber) {

        return atmRepository.existsById(cardNumber);
    }

    public boolean checkCardIsBlocked(String cardNumber) {

        return atmRepository.findById(cardNumber)
                .map(CreditCardInfo::getBlocked)
                .map(blocked -> blocked.equals('Y'))
                .orElse(true);
    }

    @Override
    public boolean checkPinIsValid(String cardNumber, String pin) {

        return atmRepository.findById(cardNumber)
                .map(CreditCardInfo::getPin)
                .map(creditCardPin -> creditCardPin.equals(pin))
                .orElse(false);
    }

    @Override
    public double withdrawMoney(String cardNumber, double amount) {

        double newBalance = 0;
        Optional<CreditCardInfo> creditCardInfoOptional = atmRepository.findById(cardNumber);

        if(creditCardInfoOptional.isPresent()) {

            CreditCardInfo creditCardInfo = creditCardInfoOptional.get();

            double balance = creditCardInfo.getBalance();
            if (balance >= amount) {

                newBalance = balance - amount;

                atmRepository.withdrawMoney(newBalance, cardNumber);

            }

            else {
                String error = String
                        .format("Credit card balance is less then amount to withdraw! Balance: %.2f Amount: %.2f",
                        balance,
                        amount
                );

                throw new UnsupportedOperationException(error);
            }
        }

        return newBalance;
    }

    @Override
    public double balance(String cardNumber) {
        return atmRepository
                .findById(cardNumber)
                .map(CreditCardInfo::getBalance)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Balance is not available for credit card with number: "+ cardNumber));
    }

    @Override
    public void blockCard(String cardNumber) {
        atmRepository.blockCard(cardNumber);
    }

}
