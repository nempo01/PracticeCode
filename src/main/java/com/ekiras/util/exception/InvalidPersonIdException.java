package com.ekiras.util.exception;

/**
 * Created by ekansh on 24/7/15.
 */
public class InvalidPersonIdException extends MyException {

    public static final String message = "invalid person id provided";

    public InvalidPersonIdException(){super(message);}
}
