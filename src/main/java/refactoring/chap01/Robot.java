package refactoring.chap01;

public class Robot {
	private final String _name;

	public Robot(String _name) {
		this._name = _name;
	}

	public void order(int command) {
		if (command == 0) {
			System.out.printf("%s %s%n", _name, " walks.");
		} else if (command == 1) {
			System.out.printf("%s %s%n", _name, " stops.");
		} else  if (command == 2) {
			System.out.printf("%s %s%n", _name, " jumps.");
		} else {
			System.out.printf("%s %s%n", "Command error. command = ", command);
		}
	}
}
