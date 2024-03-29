package task1;

import org.junit.Test;
import org.task1.Check;

import static org.junit.Assert.assertEquals;

public class CheckTest {

    @Test
    public void sizeCheck() {
        //Check check = new Check();
        boolean actual = new Check(2222).sizeCheck();
        boolean expected = true;
        assertEquals(expected, actual);

        actual = new Check(900).sizeCheck();
        expected = false;
        assertEquals(expected, actual);

    }

    @Test
    public void different() {
        //Check check = new Check();
        boolean actual = new Check(1234).different();
        boolean expected = true;
        assertEquals(expected, actual);

        actual = new Check(1111).different();
        expected = false;
        assertEquals(expected, actual);

    }
}