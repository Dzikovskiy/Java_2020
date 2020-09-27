package by.training.task3.entity;

public enum Color {
    RED("red"),
    BLUE("blue"),
    GREEN("green"),
    BLACK("black"),
    WHITE("white");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Color{" +
                "color='" + color + '\'' +
                '}';
    }

}
