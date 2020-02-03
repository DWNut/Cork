import java.util.Iterator;

public interface List<T> {
	public int size();
	public void add(T x);
	public boolean isEmpty();
	public T get(int index);
	public boolean remove(T x);
	public boolean contains(T x);
	public void set(T x, int index);
	public Iterator<T> iterator();

}
