package by.epam.javatraining.halavin.taskone.util.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOutput extends Output {
	private String filename;

	public FileOutput() {
		super();
	}

	public FileOutput(String info) {
		super(info);
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public void print(Object obj) {
		File file = new File(filename);
		String str = obj.toString();
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (BufferedWriter bf = new BufferedWriter(new PrintWriter(file.getAbsoluteFile()))) {

			bf.write(this.str + str);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
