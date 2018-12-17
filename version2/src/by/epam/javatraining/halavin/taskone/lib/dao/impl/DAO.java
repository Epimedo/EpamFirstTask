/**
 * 
 */
package by.epam.javatraining.halavin.taskone.lib.dao.impl;

import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;
import by.epam.javatraining.halavin.taskone.lib.dao.exception.DAOException;

/**
 * @author MARA7h0N
 *
 */
public interface DAO {
	
	void addResult(String info) throws DAOException;
}
