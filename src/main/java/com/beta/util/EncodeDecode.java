package com.beta.util;

import com.beta.error.InvalidInputException;

import java.security.MessageDigest;


/**
 * Utility class to be use for encoding the input
 * using various algorithms.
 */
public class EncodeDecode {


    /**
     * This method will encode the given string and generate
     * the output using specified algorithm and may throw
     * Invalid input exception if algorithm does not match
     * any available algorithms
     * @param input
     * @param algorithm
     * @return
     * @throws InvalidInputException
     */
    public String encode(String input,String algorithm) throws InvalidInputException {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(input.getBytes());
            byte[] digest = md.digest();
            String hex = "";

            for (byte i : digest) {
                hex += String.format("%02x", i);
            }
            return hex;
        } catch (Exception e){
            throw new InvalidInputException("Invalid input");
        }
    }
}
