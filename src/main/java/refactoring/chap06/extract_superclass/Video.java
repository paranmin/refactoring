package refactoring.chap06.extract_superclass;

public class Video {
	public String data;

	public Video(String videoData) {
		this.data = videoData;
	}
	
	public void play() {
		System.out.printf("Play : %s%n", data);
	}

	public void loop() {
		System.out.printf("loop : %s%n", data);
	}

	public void stop() {
		System.out.printf("stop : %s%n", data);
	}
}