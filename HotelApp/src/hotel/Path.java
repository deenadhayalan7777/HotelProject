package hotel;

public class Path {

	private int source;
	private int dest;
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getDest() {
		return dest;
	}
	public void setDest(int dest) {
		this.dest = dest;
	}
	public Path(int source, int dest) {
		
		this.source = source;
		this.dest = dest;
	}
	
	
}
