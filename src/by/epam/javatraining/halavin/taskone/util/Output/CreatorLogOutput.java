package by.epam.javatraining.halavin.taskone.util.Output;

public class CreatorLogOutput implements Creator, EmptyCreator {

	@Override
	public Output create(String str) {
		return new LogOutput(str);
	}

	@Override
	public Output create() {
		return new LogOutput();
	}

}
