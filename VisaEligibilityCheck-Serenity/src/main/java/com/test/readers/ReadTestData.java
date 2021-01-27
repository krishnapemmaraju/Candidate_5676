package com.test.readers;

import lombok.Data;

@Data
public class ReadTestData {
	private Stage stage;
	private static ReadTestData readData;

	@Data
	public static class Stage {
		private Tourism tourism;
	}

	@Data
	public static class Tourism {
		private String nationality, reasonToStay;
	}

	public static ReadTestData readTestData() {

		return readData;
	}

}
