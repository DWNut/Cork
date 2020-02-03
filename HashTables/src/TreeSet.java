import java.util.*;

public class TreeSet<T extends Comparable<T>> implements BST<T> {

	private BSTNode<T> root;

	public TreeSet(BSTNode<T> root)
	{
		super();
		this.root = new BSTNode<T>(null,null,null);
	}

	public void add(T x)
	{
		BSTNode<T> ptr = root; 
		while(ptr.getlNode() != null && ptr.getrNode() != null)
		{
			if (x.compareTo(ptr.getValue())< 0)
			{
				if(ptr.getlNode() == null)
				{
					BSTNode<T> newNode = new BSTNode<T>(null, x, null);
					ptr.setlNode(newNode);
				}
				ptr = ptr.getlNode();
			}
			else 
			{
				if(ptr.getrNode() == null)
				{
					BSTNode<T> newNode = new BSTNode<T>(null, x, null);
					ptr.setrNode(newNode);
					System.out.println("chat2");
				}
				ptr = ptr.getrNode();
			}
		}
	}

	public boolean contains(T x)
	{
		BSTNode<T> ptr = root; 
		while(ptr.getlNode() != null && ptr.getrNode() != null)
		{

			if (x.compareTo(ptr.getValue()) == 0)
			{
				return true;
			}
			else if (x.compareTo(ptr.getValue())< 0)
			{
				ptr = ptr.getlNode();
			}
			else 
			{
				ptr = ptr.getrNode();
			}
		}
		return false;
	}

	public boolean remove(T x)
	{
		BSTNode<T> ptr = root;
		if(contains(x))
		{
			if (x.compareTo(ptr.getValue()) > 0)
			{
				ptr = ptr.getrNode();
				return true;
			}
			else if (x.compareTo(ptr.getValue())< 0)
			{
				ptr = ptr.getlNode();
				return true;
			}
			else
			{
				if(ptr.getlNode() == null && ptr.getrNode() == null)
				{
					ptr.setValue(null);
					ptr = null;
					return true;
				}
				else if(ptr.getlNode() == null && ptr.getrNode() != null)
				{					
						ptr = ptr.getrNode();
						ptr.setrNode(null);
						return true;
				}
				
				else if(ptr.getlNode() != null && ptr.getrNode() == null)
				{
					ptr = ptr.getlNode();
					ptr.setlNode(null);
					return true;
				}
			}
		}
		else
			return false;
	}

	public int size()
	{
		
	}

	public boolean isEmpty()
	{
		return (root.getValue() == null); 
	}


}
