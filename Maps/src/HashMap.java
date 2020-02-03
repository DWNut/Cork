import java.util.*;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.LinkedList;

public class HashMap<K,V> implements MapI<K,V>{
	
	private HashSet<SimpleImmutableEntry<K,V>> h;
	int size;
	
	public void HashMap()
	{
		this.h = new HashSet<SimpleImmutableEntry<K,V>>(1000);
		this.size = 0;
	}
	
	
	@Override
	public void add(K key, V value) {
		SimpleImmutableEntry<K,V> cp = new SimpleImmutableEntry<K,V>(key, value);
		int index  = cp.hashCode() % h.len() ;		
		
	}

	@Override
	public V get(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	public void set(K key, V value)
	{
		
	}
	
	@Override
	public boolean remove(K key, V value) {
		// TODO Auto-generated method stub
		return false;
	}
	
	


}
