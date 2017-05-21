package org.fyp.controller;

import org.fyp.model.Session;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 02/04/2017.
 */
@RestController
@RequestMapping(value = {"Sessions", "Session"}, method=RequestMethod.GET)
public class SessionController extends MainController{

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Session> read()    {
        return sessionRepo.findAll();
    }

    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public void create(Session session)    {
        sessionRepo.save(session);
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Session session)    {
        sessionRepo.save(session);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(Session session)    {
        sessionRepo.delete(session);
    }

    @RequestMapping(value = "/delete/{sessionId}", method=RequestMethod.GET)
    public String deleteById(@PathVariable("sessionId") int sessionId) throws ParseException {

        if(sessionRepo.findBySessionId(sessionId) != null) {
            sessionRepo.deleteBySessionId(sessionId);
        } else {
            return "SessionID : " + sessionId + " does not exist";
        }

        if(sessionRepo.findBySessionId( sessionId ) == null) {
            return "Session " + sessionId + " was deleted.";
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/Account/{accountId}", method=RequestMethod.GET)
    public  Collection<Session> getSessionsByAccountId(@PathVariable int accountId)    {
        return sessionRepo.findAllByAccountId(accountId);
    }
}
