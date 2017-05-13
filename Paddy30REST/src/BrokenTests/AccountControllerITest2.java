//import org.fyp.Application;
//import org.fyp.controller.MainController;
//import org.fyp.model.Account;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// * Created by Oisin on 5/9/2017.
// */
//
//@RunWith(SpringRunner.class)
////@ContextConfiguration(classes = Application.class)
////@SpringBootTest(webEnvironment =
////SpringBootTest.WebEnvironment.DEFINED_PORT)
//@SpringBootTest(classes = Application.class)
//public class AccountControllerITest2 {
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//
//
//
//    @Test
//    public void createAccount() {
//        ResponseEntity<Account> responseEntity =
//                restTemplate.getForEntity("Accounts/10", Account.class);
////                        .postForEntity("/Accounts/10", , Account.class);
//        Account account = responseEntity.getBody();
//        assertEquals(account.getName(), "lsjdf");
//    }
//
//}
