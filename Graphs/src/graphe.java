import java.util.List;

public interface graphe<T> {
	public void insertNode(Node n);
	public boolean deleteNode(Node n);
	public void insertEdge(Edge e);
	public boolean deleteEdge(Edge e);
	public List<Edge> outEdges(Node n);
	public boolean removeEdgesTo(Node n);
	public void bfs(); 

}
