
public interface QueueInter<E> 
{
	public void enqueue(E x);
	public boolean dequeue();
	public E front();
	public int size();
	public boolean isEmpty();
}

