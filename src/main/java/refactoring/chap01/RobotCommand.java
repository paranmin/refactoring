package refactoring.chap01;

public class RobotCommand {
	private final String _name;

	public RobotCommand(String _name) {
		this._name = _name;
	}

	@Override
	public String toString() {
		return String.format("[RobotCommand : %s]", _name);
	}
}
