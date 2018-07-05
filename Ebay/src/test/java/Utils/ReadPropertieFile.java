package Utils;

import java.util.*;
import java.io.*;

public class ReadPropertieFile {

	public Properties LoadPropertiess() throws IOException {

		String propfilepath = "config.properties";
		Properties p = new Properties();
		p.load(new FileInputStream(propfilepath));

		return p;
	}
}