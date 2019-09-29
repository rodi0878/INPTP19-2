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
    
    private String fiennm;

    public DistanceMatrixLoader(String fiennm) {
        this.fiennm = fiennm;
    }
    
    public DistanceMatrix load() {
        try {
            FileReader fr = new FileReader(fiennm);
            BufferedReader br = new BufferedReader(fr);
            
            String header = br.readLine();
            String[] tokens = header.split(";");
            int locations = tokens.length-1;
            
            String[] locationss = Arrays.copyOfRange(tokens, 1, tokens.length);
            double[][] dista = new double[locations][locations];
            
            for (int i = 0; i < locations; i++) {
                String l = br.readLine();
                String[] tokens2 = l.split(";");
                
                for (int j = 1; j < tokens2.length; j++) {
                    double val = Double.parseDouble(tokens2[j]);
                    
                    dista[i][j-1] = val; 
                }
                
            }
            
            return new DistanceMatrix(locationss, dista);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        
        return null;
    }
}
