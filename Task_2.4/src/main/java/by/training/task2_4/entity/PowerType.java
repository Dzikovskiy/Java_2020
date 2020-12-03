package by.training.task2_4.entity;

import lombok.Builder;
import lombok.ToString;

@ToString
public class PowerType extends Type{
    private int power;

    @Builder
    public PowerType(String name, int power) {
        super(name);
        this.power = power;
    }
}
