
public class IntLinkedList<T> implements List<T>{
	private Node<T> head;
	private int size;
	
	public IntLinkedList(){
		this.size=0;
		this.head=null;
	}
	
	public void setSize(int size)
	{
		this.size += size;
	}
	public int size(){
		return this.size;
	}
	
	public int length(){
		return size();
	}
	public void add(T x){
		this.size++;
		Node<T> tmp = new Node<T>(x, head);
		head = tmp;
	}
	
	public void set(int index, T x)
	{
		Node<T> tmp = this.head;
		for (int i = 0; i<index; ++i)
		{
			tmp=tmp.getNext();			
		}
		tmp.setData(x);
	}
	
	public boolean isEmpty(){
		return (this.size==0);
	}
	
	public T get(int index)
	{	
			Node<T> tmp = this.head;
			while(index>0)
			{
				tmp=tmp.getNext();
				index--;
			}
			return tmp.getData();
	}
	
	
	public boolean remove(T x){
		if(x==this.head.getData()){
			this.head=this.head.getNext();
			size--;
			return true;
		}
		int i = 1;
		Node<T> tmp = this.head;
		while(i<this.size && x!=tmp.getNext().getData()){
			i++;
			tmp=tmp.getNext();
		}
		if(i==this.size){
			return false;
		}
		else{
			tmp.setNext(tmp.getNext().getNext());
			size--;
			return true;
		}
	}
	
	public boolean contains(T x){
		int i = 0;
		Node<T> tmp = this.head;
		while(i<this.size && x!=tmp.getData()){
			i++;
			tmp=tmp.getNext();
		}
		return(i!=this.size);
		
	}
	
	public void set(T x, int index){
		if(index>=0 && index<=size)
		{
			Node<T> tmp = this.head;
			while(index>0)
			{
				tmp=tmp.getNext();
				index--;
			}
			tmp.setData(x);
		}
	}
	
	public String toString(){
		int i = 0;
		String res = "";
		Node<T> tmp = this.head;
		while(i<this.size){
			res= res+tmp.getData()+" ";
			tmp=tmp.getNext();
			i++;	
		}
		return res;
	}

}





