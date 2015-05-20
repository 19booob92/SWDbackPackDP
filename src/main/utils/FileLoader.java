package main.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import main.core.dto.Parameters;


public class FileLoader {

    public static List<String> readFile(String name) throws Exception {
        List<String> lines = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        try {
            String line = br.readLine();

            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
        } finally {
            br.close();
            return lines;
        }
    }


}
