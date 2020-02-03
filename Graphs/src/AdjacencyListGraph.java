import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AdjacencyListGraph<T> implements graphe {
	
	private Map<Node, List<Node>> data =  new HashMap<Node, List<Node>>();

	@Override
	public void insertNode(Node n) {
		if(!data.containsKey(n))
		{
			List<Node> l = new LinkedList<Node>();
			data.put(n,l);
		}
	}

	@Override
	public boolean deleteNode(Node n) {
		
		if(data.containsKey(n))
		{
			data.remove(n);
			return true;
		}
		return false;
		
	}

	@Override
	public void insertEdge(Edge e) {
		Node x = e.getX();
		Node y = e.getY();
		List<Node> l1 = data.get(x);
		List<Node> l2 = data.get(y);
		l1.add(y);
		l2.add(x);
		data.put(x, l1);
		data.put(y, l2);
	}

	@Override
	public boolean deleteEdge(Edge e) {
		Node x = e.getX();
		Node y = e.getY();
		List<Node> l1 = data.get(x);
		List<Node> l2 = data.get(y);
		if(l1.remove(y) && l2.remove(x))
		{
			data.put(x, l1);
			data.put(y, l2);
			return true;
		}
		return false;
	}

	@Override
	public List<Edge> outEdges(Node n) {
		List<Edge> out = new LinkedList<Edge>();
		for(int i =0; i<data.get(n).size(); ++i)
		{
			Edge ed = new Edge(n, data.get(n).get(i));
			out.add(ed);
		}
		return out;
	}

	@Override
	public boolean removeEdgesTo(Node n) {
		
		for(List<Node> x : data.values())
		{
			x.remove(n);
		}
		
		return false;
	}
	public void bfs()
	{
		Queue<Node> q = new LinkedList<Node>();
		Set<Node> nodes = data.keySet();
		Map<Node, Boolean> check = new HashMap<Node, Boolean>();
		for(Node x : nodes)
			check.put(x,false);
		for(Node n : nodes)
		{
	
		}
	}

	@Override
	public String toString() {
		return data.toString();
	}
	
	

}
