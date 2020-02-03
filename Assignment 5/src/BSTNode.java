
public class BSTNode<T extends Comparable<T>>
{
	private BSTNode<T> lNode;
	private T value;
	private BSTNode<T> rNode;
	
	public BSTNode(BSTNode<T> lNode, T value, BSTNode<T> rNode)
	{
		super();
		this.setlNode(lNode);
		this.setValue(value);
		this.setrNode(rNode);
	}

	public BSTNode<T> getlNode() {
		return lNode;
	}

	public void setlNode(BSTNode<T> lNode) {
		this.lNode = lNode;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public BSTNode<T> getrNode() {
		return rNode;
	}

	public void setrNode(BSTNode<T> rNode) {
		this.rNode = rNode;
	}
	

}
