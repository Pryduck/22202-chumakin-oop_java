package danich.factory.Suppliers;

import danich.factory.Subjects.Subject;
import danich.factory.Warehouses.Warehouse;

abstract public class Supplier<T extends Subject> extends Thread {

    protected int period;
    protected final Warehouse<T> warehouse;

    public Supplier(int period, Warehouse<T> warehouse) {
        this.period = period;
        this.warehouse = warehouse;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int newPeriod) {
        if (newPeriod > 0) {
            this.period = newPeriod;
        }
    }

    public void run() {
        while (true) {
            try {
                deliver();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    abstract public void deliver() throws InterruptedException;
}
