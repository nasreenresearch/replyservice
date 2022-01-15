package com.beta.helper.operation;

import com.beta.error.InvalidInputException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MD5EncodeOperation.class)
public class MD5EncodeOperationTest {

    @Autowired
    private MD5EncodeOperation md5EncodeOperation;

    @Test
    public void MD5HashTest1() throws InvalidInputException {
        assertEquals(md5EncodeOperation.process("kbzw9ru"), "0fafeaae780954464c1b29f765861fad");
    }

    @Test
    public void MD5HashTest2() throws InvalidInputException {
        assertEquals(md5EncodeOperation.process("hello world"), "5eb63bbbe01eeed093cb22bb8f5acdc3");
    }
}
