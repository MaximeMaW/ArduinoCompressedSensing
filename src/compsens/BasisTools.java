package compsens;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.io.IOException;
import java.io.FileNotFoundException;

import com.opencsv.CSVReader;
 
public class BasisTools {
    // Wrapper to take care of the exceptions
    public double[][] readBasis(String path) {
	// Get CSV and convert it to the right format. No checks are made.
	try {
	    List<String[]> lines = readAll(path);
	    String basisString[][] = lines.toArray(new String[lines.size()][]);
	    double basis[][] = new double[basisString[0].length-1][basisString.length-1];

	    for (int i=1; i<basisString.length; i++) {
		for (int j=1; j<basisString[0].length; j++) {
		    basis[j-1][i-1] = Double.parseDouble(basisString[i][j]);
		}
	    }
	    return basis;
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return EMPTY_ARRAY;
    }
    /*
        Returns a "unique identifier of the basis
    */
    public int hashBasis(double basis[][]) {
        String vec;
        vec = "";
        for (double[] basi : basis) {
            for (int i=0; i<basis[0].length; i++){
                vec = vec + basi[i];
            }        
        }
        return(vec.hashCode());
    }
    
    // Actually read the CSV file
    private static List readAll(String path) throws IOException {
	CSVReader csvReader = new CSVReader(new FileReader(path));
	List<String[]> lines = csvReader.readAll();
	csvReader.close();
	return lines;
    }

    private static final double[][] EMPTY_ARRAY = {{},};
}
