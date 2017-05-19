package org.fyp.controller;

import org.fyp.model.Account;
import org.fyp.model.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by oisin on 30/03/2017.
 */
@RestController
@RequestMapping("Login")
public class LoginController extends MainController {

    int status = 0;
    HttpStatus httpStatus = HttpStatus.OK;
    String message = "";
    HashMap<String, String> respMap;

    @RequestMapping(value = "/{username}/{password}", method= RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String,String>> login (@PathVariable("username") String username,
                                                         @PathVariable("password") String password) throws ParseException {
        // check username exists
        // check password matches
        // create session with accountid, date and time
        // return success and usertype

        respMap = new HashMap<>();

        Timestamp startTime = getTimeStamp();
        Account account = accountRepo.findByEmail(username);



        if (account != null) { // yes account with this username exists

            if (account.getPassword().equals(password)) {

                respMap.put( "message"   , account.getAccountType() + " User " + account.getName() + "with id " + account.getAccountId() + " is logged in!");
                respMap.put( "userType"  , account.getAccountType() );

                respMap.put( "name"      , account.getName() );
                respMap.put( "httpStatus", "" + HttpStatus.OK );
                respMap.put( "startTime" , "" + startTime );
                respMap.put( "accountId" , "" + account.getAccountId() );
                respMap.put( "success" , ""+1);
                Session session = new Session();
                session.setAccountId(account.getAccountId());
                session.setDateStart( startTime );
                sessionRepo.saveAndFlush(session);
                httpStatus = HttpStatus.OK;

            } else { // password incorrect
                respMap.put( "message"   , "Username : [" + username + "] or password : [" + password + "] incorrect");
                respMap.put( "success" , "0");
                message = "Username or password incorrect";
                httpStatus = HttpStatus.OK;
            }
        } else { // username not found
            respMap.put( "message"   , "Username : [" + username + "] or password : [" + password + "] incorrect");
            respMap.put( "success" , ""+0);
            respMap.put("httpStatus", ""+HttpStatus.OK);
            httpStatus = HttpStatus.OK;

        }

        return new ResponseEntity<>(respMap, httpStatus);
    }


    @RequestMapping(value = "/logout/{accountId}/{startTime}", method= RequestMethod.GET)
    @ResponseBody
    public ResponseEntity logout (@PathVariable("accountId") Integer accountId,
                                  @PathVariable("startTime") Timestamp startTime) throws ParseException {
        // locate session with accountId
        // locate this session based on its startTime
        // set endTimeStamp
        // save session details
        // return successful logout status

        respMap = new HashMap<>();

        Collection<Session> sessions = sessionRepo.findAllByAccountId(accountId);
        Account account = accountRepo.findByAccountId(accountId);

        for (Session s : sessions) {
            if (s.getDateStart().equals(startTime)) {
                s.setDateEnd( getTimeStamp() );
                sessionRepo.save(s);
                message  = "User "+ account.getName() + " has successfully Logged out";
                httpStatus = HttpStatus.OK;
                break;
            } else {
                message  = "Session could not be found to terminate";
                httpStatus = HttpStatus.NOT_ACCEPTABLE;
            }
        }

        return new ResponseEntity<>(message, httpStatus);
    }
    @RequestMapping(value = "/register/{name}/{email}/{password}/{accountType}",
            method= RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String,String>> register (@PathVariable("name") String name,
                                                            @PathVariable("email")          String email,
                                                            @PathVariable("password")       String password,
                                                            @PathVariable("accountType")  String accountType )
            throws ParseException {
        // Check email is unique
        // check password conforms to correct format
        // create account
        // save account
        // return successful account creation status

        respMap = new HashMap<>();

        Timestamp dateJoined = getTimeStamp();
        Account account = accountRepo.findByEmail(email);

        if (account == null) {
            account = new Account();
            if (checkPasswordFormat(password)) {
                account.setName(name);
                account.setEmail(email);
                account.setPassword(password);
                account.setAccountType(accountType);
                account.setDateJoined(dateJoined);

                httpStatus = HttpStatus.OK;

                respMap.put("message","Account created successfully");
                respMap.put("httpStatus",""+httpStatus);
                respMap.put("success","1");
                accountRepo.save(account);

            } else {
                httpStatus = HttpStatus.OK;
                respMap.put("message","Password Incorrect: >= 6 and <= 20, at least one number, upper and lowercase character");
                respMap.put("success","0");
                respMap.put("httpStatus",""+httpStatus);
            }
        } else {
            httpStatus = HttpStatus.OK;
            respMap.put("message"," - This email address is already in use, please chose another email address");
            respMap.put("success","0");
            respMap.put("httpStatus",""+httpStatus);
        }

        return new ResponseEntity<>(respMap, httpStatus);
    }
    @RequestMapping(value = "/register/{name}/{email}/{password}/{accountType}/{phone}/{loyaltyCard}/{addressStreet}/{addressCity}/{addressCountry}/{paymentType}",
            method= RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String,String>> register (@PathVariable("name")           String name,
                                                            @PathVariable("email")          String email,
                                                            @PathVariable("password")       String password,
                                                            @PathVariable("phone")          String phone,
                                                            @PathVariable("accountType")    String accountType,
                                                            @PathVariable("loyaltyCard")    Integer loyaltyCard,
                                                            @PathVariable("addressStreet")  String addressStreet,
                                                            @PathVariable("addressCity")    String addressCity,
                                                            @PathVariable("addressCountry") String addressCountry,
                                                            @PathVariable("paymentType")    String paymentType  )
            throws ParseException {
        // Check email is unique
        // check password conforms to correct format
        // create account
        // save account
        // return successful account creation status

        respMap = new HashMap<>();

        Timestamp dateJoined = getTimeStamp();
        Account account = accountRepo.findByEmail(email);

        Byte lcard = 0x0;
        if (loyaltyCard == 1)  lcard = 0x1;


        if (account == null) {
            account = new Account();
            if (checkPasswordFormat(password)) {
                account.setName(name);
                account.setEmail(email);
                account.setPassword(password);
                account.setAccountType(accountType);
                account.setPhone(phone);
                account.setLoyaltyCard(lcard);
                account.setDateJoined(dateJoined);
                account.setAddressStreet(addressStreet);
                account.setAddressCity(addressCity);
                account.setAddressCountry(addressCountry);
                account.setPaymentType(paymentType);

                httpStatus = HttpStatus.OK;

                respMap.put("message","Account created successfully");
                respMap.put("httpStatus",""+httpStatus);
                respMap.put("success","1");
                accountRepo.save(account);

            } else {
                httpStatus = HttpStatus.OK;
                respMap.put("message","Password Incorrect: >= 6 and <= 20, at least one number, upper and lowercase character");
                respMap.put("success","0");
                respMap.put("httpStatus",""+httpStatus);
            }
        } else {
            httpStatus = HttpStatus.OK;
            respMap.put("message"," - This email address is already in use, please chose another email address");
            respMap.put("success","0");
            respMap.put("httpStatus",""+httpStatus);
        }

        return new ResponseEntity<>(respMap, httpStatus);
    }
    private boolean checkPasswordFormat(String password) {

        //  ^            #   match from start
        //  (            #   Start of group
        //  (?=.*\d)     #   must contains one digit from 0-9
        //  (?=.*[a-z])  #   must contains one lowercase characters
        //  (?=.*[A-Z])) #   must contains one Uppercase character
        //          .    #   match anything with previous condition checking
        //  {8,20}       #   length at least 8 characters and maximum of 20

        String regex = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])).{6,20}";

        return password.matches(regex);
    }
}