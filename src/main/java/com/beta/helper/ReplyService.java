package com.beta.helper;

import com.beta.error.InvalidInputException;
import com.beta.replyservice.ReplyMessage;
import org.springframework.stereotype.Service;

/**
 * ReplyService Interface contains the method reply which
 * is responsible for generating the output string from given input
 * string according to the given operations
 */
@Service
public interface ReplyService {


    /**
     * this method will be process the input and
     * will generate the output string according to
     * operations specified.
     * @param input
     * @return
     * @throws InvalidInputException
     */
    ReplyMessage reply(String input) throws InvalidInputException;

}
