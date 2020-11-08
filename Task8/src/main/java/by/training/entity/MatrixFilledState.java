package by.training.entity;

public class MatrixFilledState extends MatrixState {
    private int[][] matrix;

    public MatrixFilledState(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public String matrixToString() {
        StringBuilder result = new StringBuilder();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                result.append("[").append(anInt).append("]");
            }
            result.append("\n");
        }
        return result.toString();
    }

}
