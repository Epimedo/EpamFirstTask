package by.epam.javatraining.halavin.taskone.lib.util.factory;

import by.epam.javatraining.halavin.taskone.lib.util.builder.ConeBuilder;
import by.epam.javatraining.halavin.taskone.lib.util.builder.DotBuilder;
import by.epam.javatraining.halavin.taskone.lib.util.impl.ShapeBuilder;

public final class UtilFactory {
	private static final UtilFactory instance = new UtilFactory();
	private final ShapeBuilder shapeBuilder = new ConeBuilder();
	private final DotBuilder dotBuilder = new DotBuilder();

	private UtilFactory() {
	}

	public static UtilFactory getInstance() {
		return instance;
	}

	public ShapeBuilder getShapeBuilder() {
		return shapeBuilder;
	}

	public DotBuilder getDotBuilder() {
		return dotBuilder;
	}

}
