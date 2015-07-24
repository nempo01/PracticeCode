package com.ekiras.util.exception;

/**
 * Created by ekansh on 24/7/15.
 */
public class MyException extends RuntimeException {

    public MyException(){}
    public MyException(String message){super(message);}
    public MyException(String message, Throwable cause){super(message, cause);}

}
