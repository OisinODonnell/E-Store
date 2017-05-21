//package org.fyp.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.fyp.Application;
//import org.fyp.model.Account;
//import org.fyp.repository.AccountRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Profile;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
//import static junit.framework.TestCase.assertTrue;
//import static org.hamcrest.core.IsNull.notNullValue;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * Created by Oisin on 5/10/2017.
// */
//
//
//
//
//@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest(AccountController.class)
//public class AccountControllerTest extends MainController {
//    @MockBean
//    private MockMvc mockMvc;
//    @InjectMocks
//    private AccountRepository repository;
//    @Mock
//    private Account accountStub;
//    @Test
//    void createTest(){
//        System.out.println("Was tested");
//        assertTrue(true);
//    }
//    @Test
//    void getAccountTest()  {
//        assertTrue(true);
//        System.out.println("Was tested also");
//         // prepare data and mock's behaviour
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
//        try {
//            accountStub = new Account(attributes);
//        } catch (AttributeCountException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        //accountRepository.save(accountStub);
//        when(repository.findByAccountId(any(Integer.class))).thenReturn(accountStub);
//
//
//        //execute
//        MvcResult result = mockMvc
//                .perform(MockMvcRequestBuilders.get("/Accounts/" + "{accountId}")
//                        .accept(MediaType.APPLICATION_JSON_UTF8))
//                        .andReturn();
//
//
//
//    }
//}