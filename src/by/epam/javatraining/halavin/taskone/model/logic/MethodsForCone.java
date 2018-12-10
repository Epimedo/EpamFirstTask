package by.epam.javatraining.halavin.taskone.model.logic;

import by.epam.javatraining.halavin.taskone.model.entity.Cone;
import by.epam.javatraining.halavin.taskone.model.exception.ConeException;
import by.epam.javatraining.halavin.taskone.model.exception.ConeWithoutCentreDot;
import by.epam.javatraining.halavin.taskone.model.exception.NotConeInput;
import by.epam.javatraining.halavin.taskone.model.exception.PlateDoesNotCrossCone;
import by.epam.javatraining.halavin.taskone.util.output.CreatorLogOutput;
import by.epam.javatraining.halavin.taskone.util.output.Output;

public class MethodsForCone {

	public static double getSquare(Cone cone) throws NotConeInput {
		if (!isCone(cone)) {
			throw new NotConeInput();
		}
		double square = 0;

		try {

			square = Math.PI * cone.getRadius() * (cone.getRadius() + cone.getForming());

		} catch (ConeException e) {
			Output out = new CreatorLogOutput().create();
			out.print(e.getMessage());
		}

		return square;
	}

	public static double getSpace(Cone cone) throws NotConeInput {
		if (!isCone(cone)) {
			throw new NotConeInput();
		}
		double space = 0;

		try {

			space = cone.getHeight() / 3 * Math.pow(cone.getRadius(), 2.) * Math.PI;

		} catch (ConeException e) {
			Output out = new CreatorLogOutput().create();
			out.print(e.getMessage());
		}

		return space;
	}

	public static boolean isCone(Cone cone) {
		try {
			if (cone.getForming() == Math.sqrt(Math.pow(cone.getHeight(), 2.) + Math.pow(cone.getRadius(), 2.))) {

				return true;
			}
		} catch (ConeException e) {
			Output out = new CreatorLogOutput().create();
			out.print(e.getMessage());
		}

		return false;
	}

	public static boolean isCoorPlane(Cone cone) throws NotConeInput {
		if (!isCone(cone)) {
			throw new NotConeInput();
		}
		boolean bool = false;

		try {
			if (cone.getCentreDot().getX() == 0 || cone.getCentreDot().getY() == 0 || cone.getCentreDot().getZ() == 0) {
				bool = true;
			}
		} catch (ConeWithoutCentreDot e) {
			Output out = new CreatorLogOutput().create();
			out.print(e.getMessage());
		}

		return bool;
	}

	public static double getSpaceRatio(Cone cone) throws NotConeInput, PlateDoesNotCrossCone {
		if (!isCone(cone)) {
			throw new NotConeInput();
		}
		double ratio = -1;
		double newHeight = 0;
		double newRadius = 0;
		double plate1 = 0;
		double plate2 = 0;

		try {
			if (cone.getCentreDot().getX() == cone.getRadDot().getX()
					&& Math.abs(cone.getCentreDot().getX() - cone.getTopDot().getX()) == cone.getHeight()
					&& ((cone.getCentreDot().getX() > 0 && cone.getTopDot().getX() < 0)
							|| (cone.getCentreDot().getX() < 0 && cone.getTopDot().getX() > 0))) {
				newHeight = Math.abs(cone.getCentreDot().getX());
			} else if (cone.getCentreDot().getY() == cone.getRadDot().getY()
					&& Math.abs(cone.getCentreDot().getY() - cone.getTopDot().getY()) == cone.getHeight()
					&& ((cone.getCentreDot().getY() > 0 && cone.getTopDot().getY() < 0)
							|| (cone.getCentreDot().getY() < 0 && cone.getTopDot().getY() > 0))) {
				newHeight = Math.abs(cone.getCentreDot().getY());
			} else if (cone.getCentreDot().getZ() == cone.getRadDot().getZ()
					&& Math.abs(cone.getCentreDot().getZ() - cone.getTopDot().getZ()) == cone.getHeight()
					&& ((cone.getCentreDot().getZ() > 0 && cone.getTopDot().getZ() < 0)
							|| (cone.getCentreDot().getZ() < 0 && cone.getTopDot().getZ() > 0))) {
				newHeight = Math.abs(cone.getCentreDot().getZ());
			} else {
				throw new PlateDoesNotCrossCone();
			}
			newRadius = (cone.getHeight() - newHeight) * cone.getRadius() / cone.getHeight();

			plate1 = (cone.getHeight() - newHeight) / 3 * Math.pow(newRadius, 2.) * Math.PI;
			plate2 = newHeight * Math.PI / 3
					* (Math.pow(cone.getRadius(), 2.) + cone.getRadius() * newRadius + Math.pow(newRadius, 2.));

			ratio = plate1 / plate2;
		} catch (ConeException e) {
			Output out = new CreatorLogOutput().create();
			out.print(e.getMessage());
		}

		return ratio;
	}
}
