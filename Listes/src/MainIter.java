import java.util.*;

public class MainIter {
	
	public static void main(String[] args)
	{
		IntArrayList<String> data =  new IntArrayList<String>();
		data.add("chat");
		data.add("ponay");
		data.add("tard");
		data.add("sac");
		for(String x : data)
		{
			System.out.print(x + " ");
		}
	}
}
