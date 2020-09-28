package by.training.task3.entity;


import java.util.Comparator;

public class Ball {

    private Color color;
    private int weight;
    private int price;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        if (weight != ball.weight) return false;
        if (price != ball.price) return false;
        return color == ball.color;
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + weight;
        result = 31 * result + price;
        return result;
    }

    public static Comparator<Ball> priceComparator = new Comparator<Ball>() {
        @Override
        public int compare(Ball b1, Ball b2) {
            return (Integer.compare(b1.getPrice(), b2.getPrice()));
        }
    };

    public static Comparator<Ball> weightComparator = new Comparator<Ball>() {
        @Override
        public int compare(Ball b1, Ball b2) {
            return (Integer.compare(b1.getWeight(), b2.getWeight()));
        }
    };

    @Override
    public String toString() {
        return "Ball{" +
                "color=" + color +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

}
