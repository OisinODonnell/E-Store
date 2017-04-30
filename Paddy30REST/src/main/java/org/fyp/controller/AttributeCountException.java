package org.fyp.controller;

/**
 * Created by oisin on 30/03/2017.
 */
public class AttributeCountException extends Exception {
    String message = "Wrong number of arguments received";
    public AttributeCountException() { super(); }
    public AttributeCountException(String message) { super(message); }

}
