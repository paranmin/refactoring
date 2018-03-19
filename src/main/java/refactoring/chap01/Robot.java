package refactoring.chap01;

public class Robot {
	public static final int COMMAND_JUMP = 2;
	public static final int COMMAND_STOP = 1;
	public static final int COMMAND_WALK = 0;
	private final String _name;

	public Robot(String _name) {
		this._name = _name;
	}

	public void order(int command) {
		if (command == COMMAND_WALK) {
			System.out.printf("%s %s%n", _name, "walks.");
		} else if (command == COMMAND_STOP) {
			System.out.printf("%s %s%n", _name, "stops.");
		} else  if (command == COMMAND_JUMP) {
			System.out.printf("%s %s%n", _name, "jumps.");
		} else {
			System.out.printf("%s %s%n", "Command error. command = ", command);
		}
	}
}
