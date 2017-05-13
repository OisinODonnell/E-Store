//import org.fyp.Application;
//import org.fyp.controller.AccountController;
//import org.fyp.model.Account;
//import org.fyp.repository.AccountRepository;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//
///**
// * Created by Oisin on 5/9/2017.
// */
//
//
//@RunWith(SpringRunner.class)
////@ContextConfiguration(classes = Application.class, loader =  AnnotationConfigContextLoader.class)
//@ContextConfiguration(classes = Application.class) // this gets as far as the Spring and claps out
//
////@AutoConfigureWebMvc
//@WebMvcTest
//public class AccountControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    AccountRepository accountRepo;
//
//    @MockBean
//    private AccountController accountController;
//
//
//
//    @BeforeClass
//    public static void setUp() {
//        System.out.println("-----> SETUP <-----");
//    }
//
//    @Test
//    public void testExample() throws Exception {
//        int sampleId = 10;
//
//        given(this.accountController.getAccount(sampleId))
//                .willReturn(new Account());
//        this.mvc.perform(get("/Account/10").accept(MediaType.ALL));
//    }
//
//    @Test
//    public void testExample2() throws Exception {
//        int sampleId = 11;
//
//
//        given(this.accountRepo.findByAccountId(sampleId))
//                .willReturn(new Account());
//        this.mvc.perform(get("/Account/10").accept(MediaType.ALL));
//
//    }
//}
