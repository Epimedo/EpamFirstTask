package by.epam.javatraining.halavin.taskone.util;

public class ConeFactory {

	public ConeBuilder create(String str) {
		return new ConeBuilder(str);
	}
}
