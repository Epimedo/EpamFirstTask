package by.epam.javatraining.halavin.taskone.util.output;

import org.apache.log4j.Logger;

public class LogOutput extends Output {
	protected final Logger Log = Logger.getRootLogger();

	public LogOutput() {
		super();
	}

	public LogOutput(String info) {
		super(info);
	}

	@Override
	public void print(Object obj) {
		Log.info(str + obj);
	}

}
