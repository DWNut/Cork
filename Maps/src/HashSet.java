import java.util.*;

public class HashSet<E>  implements HashSetInter<E>, Iterable<E>
{
	private LinkedList<E> data[];
	@SuppressWarnings("unchecked")
	public HashSet(int n)
	{
		data = (LinkedList<E>[]) (new LinkedList[n]);
		for (int i = 0; i<data.length; ++i)
		{
			data[i] = new LinkedList<E>();
		}
	}
	
	
	public int hashC(E x)
	{
		if(x != null)
		{
			int k = x.hashCode();
			int h = Math.abs(k % data.length);
			return(h);
		}
		return 0;
	}
	public LinkedList<E> get(int i)
	{
		return data[i];
	}
	
	public void add(E x)
	{
		int i = hashC(x);
		if (!data[i].contains(x))
			data[i].add(x);
		
	}
	
	public boolean contains(E x)
	{
		int i = hashC(x);
		return(data[i].contains(x));
		
	}
	
	public boolean remove(E x)
	{
		int index = hashC(x);
		return data[index].remove(x);
		
	}
	
	public int size()
	{
		int size = 0;
		for(int i = 0; i<data.length; ++i)
		{
			size += data[i].size();
		}
		return size;
	}
	
	public boolean isEmpty()
	{
		return data.length == 0;
	}
	
	public void clear()
	{
		for (int i = 0; i<data.length; ++i)
		{
			for(int j = 0; j< data[i].size(); ++j)
			{
				data[i].remove(data[j]); 
			}
		}
	}
	
	
	public HashSetInter<E> union(HashSetInter<E> h)
	{
		HashSetInter<E> un = new HashSet<E>(this.size() + h.size());
		for(int i = 0; i < h.size(); ++i)
			{
				for(E x : h.get(i)) un.add(x);
			}
		for (int i = 0; i < size(); ++i)
			{
				for(E x : this.data[i]) un.add(x);
		
			}
		return un;
	}
	
	public HashSetInter<E> difference(HashSetInter<E> h)
	{
		for(int i = 0; i < h.size(); ++i)
		{
			for(E x : h.get(i))
				if (this.contains(x))
				{
					this.remove(x);
				}			
		}
		return this;
		
	}
	public HashSetInter<E> intersection(HashSetInter<E> h)
	{
		HashSetInter<E> in = new HashSet<E>(this.size() + h.size());
		for(int i = 0; i < h.size(); ++i)
		{
			for(E x : h.get(i))
			{
				if (this.contains(x))
					in.add(x);		
			}
			
		}
		return in;
	}
	public HashSetInter<E> symmetric_difference(HashSetInter<E> h)
	{
		HashSetInter<E> rem = new HashSet<E>(this.size() + h.size());
		rem = this.intersection(h);
		HashSetInter<E> dat = new HashSet<E>(this.size() + h.size());
		dat = this.union(h);
		for (int i = 0; i < this.size()+h.size(); ++i)
		{
			for(E x : dat.get(i)) 
				{
					if (rem.contains(x))
						dat.remove(x);				
			
				}
		}
		return dat;
	}
	
	public HashSetInter<E> powerSet(HashSetInter<E> h)
	{
		return h;
	}
	public boolean isSubset(HashSetInter<E> h)
	{
		for(int i =0; i<h.size();++i)
		{
			for(E x : h.get(i))
				if(!this.contains(x))
					return false;
				
		}
		return true;
	}
	public HashSetInter<E> cartesianProduct(HashSetInter<E> h)
	{
		return h;
	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	public int len()
	{
		return data.length;
	}
	
}

