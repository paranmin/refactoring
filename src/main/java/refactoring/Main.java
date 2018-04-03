package refactoring;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import refactoring.chap01.Robot;
import refactoring.chap02.FindInt;
import refactoring.chap02.simple.SimpleDatabase;
import refactoring.chap03.SortSample;
import refactoring.chap04.Label;
import refactoring.chap04.Person;
import refactoring.chap05.Banner;
import refactoring.chap06.Book;
import refactoring.chap06.extract_superclass.Player;
import refactoring.chap08.Shape;
import refactoring.chap09.Logger;
import refactoring.chap10.CH10Robot;
import refactoring.chap11.Ch11Shape;
import refactoring.chap12.IntegerDisplay;
import refactoring.chap13.Dice;
import refactoring.chap14.AddressFile;
import refactoring.chap15.CSVFileTreePrinter;
import refactoring.chap15.CSVStringTablePrinter;

public class Main {
	private static final Random random = new Random(1234);

	public static void main(String[] args) {
		// chapter01();
		// chapter02();
		// chapter02_simple();
		// chapter03();
		// chapter04();
		// chapter05();
		// chapter06();
		// chapter06_extract_superclass();
		// chapter08();
		// chapter09();
		// chapter10();
		// chapter11();
		// chapter12();
		// chapter13();
		// chapter14();
		
		chapter15();
		
	}

	private static void chapter15() {
		String sample_csv_string = 
				"좋은 아침입니다.,Good morning.\n" +
				"안녕하세요~,Hello.\n" +
				"안녕하세요.,Good evening.\n" +
				"안녕히 주무세요.,Good night.\n";
		String sample_csv_file = "file.csv";
		
		try {
			new CSVStringTablePrinter(sample_csv_string).print();
			new CSVFileTreePrinter(sample_csv_file).print();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void chapter14() {
		try {
			AddressFile file = new AddressFile("address.txt");
			file.getDatabase().set("Hanjimin", "test1@test.com");
			file.getDatabase().set("Song Hae Gyo", "test2@korea.com");
			file.getDatabase().set("Park Cho Rong", "numberOne@apink.com");
			file.getDatabase().update();

			Enumeration<?> e = file.names();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String mail = file.getDatabase().get(name);
				System.out.printf("name=%s, mail=%s%n", name, mail);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void chapter13() {
		List<Dice> dices = Arrays.asList(new Dice(), new Dice(456L), new Dice());
		dices.get(2).setSeed(456L);

		for (Dice d : dices) {
			for (int i = 0; i < 10; i++) {
				System.out.printf("%d%s", d.nextInt(), i < 9 ? "," : "");
			}
			System.out.println();
		}
	}

	private static void chapter12() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntegerDisplay frame = new IntegerDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void chapter11() {
		List<Ch11Shape> shapeList = Arrays.asList(new Ch11Shape(Ch11Shape.TYPECODE_LINE, 0, 0, 100, 200),
				new Ch11Shape(Ch11Shape.TYPECODE_RECTANGLE, 10, 20, 30, 40),
				new Ch11Shape(Ch11Shape.TYPECODE_OVAL, 100, 200, 300, 400));
		for (Ch11Shape s : shapeList) {
			s.draw();
		}
	}

	private static void chapter10() {
		CH10Robot robot = new CH10Robot("Andrew");
		System.out.println(robot.toString());

		robot.execute("forward right forward");
		System.out.println(robot.toString());

		robot.execute("left backward left forward");
		System.out.println(robot.toString());

		robot.execute("right forward forward farvard");
		System.out.println(robot.toString());
	}

	private static void chapter09() {
		Logger logger = new Logger();
		logger.log("infomation #1");

		logger.start();
		logger.log("infomation #2");

		logger.start();
		logger.log("infomation #3");

		logger.stop();
		logger.log("infomation #4");

		logger.stop();
		logger.log("infomation #5");
	}

	private static void chapter08() {
		List<Shape> shapeList = Arrays.asList(new Shape(Shape.TYPECODE_LINE, 0, 0, 100, 200),
				new Shape(Shape.TYPECODE_RECTANGLE, 10, 20, 30, 40),
				new Shape(Shape.TYPECODE_OVAL, 100, 200, 300, 400));
		for (Shape s : shapeList) {
			s.draw();
		}
	}

	private static void chapter06_extract_superclass() {
		Player musicPlayer = new Player();
		Player videoPlayer = new Player();
		musicPlayer.setCurrentMedia(true);
		videoPlayer.setCurrentMedia(false);
		play(musicPlayer);
		play(videoPlayer);
	}

	private static void play(Player player) {
		player.play();
		player.loop();
		player.stop();
	}

	// 클래스 추출
	private static void chapter06() {
		Book refactoring = new Book("Refactoring : improving the design of existing code", "ISBN0201485672", "$44.95",
				"Marting Fowler", "fowler@acm.org");

		System.out.println("refactoring : ");
		System.out.println(refactoring.toXML());
	}

	// 메서드 추출
	private static void chapter05() {
		Banner hello = new Banner("Hello, World!!");
		hello.print(3);
	}

	// 널 객체 도입
	private static void chapter04() {
		Person[] people = { new Person(new Label("Alice"), new Label("alice@test.com")),
				new Person(new Label("Bobby"), new Label("bobby@test.com")), new Person(new Label("Chris")) };

		for (Person p : people) {
			System.out.println(p);
			p.display();
			System.out.println();
		}
	}

	// 어서션 도입
	private static void chapter03() {
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

	// 제어 플러그 삭제 - 조금 더 복잡한 예제
	private static void chapter02_simple() {
		try {
			String fileUrl = Thread.currentThread().getContextClassLoader().getResource("dbfile.txt").getPath();
			SimpleDatabase db = new SimpleDatabase(new FileReader(fileUrl));
			Iterator<String> iterator = db.iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.printf("KEY : %s%nVALUE : %s%n%n", key, db.getValue(key));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 제어 플러그 삭제
	private static void chapter02() {
		int[] data = { 1, 9, 0, 2, 8, 5, 6, 3, 4, 7 };
		if (FindInt.find(data, 5)) {
			System.out.println("Found!");
		} else {
			System.out.println("Not found...");
		}
	}

	// 매직넘버를 기호 상수로 변환
	private static void chapter01() {
		Robot robot = new Robot("Andrew");
		robot.order(Robot.COMMAND_WALK);
		robot.order(Robot.COMMAND_STOP);
		robot.order(Robot.COMMAND_JUMP);
	}

}
