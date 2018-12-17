package by.epam.javatraining.halavin.taskone.lib.controller;

import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;
import by.epam.javatraining.halavin.taskone.lib.controller.command.impl.ShapeCommand;
import by.epam.javatraining.halavin.taskone.lib.util.factory.UtilFactory;
import by.epam.javatraining.halavin.taskone.lib.util.impl.ShapeBuilder;

public class Controller {
	private final CommandProvider commandProvider = new CommandProvider();
	private final char paramDelimeter = ' ';

	public String executeTask(String request) {
		String commandName = null;
		String data = null;
		ShapeCommand executionCommand;

		commandName = request.substring(0, request.indexOf(paramDelimeter));
		executionCommand = commandProvider.getCommand(commandName);
		data = request.substring(request.indexOf(paramDelimeter) + 1, request.length());

		UtilFactory shapeFactory = UtilFactory.getInstance();
		ShapeBuilder builder = shapeFactory.getShapeBuilder();

		Shape shape = builder.getResult(data);
		String responce = executionCommand.execute(request, shape);

		return responce;
	}
}
