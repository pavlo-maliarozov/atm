package com.task.atm.controller;

import com.task.atm.model.CreditCardInfo;
import com.task.atm.service.CreditCardServiceImpl;
import com.task.atm.service.OperationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(AtmController.class)
public class AtmControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CreditCardServiceImpl creditCardServiceMock;

    @MockBean
    OperationServiceImpl operationServiceMock;

    private String card;

    private char blocked;

    private String pin;

    @Before
    public void setUp() throws Exception {
        card = "1234-1234-1234-1234";
        blocked = 'N';
        pin = "1111";
    }

    @Test
    public void testCheckCardNumber_whenCardIsValid_thenReturnTrue() throws Exception {

        CreditCardInfo creditCardInfo = new CreditCardInfo();

        creditCardInfo.setCardNumber(card);

        when(creditCardServiceMock.checkCardIsPresent(card)).thenReturn(true);

        Assert.assertTrue(creditCardServiceMock.checkCardIsPresent(card));

    }

    @Test
    public void testCheckCardNotBlocked_whenCardIsNotBlocked_thenReturnFalse() throws Exception {



        CreditCardInfo creditCardInfo = new CreditCardInfo();

        creditCardInfo.setCardNumber(card);
        creditCardInfo.setBlocked(blocked);

        when(creditCardServiceMock.checkCardIsBlocked(card)).thenReturn(false);

        Assert.assertFalse(creditCardServiceMock.checkCardIsPresent(card));

    }

    @Test
    public void testCheckPinIsValid_whenPinIsValid_thenReturnTrue() throws Exception {

        CreditCardInfo creditCardInfo = new CreditCardInfo();

        creditCardInfo.setCardNumber(card);
        creditCardInfo.setBlocked(blocked);

        when(creditCardServiceMock.checkPinIsValid(card, pin)).thenReturn(true);

        Assert.assertTrue(creditCardServiceMock.checkPinIsValid(card, pin));

    }

    @Test
    public void testCheckPinIsValid_whenPinIsNotValid_thenReturnFalse() throws Exception {

        CreditCardInfo creditCardInfo = new CreditCardInfo();

        creditCardInfo.setCardNumber(card);
        creditCardInfo.setBlocked(blocked);

        String typedPin = "2222";

        when(creditCardServiceMock.checkPinIsValid(card, typedPin)).thenReturn(false);

        Assert.assertFalse(creditCardServiceMock.checkPinIsValid(card, typedPin));

    }

}
