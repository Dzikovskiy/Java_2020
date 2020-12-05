package by.training.task2_4.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FanType extends Type {
    private final boolean isContainsFan;

    @Builder
    public FanType(String name, boolean isContainsFan) {
        super(name);
        this.isContainsFan = isContainsFan;
    }
}
