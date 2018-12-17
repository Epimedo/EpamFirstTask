package by.epam.javatraining.halavin.taskone.test;

import org.testng.annotations.Test;

import by.epam.javatraining.halavin.taskone.model.entity.Cone;
import by.epam.javatraining.halavin.taskone.model.entity.Dot;
import by.epam.javatraining.halavin.taskone.model.exception.ConeWithoutCentreDot;
import by.epam.javatraining.halavin.taskone.model.exception.ConeWithoutRadDot;
import by.epam.javatraining.halavin.taskone.model.exception.ConeWithoutTopDot;
import by.epam.javatraining.halavin.taskone.util.ConeBuilder;
import by.epam.javatraining.halavin.taskone.util.ConeFactory;
import by.epam.javatraining.halavin.taskone.util.DotBuilder;
import by.epam.javatraining.halavin.taskone.util.DotFactory;
import by.epam.javatraining.halavin.taskone.util.Validator;
import by.epam.javatraining.halavin.taskone.util.Input.CreaterDataGet;
import by.epam.javatraining.halavin.taskone.util.Input.GetData;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;

public class ConeTest {
	private String fileNameCone = "input//coneData.txt";
	private String fileNameCone2 = "input//coneData2.txt";
	private String fileNameDot = "input//dotData.txt";
	private String fileNameDot2 = "input//dotData2.txt";
	private String fileNameDot3 = "input//dotData3.txt";
	private Cone cone1;
	private Cone cone2;
	private String input;
	private Dot dot;

	@BeforeClass
	public void beforeClass() {
		GetData dat = new CreaterDataGet().create(fileNameCone);
		input = dat.read();
		input = Validator.processCone(input);

		ConeBuilder builder = new ConeFactory().create(input);
		cone1 = builder.getResult();
	}

	@Test
	public void coneGetCentreDot() throws ConeWithoutCentreDot {
		String inputDot = new CreaterDataGet().create(fileNameDot).read();
		inputDot = Validator.processDot(inputDot);

		DotBuilder builder = new DotFactory().create(inputDot);
		dot = builder.getResult();
		assertEquals(dot, cone1.getCentreDot());
	}

	@Test(expectedExceptions = ConeWithoutCentreDot.class)
	public void coneGetCentreDotException() throws ConeWithoutCentreDot {
		String inputDot = new CreaterDataGet().create(fileNameDot).read();
		inputDot = Validator.processDot(inputDot);

		DotBuilder builder = new DotFactory().create(inputDot);
		dot = builder.getResult();
		cone2 = new Cone();
		assertEquals(dot, cone2.getCentreDot());
	}

	@Test
	public void coneSetCentreDot() throws ConeWithoutCentreDot {
		String inputDot = new CreaterDataGet().create(fileNameDot).read();
		inputDot = Validator.processDot(inputDot);

		DotBuilder builder = new DotFactory().create(inputDot);
		dot = builder.getResult();
		cone2 = new Cone();
		cone2.setCentreDot(dot);
		assertEquals(dot, cone2.getCentreDot());
	}

	@Test
	public void coneGetRadDot() throws ConeWithoutRadDot {
		String inputDot = new CreaterDataGet().create(fileNameDot2).read();
		inputDot = Validator.processDot(inputDot);

		DotBuilder builder = new DotFactory().create(inputDot);
		dot = builder.getResult();

		assertEquals(dot, cone1.getRadDot());
	}

	@Test(expectedExceptions = ConeWithoutRadDot.class)
	public void coneGetRadDotException() throws ConeWithoutRadDot {
		String inputDot = new CreaterDataGet().create(fileNameDot2).read();
		inputDot = Validator.processDot(inputDot);

		DotBuilder builder = new DotFactory().create(inputDot);
		dot = builder.getResult();
		cone2 = new Cone();

		assertEquals(dot, cone2.getRadDot());
	}

	@Test
	public void coneSetRadDot() throws ConeWithoutRadDot {
		String inputDot = new CreaterDataGet().create(fileNameDot2).read();
		inputDot = Validator.processDot(inputDot);

		DotBuilder builder = new DotFactory().create(inputDot);
		dot = builder.getResult();
		cone2 = new Cone();
		cone2.setRadDot(dot);

		assertEquals(dot, cone2.getRadDot());
	}

	@Test
	public void coneGetTopDot() throws ConeWithoutTopDot {
		String inputDot = new CreaterDataGet().create(fileNameDot3).read();
		inputDot = Validator.processDot(inputDot);

		DotBuilder builder = new DotFactory().create(inputDot);
		dot = builder.getResult();

		assertEquals(dot, cone1.getTopDot());
	}

	@Test(expectedExceptions = ConeWithoutTopDot.class)
	public void coneGetTopDotException() throws ConeWithoutTopDot {
		String inputDot = new CreaterDataGet().create(fileNameDot3).read();
		inputDot = Validator.processDot(inputDot);

		DotBuilder builder = new DotFactory().create(inputDot);
		dot = builder.getResult();
		cone2 = new Cone();

		assertEquals(dot, cone2.getTopDot());
	}

	@Test
	public void coneSetTopDot() throws ConeWithoutTopDot {
		String inputDot = new CreaterDataGet().create(fileNameDot3).read();
		inputDot = Validator.processDot(inputDot);

		DotBuilder builder = new DotFactory().create(inputDot);
		dot = builder.getResult();
		cone2 = new Cone();
		cone2.setTopDot(dot);

		assertEquals(dot, cone2.getTopDot());
	}

	@Test
	public void coneEqualsTest() {
		ConeBuilder builder = new ConeFactory().create(input);
		cone2 = builder.getResult();

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
		String inputCone = new CreaterDataGet().create(fileNameCone2).read();
		inputCone = Validator.processCone(inputCone);

		ConeBuilder builder = new ConeFactory().create(inputCone);
		cone2 = builder.getResult();
		
		assertEquals(cone2.hashCode() == cone1.hashCode(),false);
	}

	@Test
	public void coneToStringTest() throws ConeWithoutCentreDot, ConeWithoutRadDot, ConeWithoutTopDot {
		String expected = "Dot\ncentre " + cone1.getCentreDot() + "\nradius " + cone1.getRadDot() + "\ntop "
				+ cone1.getTopDot() + "\nheigth = " + cone1.getHeight() + "\nradius = " + cone1.getRadius()
				+ "\nforming = " + cone1.getForming();

		assertEquals(cone1.toString(), expected);

	}

	@Test
	public void coneGetHeightTest() throws ConeWithoutCentreDot, ConeWithoutTopDot {
		double expected = 4.;
		assertEquals(cone1.getHeight(), expected, 5);
	}

	@Test(expectedExceptions = ConeWithoutCentreDot.class)
	public void coneGetHeightTestWithoutCentre() throws ConeWithoutCentreDot, ConeWithoutTopDot {
		double expected = 4.;
		cone2 = new Cone();

		assertEquals(cone2.getHeight(), expected);
	}

	@Test(expectedExceptions = ConeWithoutTopDot.class)
	public void coneGetHeightTestWithoutTop() throws ConeWithoutCentreDot, ConeWithoutTopDot {
		double expected = 4.;
		cone2 = new Cone();
		Dot dot = new Dot(1.2, 3.2, 4.5);
		cone2.setCentreDot(dot);

		assertEquals(cone2.getHeight(), expected);
	}

	@Test
	public void coneGetRadiusTest() throws ConeWithoutCentreDot, ConeWithoutRadDot {
		double expected = 5.;
		assertEquals(cone1.getRadius(), expected, 5);
	}

	@Test(expectedExceptions = ConeWithoutCentreDot.class)
	public void coneGetRadiusTestWhithoutCentre() throws ConeWithoutCentreDot, ConeWithoutRadDot {
		double expected = 5.;
		Dot dot = new Dot(9, 3, 2);
		cone2 = new Cone();
		cone2.setRadDot(dot);

		assertEquals(cone2.getRadius(), expected);

	}

	@Test(expectedExceptions = ConeWithoutRadDot.class)
	public void coneGetRadiusTestWhithoutRad() throws ConeWithoutCentreDot, ConeWithoutRadDot {
		double expected = 5.;
		Dot dot = new Dot(9, 3, 2);
		cone2 = new Cone();
		cone2.setCentreDot(dot);

		assertEquals(cone2.getRadius(), expected);

	}

	@Test
	public void coneGetForming() throws  ConeWithoutRadDot, ConeWithoutTopDot {
		double expected = 6.4;
		assertEquals(cone1.getForming(), expected, 2);
	}

	

	@Test(expectedExceptions = ConeWithoutTopDot.class)
	public void coneGetFormingWithoutTop() throws  ConeWithoutRadDot, ConeWithoutTopDot {
		double expected = 6.4;
		Dot dot1 = new Dot(1,2,2);
		Dot dot2 = new Dot(1,2,4);
		cone2 = new Cone();
		cone2.setRadDot(dot2);
		cone2.setCentreDot(dot1);
		
		assertEquals(cone2.getForming(), expected, 2);
	}

	@Test(expectedExceptions = ConeWithoutRadDot.class)
	public void coneGetFormingWithoutRad() throws  ConeWithoutRadDot, ConeWithoutTopDot {
		double expected = 6.4;
		Dot dot1 = new Dot(1,2,2);
		Dot dot2 = new Dot(1,2,4);
		cone2 = new Cone();
		cone2.setCentreDot(dot2);
		cone2.setTopDot(dot1);
		
		assertEquals(cone2.getForming(), expected, 2);
	}
}
