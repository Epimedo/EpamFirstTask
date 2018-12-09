package by.epam.javatraining.halavin.taskone.util.Input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetDataFromFile implements GetData {

	private String FileName;

	@Override
	public String read() {
		String str = null;
		StringBuilder sb = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(FileName))) {

			while ((str = reader.readLine()) != null) {
				sb.append(str).append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

}
