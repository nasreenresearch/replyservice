package com.beta.helper.operation;

/**
 * Implementation of Operation class for getting the
 * reverse string of the given input string
 */
public class StringReverseOperation implements Operation {

    @Override
    public String process(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
