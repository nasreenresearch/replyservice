package com.beta.helper.operation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StringReverseOperation.class)
public class StringReverseOperationTest {

    @Autowired
    private StringReverseOperation stringReverseOperation;

    @Test
    public void StringReverseOperationTest1() {
        assertEquals(stringReverseOperation.process("kbzw9ru"), "ur9wzbk");
    }

    @Test
    public void StringReverseOperationTest2() {
        assertEquals(stringReverseOperation.process("helloworld"), "dlrowolleh");
    }

}