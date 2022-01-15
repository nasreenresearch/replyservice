package com.beta.helper;


import com.beta.error.InvalidInputException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReplyServiceImpl.class)
public class ReplyServiceImplTest {

    @Autowired
    private ReplyService replyService;


    /**  Tests cases for valid inputs  **/

    @Test
    public void replyTest1WithValidInput() throws InvalidInputException {
        assertEquals(replyService.reply("12-kbzw9ru").getMessage(), "5a8973b3b1fafaeaadf10e195c6e1dd4");
    }

    @Test
    public void replyTest2WithValidInput() throws InvalidInputException {
        assertEquals(replyService.reply("21-kbzw9ru").getMessage(), "daf168567f92b1c464459087eaaefaf0");
    }

    @Test
    public void replyTest3WithValidInput() throws InvalidInputException {
        assertEquals(replyService.reply("11-kbzw9ru").getMessage(), "kbzw9ru");
    }

    @Test
    public void replyTest4WithValidInput() throws InvalidInputException {
        assertEquals(replyService.reply("22-kbzw9ru").getMessage(), "e8501e64cf0a9fa45e3c25aa9e77ffd5");
    }


    /**  Tests cases for invalid inputs  **/

    @Test(expected = InvalidInputException.class)
    public void replyTest1WithInvalidInput() throws InvalidInputException {
        replyService.reply("122-kbzw9ru");
    }

    @Test(expected = InvalidInputException.class)
    public void replyTest2WithInvalidInput() throws InvalidInputException {
        replyService.reply("13-kbzw9ru");
    }

    @Test(expected = InvalidInputException.class)
    public void replyTest3WithInvalidInput() throws InvalidInputException {
        replyService.reply("12--kbzw9ru");
    }

    @Test(expected = InvalidInputException.class)
    public void replyTest4WithInvalidInput() throws InvalidInputException {
        replyService.reply("1-kbzw9ru");
    }

    @Test(expected = InvalidInputException.class)
    public void replyTest5WithInvalidInput() throws InvalidInputException {
        replyService.reply("-kbzw9ru");
    }
}