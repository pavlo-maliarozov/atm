package com.task.atm.controller;

import com.task.atm.model.OperationCode;
import com.task.atm.model.OperationInfo;
import com.task.atm.service.CreditCardService;
import com.task.atm.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
public class AtmController {

    @Autowired
    @Qualifier("mysql-credit-card-service")
    private CreditCardService creditCardService;

    @Autowired
    @Qualifier("mysql-operation-service")
    private OperationService operationService;

    private String cardNumber;

    private ModelAndView modelAndView;
    private int numWrong = 0;

    @RequestMapping("/")
    public ModelAndView homePage() {

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/check_card_number", method = RequestMethod.POST)
    public ModelAndView cardNumberInputPage(@RequestParam("card_number") String cardNumber) {

        this.cardNumber = cardNumber;
        this.modelAndView = new ModelAndView();

        boolean cardIsPresent = creditCardService.checkCardIsPresent(cardNumber);
        boolean cardIsBlocked = creditCardService.checkCardIsBlocked(cardNumber);
        if (cardIsPresent && !cardIsBlocked) {

            modelAndView.setViewName("redirect:/pin");
            modelAndView.addObject(cardNumber);

        } else {
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            if (!cardIsPresent) {

                modelAndView.setViewName("redirect:/card_presence_error");
                modelAndView.addObject(cardNumber);

                operationService.saveOperation(new OperationInfo(
                        OperationCode.NOT_PRESENT,
                        cardNumber,
                        0,
                        date,
                        time)
                );

            } else {

                modelAndView.setViewName("redirect:/card_blocked_error");
                modelAndView.addObject(cardNumber);

                operationService.saveOperation(new OperationInfo(
                        OperationCode.BLOCKED,
                        cardNumber,
                        0,
                        date,
                        time)
                );
            }
        }

        return modelAndView;
    }

    @RequestMapping("/pin")
    public ModelAndView pinPage() {

        modelAndView.setViewName("pin");

        return modelAndView;
    }

    @RequestMapping(value = "/check_pin", method = RequestMethod.POST)
    public ModelAndView pinCodeInputPage(@RequestParam("card_pin") String pin) {

        if (creditCardService.checkPinIsValid(cardNumber, pin)) {

            modelAndView.setViewName("redirect:/operations");
            modelAndView.addObject(pin);
        } else {

            modelAndView.setViewName("redirect:/card_pin_error");
            ++numWrong;
        }
        if (numWrong == 4) {
            modelAndView.setViewName("redirect:/card_blocked_error");
            modelAndView.addObject(pin);

            creditCardService.blockCard(cardNumber);
        }

        return modelAndView;
    }

    @RequestMapping("/operations")
    public ModelAndView operationsPage() {

        modelAndView.setViewName("operations");

        return modelAndView;
    }

    @RequestMapping("/get_balance")
    public ModelAndView getBalance() {

        double balance = creditCardService.balance(cardNumber);

        LocalDate localDate = LocalDate.now();
        LocalTime time = LocalTime.now();

        OperationInfo operationInfo = new OperationInfo(
                OperationCode.BALANCE,
                cardNumber,
                balance,
                localDate,
                time);

        operationService.saveOperation(operationInfo);

        modelAndView.setViewName("redirect:/balance");
        modelAndView.addObject("operation_info", operationInfo);

        return modelAndView;
    }

    @RequestMapping("/balance")
    public ModelAndView balancePage() {

        modelAndView.setViewName("/balance");

        return modelAndView;
    }

    @RequestMapping("/withdraw_money")
    public ModelAndView withdrawMoneyPage() {

        modelAndView.setViewName("/withdraw_money");

        return modelAndView;
    }

    @RequestMapping("/calculate_withdraw")
    public ModelAndView calculateWithdraw(@RequestParam("withdraw") double withdraw) {

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        try {
            double balance = creditCardService.withdrawMoney(cardNumber, withdraw);

            OperationInfo operationInfoWithdraw = new OperationInfo(
                    OperationCode.WITHDRAW,
                    cardNumber,
                    balance,
                    date,
                    time);

            operationService.saveOperation(operationInfoWithdraw);

            modelAndView.setViewName("redirect:/withdraw_result");
            modelAndView.addObject("opWithdraw", operationInfoWithdraw);
            modelAndView.addObject("withdraw", withdraw);

        } catch (UnsupportedOperationException e) {

            OperationInfo operationInfoError = new OperationInfo(
                    OperationCode.ERROR,
                    cardNumber,
                    withdraw,
                    date,
                    time);

            operationService.saveOperation(operationInfoError);

            modelAndView.setViewName("redirect:/withdraw_error");
            modelAndView.addObject("error", operationInfoError);
        }

        return modelAndView;
    }

    @RequestMapping("/withdraw_result")
    public ModelAndView withdrawResult() {
        modelAndView.setViewName("/withdraw_result");

        return modelAndView;
    }

    @RequestMapping("/card_presence_error")
    public ModelAndView cardNumberPresenceErrorPage() {
        return new ModelAndView("card_presence_error");
    }

    @RequestMapping("/card_blocked_error")
    public ModelAndView cardNumberBlockedErrorPage() {
        return new ModelAndView("card_blocked_error");
    }

    @RequestMapping("/card_pin_error")
    public ModelAndView cardPinErrorPage() {
        return new ModelAndView("/card_pin_error");
    }

    @RequestMapping("/withdraw_error")
    public ModelAndView withdrawErrorPage() {
        return new ModelAndView("withdraw_error");
    }
}
