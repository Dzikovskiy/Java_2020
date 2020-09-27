package by.training.task3.entity;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Ball> balls;

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public int getTotalBallsWeight() {
        int weight = 0;
        for (Ball ball : balls) {
            weight += ball.getWeight();
        }
        return weight;
    }

    public int getTotalNumberOfBallsOfColor(Color color) {
        int total = 0;
        for (Ball ball : balls) {
            if(ball.getColor().equals(color)){
                total++;
            }
        }
        return total;
    }
}
