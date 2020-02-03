
import java.util.LinkedList;
import java.util.AbstractMap.SimpleImmutableEntry;

public interface HashSetInter<E> {
	public int hashC(E x);
	public void add(E x);
	public LinkedList<E> get(int i);
	public boolean contains(E x);
	public boolean remove(E x);
	public int size();
	public boolean isEmpty();
	public void clear();
}
