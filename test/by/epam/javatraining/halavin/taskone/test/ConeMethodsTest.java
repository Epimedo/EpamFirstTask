package by.epam.javatraining.halavin.taskone.test;

import org.testng.annotations.Test;

import by.epam.javatraining.halavin.taskone.model.entity.Cone;
import by.epam.javatraining.halavin.taskone.model.exception.ConeException;
import by.epam.javatraining.halavin.taskone.model.exception.ConeWithoutCentreDot;
import by.epam.javatraining.halavin.taskone.model.exception.ConeWithoutRadDot;
import by.epam.javatraining.halavin.taskone.model.exception.ConeWithoutTopDot;
import by.epam.javatraining.halavin.taskone.model.exception.NotConeInput;
import by.epam.javatraining.halavin.taskone.model.exception.PlateDoesNotCrossCone;
import by.epam.javatraining.halavin.taskone.model.logic.MethodsForCone;
import by.epam.javatraining.halavin.taskone.util.ConeBuilder;
import by.epam.javatraining.halavin.taskone.util.ConeFactory;
import by.epam.javatraining.halavin.taskone.util.Validator;
import by.epam.javatraining.halavin.taskone.util.Input.CreaterDataGet;
import by.epam.javatraining.halavin.taskone.util.Input.GetData;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class ConeMethodsTest {
	private String input;
	private Cone cone1;
	private Cone cone2;
	private Cone cone3;
	private Cone cone4;
	private String fileNameCone = "input/coneData.txt";
	private String fileNameCone2 = "input/coneData2.txt";
	private String fileNameCone3 = "input/coneData3.txt";
	private String fileNameCone4 = "input/coneData4.txt";

	@BeforeClass
	public void beforeClass() {
		GetData dat = new CreaterDataGet().create(fileNameCone);
		input = dat.read();
		input = Validator.processCone(input);

		ConeBuilder builder = new ConeFactory().create(input);
		cone1 = builder.getResult();

		dat = new CreaterDataGet().create(fileNameCone2);
		input = dat.read();
		input = Validator.processCone(input);

		builder = new ConeFactory().create(input);
		cone2 = builder.getResult();

		dat = new CreaterDataGet().create(fileNameCone3);
		input = dat.read();
		input = Validator.processCone(input);

		builder = new ConeFactory().create(input);
		cone3 = builder.getResult();

		dat = new CreaterDataGet().create(fileNameCone4);
		input = dat.read();
		input = Validator.processCone(input);

		builder = new ConeFactory().create(input);
		cone4 = builder.getResult();
	}

	@Test
	public void getSquareTest() throws ConeException, NotConeInput {
		double expected = Math.PI * cone1.getRadius() * (cone1.getRadius() + cone1.getForming());

		assertEquals(MethodsForCone.getSquare(cone1), expected, 5);
	}

	@Test(expectedExceptions = NotConeInput.class)
	public void getSquareTestException() throws ConeException, NotConeInput {
		double expected = Math.PI * cone1.getRadius() * (cone1.getRadius() + cone1.getForming());

		assertEquals(MethodsForCone.getSquare(cone2), expected, 5);
	}

	@Test
	public void getSpaceTest() throws ConeException, NotConeInput {
		double expected = cone1.getHeight() / 3 * Math.pow(cone1.getRadius(), 2.) * Math.PI;

		assertEquals(MethodsForCone.getSpace(cone1), expected);
	}

	@Test(expectedExceptions = NotConeInput.class)
	public void getSpaceTestException() throws ConeException, NotConeInput {
		double expected = cone2.getHeight() / 3 * Math.pow(cone2.getRadius(), 2.) * Math.PI;

		assertEquals(MethodsForCone.getSpace(cone2), expected);
	}

	@Test
	public void isConeTestTrue() {
		assertEquals(MethodsForCone.isCone(cone1), true);
	}

	@Test
	public void isConeTestFalse() {
		assertEquals(MethodsForCone.isCone(cone2), false);
	}

	@Test
	public void isCoorPlaneTrue() throws NotConeInput {
		assertEquals(MethodsForCone.isCoorPlane(cone3), true);
	}

	@Test
	public void isCoorPlaneFalse() throws NotConeInput {
		assertEquals(MethodsForCone.isCoorPlane(cone1), false);
	}

	@Test(expectedExceptions = NotConeInput.class)
	public void isCoorPlaneException() throws NotConeInput {
		assertEquals(MethodsForCone.isCoorPlane(cone2), true);
	}

	@Test(expectedExceptions = PlateDoesNotCrossCone.class)
	public void getSpaceRatioTestPlateException() throws NotConeInput, PlateDoesNotCrossCone {
		assertEquals(MethodsForCone.getSpaceRatio(cone1), 1.2);
	}

	@Test(expectedExceptions = NotConeInput.class)
	public void getSpaceRatioTestNotCone() throws NotConeInput, PlateDoesNotCrossCone {
		assertEquals(MethodsForCone.getSpaceRatio(cone2), 1.2);
	}

	@Test
	public void getSpaceRatio() throws ConeException, NotConeInput, PlateDoesNotCrossCone {
		double newHeight = 0;
		double newRadius = 0;
		double plate1 = 0;
		double plate2 = 0;
		double expected;
		newHeight = Math.abs(cone4.getCentreDot().getX());
		newRadius = (cone4.getHeight() - newHeight) * cone4.getRadius() / cone4.getHeight();

		plate1 = (cone4.getHeight() - newHeight) / 3 * Math.pow(newRadius, 2.) * Math.PI;
		plate2 = newHeight * Math.PI / 3
				* (Math.pow(cone4.getRadius(), 2.) + cone4.getRadius() * newRadius + Math.pow(newRadius, 2.));

		expected = plate1 / plate2;

		assertEquals(MethodsForCone.getSpaceRatio(cone4), expected, 5);
	}
}
