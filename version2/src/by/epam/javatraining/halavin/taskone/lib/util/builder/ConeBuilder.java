package by.epam.javatraining.halavin.taskone.lib.util.builder;

import by.epam.javatraining.halavin.taskone.lib.bean.Cone;
import by.epam.javatraining.halavin.taskone.lib.bean.Dot;
import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;
import by.epam.javatraining.halavin.taskone.lib.util.impl.ShapeBuilder;

public class ConeBuilder implements ShapeBuilder {
	private Dot[] dots;
	private Cone cone;

	{
		dots = new Dot[3];
	}

	public ConeBuilder() {}

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

	public Shape getResult(String line) {
		String[] str = line.split("\\s+");

		for (int i = 0, j = 0; i < str.length; i += 3, j++) {
			dots[j] = new Dot();
			dots[j].setX(Double.parseDouble(str[i]));
			dots[j].setY(Double.parseDouble(str[i + 1]));
			dots[j].setZ(Double.parseDouble(str[i + 2]));
		}
		cone = new Cone();
		appendCenterDot(dots[0]);
		appendRadDot(dots[1]);
		appendTopDot(dots[2]);

		return cone;
	}
}
