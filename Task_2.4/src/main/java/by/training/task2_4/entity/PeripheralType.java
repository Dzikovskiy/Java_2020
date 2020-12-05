package by.training.task2_4.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PeripheralType extends Type {
    private final boolean isPeripheral;

    @Builder
    public PeripheralType(String name, boolean isPeripheral) {
        super(name);
        this.isPeripheral = isPeripheral;
    }
}
