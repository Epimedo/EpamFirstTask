package by.epam.javatraining.halavin.taskone.util.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import by.epam.javatraining.halavin.taskone.util.output.CreatorLogOutput;
import by.epam.javatraining.halavin.taskone.util.output.Output;

public class GetDataFromFile implements GetData {

	private String fileName;

	@Override
	public String read() {
		Path path = Paths.get(fileName);
		StringBuilder sb = new StringBuilder();
		
		try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {

			lineStream.forEach(s->sb.append(s).append("\n"));

		} catch (IOException e) {
			Output out = new CreatorLogOutput().create();
			out.print(e.getMessage());
		}

		return sb.toString();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
