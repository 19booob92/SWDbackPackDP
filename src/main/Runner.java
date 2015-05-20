package main;

import main.core.dto.Parameters;
import main.dynamicProgramming.BackpackProblemSolver;


public class Runner {

    public static void main(String[] args) {
        Parameters params = new Parameters();
        
        BackpackProblemSolver solver = new BackpackProblemSolver(params);
        
        System.out.println(solver.backTracking());
    }
}
