package com.book.book.web.exception;

/**
 * author anand.
 * since on 17/3/18.
 */
public class BookIdMismatchException extends RuntimeException {


    public BookIdMismatchException(){
        super();
    }
    public BookIdMismatchException(String message,Throwable throwable){
        super(message,throwable);
    }
    public BookIdMismatchException(String message){
        super(message);
    }
    public BookIdMismatchException(Throwable throwable){
        super(throwable);
    }
}
