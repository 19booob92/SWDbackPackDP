package main;

import java.util.List;
import javax.swing.JOptionPane;
import main.core.dto.Parameters;
import main.dynamicProgramming.BackpackProblemSolver;
import main.utils.FileLoader;
import main.utils.InputDataProcessor;

public class Runner {

    public static void main(String[] args) throws Exception {
        InputDataProcessor dataProcessor = new InputDataProcessor();
        Parameters params;

        try {
            List<String> data = FileLoader.readFile("/home/booob/Documents/workspace-sts-3.5.1.RELEASE/SWDProblemPlecakowy/resources/wagi.txt");
            params = dataProcessor.processData(data);
          
            BackpackProblemSolver solver = new BackpackProblemSolver(params);

            System.out.println(solver.backTracking());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Nie odnaleziono pliku");
            System.err.println(ex);
        }
        
    }
}
