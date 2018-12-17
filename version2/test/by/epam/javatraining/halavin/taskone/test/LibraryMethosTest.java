package by.epam.javatraining.halavin.taskone.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.epam.javatraining.halavin.taskone.lib.bean.Cone;
import by.epam.javatraining.halavin.taskone.lib.service.exception.ServiceException;
import by.epam.javatraining.halavin.taskone.lib.service.factory.ServiceFactory;
import by.epam.javatraining.halavin.taskone.lib.service.impl.ShapeLibraryService;
import by.epam.javatraining.halavin.taskone.lib.util.Validator;
import by.epam.javatraining.halavin.taskone.lib.util.factory.UtilFactory;
import by.epam.javatraining.halavin.taskone.lib.util.impl.ShapeBuilder;
import by.epam.javatraining.halavin.taskone.util.input.CreaterDataGet;
import by.epam.javatraining.halavin.taskone.util.input.GetData;

public class LibraryMethosTest {
	private Cone cone;
	private ServiceFactory factory = ServiceFactory.getInstance();
	private ShapeLibraryService service = factory.getShapeLibraryService();
	private String fileNameCone = "input/coneData.txt";
	private String input;

	@BeforeClass
	public void beforeClass() {
		GetData dat = new CreaterDataGet().create(fileNameCone);
		input = dat.read();
		input = Validator.processCone(input);

		UtilFactory factory = UtilFactory.getInstance();
		ShapeBuilder builder = factory.getShapeBuilder();
		cone = (Cone) builder.getResult(input);
	}

	@Test
	public void AddToFileTest() throws ServiceException {
		service.addShape(cone);
		String str;
		GetData dat = new CreaterDataGet().create("output/result.txt");
		str = dat.read();

		assertEquals("\n" + cone.toString() + "\n", str);
	}

	@Test(expectedExceptions = ServiceException.class)
	public void AddToFileTestException() throws ServiceException {
		service.addShape(null);
	}
}
