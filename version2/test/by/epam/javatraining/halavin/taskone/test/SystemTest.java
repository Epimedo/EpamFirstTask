package by.epam.javatraining.halavin.taskone.test;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.epam.javatraining.halavin.taskone.lib.bean.Cone;
import by.epam.javatraining.halavin.taskone.lib.bean.exception.BeanException;
import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;
import by.epam.javatraining.halavin.taskone.lib.controller.Controller;
import by.epam.javatraining.halavin.taskone.lib.util.Validator;
import by.epam.javatraining.halavin.taskone.lib.util.factory.UtilFactory;
import by.epam.javatraining.halavin.taskone.lib.util.impl.ShapeBuilder;
import by.epam.javatraining.halavin.taskone.util.input.CreaterDataGet;
import by.epam.javatraining.halavin.taskone.util.input.GetData;

public class SystemTest {
	private String input1;
	private String input4;
	private String squareRequest = "get_cone_square";
	private String spaceRequest = "get_cone_space";
	private String isFigureRequest = "get_is_figure_cone";
	private String isCoorPlaneCross = "get_is_cross_coor_plane";
	private String getSpaceRatio = "get_space_ratio";
	private String fileNameCone = "input/coneData.txt";
	private String fileNameCone4 = "input/coneData4.txt";
	private Shape cone1;
	private Shape cone4;

	@BeforeClass
	public void beforeClass() {
		GetData dat = new CreaterDataGet().create(fileNameCone);
		input1 = dat.read();
		input1 = Validator.processCone(input1);

		UtilFactory factory = UtilFactory.getInstance();
		ShapeBuilder builder = factory.getShapeBuilder();
		cone1 = builder.getResult(input1);
		
		dat = new CreaterDataGet().create(fileNameCone4);
		input4 = dat.read();
		input4 = Validator.processCone(input4);

		cone4 = builder.getResult(input4);
		
	}

	@Test
	public void squareCommandTest() throws BeanException {
		Controller controller = new Controller();
		String responce = controller.executeTask(squareRequest + " " + input1);
		Cone cone = (Cone) cone1;

		double expected = Math.PI * cone.getRadius() * (cone.getRadius() + cone.getForming());
		assertEquals(responce, "" + expected);

	}
	
	@Test
	public void wrongCommandTest() throws BeanException {
		Controller controller = new Controller();
		String responce = controller.executeTask("build"+ " " + input1);

		String expected = "Wrong command";
		assertEquals(responce, "" + expected);

	}

	@Test
	public void addShapeToFileCommandTest() throws BeanException {
		Controller controller = new Controller();
		String responce = controller.executeTask("add_shape_to_file"+ " " + input1);

		String expected = "Complete";
		assertEquals(responce, "" + expected);

	}

	
	@Test
	public void spaceCommandTest() throws BeanException {
		Controller controller = new Controller();
		String responce = controller.executeTask(spaceRequest + " " + input1);
		Cone cone = (Cone) cone1;

		double expected = cone.getHeight() / 3 * Math.pow(cone.getRadius(), 2.) * Math.PI;
		assertEquals(responce, "" + expected);

	}

	@Test
	public void isFigureCommandTest() throws BeanException {
		Controller controller = new Controller();
		String responce = controller.executeTask(isFigureRequest + " " + input1);

		boolean expected = true;
		assertEquals(responce, "" + expected);

	}
	
	@Test
	public void isCoorPlaneCommandTest() {
		Controller controller = new Controller();
		String responce = controller.executeTask(isCoorPlaneCross + " " + input1);

		boolean expected = false;
		assertEquals(responce, "" + expected);
	}
	
	@Test
	public void spaceRatioCommandTest() throws BeanException {
		Controller controller = new Controller();
		String responce = controller.executeTask(getSpaceRatio + " " + input4);

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

		assertEquals(responce, "" + expected);
	}
}
