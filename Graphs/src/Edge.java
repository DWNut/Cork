
public class Edge {
	private Node y;
	private Node x;
	
	Edge(Node x, Node y)
	{
		this.x = x;
		this.y = y;		
	}

	public Node getY() {
		return y;
	}

	public void setY(Node y) {
		this.y = y;
	}

	public Node getX() {
		return x;
	}

	public void setX(Node x) {
		this.x = x;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y +")";
	}
	
	

}
