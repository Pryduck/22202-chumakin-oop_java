package danich.factory.Suppliers;
import danich.factory.Subjects.Motor;
import danich.factory.ID.IDAssignor;
import danich.factory.Warehouses.Warehouse;

public class MotorsSupplier extends Supplier<Motor> {

    public MotorsSupplier(int period, Warehouse<Motor> warehouse) {
        super(period, warehouse);
    }

    @Override
    public void deliver() throws InterruptedException {
        sleep(period);
        warehouse.put(new Motor(IDAssignor.generateId()));
    }
}
