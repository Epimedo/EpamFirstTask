package by.epam.javatraining.halavin.taskone.lib.service.exception;

import by.epam.javatraining.halavin.taskone.lib.exception.FirstTaskException;

public class ServiceException extends FirstTaskException {

	public ServiceException() {
		super();
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}

	public ServiceException(String message) {
		super(message);
	}

}
