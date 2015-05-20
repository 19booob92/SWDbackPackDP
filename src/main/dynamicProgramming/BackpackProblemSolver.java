package main.dynamicProgramming;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import main.core.dto.Parameters;

public class BackpackProblemSolver {

    private int[][] matrix;

    private Parameters parameters;

    public BackpackProblemSolver(Parameters parameters) {
        this.parameters = parameters;
        matrix = new int[parameters.getItemsAmount()][parameters.getPackSize()];
    }

    private void solveProblem() {
        for (int itemIdx = 1; itemIdx < parameters.getItemsAmount() + 1; itemIdx++) {
            for (int b = 1; b < parameters.getPackSize() + 1; b++) {
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
        
        for (int i = parameters.getItemsAmount(); i >= 0; i--) {
            if (matrix[i][b] == matrix[i-1][b]) {
                vector.add(false);
            } else {
                vector.add(true);
                b -= parameters.getSizes().get(i-1);
            }
        }
        Collections.reverse(vector);
        
        return vector;
    }
    
}
