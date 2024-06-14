package danich.view;

import danich.factory.Factory;
import danich.factory.Warehouses.WarehousesMap;
import danich.view.sliderwork.AccessoriesSlider;
import danich.view.sliderwork.BodySlider;
import danich.view.sliderwork.DealerSlider;
import danich.view.sliderwork.MotorSlider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

public class OutputScreen extends JPanel implements ActionListener {
    private final Factory factory;

    public OutputScreen(Factory factory) {
        this.factory = factory;
        this.setBackground(new Color(255, 255, 0));

        AccessoriesSlider l1 = new AccessoriesSlider();
        BodySlider l2 = new BodySlider();
        DealerSlider l3 = new DealerSlider();
        MotorSlider l4 = new MotorSlider();

        l1.addObserver(factory.settings);
        l2.addObserver(factory.settings);
        l3.addObserver(factory.settings);
        l4.addObserver(factory.settings);

        SliderArea accessoriesSupplierSlider = new SliderArea(l1, factory.accessoriesSuppliers.get(0).getPeriod() / 1000, "Accessories suppliers period (sec)");
        SliderArea bodiesSupplierSlider = new SliderArea(l2, factory.bodiesSupplier.getPeriod() / 1000, "Bodies supplier period (sec)");
        SliderArea dealerSlider = new SliderArea(l3, factory.dealers.get(0).getSpeed() / 1000, "Dealers period (sec)");
        SliderArea motorsSupplierSlider = new SliderArea(l4, factory.motorsSupplier.getPeriod() / 1000, "Motors supplier period (sec)");

        accessoriesSupplierSlider.setLocation(0, 0);
        bodiesSupplierSlider.setLocation(350, 350);
        dealerSlider.setLocation(0, 0);
        motorsSupplierSlider.setLocation(0, 0);

        this.add(accessoriesSupplierSlider);
        this.add(bodiesSupplierSlider);
        this.add(dealerSlider);
        this.add(motorsSupplierSlider);
        Timer timer = new Timer(100, this);
        timer.start();

    }

    private String getData() {
        String text = "";
        WarehousesMap warehouses = factory.warehouses;
        if (warehouses != null) {
            text += "Аксессуаров поставлено: " + warehouses.get(WarehousesMap.WarehouseNames.accessories).getTotalProduced() + '\n';
            text += "Кузовов поставлено: " + warehouses.get(WarehousesMap.WarehouseNames.bodies).getTotalProduced() + '\n';
            text += "Деталей поставлено: " + warehouses.get(WarehousesMap.WarehouseNames.motors).getTotalProduced() + "\n\n";

            text += "Аксессуаров на складе: " + warehouses.get(WarehousesMap.WarehouseNames.accessories).getCurrentSize() + '\n';
            text += "Кузовов на складе: " + warehouses.get(WarehousesMap.WarehouseNames.bodies).getCurrentSize() + '\n';
            text += "Деталей на складе: " + warehouses.get(WarehousesMap.WarehouseNames.motors).getCurrentSize() + "\n\n";

            text += "Машин собрано: " + warehouses.get(WarehousesMap.WarehouseNames.cars).getTotalProduced() + '\n';
            text += "Машин на складе: " + warehouses.get(WarehousesMap.WarehouseNames.cars).getCurrentSize() + "\n";

        }
        return text;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        String data = getData();
        Graphics2D graphics2D = (Graphics2D) g;
        FontRenderContext frc = graphics2D.getFontRenderContext();
        Font font = new Font("Helvetica", Font.ITALIC, 30);
        TextLayout layout = new TextLayout(data, font, frc);

        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(font);
        String[] outputs = data.split("\n");
        for (int i = 0; i < outputs.length; i++) {
            graphics2D.drawString(outputs[i], 50, (int) (300 + i * layout.getBounds().getHeight() + 1));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
