package by.epam.javatraining.halavin.taskone.lib.service;

import by.epam.javatraining.halavin.taskone.lib.bean.Cone;
import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;
import by.epam.javatraining.halavin.taskone.lib.dao.exception.DAOException;
import by.epam.javatraining.halavin.taskone.lib.dao.factory.DAOFactory;
import by.epam.javatraining.halavin.taskone.lib.dao.impl.ShapeDAO;
import by.epam.javatraining.halavin.taskone.lib.service.exception.ServiceException;
import by.epam.javatraining.halavin.taskone.lib.service.impl.ShapeLibraryService;

public class ConeLibraryService implements ShapeLibraryService {

	@Override
	public void addShape(Shape shape) throws ServiceException {
		if (shape == null) {
			throw new ServiceException("Shape is empty");
		}
		if (shape.getClass() != Cone.class) {
			throw new ServiceException("Incorrect object type");
		}

		DAOFactory daoFactory = DAOFactory.getInstance();
		ShapeDAO fileConeDAO = daoFactory.getShapeDAO();

		try {
			fileConeDAO.addShape(shape);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
