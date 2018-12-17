package by.epam.javatraining.halavin.taskone.lib.service.factory;

import by.epam.javatraining.halavin.taskone.lib.service.ConeLibraryService;
import by.epam.javatraining.halavin.taskone.lib.service.MethodsForConeService;
import by.epam.javatraining.halavin.taskone.lib.service.impl.MethodsForShapeService;
import by.epam.javatraining.halavin.taskone.lib.service.impl.ShapeLibraryService;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	private final ShapeLibraryService shapeLibraryService = new ConeLibraryService();
	private final MethodsForShapeService methodsForShapeService = new MethodsForConeService();

	private ServiceFactory() {}

	public ShapeLibraryService getShapeLibraryService() {
		return shapeLibraryService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public MethodsForShapeService getMethodsForShapeService() {
		return methodsForShapeService;
	}

}
