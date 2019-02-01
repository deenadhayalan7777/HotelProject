package hotel;

public class Node {

	private int id;
	private Node source;
	private int distance;
	boolean visited;
	boolean reached;
	
	public Node(int id,Node source,int distance)
	{
		this.id=id;
		this.source=source;
		this.distance=distance;
		visited=false;
		reached=false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Node getSource() {
		return source;
	}

	public void setSource(Node source) {
		this.source = source;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public boolean isReached() {
		return reached;
	}

	public void setReached(boolean reached) {
		this.reached = reached;
	}
	
}
