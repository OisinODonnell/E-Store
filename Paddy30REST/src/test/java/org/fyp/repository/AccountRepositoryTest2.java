//package org.fyp.repository;
//import org.fyp.Application;
//import org.fyp.controller.AccountController;
//import org.fyp.controller.AttributeCountException;
//import org.fyp.model.Account;
//import org.fyp.repository.AccountRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// * Created by Oisin on 5/9/2017.
// */
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = Application.class)
//@DataJpaTest
//public class AccountRepositoryTest2 {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
////    @Autowired
////    private AccountRepository accountRepository;
//
//    @Test
//    public void testFindById() throws AttributeCountException, ParseException {
//       int sampleId = 10;
////        List<String> attributes = Arrays.asList("2015-08-09 10:57:00", "Sherlock Holmes",
////                "sherlockhomes@gmail.com", "0877904664", "CUSTOMER", "VISA", "1", "98", "London",
////                "22B Baker Street", "England");
////        Account x = new Account(attributes);
////        entityManager.persist(new Account(attributes));
//
//
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
//        Account account = new Account(attributes);
//
//        assertEquals(account.getName(), "Sherlock Holmes");
//
//
////        entityManager.persist(account);
////    //  accountRepository.save(account);
////        AccountController a = new AccountController();
////        Optional<Account> account2 = Optional.ofNullable(a.getAccount(sampleId));
////        //Optional<Account> account2 = accountRepository.findByAccountId(sampleId);
////        assertEquals(10, account2.get().getAccountId());
//
//
//
//
//    }
//
//
//}
//
//
