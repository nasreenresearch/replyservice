package com.beta.helper.operation;

import com.beta.error.InvalidInputException;


/**
 * Operation Interface contains the process method
 * which will be use for performing the various tasks
 * against the given input string.
 */
public interface Operation {

    /**
     * Process the input string and generate the oputput
     * according to the operation.
     * @param input
     * @return output
     * @throws InvalidInputException
     */
    String process(String input) throws InvalidInputException;

}
