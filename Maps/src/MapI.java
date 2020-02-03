import java.util.LinkedList;

public interface MapI<K,V>{
	public void add(K key, V value);
	public V get(K key, V value);
	public boolean contains(K key, V value);
	public boolean remove(K key, V value);

}
