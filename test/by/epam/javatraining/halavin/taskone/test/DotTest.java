package by.epam.javatraining.halavin.taskone.test;

import org.testng.annotations.Test;

import by.epam.javatraining.halavin.taskone.model.entity.Dot;
import by.epam.javatraining.halavin.taskone.util.DotBuilder;
import by.epam.javatraining.halavin.taskone.util.DotFactory;
import by.epam.javatraining.halavin.taskone.util.Validator;
import by.epam.javatraining.halavin.taskone.util.Input.CreaterDataGet;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;

public class DotTest {
	private Dot dot1;
	private Dot dot2;
	private Dot dot3;
	private String fileNameDot = "input/dotData.txt";
	private String fileNameDot2 = "input/dotData2.txt";
	private String fileNameDot3 = "input/dotData3.txt";

	@BeforeClass
	public void beforeClass() {
		String inputDot = new CreaterDataGet().create(fileNameDot).read();
		inputDot = Validator.processDot(inputDot);

		DotBuilder builder = new DotFactory().create(inputDot);
		dot1 = builder.getResult();

		inputDot = new CreaterDataGet().create(fileNameDot3).read();
		inputDot = Validator.processDot(inputDot);

		builder = new DotFactory().create(inputDot);
		dot3 = builder.getResult();
	}

	@Test
	public void dotGetXTest() {
		double expected = 5;

		assertEquals(dot3.getX(), expected);
	}

	@Test
	public void dotSetXTest() {
		double expected = 3;

		dot3.setX(expected);

		assertEquals(dot3.getX(), expected);
	}

	@Test
	public void dotGetYTest() {
		double expected = 2;

		assertEquals(dot3.getY(), expected);
	}

	@Test
	public void dotSetYTest() {
		double expected = 1.2;
		dot3.setY(expected);

		assertEquals(dot3.getY(), expected);
	}

	@Test
	public void dotGetZTest() {
		double expected = 5;

		assertEquals(dot3.getZ(), expected);
	}

	@Test
	public void dotSetZTest() {
		double expected = 1.1;
		dot3.setZ(expected);

		assertEquals(dot3.getZ(), expected);
	}

	@Test
	public void dotToString() {
		String expected = "Dot\nx = " + dot1.getX() + "\ny = " + dot1.getY() + "\nz = " + dot1.getZ();

		assertEquals(dot1.toString(), expected);
	}

	@Test
	public void dotEqualsTestTrue() {
		String str = new CreaterDataGet().create(fileNameDot).read();
		str = Validator.processDot(str);

		DotBuilder builder = new DotFactory().create(str);

		dot2 = builder.getResult();
		assertEquals(dot1, dot2);
	}

	@Test
	public void dotEqualsTestFalse() {
		String str = new CreaterDataGet().create(fileNameDot2).read();
		str = Validator.processDot(str);

		DotBuilder builder = new DotFactory().create(str);

		dot2 = builder.getResult();
		assertEquals(dot1.equals(dot2), false);
	}

	@Test
	public void dotHashCodeTestFalse() {
		dot2 = new Dot(dot1);

		assertEquals(dot2.hashCode() == dot3.hashCode(), false);
	}

	@Test
	public void dotHashCodeTestTrue() {
		dot2 = new Dot(dot1);

		assertEquals(dot2.hashCode(), dot2.hashCode());
	}

	@Test
	public void dotCopyConstructorTest() {
		dot2 = new Dot(dot1);

		assertEquals(dot1.equals(dot2), true);
	}

	@Test
	public void dotParameterConstructorTest() {
		dot2 = new Dot(1., 2., 5.);

		assertEquals(dot1.equals(dot2), true);
	}
}
