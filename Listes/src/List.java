
public interface List<T> {
	public int size();
	public void setSize(int size);
	public void add(T x);
	public T get(int index);
	public void set(int index, T x);
	public boolean remove(T x);
	public boolean contains(T x);
	public boolean isEmpty();
	public String toString();
	public boolean equals(Object other);
}
