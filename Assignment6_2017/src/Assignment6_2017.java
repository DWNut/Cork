import java.util.*;
import java.util.function.*;
public class Assignment6_2017{
  public static void main(String args[]){
    /*Question 1 ==========================================================
    Using the class NewNumbers listed below write a code sequence that tests
    the methods: 
      forAll(Predicate<Integer> pr),
      List<Integer> getSubList(Predicate<Integer> pr)
      List<Integer> mapList(Function<Integer,Integer> f)
      Sample tests might be: all the values are positive, all negative,
      retrieve a list of the even numbers, a list of negative numbers,
      use mapList to return the square of all the numbers, etc
      You should write at least three tests for each method
    ======================================================================*/
    // This code sets up a List
    NewNumbers lst = new NewNumbers();
    lst.add(Arrays.asList(1,2,3,4,6,-1,-5,7,8,12,4,-5,0,0,1,4,-2));
    lst.print(x->System.out.print(x+" "));
    
    
    Predicate<Integer> pos = x -> x>0;
    Predicate<Integer> range = x -> x<15 && x>-15;
    Predicate<Integer> odd = x-> x%2!=0;
    System.out.println(lst.forAll(pos)==false);
    System.out.println(lst.forAll(range)==true);
    System.out.println(lst.forAll(odd)==false);
    
    Predicate<Integer> range2 = x -> x<=5 && x>=-5;
    Predicate<Integer> even = x-> x%2==0;
    Predicate<Integer> neg = x -> x<0;
    System.out.println(lst.getSubList(range2).equals(Arrays.asList(1,2,3,4,-1,-5,4,-5,0,0,1,4,-2)));
    System.out.println(lst.getSubList(even).equals(Arrays.asList(2,4,6,8,12,4,0,0,4,-2)));
    System.out.println(lst.getSubList(neg).equals(Arrays.asList(-1,-5,-5,-2)));
    
    Function<Integer,Integer> square = x -> x*x;
    Function<Integer,Integer> opp = x-> -x;
    Function<Integer,Integer> doub = x -> 2*x ;
    System.out.println(lst.mapList(square).equals(Arrays.asList(1,4,9,16,36,1,25,49,64,144,16,25,0,0,1,16,4)));
    System.out.println(lst.mapList(opp).equals(Arrays.asList(-1,-2,-3,-4,-6,1,5,-7,-8,-12,-4,5,0,0,-1,-4,2)));
    System.out.println(lst.mapList(doub).equals(Arrays.asList(2,4,6,8,12,-2,-10,14,16,24,8,-10,0,0,2,8,-4)));
    
    
    /*Question 2 ============================================================
    Using the generic class MyList<E> listed below write a code sequence that 
    tests all of its methods. You are given a Book class that you can use 
    to perform your tests. Note that creating a MyList<Integer> instance is not
    an acceptable data type for your tests.
    ================================================================== */
    Book B1 = new Book("Le haut-bite, ", "Tôt Le Qui Aine");
    Book B2 = new Book("Meuch Peau Lit Tique, ", "Franc Soit Dos Lande");
    Book B3 = new Book("Lé fleur du malle, ", "Chat rlle Beau de L'air");
    Book B4 = new Book("Halle Colle, ", "Gui Ohm Appeau Line Air");
    Book B5 = new Book("La preincesse 2 claives aka le cancer, ", "Madamme 2 la faïète");
    Book B6 = new Book("An à Tendant Go dos, ", "Samu aile bec ette");
    Book B7 = new Book("Le Sait Ni Heure Dés Ane Aux, ", "Tôle Quille haine");
    Book B8 = new Book("Maille Noeud Quand pff, ", "Ado Le Fit l'Air");
    Book B9 = new Book("Na route eau, ", "Clan pain rang d'homme");
    Book B10 = new Book("Eh recule poire eau, ", "Ah gâte ah crisse ti");
    
    MyList<Book> LailBraitRiz = new MyList<Book>();
    LailBraitRiz.add(B1);
    LailBraitRiz.add(B3);
    LailBraitRiz.add(B5);
    LailBraitRiz.add(B7);
    LailBraitRiz.add(B9);
    
    Consumer<Book> QuHommeTueVeu = x-> System.out.println(x);
    
    LailBraitRiz.print(QuHommeTueVeu);
    List<Book> bouc = new LinkedList<Book>();
    bouc.add(B2);
    bouc.add(B4);
    bouc.add(B6);
    bouc.add(B8);
    bouc.add(B10);
    
    LailBraitRiz.add(bouc);
    System.out.println("");
    LailBraitRiz.print(QuHommeTueVeu);
    
    Predicate<Book> auth = x-> x.author() =="Franc Soit Dos Lande";
    Predicate<Book> tit = x-> x.title() =="Mare Tignes Ah Cèpes Remis Air Aigle  ";
    
    System.out.println(LailBraitRiz.contains(auth));
    System.out.println(LailBraitRiz.contains(tit));
    
    LailBraitRiz.remove(auth);
    LailBraitRiz.print(QuHommeTueVeu);
    
    Predicate<Book> cont = x-> x.author().contains("Air");
    System.out.println(LailBraitRiz.filterList(cont));
    
  }
}


class MyList<E> implements Iterable<E>{
 
	private List<E> data = new LinkedList<>();
 
 public void add(E x)
 {
	 data.add(x);
 }
 
 public void add(List<E> ls)
 {
   for(E x : ls) data.add(x);
 }
 
 public boolean contains(Predicate<E> pr)
 {
    for(E x : data) if(pr.test(x)) return true;
    return false;
 }
 
 public List<E> filterList(Predicate<E> pr)
 {
  List<E> tmp = new LinkedList<>();
  for(E x : data) if(pr.test(x)) tmp.add(x);
  return tmp; 
 }
 
 public void remove(Predicate<E> pr)
 {
  data.removeIf(pr);
 }
 
 public void print(Consumer<E> cn)
 {
   data.forEach(cn);
	 System.out.println();
 }
 
 public Iterator<E> iterator()
 {
	 return data.iterator();
 }
}


class Book
{
	private String title;
	private String author;
 
	public Book(String t, String a)
	{
		title = t; author = a;
	}
 
	public String title()
	{
		return title;
	}
 
	public String author()
	{
		return author;
	}
 
	public boolean equals(Object ob){
		if(!(ob instanceof Book)) 
			return false;
		Book b = (Book)ob;
		return title.equals(b.title) && author.equals(b.author);
 }
 
 public int hashCode()
 {
	 return 31*title.hashCode()*author.hashCode();
 }
 
 public String toString()
 {
	 return title+" "+author;
 }
}

class NewNumbers{
	private List<Integer> data = new ArrayList<>();
	void add(int x){data.add(x);}
	void add(List<Integer> lst){data.addAll(lst);}
	boolean contains(Predicate<Integer> pr){
		for(Integer x : data)
		 if(pr.test(x)) return true;
		return false;
	}
	boolean forAll(Predicate<Integer> pr){
		for(Integer x : data)
		  if(!pr.test(x)) return false;
		return true;
	}
	List<Integer> getSubList(Predicate<Integer> pr){
		List<Integer> tmp = new ArrayList<>();
		for(Integer x : data)
		 if(pr.test(x)) tmp.add(x);
		return tmp;
	}
	List<Integer> mapList(Function<Integer,Integer> f){
	 List<Integer> tmp = new ArrayList<>();
	 for(Integer x : data) tmp.add(f.apply(x));
	 return tmp;
	}
	int count(Predicate<Integer> pr){
		int count = 0;
		for(Integer x : data) if(pr.test(x)) count++;
	  return count;
	}
	int sum(Predicate<Integer> pr){
		int s = 0;
		for(Integer x : data) if(pr.test(x)) s += x;
		return s;
	}
	void print(Consumer<Integer> cn){
		data.forEach(cn);
		System.out.println();
	}
}