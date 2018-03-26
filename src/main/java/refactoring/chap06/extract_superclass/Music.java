package refactoring.chap06.extract_superclass;

public class Music {
	private String data;

	public Music(String data) {
		this.data = data;
	}

	public void play() {
		System.out.printf("Play : %s%n", data);
	}

	public void loop() {
		System.out.printf("Loop : %s%n", data);
	}

	public void stop() {
		System.out.printf("Stop : %s%n", data);
	}
}