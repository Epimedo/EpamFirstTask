package by.epam.javatraining.halavin.taskone.lib.dao;

public enum InfoForFile {
	FILENAMEOUTPUT("output/output first task.txt"),FILENAMERESULT("output/result.txt");

	private String str;

	private InfoForFile(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}
}
