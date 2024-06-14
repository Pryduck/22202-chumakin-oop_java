package danich.factory.ControllerWarehouseFinCars;
import danich.factory.Warehouses.CarsWarehouse;

public class Controller extends Thread {

    protected final CarsWarehouse warehouse;
    protected final TasksDistribution tasksDistribution;
    protected int criticalSize;

    public Controller(CarsWarehouse warehouse, TasksDistribution tasksDistribution, int criticalSize) {
        this.warehouse = warehouse;
        this.criticalSize = criticalSize;
        this.tasksDistribution = tasksDistribution;
    }

    public Controller(CarsWarehouse warehouse, TasksDistribution tasksDistribution) {
        this(warehouse, tasksDistribution, 5);
    }
    public CarsWarehouse getCarWarehouse() {
        return warehouse;
    }

    public synchronized void run() {
        while (true) {
            try {
                wait();
                synchronized (warehouse) {
                    if (warehouse.getCurrentSize() < criticalSize) {
                        tasksDistribution.addTasks((criticalSize - warehouse.getCurrentSize()) * 2);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
