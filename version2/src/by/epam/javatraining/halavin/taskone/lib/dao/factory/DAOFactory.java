package by.epam.javatraining.halavin.taskone.lib.dao.factory;

import by.epam.javatraining.halavin.taskone.lib.dao.FileConeDAO;
import by.epam.javatraining.halavin.taskone.lib.dao.FileResultDAO;
import by.epam.javatraining.halavin.taskone.lib.dao.impl.DAO;
import by.epam.javatraining.halavin.taskone.lib.dao.impl.ShapeDAO;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ShapeDAO shapeDAO = new FileConeDAO();
	private final DAO dao = new FileResultDAO();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public ShapeDAO getShapeDAO() {
		return shapeDAO;
	}

	public DAO getDao() {
		return dao;
	}

}
