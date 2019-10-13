package cz.upce.fei.inptp.zz.entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Roman
 */
public class DistanceMatrixLoader {

    private String fileName;
    private String columnSeparator = ";";

    public DistanceMatrixLoader(String fileName) {
        this.fileName = fileName;
    }

    public DistanceMatrix load() {
        try (
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String[] locations = loadLocations(bufferedReader);
            double[][] distances = loadDistances(bufferedReader, locations.length);

            return new DistanceMatrix(locations, distances);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        
        return null;
    }

    private String[] loadLocations(BufferedReader reader) throws IOException {
        String header = reader.readLine();
        String[] tokens = header.split(columnSeparator);
        return Arrays.copyOfRange(tokens, 1, tokens.length);
    }

    private double[][] loadDistances(BufferedReader reader, int numberOfLocations) throws IOException {
        double[][] distances = new double[numberOfLocations][numberOfLocations];

        for (int i = 0; i < numberOfLocations; i++) {
            String loadedLine = reader.readLine();
            String[] tokensOnLine = loadedLine.split(columnSeparator);

            for (int j = 1; j < tokensOnLine.length; j++) {
                distances[i][j - 1] = Double.parseDouble(tokensOnLine[j]);
            }
        }

        return distances;
    }

}
