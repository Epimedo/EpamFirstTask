package by.epam.javatraining.halavin.taskone.lib.exception;

public class FirstTaskException extends Exception {

	public FirstTaskException() {
		super();
	}

	public FirstTaskException(Exception e) {
		super(e);
	}

	public FirstTaskException(String message) {
		super(message);
	}

	public FirstTaskException(String message, Exception e) {
		super(message, e);
	}
}
