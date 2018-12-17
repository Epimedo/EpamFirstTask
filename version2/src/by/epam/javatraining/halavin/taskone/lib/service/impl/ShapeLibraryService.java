package by.epam.javatraining.halavin.taskone.lib.service.impl;

import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;
import by.epam.javatraining.halavin.taskone.lib.service.exception.ServiceException;

public interface ShapeLibraryService {

	public void addShape(Shape shape) throws ServiceException;
}
