package by.epam.javatraining.halavin.taskone.lib.bean;

import by.epam.javatraining.halavin.taskone.lib.bean.exception.BeanException;
import by.epam.javatraining.halavin.taskone.lib.bean.impl.Shape;

public class Cone implements Shape{
	private Dot topDot;
	private double radius;
	private Dot centreDot;
	private double height;
	private Dot radDot;
	private double forming;

	public Cone() {
		super();
	}

	public Cone(Dot centreDot, Dot radDot, Dot topDot) {
		this.centreDot = centreDot;
		this.radDot = radDot;
		this.topDot = topDot;
		radius = Math.sqrt(Math.pow(centreDot.getX() - radDot.getX(), 2.)
				+ Math.pow(centreDot.getY() - radDot.getY(), 2.) + Math.pow(centreDot.getZ() - radDot.getZ(), 2.));
		height = Math.sqrt(Math.pow(centreDot.getX() - topDot.getX(), 2.)
				+ Math.pow(centreDot.getY() - topDot.getY(), 2.) + Math.pow(centreDot.getZ() - topDot.getZ(), 2.));
		forming = Math.sqrt(Math.pow(topDot.getX() - radDot.getX(), 2.) + Math.pow(topDot.getY() - radDot.getY(), 2.)
				+ Math.pow(topDot.getZ() - radDot.getZ(), 2.));
	}

	public Cone(Cone cone) {
		centreDot = cone.centreDot;
		radDot = cone.radDot;
		topDot = cone.topDot;
		height = cone.height;
		radius = cone.radius;
		forming = cone.forming;
	}

	public Dot getTopDot() throws BeanException {
		if (topDot == null) {
			throw new BeanException("Cone doesn't have top dot");
		}
		return topDot;
	}

	public void setTopDot(Dot topDot) {
		this.topDot = topDot;
	}

	public double getRadius() throws BeanException {
		if (radius == 0) {
			if (centreDot == null) {
				throw new BeanException("Cone doesn't have centre dot");
			}
			if (radDot == null) {
				throw new BeanException("Cone doesn't have radius dot");
			}
			radius = Math.sqrt(Math.pow(centreDot.getX() - radDot.getX(), 2.)
					+ Math.pow(centreDot.getY() - radDot.getY(), 2.) + Math.pow(centreDot.getZ() - radDot.getZ(), 2.));
		}
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Dot getCentreDot() throws BeanException {
		if (centreDot == null) {
			throw new BeanException("Cone doesn't have centre dot");
		}
		return centreDot;
	}

	public void setCentreDot(Dot centreDot) {
		this.centreDot = centreDot;
	}

	public double getForming() throws BeanException {
		if (forming == 0) {
			if (radDot == null) {
				throw new BeanException("Cone doesn't have radius dot");
			}
			if (topDot == null) {
				throw new BeanException();
			}
			forming = Math.sqrt(Math.pow(topDot.getX() - radDot.getX(), 2.)
					+ Math.pow(topDot.getY() - radDot.getY(), 2.) + Math.pow(topDot.getZ() - radDot.getZ(), 2.));
		}
		return forming;
	}

	public void setForming(double froming) {
		this.forming = froming;
	}

	public double getHeight() throws BeanException {
		if (height == 0) {
			if (centreDot == null) {
				throw new BeanException("Cone doesn't have centre dot");
			}
			if (topDot == null) {
				throw new BeanException("Cone doesn't have top dot");
			}

			height = Math.sqrt(Math.pow(centreDot.getX() - topDot.getX(), 2.)
					+ Math.pow(centreDot.getY() - topDot.getY(), 2.) + Math.pow(centreDot.getZ() - topDot.getZ(), 2.));
		}
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Dot getRadDot() throws BeanException {
		if (radDot == null) {
			throw new BeanException("Cone doesn't have radius dot");
		}
		return radDot;
	}

	public void setRadDot(Dot radDot) {
		this.radDot = radDot;
	}

	@Override
	public String toString() {
		return "Dot\ncentre " + centreDot + "\nradius " + radDot + "\ntop " + topDot + "\nheigth = " + height
				+ "\nradius = " + radius + "\nforming = " + forming;
	}

	@Override
	public int hashCode() {
		int prime = 12;
		return (int) (prime * (radius + height + forming)) + centreDot.hashCode() + topDot.hashCode()
				+ radDot.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Cone cone = (Cone) obj;

		return centreDot.equals(cone.centreDot) && topDot.equals(cone.topDot) && radDot.equals(cone.radDot);

	}
}
