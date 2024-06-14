package danich.factory.Suppliers;
import danich.factory.Subjects.Accessory;
import danich.factory.ID.IDAssignor;
import danich.factory.Warehouses.Warehouse;

public class AccessoriesSupplier extends Supplier<Accessory> {

    public AccessoriesSupplier(int period, Warehouse<Accessory> warehouse) {
        super(period, warehouse);
    }

    @Override
    public void deliver() throws InterruptedException {
        sleep(period);
        warehouse.put(new Accessory(IDAssignor.generateId()));
    }
}

