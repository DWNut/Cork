
	import java.util.Iterator;

	public class LinkedList<T> implements List<T>, Iterable<T>{
		private Node<T> head;
		private int size;
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public LinkedList(){
			this.size = 0;
			this.head = new Node(0,null);
		}
		
		public int size(){
			return size;
		}
		
		public void add(T x){
			@SuppressWarnings({ "unchecked", "rawtypes" })
			Node<T> newnode = new Node(x, head.getNext());
			head.setNext(newnode);
			size++;
		}
		
		public boolean isEmpty(){
			return head.getNext() == null;
		}
		
		public T get(int index){
			Node<T> temp = head;
			for(int i = 0; i < size - index; i++)
				temp = temp.getNext();
			return temp.getData();
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public boolean remove(T x){
			Node temp = head;
			int i = 0;
			while(i < size && temp.getNext().getData() != x){
				temp = temp.getNext();
				i++;
			}
			if (i != size){
				temp.setNext(temp.getNext().getNext());
				size--;
				return true;
			}
			return false;
		}
		
		@SuppressWarnings("rawtypes")
		public boolean contains(T x){
			int i = 0;                
			Node temp = head;
			while(i < size && temp.getData() != x){
				temp = temp.getNext();
				i++;
			}
			return i != size;
		}
		
		public void set(T x, int index){
			Node<T> temp = head;
			for(int i = 0; i < size - index; i++){
				temp = temp.getNext();
			}
			temp.setData(x);
			
		}

		
		@SuppressWarnings("unchecked")
		public Iterator<T> iterator(){
			LinkedList<T> items = new LinkedList<T>();    
			int ind = 0;    
			while(ind < size){
				Iterator<T> it = ((Iterable<T>) items.get(ind)).iterator();    
				while(it.hasNext())     
					items.add(it.next());    
				ind++;     
			}     
			return items.iterator();  
		}
		
	}

