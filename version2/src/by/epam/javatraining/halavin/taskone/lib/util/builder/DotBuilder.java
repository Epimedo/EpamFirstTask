package by.epam.javatraining.halavin.taskone.lib.util.builder;

import by.epam.javatraining.halavin.taskone.lib.bean.Dot;

public class DotBuilder {
	private Dot dot;

	public DotBuilder() {}

	public DotBuilder appendX(double x) {
		dot.setX(x);
		return this;
	}

	public DotBuilder appendY(double y) {
		dot.setY(y);
		return this;
	}

	public DotBuilder appendZ(double z) {
		dot.setZ(z);
		return this;
	}

	public Dot getResult(String line) {
		String[] str = line.split("\\s+");

		dot = new Dot();
		
		appendX(Double.parseDouble(str[0]));
		appendY(Double.parseDouble(str[1]));
		appendZ(Double.parseDouble(str[2]));
		
		return dot;
	}
}
