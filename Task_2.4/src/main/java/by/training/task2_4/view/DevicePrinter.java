package by.training.task2_4.view;

import by.training.task2_4.entity.*;

import java.util.ArrayList;
import java.util.List;

public class DevicePrinter {
    public void printDevices(List<Device> devices) {
        ArrayList<Type> typeArrayList = new ArrayList<>();
        String leftAlignFormat = "| %-4d | %-15s | %-12s | %-6d | %-8b | %-16s |%-99s |%n";

        System.out.format("+------+-----------------+--------------+--------+----------+------------------+----------------------------------------------------------------------------------------------------+%n");
        System.out.format("| ID   | Name            | ORIGIN       | Price  | Critical | Manufacture date | Types                                                                                              |%n");
        System.out.format("+------+-----------------+--------------+--------+----------+------------------+----------------------------------------------------------------------------------------------------+%n");

        for (Device device : devices) {
            typeArrayList = device.getTypes();
            StringBuilder types = new StringBuilder();
            for (Type type : typeArrayList) {
                if (type.getClass() == Type.class) {
                    types.append(" ").append(type.getName()).append(",");
                }
                if (type.getClass() == FanType.class) {
                    types.append(" ").append("fan: ").append(((FanType) type).isContainsFan()).append(",");
                }
                if (type.getClass() == PeripheralType.class) {
                    types.append(" ").append("peripheral: ").append(((PeripheralType) type).isPeripheral()).append(",");
                }
                if (type.getClass() == PowerType.class) {
                    types.append(" ").append("power: ").append(((PowerType) type).getPower()).append("watt").append(",");
                }

            }

            System.out.format(leftAlignFormat, device.getId(), device.getName(), device.getOrigin(), device.getPrice(), device.isCritical(), device.getManufactureDate(), types.toString());
        }
        System.out.format("+------+-----------------+--------------+--------+----------+------------------+----------------------------------------------------------------------------------------------------+%n");
    }
}
