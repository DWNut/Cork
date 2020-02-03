import java.util.Arrays;
import java.util.Iterator;

public class IntArrayList<T> implements List<T>, Iterable<T> {
	private T[] contents;
	public int nextFree = 0;
	
	@SuppressWarnings("unchecked")
	public IntArrayList()
	{
		contents = (T[])(new Object[50]);
	}
	@SuppressWarnings("unchecked")
	public IntArrayList(int n)
	{
		contents = (T[])(new Object[n]);
	}
	public int size()
	{
		return nextFree;
	}
	
	public void setSize(int size)
	{
		nextFree += size;
	}
	@SuppressWarnings("unchecked")
	public void add(T x)
	{
		if(contents.length==nextFree)
		{
			T[] tmp = (T[]) (new Object[contents.length*2]);
			for(int i= 0;i<contents.length;i++){
				tmp[i]=contents[i];
			}
			contents=tmp;
		}
		contents[nextFree]=x;
		nextFree++;
	}
	
	public T get(int index)
	{
		return (contents[index]);
	}
	
	public void set(int index, T x)
	{
		contents[index]=x;
	}
	
	public boolean remove(T x)
	{
		int i=0;
		while(i<nextFree && contents[i]!=x)
		{
			i++;
		}
		if(i==nextFree)
		{
			return false;
		}
		for(int j=i+1;j<nextFree;j++)
		{
			contents[j-1]=contents[j];
		}
		nextFree--;
		return true;		
	}
	
	
	public boolean contains(T x)
	{
		int i=0;
		while(i<contents.length && contents[i]!=x)
		{
			i++;
		}
		return (i!=contents.length);
	}
	public boolean isEmpty()
	{
		return (nextFree == 0);
	}
	public String toString()
	{
		String str="";
		for(int i=0;i<nextFree;i++)
		{
			str = str + contents[i]+ " ";
		}
		return str;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntArrayList other = (IntArrayList) obj;
		if (!Arrays.equals(contents, other.contents))
			return false;
		if (nextFree != other.nextFree)
			return false;
		return true;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return  (Iterator<T>) new ArrayIterator<T>(contents, nextFree);
	}
	
	
}
