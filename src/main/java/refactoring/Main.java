package refactoring;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import refactoring.chap01.Robot;
import refactoring.chap02.FindInt;
import refactoring.chap02.simple.SimpleDatabase;
import refactoring.chap03.SortSample;

public class Main {
	private static final Random random = new Random(1234);
	public static void main(String[] args) {
		// chapter01();
		// chapter02();
		// chapter02_simple();
		
		execute(10);
		execute(10);
		execute(10);
		execute(10);
		execute(10);
	}
	
	private static void execute(int length) {
		int[] data = new int[length];
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(data.length);
		}
		
		SortSample sorter = new SortSample(data);
		System.out.printf("%6s : %s%n", "BEFORE", sorter);
		
		sorter.sort();
		System.out.printf("%6s : %s%n%n", "AFTER", sorter);
	}

	private static void chapter02_simple() {
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
