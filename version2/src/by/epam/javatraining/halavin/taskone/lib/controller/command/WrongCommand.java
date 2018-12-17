package by.epam.javatraining.halavin.taskone.lib.controller.command;

import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;
import by.epam.javatraining.halavin.taskone.lib.controller.command.impl.ShapeCommand;

public class WrongCommand implements ShapeCommand {

	@Override
	public String execute(String request,Shape shape) {
		return "Wrong command";
	}

}
