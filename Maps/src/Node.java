public class Node<T> {
	private T data1;
	private Node<T> next;
	
	public Node(T data, Node<T> next){
		this.data1 = data1;
		this.next = next;
	}
	
	public T getData(){
		return data1;
	}
	
	public void setData(T data){
		this.data1 = data;
	}
	
	public Node<T> getNext(){
		return next;
	}
	
	public void setNext(Node<T> next){
		this.next = next;
	}
}