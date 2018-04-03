package refactoring.chap14;

import java.util.Enumeration;

public class AddressFile {
	private final Database database;

	public AddressFile(String fileName) {
		this.database = new Database(fileName);
	}

	public Database getDatabase() {
		return database;
	}

	public Enumeration<?> names() {
		return database.getProperties().propertyNames();
	}

}
