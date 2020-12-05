package by.training.task2_4.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PowerType extends Type {
    private final int power;

    @Builder
    public PowerType(String name, int power) {
        super(name);
        this.power = power;
    }
}
