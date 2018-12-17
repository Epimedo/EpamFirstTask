package by.epam.javatraining.halavin.taskone.lib.dao.exception;

import by.epam.javatraining.halavin.taskone.lib.exception.FirstTaskException;

public class DAOException extends FirstTaskException {

	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception e) {
		super(e);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}
}
