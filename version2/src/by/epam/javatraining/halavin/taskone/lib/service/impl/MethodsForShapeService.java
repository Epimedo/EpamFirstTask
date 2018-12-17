package by.epam.javatraining.halavin.taskone.lib.service.impl;

import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;
import by.epam.javatraining.halavin.taskone.lib.service.exception.ServiceException;

public interface MethodsForShapeService {

	public double getSquare(Shape shape) throws ServiceException;

	public double getSpace(Shape shape) throws ServiceException;

	public boolean isFigure(Shape shape) throws ServiceException;

	public boolean isCoorPlane(Shape shape) throws ServiceException;

	public double getSpaceRatio(Shape shape) throws ServiceException;
}
