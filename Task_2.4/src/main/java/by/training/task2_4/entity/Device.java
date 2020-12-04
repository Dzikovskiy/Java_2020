package by.training.task2_4.entity;

import lombok.*;

import java.util.ArrayList;

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
    private String manufactureDate;
    private ArrayList<Type> types ;

}
