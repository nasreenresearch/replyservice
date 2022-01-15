package com.beta.helper;

import com.beta.error.InvalidInputException;
import com.beta.helper.operation.MD5EncodeOperation;
import com.beta.helper.operation.Operation;
import com.beta.helper.operation.StringReverseOperation;
import com.beta.replyservice.ReplyMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Implementation of ReplyService Interface and
 * Responsible for -
 * Validating Input
 * Processing Input
 * Performing series of operations on Input
 * Generating Output string
 */
@Service
public class ReplyServiceImpl implements ReplyService{
    private HashMap<Character, Operation> operations = new HashMap<>();

    /**
     * Constructor for ReplyServiceImpl class
     * which will add the all available key-value pairs
     * of operations and responsible class object for
     * that operation in the hashmap.
     */
    public ReplyServiceImpl(){
        operations.put('1', new StringReverseOperation());
        operations.put('2', new MD5EncodeOperation());
    }

    /**
     * Generate ReplyMessage entity which contains
     * the output string or it can also throw the Invalid input
     * exception when input is not in proper format.
     * @param input
     * @return
     * @throws InvalidInputException
     */
    @Override
    public ReplyMessage reply(String input) throws InvalidInputException {
        InputValidator(input);
        return new ReplyMessage(processValidInput(input));
    }

    /**
     * This method will process the validated input
     * and it is also responsible for identifying the
     * series of operation to be perform on input string
     * @param input
     * @return
     * @throws InvalidInputException
     */
    protected String processValidInput(String input) throws InvalidInputException {
        String[] parts = input.split("-");
        String operations = parts[0];
        String message = parts[1];

        return performOperation(operations,message);
    }

    /**
     * This method is responsible for performing the associated
     * operation as per the operation series specified in
     * input string.
     * @param operationsList
     * @param message
     * @return
     * @throws InvalidInputException
     */
    protected String performOperation(String operationsList, String message) throws InvalidInputException {

        String result = message;
        for (Character ch: operationsList.toCharArray()) {
            Operation op = operations.get(ch);
            if(op == null){
                throw new InvalidInputException("Invalid input");
            }
            result = op.process(result);
        }
        return result;
    }


    /**
     * This method is responsible for validating the input
     * and will throw the InvalidInput Exception if required.
     * Following validation is performing by this method -
     * Input string should contain separator character (-)
     * Operation string should have 2 one digit integers. (i.e 12,42,22 etc)
     * Input string on which operations need to be perform (2nd part of the input string)
     * should not be empty.(i.e "12-")
     * @param input
     * @throws InvalidInputException
     */
    protected void InputValidator(String input) throws InvalidInputException {
        if(!input.contains("-"))
            throw  new InvalidInputException("Invalid input");

        String[] parts = input.split("-");
        String operation = parts[0];
        if(operation.length()!=2)
            throw new InvalidInputException("Invalid input");

        String messageStr = parts[1];
        if(messageStr.isEmpty())
            throw new InvalidInputException("Invalid input");

    }
}
