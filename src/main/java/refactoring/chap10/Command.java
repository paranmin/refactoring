package refactoring.chap10;

import java.util.HashMap;
import java.util.Map;

public class Command {
	public static final Command FORWARD = new Command("forward");
	public static final Command BACKWARD = new Command("backward");
	public static final Command TURN_RIGHT = new Command("right");
	public static final Command TURN_LEFT = new Command("left");

	private static final Map<String, Command> commandMap = new HashMap<>();
	static {
		commandMap.put(FORWARD.name, FORWARD);
		commandMap.put(BACKWARD.name, BACKWARD);
		commandMap.put(TURN_RIGHT.name, TURN_RIGHT);
		commandMap.put(TURN_LEFT.name, TURN_LEFT);
	}

	private final String name;

	public Command(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Command parseCommand(String name) {
		if (!commandMap.containsKey(name)) {
			return null;
		}
		return commandMap.get(name);
	}

	@Override
	public String toString() {
		return String.format("Command [name=%s]", name);
	}

}
