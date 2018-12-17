package by.epam.javatraining.halavin.taskone.lib.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;
import by.epam.javatraining.halavin.taskone.lib.dao.exception.DAOException;
import by.epam.javatraining.halavin.taskone.lib.dao.impl.DAO;
import by.epam.javatraining.halavin.taskone.lib.dao.impl.ShapeDAO;
import by.epam.javatraining.halavin.taskone.util.output.CreatorLogOutput;
import by.epam.javatraining.halavin.taskone.util.output.Output;

public class FileConeDAO implements ShapeDAO {

	@Override
	public void addShape(Shape shape) throws DAOException {
		File file = new File(InfoForFile.FILENAMERESULT.getStr());

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}

		try (BufferedWriter bf = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true))) {
			bf.write("\n" + shape.toString());

		} catch (IOException e) {
			throw new DAOException(e);
		}

	}

}
