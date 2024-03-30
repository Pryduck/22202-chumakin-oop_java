package org.task1;

public class BullsAndCowsContainer {
    private int bulls, cows;

    public BullsAndCowsContainer(int bulls, int cows) {
        this.cows = cows;
        this.bulls = bulls;
    }

    public int getBulls() {
        return this.bulls;
    }

    public int getCows() {
        return this.cows;
    }
}
