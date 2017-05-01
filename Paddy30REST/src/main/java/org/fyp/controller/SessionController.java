package org.fyp.controller;

import org.fyp.model.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by oisin on 02/04/2017.
 */
@RestController
@RequestMapping(value = "Sessions", method=RequestMethod.GET)
public class SessionController extends MainController{

    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public void create(Session session)    {
        sessionRepo.save(session);
    }

    @RequestMapping(value = "/read", method=RequestMethod.GET)
    public Collection<Session> read()    {
        return sessionRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Session session)    {
        sessionRepo.save(session);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(Session session)    {
        sessionRepo.delete(session);
    }

    @RequestMapping(value = "/Account/{accountId}", method=RequestMethod.GET)
    public  Collection<Session> getSessionsByAccountId(int accountId)    {
        return sessionRepo.findAllByAccountId(accountId);
    }
}
