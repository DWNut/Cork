
public class Pair<A,B> {
	
	private A x; private B y;
	Pair(A x1, B y1)
		{
			x = x1; 
			y = y1;
		}
	public A x()
		{
			return x;
		}
	public B y()
		{
			return y;
		}
	public boolean equals(Object ob)
		{
			if(!(ob instanceof Pair)) 
				return false;
			Pair<?,?> p = (Pair)ob;
			return x.equals(p.x) && y.equals(p.y);
		}
}


