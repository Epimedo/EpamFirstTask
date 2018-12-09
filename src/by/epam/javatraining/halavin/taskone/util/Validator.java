package by.epam.javatraining.halavin.taskone.util;

import java.util.regex.Pattern;

public class Validator {
	private static final Pattern CHECK_DOUBLE = Pattern.compile("^-?[0-9]*\\.[0-9]+$");

	public static String processCone(String str) {
		String result = "";
		boolean bool = false;

		for (String line : str.split("\\n+")) {
			if (line.split("\\s+").length == 9) {
				bool = true;
				for (String strok : line.split("\\s+")) {
					if (!CHECK_DOUBLE.matcher(strok).matches()) {
						bool = false;
						break;
					}
				}
			}
			if (bool) {
				result = line;
				break;
			}
		}
		return result;
	}

	public static String processDot(String str) {
		String result = "";
		boolean bool = false;

		for (String line : str.split("\\n+")) {
			if (line.split("\\s+").length == 3) {
				bool = true;
				for (String strok : line.split("\\s+")) {
					if (!CHECK_DOUBLE.matcher(strok).matches()) {
						bool = false;
						break;
					}
				}
			}
			if (bool) {
				result = line;
				break;
			}
		}
		return result;

	}
}
