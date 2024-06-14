package danich.factory.ControllerWarehouseFinCars;
import danich.factory.Warehouses.WarehousesMap;
import danich.threadpool.BlockingQueue;
import danich.threadpool.ThreadPool;

public class TasksDistribution {

    protected WarehousesMap warehouses;
    protected BlockingQueue<Runnable> tasks;

    protected ThreadPool workers;

    public TasksDistribution(int workersNum, WarehousesMap warehouses) {
        this.warehouses = warehouses;
        this.tasks = new BlockingQueue<>();
        this.workers = new ThreadPool(workersNum, tasks);
        this.workers.start();
    }

    public void addTasks(int num) {
        for (int i = 0; i < num; i++) {
            tasks.put(new CarAssembly(warehouses));
        }
    }

}
