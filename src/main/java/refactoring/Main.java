package refactoring;

import refactoring.chap01.Robot;
import refactoring.chap02.FindInt;

public class Main {

	public static void main(String[] args) {
		// chapter01();
		int[] data = { 1, 9, 0, 2, 8, 5, 6, 3, 4, 7 };
		if (FindInt.find(data, 5)) {
			System.out.println("Found!");
		} else {
			System.out.println("Not found...");
		}
	}

	private static void chapter01() {
		Robot robot = new Robot("Andrew");
		robot.order(Robot.COMMAND_WALK);
		robot.order(Robot.COMMAND_STOP);
		robot.order(Robot.COMMAND_JUMP);
	}

}
