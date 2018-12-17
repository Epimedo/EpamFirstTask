package by.epam.javatraining.halavin.taskone.test;

import org.testng.annotations.Test;

import by.epam.javatraining.halavin.taskone.lib.bean.Cone;
import by.epam.javatraining.halavin.taskone.lib.bean.exception.BeanException;
import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;
import by.epam.javatraining.halavin.taskone.lib.service.exception.ServiceException;
import by.epam.javatraining.halavin.taskone.lib.service.factory.ServiceFactory;
import by.epam.javatraining.halavin.taskone.lib.service.impl.MethodsForShapeService;
import by.epam.javatraining.halavin.taskone.lib.util.Validator;
import by.epam.javatraining.halavin.taskone.lib.util.factory.UtilFactory;
import by.epam.javatraining.halavin.taskone.lib.util.impl.ShapeBuilder;
import by.epam.javatraining.halavin.taskone.util.input.CreaterDataGet;
import by.epam.javatraining.halavin.taskone.util.input.GetData;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;

public class ConeMethodsTest {
	private String input;
	private Shape cone1;
	private Shape cone2;
	private Shape cone3;
	private Shape cone4;
	private String fileNameCone = "input/coneData.txt";
	private String fileNameCone2 = "input/coneData2.txt";
	private String fileNameCone3 = "input/coneData3.txt";
	private String fileNameCone4 = "input/coneData4.txt";
	private ServiceFactory serviceFactory = ServiceFactory.getInstance();
	private MethodsForShapeService methods = serviceFactory.getMethodsForShapeService();

	@BeforeClass
	public void beforeClass() {
		GetData dat = new CreaterDataGet().create(fileNameCone);
		input = dat.read();
		input = Validator.processCone(input);

		UtilFactory factory = UtilFactory.getInstance();
		ShapeBuilder builder = factory.getShapeBuilder();
		cone1 = builder.getResult(input);

		dat = new CreaterDataGet().create(fileNameCone2);
		input = dat.read();
		input = Validator.processCone(input);

		cone2 = builder.getResult(input);

		dat = new CreaterDataGet().create(fileNameCone3);
		input = dat.read();
		input = Validator.processCone(input);

		cone3 = builder.getResult(input);

		dat = new CreaterDataGet().create(fileNameCone4);
		input = dat.read();
		input = Validator.processCone(input);

		cone4 = builder.getResult(input);
	}

	@Test
	public void getSquareTest() throws BeanException, ServiceException {
		Cone cone = (Cone) cone1;
		double expected = Math.PI * cone.getRadius() * (cone.getRadius() + cone.getForming());

		assertEquals(methods.getSquare(cone), expected, 5);
	}

	@Test(expectedExceptions = ServiceException.class)
	public void getSquareTestException() throws BeanException, ServiceException {
		Cone cone = (Cone) cone1;
		double expected = Math.PI * cone.getRadius() * (cone.getRadius() + cone.getForming());

		assertEquals(methods.getSquare(cone2), expected, 5);
	}

	@Test
	public void getSpaceTest() throws BeanException, ServiceException {
		Cone cone = (Cone) cone1;
		double expected = cone.getHeight() / 3 * Math.pow(cone.getRadius(), 2.) * Math.PI;

		assertEquals(methods.getSpace(cone1), expected);
	}

	@Test(expectedExceptions = ServiceException.class)
	public void getSpaceTestException() throws ServiceException, BeanException {
		Cone cone = (Cone) cone2;
		double expected = cone.getHeight() / 3 * Math.pow(cone.getRadius(), 2.) * Math.PI;

		assertEquals(methods.getSpace(cone2), expected);
	}

	@Test
	public void isConeTestTrue() throws ServiceException {
		assertEquals(methods.isFigure(cone1), true);
	}

	@Test
	public void isConeTestFalse() throws ServiceException {
		assertEquals(methods.isFigure(cone2), false);
	}

	@Test
	public void isCoorPlaneTrue() throws ServiceException {
		assertEquals(methods.isCoorPlane(cone3), true);
	}

	@Test
	public void isCoorPlaneFalse() throws ServiceException {
		assertEquals(methods.isCoorPlane(cone1), false);
	}

	@Test(expectedExceptions = ServiceException.class)
	public void isCoorPlaneException() throws ServiceException {
		assertEquals(methods.isCoorPlane(cone2), true);
	}

	@Test(expectedExceptions = ServiceException.class)
	public void getSpaceRatioTestPlateException() throws ServiceException {
		assertEquals(methods.getSpaceRatio(cone1), 1.2);
	}

	@Test(expectedExceptions = ServiceException.class)
	public void getSpaceRatioTestNotCone() throws ServiceException {
		assertEquals(methods.getSpaceRatio(cone2), 1.2);
	}

	@Test
	public void getSpaceRatio() throws ServiceException, BeanException {
		double newHeight = 0;
		double newRadius = 0;
		double plate1 = 0;
		double plate2 = 0;
		double expected;
		Cone cone = (Cone) cone4;
		newHeight = Math.abs(cone.getCentreDot().getX());
		newRadius = (cone.getHeight() - newHeight) * cone.getRadius() / cone.getHeight();

		plate1 = (cone.getHeight() - newHeight) / 3 * Math.pow(newRadius, 2.) * Math.PI;
		plate2 = newHeight * Math.PI / 3
				* (Math.pow(cone.getRadius(), 2.) + cone.getRadius() * newRadius + Math.pow(newRadius, 2.));

		expected = plate1 / plate2;

		assertEquals(methods.getSpaceRatio(cone), expected, 5);
	}
}
