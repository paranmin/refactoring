package refactoring.chap06.extract_superclass;

public class Player {
	private boolean isMusic;
	private String musicData = "좋니";
	private String videoData = "효리네 민박";

	public void setCurrentMedia(boolean isMusic) {
		this.isMusic = isMusic;
	}

	public void play() {
		if (isMusic) {
			playMusic();
		} else {
			playVideo();
		}
	}

	public void loop() {
		if (isMusic) {
			loopMusic();
		} else {
			loopVideo();
		}
	}

	public void stop() {
		if (isMusic) {
			stopMusic();
		} else {
			stopVideo();
		}
	}

	private void playVideo() {
		System.out.printf("Play : %s%n", videoData);
	}

	private void playMusic() {
		System.out.printf("Play : %s%n", musicData);
	}

	private void loopVideo() {
		System.out.printf("loop : %s%n", videoData);
	}

	private void loopMusic() {
		System.out.printf("loop : %s%n", musicData);
	}

	private void stopVideo() {
		System.out.printf("stop : %s%n", videoData);
	}

	private void stopMusic() {
		System.out.printf("stop : %s%n", musicData);
	}
}
