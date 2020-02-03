/**
 * student name: Juliette Malassé
 * student number: 2944347
 */
import java.util.*;
import java.util.function.Predicate;
public class Assignment8_2017 {
	public static void main(String[] args){
			Point pt = new Point(12, 23);
			Point poi = new Point(42,66);
			Point po = new Point(42,66);
			Point ot = new Point(25,36);
			Point p = poi;
			System.out.println(pt == poi);
			System.out.println(p == poi);
			System.out.println(p.equals(poi));
			System.out.println(p.hashCode() == poi.hashCode());
			System.out.println(pt.hashCode() == poi.hashCode());
			Set<Point> s = new HashSet<Point>();
			s.add(pt);
			s.add(ot);
			s.add(poi);
			s.add(p);
			System.out.println(s);
			System.out.println();
			MyHashList<Point> hl = new MyHashList<Point>(5);
			hl.add(pt);
			hl.add(poi);
			hl.add(po);
			hl.add(ot);
			hl.add(p);
			System.out.println(hl.getList(poi));
			LinkedList<Point> l = new LinkedList<Point>();
			l.add(pt);
			l.add(poi);
			l.add(po);
			hl.remove(l);
			System.out.println(hl);
			
			MyHashList<Integer> in = new MyHashList<Integer>(4);
			for(int i = 0; i<10; ++i)
				in.add(i);
			System.out.println(in.get(x -> x%2 == 0));
		
			
  }
}
//=======================================================
// class Point
class Point{
	private int x,y;
	Point(int a, int b){x = a; y = b;}
	public int x(){return x;}
	public int y(){return y;}
	public String toString(){return "("+x+","+y+")";}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}


//End class Point
//=======================================================
//HashTable class
class MyHashList<E> implements Iterable<E>{
	private ArrayList<LinkedList<E>> table;
	public MyHashList(int n){
	 // n = the number of lists to create - 
	 // it does not limit the number of elements in the table 
	 table = new ArrayList<>();
   for(int j = 0; j < n; j++)
   	  table.add(new LinkedList<>());
  }
  private int hashC(E x){
		int k = x.hashCode();
		//an alternative is to mask the minus using
		//int k = x.hashCode() & 0x7fffffff;
		int h = Math.abs(k % table.size());
		return(h);
	}
	
  public LinkedList<E> getList(E x)
  {
	  int index = hashC(x);
	  LinkedList<E> str = new LinkedList<E>();
	  str = table.get(index);
	  return str;
  }
  
  public void remove(List<E> ls)
  {
	  for(int i = 0; i<ls.size(); ++i)
	  {
		  remove(ls.get(i));
	  }
  }
  
  List<E> get(Predicate<E> pr)
  {
	  List<E> ls = new LinkedList<E>();
	  for(LinkedList<E> ll : table)
		  for(E x : ll)
			  if(pr.test(x))
				  ls.add(x);
	  return ls;
				  
  }
  
	public void add(E x){
		int index = hashC(x);
		table.get(index).addFirst(x);
	}
	public boolean contains(E x){
		int index = hashC(x);
		return(table.get(index).contains(x));
	}
	public boolean remove(E x){
		int index = hashC(x);
		return table.get(index).remove(x);
	}
	
	public int size(){
		int count = 0;
		for(int j = 0; j < table.size();j++) count += table.get(j).size();
		return count;
	}
	public Iterator<E> iterator(){
	  ArrayList<E> items = new ArrayList<E>();
	  int ind = 0;
	  while(ind < table.size()){
			Iterator<E> it = table.get(ind).iterator();
			while(it.hasNext()) items.add(it.next());
			ind++;
	   }
	   return items.iterator();
	}
	public String toString(){return table.toString();} 
	
	//==================================================================
	//Methods that provide information about the state of the hashtable
	public double percentUsed(){
		int count = 0;
		for(int j = 0; j < table.size(); j++){
			if(table.get(j).size() > 0)
			  count++;
		}
		double p = count *100.0 / table.size();
		return p;
	}
	public int largestBucket(){
		int max = 0;
		for(int j = 0; j < table.size(); j++){
		  int k = table.get(j).size();
			if( k > max) max = k;
		}
		return max;
	}
	public int smallestBucket(){
		int min = table.get(0).size();
		for(int j = 1; j < table.size(); j++){
		  int k = table.get(j).size();
			if(k < min) min = k;
		}
		return min;
	}
	public int[] listSizes(){
		int n = this.largestBucket();
		int d[] = new int[n+1];
		for(int j = 0; j < d.length; j++) d[j] = 0;
		for(int j = 0; j < table.size(); j++){
			int m = table.get(j).size();
			d[m] = d[m] + 1;
		}
		return d;
	}
	public int empty(){
		int count = 0;
		for(int j = 0; j < table.size(); j++)
			if(table.get(j).size() == 0) count++;
		return count;
	}	
	//==================================================================
}