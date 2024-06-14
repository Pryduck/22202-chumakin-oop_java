package danich.factory.ID;


public class IDAssignor {

    private static long last = 0;
    synchronized public static long generateId() {
        return last++;
    }
}
