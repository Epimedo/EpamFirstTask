package by.epam.javatraining.halavin.taskone.util.input;

public class CreaterDataGet {

	public GetData create(String filename) {
		GetDataFromFile in = new GetDataFromFile();
		in.setFileName(filename);
		return in;
	}
}
