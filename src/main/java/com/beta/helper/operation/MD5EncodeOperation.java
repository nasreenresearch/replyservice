package com.beta.helper.operation;

import com.beta.error.InvalidInputException;
import com.beta.util.EncodeDecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of Operation class for generating the
 * MD5 hash for given input string.
 */
@Service
public class MD5EncodeOperation implements Operation {

    private EncodeDecode encodeDecode = new EncodeDecode();

    /**
     * Return the hash in string format for the given input
     * string
     * @param input
     * @return hash
     * @throws InvalidInputException
     */
    @Override
    public String process(String input) throws InvalidInputException {
        return encodeDecode.encode(input,"MD5");
    }

}
