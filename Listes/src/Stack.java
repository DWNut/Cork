
public class Stack<E> implements Staque<E>
{
	private List<E> st;
	
	@SuppressWarnings("unchecked")
	public Stack()
	{
		st = new IntArrayList<E>();
	}
	
	public void push(E x)
	{
		st.add(x);
		
	}
	
	public boolean pop()
	{
		st.remove(st.get(0));
		return true;
	}
	
	public E top()
	{
		return st.get(0);
	}
	
	public boolean empty()
	{
		return st.isEmpty();
	}
	
	public boolean full()
	{
		return false;
	}

}
