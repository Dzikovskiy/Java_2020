package by.training.task2_4.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@Builder
@ToString
public class Device {
    private int id;
    private String name;
    private String origin;
    private int price;
    private boolean critical;
    private Date manufacture_date;
    private ArrayList<Type> types ;

}
