package task1;

import org.junit.Test;
import org.task1.Check;

import static org.junit.Assert.assertEquals;

public class CheckTest {

    @Test
    public void sizeCheck() {
        //Check check = new Check();
        int actual = Check.sizeCheck(2222);
        int expected = 1;
        assertEquals(expected, actual);

        actual = Check.sizeCheck(900);
        expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    public void different() {
        //Check check = new Check();
        int actual = Check.different(new char[]{1,2,3,4});
        int expected = 1;
        assertEquals(expected, actual);

        actual = Check.different(new char[]{1,1,1,1});
        expected = 0;
        assertEquals(expected, actual);

    }
}