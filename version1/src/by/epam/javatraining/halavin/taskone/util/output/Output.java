package by.epam.javatraining.halavin.taskone.util.output;

public abstract class Output implements Printer {
	protected String str = "";

	public Output() {
		super();
	}

	public Output(String info) {
		str = info;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	abstract public void print(Object obj);
}