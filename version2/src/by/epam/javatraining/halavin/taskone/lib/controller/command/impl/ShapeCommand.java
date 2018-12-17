package by.epam.javatraining.halavin.taskone.lib.controller.command.impl;

import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;

public interface ShapeCommand {

	public String execute(String request, Shape shape);
}
