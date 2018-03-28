package refactoring.chap11;

public class Ch11Shape {
	public static final int TYPECODE_LINE = 0;
	public static final int TYPECODE_RECTANGLE = 1;
	public static final int TYPECODE_OVAL = 2;

	private final int typecode;
	private final int startx;
	private final int starty;
	private final int endx;
	private final int endy;

	public Ch11Shape(int typecode, int startx, int starty, int endx, int endy) {
		this.typecode = typecode;
		this.startx = startx;
		this.starty = starty;
		this.endx = endx;
		this.endy = endy;
	}

	public int getTypecode() {
		return typecode;
	}

	@Override
	public String toString() {
		return String.format("[%-10s, (%3s, %3s) - (%3s, %3s)]", getName(), startx, starty,
				endx, endy);
	}

	private String getName() {
		switch(typecode) {
		case TYPECODE_LINE:
			return "LINE";
		case TYPECODE_RECTANGLE:
			return "RECTANGLE";
		case TYPECODE_OVAL:
			return "OVAL";
		default:
			return null;
		}
	}

	public void draw() {
		switch(typecode) {
		case TYPECODE_LINE:
			drawLine();
			break;
		case TYPECODE_RECTANGLE:
			drawRectangle();
			break;
		case TYPECODE_OVAL:
			drawOval();
			break;
		default:
		}
	}

	private void drawOval() {
		System.out.printf("%15s : %s%n", "drawOval", this.toString());
	}

	private void drawRectangle() {
		System.out.printf("%15s : %s%n", "drawRectangle", this.toString());
	}

	private void drawLine() {
		System.out.printf("%15s : %s%n", "drawLine", this.toString());
	}
}
