//package org.fyp.repository;
//
//import org.fyp.controller.AccountController;
//import org.fyp.controller.AttributeCountException;
//import org.fyp.model.Account;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * Created by Oisin on 5/10/2017.
// */
//@RunWith(SpringRunner.class)
//@DataJpaTest
//class AccountRepositoryTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private AccountRepository accountRepository1;
//
//
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void findByAccountId() throws AttributeCountException, ParseException {
//
//
//        // prepare data and mock's behaviour
//        List<String> attributes = new ArrayList<String>();
//        attributes.add("2015-08-09 10:57:00");
//        attributes.add("Sherlock Holmes");
//        attributes.add("sholmes@gmail.com");
//        attributes.add("0877904664");
//        attributes.add("CUSTOMER");
//        attributes.add("VISA");
//        attributes.add("1");
//        attributes.add("98");
//        attributes.add("London");
//        attributes.add("22B Baker Street");
//        attributes.add("England");
//
//        // prepare data and mock's behaviour
//        Account accountStub = new Account(attributes);
//        entityManager.persist(accountStub);
//
//        Account account = accountRepository1.findByAccountId(1);
//        assertEquals("1", account.getAccountId());
//    }
//
//    @Test
//    void deleteByAccountId() {
//    }
//
//}