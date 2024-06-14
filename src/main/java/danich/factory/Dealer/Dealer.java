package danich.factory.Dealer;

import danich.factory.Subjects.Car;
import danich.factory.ControllerWarehouseFinCars.Controller;
import danich.factory.SingletonLogger;
import danich.factory.ID.IDAssignor;

import java.text.MessageFormat;
import java.util.logging.Level;

public class Dealer extends Thread {
    protected long id;
    protected int period;
    protected final Controller warehouseController;

    private static final SingletonLogger logger = new SingletonLogger("DealerLog", "log.txt");

    private boolean log;

    public Dealer(int period, Controller warehouseController, boolean log) {
        this.id = IDAssignor.generateId();
        this.warehouseController = warehouseController;
        this.period = period;
        this.log = log;
    }

    public Dealer(int period, Controller warehouseController) {
        this(period, warehouseController, false);
    }

    public int getSpeed() {
        return this.period;
    }

    public void run() {
        while (true) {
            try {
                Car car = orderCar();
                if (log) {
                    String msg = MessageFormat.format("Dealer {0} : Auto {1} : (Body: {2}, Motor {3}, Accessory {4})",
                            id, car.getId(), car.getBody().getId(), car.getMotor().getId(), car.getAccessory().getId());
                    logger.getLogger().log(Level.INFO, msg);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Car orderCar() throws InterruptedException {
        sleep(period);
        synchronized (warehouseController) {
            warehouseController.notify();
        }
        return (Car) warehouseController.getCarWarehouse().get();
    }

    public void setSpeed(int period) {
        this.period = period;
    }

}
