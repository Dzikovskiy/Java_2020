package by.training.task2_4.bean;

import by.training.task2_4.entity.Device;

import java.util.ArrayList;

public class DevicesBean {

    public static ArrayList<Device> devices =new ArrayList<>();
    public static String xmlPath = "";

    public static ArrayList<Device> getDevices() {
        return devices;
    }

    public static void setDevices(ArrayList<Device> devices) {
        DevicesBean.devices = devices;
    }

    public static String getXmlPath() {
        return xmlPath;
    }

    public static void setXmlPath(String xmlPath) {
        DevicesBean.xmlPath = xmlPath;
    }
}
