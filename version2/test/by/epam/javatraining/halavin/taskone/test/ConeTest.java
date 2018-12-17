package by.epam.javatraining.halavin.taskone.test;

import org.testng.annotations.Test;

import by.epam.javatraining.halavin.taskone.lib.bean.Cone;
import by.epam.javatraining.halavin.taskone.lib.bean.Dot;
import by.epam.javatraining.halavin.taskone.lib.bean.exception.BeanException;
import by.epam.javatraining.halavin.taskone.lib.util.Validator;
import by.epam.javatraining.halavin.taskone.lib.util.builder.DotBuilder;
import by.epam.javatraining.halavin.taskone.lib.util.factory.UtilFactory;
import by.epam.javatraining.halavin.taskone.lib.util.impl.ShapeBuilder;
import by.epam.javatraining.halavin.taskone.util.input.CreaterDataGet;
import by.epam.javatraining.halavin.taskone.util.input.GetData;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;

public class ConeTest {
	private String fileNameCone = "input/coneData.txt";
	private String fileNameCone2 = "input/coneData2.txt";
	private String fileNameDot = "input/dotData.txt";
	private String fileNameDot2 = "input/dotData2.txt";
	private String fileNameDot3 = "input/dotData3.txt";
	private Cone cone1;
	private Cone cone2;
	private String input;
	private Dot dot;
	private UtilFactory factory = UtilFactory.getInstance();
	private ShapeBuilder shapeBuilder = factory.getShapeBuilder();
	private DotBuilder dotBuilder = factory.getDotBuilder();

	@BeforeTest
	public void beforeClass() {
		GetData dat = new CreaterDataGet().create(fileNameCone);
		input = dat.read();
		input = Validator.processCone(input);

		cone1 = (Cone) shapeBuilder.getResult(input);
	}

	@Test
	public void coneGetCentreDot() throws BeanException {
		String inputDot = new CreaterDataGet().create(fileNameDot).read();
		inputDot = Validator.processDot(inputDot);

		dot = dotBuilder.getResult(inputDot);
		assertEquals(dot, cone1.getCentreDot());
	}

	@Test(expectedExceptions = BeanException.class)
	public void coneGetCentreDotException() throws BeanException {
		String inputDot = new CreaterDataGet().create(fileNameDot).read();
		inputDot = Validator.processDot(inputDot);

		dot = dotBuilder.getResult(inputDot);
		cone2 = new Cone();
		assertEquals(dot, cone2.getCentreDot());
	}

	@Test
	public void coneSetCentreDot() throws BeanException {
		String inputDot = new CreaterDataGet().create(fileNameDot).read();
		inputDot = Validator.processDot(inputDot);

		dot = dotBuilder.getResult(inputDot);
		cone2 = new Cone();
		cone2.setCentreDot(dot);
		assertEquals(dot, cone2.getCentreDot());
	}

	@Test
	public void coneGetRadDot() throws BeanException {
		String inputDot = new CreaterDataGet().create(fileNameDot2).read();
		inputDot = Validator.processDot(inputDot);

		dot = dotBuilder.getResult(inputDot);

		assertEquals(dot, cone1.getRadDot());
	}

	@Test(expectedExceptions = BeanException.class)
	public void coneGetRadDotException() throws BeanException {
		String inputDot = new CreaterDataGet().create(fileNameDot2).read();
		inputDot = Validator.processDot(inputDot);

		dot = dotBuilder.getResult(inputDot);
		cone2 = new Cone();

		assertEquals(dot, cone2.getRadDot());
	}

	@Test
	public void coneSetRadDot() throws BeanException {
		String inputDot = new CreaterDataGet().create(fileNameDot2).read();
		inputDot = Validator.processDot(inputDot);

		dot = dotBuilder.getResult(inputDot);
		cone2 = new Cone();
		cone2.setRadDot(dot);

		assertEquals(dot, cone2.getRadDot());
	}

	@Test
	public void coneGetTopDot() throws BeanException {
		String inputDot = new CreaterDataGet().create(fileNameDot3).read();
		inputDot = Validator.processDot(inputDot);

		dot = dotBuilder.getResult(inputDot);

		assertEquals(dot, cone1.getTopDot());
	}

	@Test(expectedExceptions = BeanException.class)
	public void coneGetTopDotException() throws BeanException {
		String inputDot = new CreaterDataGet().create(fileNameDot3).read();
		inputDot = Validator.processDot(inputDot);

		dot = dotBuilder.getResult(inputDot);
		cone2 = new Cone();

		assertEquals(dot, cone2.getTopDot());
	}

	@Test
	public void coneSetTopDot() throws BeanException {
		String inputDot = new CreaterDataGet().create(fileNameDot3).read();
		inputDot = Validator.processDot(inputDot);

		dot = dotBuilder.getResult(inputDot);
		cone2 = new Cone();
		cone2.setTopDot(dot);

		assertEquals(dot, cone2.getTopDot());
	}

	@Test
	public void coneEqualsTest() {
		cone2 = (Cone) shapeBuilder.getResult(input);

		assertEquals(cone2, cone1);
	}

	@Test
	public void coneCopyConstructorTest() {
		cone2 = new Cone(cone1);
		assertEquals(cone2, cone1);
	}

	@Test
	public void coneHashCodeTestTrue() {
		cone2 = new Cone(cone1);
		assertEquals(cone2.hashCode(), cone1.hashCode());
	}

	@Test
	public void coneHashCodeTestFalse() {
		String inputCone = new CreaterDataGet().create("input/coneData4.txt").read();
		inputCone = Validator.processCone(inputCone);
		cone2 = (Cone) shapeBuilder.getResult(inputCone);

		assertEquals(cone2.hashCode() == cone1.hashCode(), false);
	}

	@Test
	public void coneToStringTest() throws BeanException {
		String expected = "Dot\ncentre " + cone1.getCentreDot() + "\nradius " + cone1.getRadDot() + "\ntop "
				+ cone1.getTopDot() + "\nheigth = " + cone1.getHeight() + "\nradius = " + cone1.getRadius()
				+ "\nforming = " + cone1.getForming();

		assertEquals(cone1.toString(), expected);

	}

	@Test
	public void coneGetHeightTest() throws BeanException {
		double expected = 4.;
		assertEquals(cone1.getHeight(), expected, 5);
	}

	@Test(expectedExceptions = BeanException.class)
	public void coneGetHeightTestWithoutCentre() throws BeanException {
		double expected = 4.;
		cone2 = new Cone();

		assertEquals(cone2.getHeight(), expected);
	}

	@Test(expectedExceptions = BeanException.class)
	public void coneGetHeightTestWithoutTop() throws BeanException {
		double expected = 4.;
		cone2 = new Cone();
		Dot dot = new Dot(1.2, 3.2, 4.5);
		cone2.setCentreDot(dot);

		assertEquals(cone2.getHeight(), expected);
	}

	@Test
	public void coneGetRadiusTest() throws BeanException {
		double expected = 5.;
		assertEquals(cone1.getRadius(), expected, 5);
	}

	@Test(expectedExceptions = BeanException.class)
	public void coneGetRadiusTestWhithoutCentre() throws BeanException {
		double expected = 5.;
		Dot dot = new Dot(9, 3, 2);
		cone2 = new Cone();
		cone2.setRadDot(dot);

		assertEquals(cone2.getRadius(), expected);

	}

	@Test(expectedExceptions = BeanException.class)
	public void coneGetRadiusTestWhithoutRad() throws BeanException {
		double expected = 5.;
		Dot dot = new Dot(9, 3, 2);
		cone2 = new Cone();
		cone2.setCentreDot(dot);

		assertEquals(cone2.getRadius(), expected);

	}

	@Test
	public void coneGetForming() throws BeanException {
		double expected = 6.4;
		assertEquals(cone1.getForming(), expected, 2);
	}

	@Test(expectedExceptions = BeanException.class)
	public void coneGetFormingWithoutTop() throws BeanException {
		double expected = 6.4;
		Dot dot1 = new Dot(1, 2, 2);
		Dot dot2 = new Dot(1, 2, 4);
		cone2 = new Cone();
		cone2.setRadDot(dot2);
		cone2.setCentreDot(dot1);

		assertEquals(cone2.getForming(), expected, 2);
	}

	@Test(expectedExceptions = BeanException.class)
	public void coneGetFormingWithoutRad() throws BeanException {
		double expected = 6.4;
		Dot dot1 = new Dot(1, 2, 2);
		Dot dot2 = new Dot(1, 2, 4);
		cone2 = new Cone();
		cone2.setCentreDot(dot2);
		cone2.setTopDot(dot1);

		assertEquals(cone2.getForming(), expected, 2);
	}
}
