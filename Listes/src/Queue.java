
public class Queue<E> implements QueueInter<E> {
	
protected List<E> st;
	
	 Queue()
	{
		st = new IntArrayList<E>();
	}
	
	public void enqueue(E x)
	{
		st.set(st.size(), x);
		st.setSize(1); //increments size by 1
		
	}
	
	public boolean dequeue()
	{
		st.remove(st.get(0));
		return true;
	}
	
	public E front()
	{
		return st.get(0);
	}
	public int size()
	{
		return st.size();
	}
	
	public boolean isEmpty()
	{
		return st.isEmpty();
	}
	
	

}
