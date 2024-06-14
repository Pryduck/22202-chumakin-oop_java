package danich.factory.Suppliers;

import danich.factory.Subjects.Body;
import danich.factory.ID.IDAssignor;
import danich.factory.Warehouses.Warehouse;

public class BodiesSupplier extends Supplier<Body> {

    public BodiesSupplier(int period, Warehouse<Body> warehouse) {
        super(period, warehouse);
    }

    @Override
    public void deliver() throws InterruptedException {
        sleep(period);
        warehouse.put(new Body(IDAssignor.generateId()));
    }
}
