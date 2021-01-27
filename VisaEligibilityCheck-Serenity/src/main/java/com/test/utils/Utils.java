package com.test.utils;

import java.io.File;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Utils {

	public static final String CUR_DIR = System.getProperty("user.dir");
	public static final String FILE_SEPERATOR = System.getProperty("file.separator");
	private static final String ENV = CUR_DIR + FILE_SEPERATOR + "src" + FILE_SEPERATOR + "test" + FILE_SEPERATOR
			+ "resources" + FILE_SEPERATOR + "apikey.properties";
	private static File file;

	public static String getEnvironment(String key) {
		file = new File(ENV);
		PropertiesConfiguration config = null;
		try {
			config = new PropertiesConfiguration(file);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return config.getString(key);
	}

	public static String getApiKey(String key) {
		System.out.println(ENV);
		file = new File(ENV);
		PropertiesConfiguration config = null;
		try {
			config = new PropertiesConfiguration(file);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return config.getString(key);
	}

	public String endPoint(Map<String, String> params) {
		return params.keySet().stream().map(key -> key + "=" + params.get(key))
				.collect(Collectors.joining("&", "?", ""));
	}

}
