package com.beta.error;

/**
 * This class will handle all the invalid inputs
 */
public class InvalidInputException extends Exception{

    public InvalidInputException(String errorMessage){
        super(errorMessage);
    }
}
