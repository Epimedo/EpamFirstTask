package by.epam.javatraining.halavin.taskone.lib.controller.command;

import org.testng.log4testng.Logger;

import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;
import by.epam.javatraining.halavin.taskone.lib.controller.command.impl.ShapeCommand;
import by.epam.javatraining.halavin.taskone.lib.service.exception.ServiceException;
import by.epam.javatraining.halavin.taskone.lib.service.factory.ServiceFactory;
import by.epam.javatraining.halavin.taskone.lib.service.impl.ShapeLibraryService;

public class AddShapeToFile implements ShapeCommand {
	private final Logger LOG = Logger.getLogger(AddShapeToFile.class);

	@Override
	public String execute(String request, Shape shape) {
		String responce = null;

		ServiceFactory servicefactory = ServiceFactory.getInstance();
		ShapeLibraryService shapeLibraryService = servicefactory.getShapeLibraryService();

		try {
			shapeLibraryService.addShape(shape);
			responce = "Complete";
		} catch (ServiceException e) {
			LOG.error(e);
		}
		return responce;
	}

}
