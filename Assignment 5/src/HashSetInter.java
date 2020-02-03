import java.util.Iterator;
import java.util.LinkedList;

public interface HashSetInter<E> {
	
	public int hashC(E x);
	public void add(E x);
	public LinkedList<E> get(int i);
	public boolean contains(E x);
	public boolean remove(E x);
	public int size();
	public boolean isEmpty();
	public void clear();
	public double percentUsed();
	public int largestBucket();
	public int smallestBucket();
	public int[] listSizes();
	public void resize();
	public Iterator<E> iterator();

}
