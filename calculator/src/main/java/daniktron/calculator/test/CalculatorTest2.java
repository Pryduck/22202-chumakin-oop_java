package daniktron.calculator.test;

//import org.junit.Assert;
//import org.junit.Test;
import daniktron.calculator.Calculator;
import daniktron.calculator.exceptions.StackCalcException;
import daniktron.calculator.exceptions.StackCalcTooShortStackSizeException;
import daniktron.calculator.exceptions.StackCalcVariableNotDefinedException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CalculatorTest2 {

    private static class TestDescriptor {
        public String getInput() {
            return input;
        }

        public String getAnswer() {
            return answer;
        }

        //тип Class - подтип класса StackCalcException
        public Class<? extends StackCalcException> getException() {
            return exception;
        }

        private String input;
        private String answer;
        private Class<? extends StackCalcException> exception;

        TestDescriptor(String input, String answer, Class<? extends StackCalcException> exception) {
            this.input = input;
            this.answer = answer;
            this.exception = exception;
        }

        TestDescriptor(String input, String answer) {
            this.input = input;
            this.answer = answer;
            this.exception = null;
        }
    }

    private static final TestDescriptor[] tests = {
        new TestDescriptor(
            """
            #test 1
            #testing PRINT, POP and PUSH operations
                        
            PUSH 1
            PRINT
            PUSH 2
            PRINT
                        
            POP
            PRINT
            
            """,
            "1.0\n2.0\n1.0\n"

        ),
        new TestDescriptor(
            """
            #test 2
            #testing POP on empty stack
                        
            PUSH 1
            PUSH 2
                        
            POP
            POP
            POP
            
            """,
            "",
            StackCalcTooShortStackSizeException.class
        ),
        new TestDescriptor(
            """
            #test 3
            #testing how "+" and "-" operations
            
            PUSH 10
            PUSH 40
            +
            PRINT
            #answer: 50
            
            
            PUSH 10
            PUSH 40
            -
            PRINT
            #answer: 30
            
            """,
            "50.0\n30.0\n"
        ),
        new TestDescriptor(
            """
            #test 4
            #testing DEFINE operation
                        
            DEFINE a 10
            PUSH a
            PRINT
                        
            DEFINE b 20
            PUSH b
            PRINT
                        
            DEFINE c b
            PUSH c
            PRINT
                        
            DEFINE d abracadabra
            PUSH d
            PRINT
            """,
            "10.0\n20.0\n20.0\n",
            StackCalcVariableNotDefinedException.class
        ),
        new TestDescriptor(
            """
            #test 5
            #testing SQRT
                        
            PUSH 1
            SQRT
            PRINT
                        
            PUSH 4
            SQRT
            PRINT
                        
            DEFINE value 9
            PUSH value
            SQRT
            PRINT
            """,
            "1.0\n2.0\n3.0\n"
        )

    };

    @Test
    public void testPopAndPushOperations() {

        for (final TestDescriptor test : tests) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
            boolean exceptionThrowed = false;
            try {
                //подаём на вход прописанные строки
                Calculator calc = new Calculator(new Scanner(new ByteArrayInputStream(test.getInput().getBytes())));
                calc.work();
            }
            catch (StackCalcException e) {
                exceptionThrowed = true;
                if (test.getException() == null) {
                    //не должно было, но выбросилось
                    Assert.fail("Exception caught: " + e);
                }
                else{
                    Assert.assertEquals(test.getException(), e.getClass());
                }
            }
            Assert.assertEquals(test.getAnswer(), outputStream.toString().replaceAll("\r\n", "\n"));
            //не выбросилось, но должно было
            if (!exceptionThrowed) {
                Assert.assertNull(test.getException());
            }
        }
    }
}