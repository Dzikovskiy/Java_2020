package by.training.task2_4.entity;

import lombok.Builder;
import lombok.ToString;

@ToString
public class PeripheralType extends Type {
    private boolean isPeripheral;

    @Builder
    public PeripheralType(String name, boolean isPeripheral) {
        super(name);
        this.isPeripheral = isPeripheral;
    }
}
