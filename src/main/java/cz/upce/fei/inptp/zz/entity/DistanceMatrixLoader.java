/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roman
 */
public class DistanceMatrixLoader {

    private String fileName;

    public DistanceMatrixLoader(String fileName) {
        this.fileName = fileName;
    }

    public DistanceMatrix load() {
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String header = bufferedReader.readLine();
            String[] tokens = header.split(";");
            int numberOfLocations = tokens.length-1;
            
            String[] locations = Arrays.copyOfRange(tokens, 1, tokens.length);
            double[][] distances = new double[numberOfLocations][numberOfLocations];
            
            for (int i = 0; i < numberOfLocations; i++) {
                String loadedLine = bufferedReader.readLine();
                String[] tokensOnLine = loadedLine.split(";");
                
                for (int j = 1; j < tokensOnLine.length; j++) {
                    double value = Double.parseDouble(tokensOnLine[j]);                    
                    distances[i][j-1] = value; 
                }
                
            }
            
            return new DistanceMatrix(locations, distances);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        
        return null;
    }
}
