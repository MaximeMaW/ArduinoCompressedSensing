package compsens;

// Several helper functions to write/load config files
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    public String writeConfig(String path) {
	Properties prop = new Properties();
	OutputStream output = null;
	try {
	    output = new FileOutputStream(path);
	    // set the properties value
	    prop.setProperty("basis", "./data/basis.csv");
	    prop.setProperty("outfolder", "./out/");
	    // save properties to project root folder
	    prop.store(output, null);
	} catch (IOException io) {
	    io.printStackTrace();
	} finally {
	    if (output != null) {
		try {
		    output.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	return "-- should return something interesting here";
    }

    public Properties readConfig(String path) {
	Properties prop = new Properties();
	InputStream input = null;
	
	try {
	    input = new FileInputStream(path);
	    // load a properties file
	    prop.load(input);
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
	    if (input != null) {
		try {
		    input.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	return prop;
    }
}
