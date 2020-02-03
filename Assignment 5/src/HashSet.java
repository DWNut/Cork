import java.util.*;

public class HashSet<E extends Comparable <E>> implements HashSetInter<E>, Iterable<E>
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
	
	@SuppressWarnings("unchecked")

	public Iterator<E> iterator(){
		return (HashIterator<E>)(new HashIterator<E>(data, size()));
	}
	private class HashIterator<E> implements Iterator<E>{
		private LinkedList<E>[] d;
		private int index = 0,index2=0;
		private int size;
		HashIterator(LinkedList<E>[] dd, int s){
			d = dd; size = s;
		}
		public boolean hasNext(){
			return index < size;
		}
		public E next(){
			if(index == size) throw new NoSuchElementException();
			if(d[index]==null || index2==d[index].size()){
				index++;
				index2=0;
			}
			E item = d[index].get(index2); index2++;
			return item;
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
	
	public double percentUsed(){
		int count = 0;
		for(int j = 0; j < data.length; j++){
		if(data[j].size() > 0)
		count++;
		}
		double p = count *100.0 / data.length;
		return p;
		}
	public int largestBucket(){
		int max = 0;
		for(int j = 0; j < data.length; j++)
		if(data[j].size() > max) max = data[j].size();
		return max;
		}
	
	public int smallestBucket(){
	int min = data[0].size();
	for(int j = 1; j < data.length; j++)
	if(data[j].size() < min) min = data[j].size();
	return min;
	}
	public int[] listSizes(){
		int n = this.largestBucket();
		int d[] = new int[n+1];
		for(int j = 0; j < d.length; j++) d[j] = 0;
		for(int j = 0; j < data.length; j++){
		int m = data[j].size();
		d[m] = d[m] + 1;
		}
		return d;
		}
	
	public void resize()
	{
		if (size()/data.length >= 0.85)
		{
			HashSet<Integer> temp = new HashSet<Integer>(data.length*2);
			
		}
	}

/*	union
	difference
	intersection
	symmetric difference
	powerSet
	isSubset
	cartesianProduct*/
	
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
	
}

