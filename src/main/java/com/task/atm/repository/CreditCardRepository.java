package com.task.atm.repository;

import com.task.atm.model.CreditCardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardInfo, String> {

    @Modifying
    @Transactional
    @Query("UPDATE CreditCardInfo cci " +
            "SET cci.balance = :balance " +
            "where cci.cardNumber = :cardNumber")
    int withdrawMoney(@Param("balance") double balance, @Param("cardNumber") String cardNumber);

    @Modifying
    @Transactional
    @Query("UPDATE CreditCardInfo cci " +
            "SET cci.blocked = 'Y' " +
            "where cci.cardNumber = :cardNumber")
    void blockCard(@Param("cardNumber") String cardNumber);
}
