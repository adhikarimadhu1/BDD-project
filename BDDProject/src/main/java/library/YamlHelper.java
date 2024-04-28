package library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlHelper {
	private String file;
	private Map<Integer, Map<String, String>> dataCurrent;
	private Map<String, String> dataFinal;
 
	public YamlHelper() {
		file = "resources/regression.yaml";
	}
 
	public Map<Integer, Map<String, String>> getCurrentData() throws FileNotFoundException {
		Yaml yaml = new Yaml();
		FileInputStream input = new FileInputStream(file);
		dataCurrent = yaml.load(input);
		return dataCurrent;
	}
 
	public Map<String, String> getFinalData(Integer key) throws FileNotFoundException {
		dataFinal = getCurrentData().get(key);
		return dataFinal;
 
	}


}
