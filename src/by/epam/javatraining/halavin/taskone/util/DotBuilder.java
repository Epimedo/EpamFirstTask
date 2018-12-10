package by.epam.javatraining.halavin.taskone.util;

import by.epam.javatraining.halavin.taskone.model.entity.Dot;

public class DotBuilder {
	private Dot dot;

	{
		dot = new Dot();
	}

	public DotBuilder(String line) {
		String[] str = line.split("\\s+");

		appendX(Double.parseDouble(str[0]));
		appendY(Double.parseDouble(str[1]));
		appendZ(Double.parseDouble(str[2]));
	}

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

	public Dot getResult() {
		return dot;
	}
}
