package refactoring.chap03;

public class SortSample {
	private final int[] data;

	public SortSample(int[] data) {
		this.data = new int[data.length];
		System.arraycopy(data, 0, this.data, 0, data.length);
	}
	
	public void sort() {
		// Arrays.sort(data);
		for (int x = 0; x < data.length - 1; x++) {
			int m = x;
			for (int y = x + 1; y < data.length; y++) {
				if (data[m] > data[y]) {
					m = y;
				}
			}
			int v = data[m];
			data[m] = data[x];
			data[x] = v;
		}
	}

	private boolean isSorted(int start, int end) {
		for (int i = start; i < end; i++) {
			if (data[i] > data[i + 1]) {
				return false;
			}
		}
		return true;
	}

	private boolean isMin(int pos, int start, int end) {
		for (int i = start; i < end+1; i++) {
			if (data[pos] > data[i]) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (int i = 0; i < data.length; i++) {
			sb.append(data[i]);
			sb.append(", ");
		}
		sb.append("]");
		
		return sb.toString();
	}
	
}
