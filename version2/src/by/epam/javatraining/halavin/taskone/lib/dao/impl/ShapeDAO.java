package by.epam.javatraining.halavin.taskone.lib.dao.impl;

import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;
import by.epam.javatraining.halavin.taskone.lib.dao.exception.DAOException;

public interface ShapeDAO {
	
	void addShape(Shape shape) throws DAOException;
}
