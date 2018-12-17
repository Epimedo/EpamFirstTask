package by.epam.javatraining.halavin.taskone.lib.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.javatraining.halavin.taskone.lib.controller.command.AddShapeToFile;
import by.epam.javatraining.halavin.taskone.lib.controller.command.CommandName;
import by.epam.javatraining.halavin.taskone.lib.controller.command.GetConeSpace;
import by.epam.javatraining.halavin.taskone.lib.controller.command.GetConeSquare;
import by.epam.javatraining.halavin.taskone.lib.controller.command.GetIsCrossCoorPlane;
import by.epam.javatraining.halavin.taskone.lib.controller.command.GetIsFigureCone;
import by.epam.javatraining.halavin.taskone.lib.controller.command.GetSpaceRatio;
import by.epam.javatraining.halavin.taskone.lib.controller.command.WrongCommand;
import by.epam.javatraining.halavin.taskone.lib.controller.command.impl.ShapeCommand;

public class CommandProvider {
	private final Map<CommandName, ShapeCommand> repository = new HashMap<>();
	private final Logger LOG = Logger.getLogger(CommandProvider.class);

	CommandProvider() {
		repository.put(CommandName.GET_CONE_SPACE, new GetConeSpace());
		repository.put(CommandName.GET_CONE_SQUARE, new GetConeSquare());
		repository.put(CommandName.GET_IS_CROSS_COOR_PLANE, new GetIsCrossCoorPlane());
		repository.put(CommandName.GET_IS_FIGURE_CONE, new GetIsFigureCone());
		repository.put(CommandName.GET_SPACE_RATIO, new GetSpaceRatio());
		repository.put(CommandName.WRONG_COMMAND, new WrongCommand());
		repository.put(CommandName.ADD_SHAPE_TO_FILE, new AddShapeToFile());
	}

	ShapeCommand getCommand(String name) {
		CommandName comName = null;
		ShapeCommand command = null;
		try {
			comName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(comName);
		} catch (IllegalArgumentException | NullPointerException e) {
			LOG.error(e);
			command = repository.get(CommandName.WRONG_COMMAND);
		}
		return command;
	}
}
