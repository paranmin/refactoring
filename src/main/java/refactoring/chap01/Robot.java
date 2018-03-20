package refactoring.chap01;

public class Robot {
	public static final RobotCommand COMMAND_WALK = new RobotCommand("WALK");
	public static final RobotCommand COMMAND_STOP = new RobotCommand("STOP");
	public static final RobotCommand COMMAND_JUMP = new RobotCommand("JUMP");

	private final String _name;

	public Robot(String _name) {
		this._name = _name;
	}

	public void order(RobotCommand command) {
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
