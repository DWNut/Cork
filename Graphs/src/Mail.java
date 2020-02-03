
public class Mail {

	public static void main(String[] args) {
		Node un = new Node("one");
		Node deux = new Node("two");
		Node trois = new Node("three");
		Node quatre = new Node("four");
		Node cinq = new Node("five");
		
		AdjacencyListGraph graph = new AdjacencyListGraph();
		
		graph.insertNode(un);
		graph.insertNode(deux);
		graph.insertNode(trois);
		graph.insertNode(quatre);
		graph.insertNode(cinq);
		graph.deleteNode(un);
		graph.deleteNode(cinq);
		Edge e = new Edge(deux,trois);
		Edge f = new Edge(quatre,trois);
		graph.insertEdge(e);
		graph.insertEdge(f);
		
		graph.removeEdgesTo(trois);
		System.out.println(graph.outEdges(trois));
		System.out.println(graph.toString());
	}

}
