
import java.util.*;

public class ArrayIterator<T> implements Iterator<T>
{
	private T[] d;
	private int index = 0;
	private int size;
	
	ArrayIterator(T[] dd, int s)
	{
		d = dd;
		size = s;
	}
	
	public boolean hasNext()
	{
		return index < size;
	}
	public T next()
	{
		if(index == size) throw new NoSuchElementException();
		T item = (T) d[index];
		index++;
		return item;
	}
	public void remove(){}
	public Iterator<T> iterator()
	{
		return new ArrayIterator<T>(d,size);
	}
	
	
}
