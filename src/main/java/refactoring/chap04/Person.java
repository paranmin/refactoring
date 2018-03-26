package refactoring.chap04;

public class Person {
	private final Label name;
	private final Label mail;

	public Person(Label name, Label mail) {
		this.name = name;
		this.mail = mail;
	}

	public Person(Label name) {
		this(name, new NullLabel());
	}

	public void display() {
		name.display();
		mail.display();
	}

	@Override
	public String toString() {
		return String.format("Person [name=%s, mail=%s]",
				name == null ? "\"(none)\"" : name,
				mail == null ? "\"(none)\"" : mail);
	}

}
