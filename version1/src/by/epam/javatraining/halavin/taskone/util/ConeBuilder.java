package by.epam.javatraining.halavin.taskone.util;

import by.epam.javatraining.halavin.taskone.model.entity.Cone;
import by.epam.javatraining.halavin.taskone.model.entity.Dot;

public class ConeBuilder {
	private Dot[] dots;
	private Cone cone;

	{
		cone = new Cone();
		dots = new Dot[3];
	}

	public ConeBuilder(String line) {
		String[] str = line.split("\\s+");

		for (int i = 0, j = 0; i < str.length; i += 3, j++) {
			dots[j] = new Dot();
			dots[j].setX(Double.parseDouble(str[i]));
			dots[j].setY(Double.parseDouble(str[i + 1]));
			dots[j].setZ(Double.parseDouble(str[i + 2]));
		}

		appendCenterDot(dots[0]);
		appendRadDot(dots[1]);
		appendTopDot(dots[2]);
	}

	public ConeBuilder appendCenterDot(Dot dot) {
		cone.setCentreDot(dot);
		return this;
	}

	public ConeBuilder appendRadDot(Dot dot) {
		cone.setRadDot(dot);
		return this;
	}

	public ConeBuilder appendTopDot(Dot dot) {
		cone.setTopDot(dot);
		return this;
	}

	public Cone getResult() {
		return cone;
	}
}
