package by.training.task2_4.entity;

import lombok.Builder;
import lombok.ToString;

@ToString
public class FanType extends Type {
    private final boolean isContainsFan;

    @Builder
    public FanType(String name, boolean isContainsFan) {
        super(name);
        this.isContainsFan = isContainsFan;
    }
}
