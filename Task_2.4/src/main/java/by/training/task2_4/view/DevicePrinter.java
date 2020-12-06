package by.training.task2_4.view;

import by.training.task2_4.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DevicePrinter {
    private static final Logger logger = LogManager.getLogger();

    /**
     * Method for printing List of devices to the console table
     *
     * @param devices List of devices
     */
    public void printDevices(List<Device> devices) {
        ArrayList<Type> typeArrayList = new ArrayList<>();
        String leftAlignFormat = "| %-4d | %-15s | %-12s | %-6d | %-8b | %-16s |%-99s |%n";
        String delimiter = "+------+-----------------+--------------+--------+----------+------------------+----------------------------------------------------------------------------------------------------+%n";

        System.out.format(delimiter);
        System.out.format("| ID   | Name            | ORIGIN       | Price  | Critical | Manufacture date | Types                                                                                              |%n");
        System.out.format(delimiter);

        for (Device device : devices) {
            typeArrayList = device.getTypes();
            String types = typesToString(typeArrayList);

            System.out.format(leftAlignFormat, device.getId(), device.getName(), device.getOrigin(), device.getPrice(), device.isCritical(), device.getManufactureDate(), types);
        }
        System.out.format(delimiter);
    }

    /**
     * Method for translating list of types into String separated by ","
     *
     * @param typesList given Types
     * @return String of types
     */
    public static String typesToString(List<Type> typesList) {
        StringBuilder types = new StringBuilder();

        logger.debug(typesList);

        for (Type type : typesList) {
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
        return types.toString();
    }
}
