package refactoring.chap09.exam;

public class Player {
	private Media media = Media.NULL;

	public void play() {
		if (media == Media.VIDEO) {
			System.out.printf("%s : %s%n", "Video", "play");
		} else if (media == Media.MUSIC) {
			System.out.printf("%s : %s%n", "Music", "play");
		} else if (media == Media.NULL) {
			System.out.printf("%s : %s%n", "Null", "play");
		} else {
			assert false;
		}
	}

	public void loop() {
		if (media == Media.VIDEO) {
			System.out.printf("%s : %s%n", "Video", "loop");
		} else if (media == Media.MUSIC) {
			System.out.printf("%s : %s%n", "Music", "loop");
		} else if (media == Media.NULL) {
			System.out.printf("%s : %s%n", "Null", "loop");
		} else {
			assert false;
		}
	}

	public void stop() {
		if (media == Media.VIDEO) {
			System.out.printf("%s : %s%n", "Video", "stop");
		} else if (media == Media.MUSIC) {
			System.out.printf("%s : %s%n", "Music", "stop");
		} else if (media == Media.NULL) {
			System.out.printf("%s : %s%n", "Null", "stop");
		} else {
			assert false;
		}
	}
	
	public void setMedia(Media media) {
		if (this.media == null) {
			this.media = Media.NULL;
		} else {
			this.media = media;
		}
	}
}
