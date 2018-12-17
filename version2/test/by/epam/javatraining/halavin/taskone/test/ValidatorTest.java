package by.epam.javatraining.halavin.taskone.test;

import org.testng.annotations.Test;

import by.epam.javatraining.halavin.taskone.lib.util.Validator;
import by.epam.javatraining.halavin.taskone.util.input.CreaterDataGet;
import by.epam.javatraining.halavin.taskone.util.input.GetData;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class ValidatorTest {
	private String fileNameCone = "input/validatorData.txt";
	private String fileNameConeNeg = "input/validatorDataNeg.txt";
	private String fileNameDot = "input/validatorDot.txt";
	private String fileNameDotNeg = "input/validatorDotNeg.txt";
	private String input;
	private String inputNeg;
	private String inputDot;
	private String inputDotNeg;

	@BeforeClass
	public void beforeClass() {
		GetData dat = new CreaterDataGet().create(fileNameCone);
		input = dat.read();
		dat = new CreaterDataGet().create(fileNameConeNeg);
		inputNeg = dat.read();
		dat = new CreaterDataGet().create(fileNameDot);
		inputDot = dat.read();
		dat = new CreaterDataGet().create(fileNameDotNeg);
		inputDotNeg = dat.read();
	}

	@Test
	public void validatorConeTest() {
		String expected = input.split("\\n+")[3];
		String result;

		result = Validator.processCone(input);

		Assert.assertEquals(result, expected);
	}

	@Test
	public void validatorConeNegTest() {
		String expected = inputNeg.split("\\n+")[3];
		String result;

		result = Validator.processCone(inputNeg);

		Assert.assertEquals(result, expected);
	}

	@Test
	public void validatorDotTest() {
		String expected = inputDot.split("\\n+")[2];
		String result;

		result = Validator.processDot(inputDot);

		Assert.assertEquals(result, expected);
	}

	@Test
	public void validatorDotNegTest() {
		String expected = inputDotNeg.split("\\n+")[2];
		String result;

		result = Validator.processDot(inputDotNeg);

		Assert.assertEquals(result, expected);
	}
}
