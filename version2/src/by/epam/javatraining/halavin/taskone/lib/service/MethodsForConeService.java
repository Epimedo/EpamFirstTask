package by.epam.javatraining.halavin.taskone.lib.service;

import by.epam.javatraining.halavin.taskone.lib.bean.Cone;
import by.epam.javatraining.halavin.taskone.lib.bean.exception.BeanException;
import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;
import by.epam.javatraining.halavin.taskone.lib.service.exception.ServiceException;
import by.epam.javatraining.halavin.taskone.lib.service.impl.MethodsForShapeService;

public class MethodsForConeService implements MethodsForShapeService {

	@Override
	public double getSquare(Shape shape) throws ServiceException {
		if (shape == null) {
			throw new ServiceException("Input shape is empty");
		}
		if (!isFigure(shape)) {
			throw new ServiceException("Input figure isn't cone.");
		}
		Cone cone = (Cone) shape;
		double square = 0;

		try {

			square = Math.PI * cone.getRadius() * (cone.getRadius() + cone.getForming());

		} catch (BeanException e) {
			throw new ServiceException(e);
		}

		return square;
	}

	@Override
	public double getSpace(Shape shape) throws ServiceException {
		if (shape == null) {
			throw new ServiceException("Input shape is empty");
		}
		if (!isFigure(shape)) {
			throw new ServiceException("Input figure isn't cone.");
		}
		Cone cone = (Cone) shape;
		double space = 0;

		try {

			space = cone.getHeight() / 3 * Math.pow(cone.getRadius(), 2.) * Math.PI;

		} catch (BeanException e) {
			throw new ServiceException(e);
		}

		return space;
	}

	@Override
	public boolean isFigure(Shape shape) throws ServiceException {
		if (shape == null) {
			throw new ServiceException("Input shape is empty");
		}
		if (shape.getClass() != Cone.class) {
			throw new ServiceException("Incorrect object type");
		}
		Cone cone = (Cone) shape;

		try {
			if (cone.getForming() == Math.sqrt(Math.pow(cone.getHeight(), 2.) + Math.pow(cone.getRadius(), 2.))) {

				return true;
			}
		} catch (BeanException e) {
			throw new ServiceException(e);
		}

		return false;
	}

	@Override
	public boolean isCoorPlane(Shape shape) throws ServiceException {
		if (shape == null) {
			throw new ServiceException("Input shape is empty");
		}
		if (!isFigure(shape)) {
			throw new ServiceException("Input figure isn't cone.");
		}
		boolean bool = false;
		Cone cone = (Cone) shape;

		try {
			if (cone.getCentreDot().getX() == 0 || cone.getCentreDot().getY() == 0 || cone.getCentreDot().getZ() == 0) {
				bool = true;
			}
		} catch (BeanException e) {
			throw new ServiceException(e);
		}

		return bool;
	}

	@Override
	public double getSpaceRatio(Shape shape) throws ServiceException {
		if (shape == null) {
			throw new ServiceException("Input shape is empty");
		}
		if (!isFigure(shape)) {
			throw new ServiceException("Input figure isn't cone.");
		}
		Cone cone = (Cone) shape;

		double ratio = -1;
		double newHeight = 0;
		double newRadius = 0;
		double plate1 = 0;
		double plate2 = 0;

		try {
			if (cone.getCentreDot().getX() == cone.getRadDot().getX()
					&& Math.abs(cone.getCentreDot().getX() - cone.getTopDot().getX()) == cone.getHeight()
					&& ((cone.getCentreDot().getX() > 0 && cone.getTopDot().getX() < 0)
							|| (cone.getCentreDot().getX() < 0 && cone.getTopDot().getX() > 0))) {
				newHeight = Math.abs(cone.getCentreDot().getX());
			} else if (cone.getCentreDot().getY() == cone.getRadDot().getY()
					&& Math.abs(cone.getCentreDot().getY() - cone.getTopDot().getY()) == cone.getHeight()
					&& ((cone.getCentreDot().getY() > 0 && cone.getTopDot().getY() < 0)
							|| (cone.getCentreDot().getY() < 0 && cone.getTopDot().getY() > 0))) {
				newHeight = Math.abs(cone.getCentreDot().getY());
			} else if (cone.getCentreDot().getZ() == cone.getRadDot().getZ()
					&& Math.abs(cone.getCentreDot().getZ() - cone.getTopDot().getZ()) == cone.getHeight()
					&& ((cone.getCentreDot().getZ() > 0 && cone.getTopDot().getZ() < 0)
							|| (cone.getCentreDot().getZ() < 0 && cone.getTopDot().getZ() > 0))) {
				newHeight = Math.abs(cone.getCentreDot().getZ());
			} else {
				throw new ServiceException("There isn't any coordinate plate that can cross input cone");
			}
			newRadius = (cone.getHeight() - newHeight) * cone.getRadius() / cone.getHeight();

			plate1 = (cone.getHeight() - newHeight) / 3 * Math.pow(newRadius, 2.) * Math.PI;
			plate2 = newHeight * Math.PI / 3
					* (Math.pow(cone.getRadius(), 2.) + cone.getRadius() * newRadius + Math.pow(newRadius, 2.));

			ratio = plate1 / plate2;
		} catch (BeanException e) {
			throw new ServiceException(e);
		}

		return ratio;
	}
}
