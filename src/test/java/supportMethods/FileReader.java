package supportMethods;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class FileReader {

	public static FileInputStream readFile(String file) throws FileNotFoundException {
		return new FileInputStream(new File(file));
	}

	public static Map<String, String> readProperties() throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(readFile("src/test/resources/config.properties"));

		Map<String, String> properties = new HashMap<String, String>();

		Enumeration<?> KeyValues = prop.keys();
		while (KeyValues.hasMoreElements()) {
			String key = (String) KeyValues.nextElement();
			String value = prop.getProperty(key);
			properties.put(key, System.getProperty(key, value));
		}

		return properties;
	}

	public static void addData(String key, String val) {
		try {
			File file = new File("src/test/resources/config.properties");
			Properties properties = new Properties();
			properties.load(new FileInputStream(file));
			FileOutputStream obj = new FileOutputStream(file);
			properties.setProperty(key, val);
			properties.store(obj, "Update data into file ");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

