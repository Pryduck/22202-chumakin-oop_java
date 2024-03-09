package task1;

import org.junit.Test;
import org.task1.BullsAndCowsContainer;
import org.task1.Compare;

import static org.junit.Assert.assertEquals;

public class CompareTest {

    @Test
    public void compare() {
        Compare compare = new Compare();
        BullsAndCowsContainer actual = compare.counting(new char[]{1,2,3,4}, new char[]{5,6,7,8});
        BullsAndCowsContainer expected = new BullsAndCowsContainer(0,0);
        assertEquals(expected.getBulls(), actual.getBulls());
        assertEquals(expected.getCows(), actual.getCows());

        actual = compare.counting(new char[]{1,2,3,4}, new char[]{1,2,4,5});
        expected = new BullsAndCowsContainer(2,1);
        assertEquals(expected.getBulls(), actual.getBulls());
        assertEquals(expected.getCows(), actual.getCows());
    }

}