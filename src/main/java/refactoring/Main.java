package refactoring;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import refactoring.chap01.Robot;
import refactoring.chap02.FindInt;
import refactoring.chap02.simple.SimpleDatabase;

public class Main {

	public static void main(String[] args) {
		// chapter01();
		// chapter02();
		
		try {
			String fileUrl = Thread.currentThread()
					.getContextClassLoader()
					.getResource("dbfile.txt")
					.getPath();
			SimpleDatabase db = new SimpleDatabase(new FileReader(fileUrl));
			Iterator<String> iterator = db.iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.printf("KEY : %s%nVALUE : %s%n%n", key, db.getValue(key));
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void chapter02() {
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
