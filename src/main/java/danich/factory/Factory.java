package danich.factory;

import danich.factory.Dealer.Dealer;
import danich.factory.Warehouses.*;
import danich.factory.service.Observer;
import danich.factory.ControllerWarehouseFinCars.Controller;
import danich.factory.ControllerWarehouseFinCars.TasksDistribution;
import danich.factory.ConfigReader.ConfigReader;
import danich.factory.Suppliers.AccessoriesSupplier;
import danich.factory.Suppliers.BodiesSupplier;
import danich.factory.Suppliers.MotorsSupplier;
import danich.view.actions.*;
import danich.view.actions.Event;
import danich.view.OutputScreen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Factory extends JFrame implements Runnable, Observer {


    public final ArrayList<Dealer> dealers;
    public final Settings settings;
    public final ArrayList<AccessoriesSupplier> accessoriesSuppliers;
    public final BodiesSupplier bodiesSupplier;
    public final MotorsSupplier motorsSupplier;

    public final WarehousesMap warehouses;
    public final Controller controller;

    public Factory(ConfigReader configReader, Settings settings) {
        this.settings = settings;
        CarsWarehouse carsWarehouse = new CarsWarehouse(configReader.get(ConfigReader.Settings.storageAutoSize));
        BodiesWarehouse bodiesWarehouse = new BodiesWarehouse(configReader.get(ConfigReader.Settings.storageBodySize));
        MotorsWarehouse motorsWarehouse = new MotorsWarehouse(configReader.get(ConfigReader.Settings.storageMotorSize));
        AccessoriesWarehouse accessoriesWarehouse = new AccessoriesWarehouse(configReader.get(ConfigReader.Settings.storageAccessorySize));

        accessoriesSuppliers = new ArrayList<>();
        for (int i = 0; i < configReader.get(ConfigReader.Settings.accessorySuppliers); i++) {
            accessoriesSuppliers.add(new AccessoriesSupplier(settings.accessoriesSupplierSpeed, accessoriesWarehouse));
        }

        bodiesSupplier = new BodiesSupplier(settings.bodiesSupplierSpeed, bodiesWarehouse);
        motorsSupplier = new MotorsSupplier(settings.motorsSupplierSpeed, motorsWarehouse);

        warehouses = new WarehousesMap(motorsWarehouse, bodiesWarehouse, accessoriesWarehouse, carsWarehouse);

        TasksDistribution tasksDistribution = new TasksDistribution(configReader.get(ConfigReader.Settings.workers), warehouses);
        controller = new Controller(carsWarehouse, tasksDistribution);

        dealers = new ArrayList<>();
        boolean log = configReader.get(ConfigReader.Settings.logSale) == 1;
        for (int i = 0; i < configReader.get(ConfigReader.Settings.dealers); i++) {
            if (log) {
                dealers.add(new Dealer(settings.dealerPeriod, controller, true));
            } else {
                dealers.add(new Dealer(settings.dealerPeriod, controller));
            }
        }
    }

    public void run() {

        for (AccessoriesSupplier supplier : accessoriesSuppliers) {
            supplier.start();
        }

        bodiesSupplier.start();
        motorsSupplier.start();


        for (Dealer dealer : dealers) {
            dealer.start();
        }

        controller.start();
    }

    public static void main(String[] args) {
        ConfigReader configReader = new ConfigReader();
        Settings settings = new Settings(5000, 2000, 3000, 10000);
        Factory factory = new Factory(configReader, settings);
        OutputScreen outputScreen = new OutputScreen(factory);
        factory.setSize(new Dimension(600, 650));
        factory.setTitle("factory");
        factory.getContentPane().add(outputScreen);
        factory.setVisible(true);
        factory.setDefaultCloseOperation(EXIT_ON_CLOSE);
        factory.setResizable(false);
        settings.addObserver(factory);;
        factory.run();
    }

    @Override
    public void notify(Event event) {
        if (event instanceof AccessoriesSupAction) {
            this.settings.accessoriesSupplierSpeed = event.value * 1000;
            for (AccessoriesSupplier supplier : accessoriesSuppliers) {
                supplier.setPeriod(this.settings.accessoriesSupplierSpeed);
            }
        } else if (event instanceof BodySupAction) {
            this.settings.bodiesSupplierSpeed = event.value * 1000;
            bodiesSupplier.setPeriod(this.settings.bodiesSupplierSpeed);
        } else if (event instanceof DealerAction) {
            this.settings.dealerPeriod = event.value * 1000;
            for (Dealer dealer : dealers) {
                dealer.setSpeed(this.settings.dealerPeriod);
            }
        } else if (event instanceof MotorSupAction) {
            this.settings.motorsSupplierSpeed = event.value * 1000;
            motorsSupplier.setPeriod(this.settings.motorsSupplierSpeed);
        }
    }
}
