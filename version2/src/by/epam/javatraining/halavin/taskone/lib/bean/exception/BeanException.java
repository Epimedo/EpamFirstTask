package by.epam.javatraining.halavin.taskone.lib.bean.exception;

import by.epam.javatraining.halavin.taskone.lib.exception.FirstTaskException;

public class BeanException extends FirstTaskException {

	public BeanException() {
		super();
	}

	public BeanException(Exception e) {
		super(e);
	}

	public BeanException(String message, Exception e) {
		super(message, e);
	}

	public BeanException(String message) {
		super(message);
	}

	
}
