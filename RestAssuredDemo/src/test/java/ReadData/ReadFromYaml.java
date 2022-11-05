package ReadData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ReadFromYaml{
	public static Map<String, Object> data;

	private static Map readYaml() throws FileNotFoundException   {
		InputStream inputStream = new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ReadConfig.yaml"));
		Yaml yamlread = new Yaml();
		data = yamlread.load(inputStream);
		return data;
	}

	public static String returnyamldata(String keydata) {

		return (String) data.get(keydata);

	}



	/*public static void main(String args[]) throws FileNotFoundException {
		readYaml();
		System.out.println();
	}*/
}
