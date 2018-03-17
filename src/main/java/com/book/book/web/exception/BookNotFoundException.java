package com.book.book.web.exception;

/**
 * author anand.
 * since on 17/3/18.
 */
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(){
        super();
    }
    public BookNotFoundException(String message,Throwable throwable){
        super(message,throwable);
    }
    public BookNotFoundException(String message){
        super(message);
    }
    public BookNotFoundException(Throwable throwable){
        super(throwable);
    }
}
