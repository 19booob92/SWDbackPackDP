package main.dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import main.core.dto.Parameters;

public class BackpackProblemSolver {

    private int[][] matrix;

    private Parameters parameters;

    public BackpackProblemSolver(Parameters parameters) {
        this.parameters = parameters;
        matrix = new int[parameters.getItemsAmount() + 1][parameters.getPackSize() + 1];
    }

    public String getInsertetItems(List<Boolean> vector) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (Boolean isInserted : vector) {
            if (isInserted) {
                result.append(parameters.getItemsNames().get(index));
                result.append(", ");
            }
            index++;
        }
        return result.toString();
    }

    private void solveProblem() {
        for (int itemIdx = 1; itemIdx <= parameters.getItemsAmount(); itemIdx++) {
            for (int b = 1; b <= parameters.getPackSize(); b++) {
                if (b >= parameters.getSizes().get(itemIdx - 1)) {
                    matrix[itemIdx][b] = Math.max(matrix[itemIdx - 1][b - parameters.getSizes().get(itemIdx - 1)] + parameters.getPrices().get(itemIdx - 1), matrix[itemIdx - 1][b]);
                }
            }
        }
    }

    public List<Boolean> backTracking() {
        solveProblem();

        int b = parameters.getPackSize();
        List<Boolean> vector = new ArrayList<>();

        for (int i = parameters.getItemsAmount() - 1; i > 0; i--) {
            if (matrix[i][b] == matrix[i - 1][b]) {
                vector.add(false);
            } else {
                vector.add(true);
                b -= parameters.getSizes().get(i - 1);
            }
        }
        Collections.reverse(vector);

        printSteps();

        return vector;
    }

    private void printSteps() {
        for (int itemIdx = 0; itemIdx <= parameters.getItemsAmount(); itemIdx++) {
            for (int b = 0; b <= parameters.getPackSize(); b++) {
                System.out.printf("%4d", matrix[itemIdx][b]);
            }
           System.out.println();
        }
    }
}
