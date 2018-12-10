package by.epam.javatraining.halavin.taskone.util.Output;

public enum InfoForFile {
	FILENAMEOUTPUT("output/output first task.txt");

	private String str;

	private InfoForFile(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}
}
