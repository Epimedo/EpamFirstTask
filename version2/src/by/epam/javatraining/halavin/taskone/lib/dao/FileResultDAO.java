package by.epam.javatraining.halavin.taskone.lib.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import by.epam.javatraining.halavin.taskone.lib.dao.exception.DAOException;
import by.epam.javatraining.halavin.taskone.lib.dao.impl.DAO;

public class FileResultDAO implements DAO {

	@Override
	public void addResult(String info) throws DAOException {
		File file = new File(InfoForFile.FILENAMEOUTPUT.getStr());

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}

		try (BufferedWriter bf = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true))) {
			bf.write("\n" + info);

		} catch (IOException e) {
			throw new DAOException(e);
		}
	}

}
