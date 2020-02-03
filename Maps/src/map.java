
import java.util.*;

public class map{
	
	public static void main(String[] args)
	{
		List<Integer> ls = new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,5,5,5,5,5,5));
		printOccurences(ls);
		rnaTranscription("GATCGTA");
		
	}
	
	public static void printOccurences(List<Integer> ls)
	{ 
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for (int i = 0; i<ls.size(); ++i)
		{
			if(m.containsKey(ls.get(i)))
				m.put(ls.get(i), m.get(ls.get(i))+1);
			else
				m.put(ls.get(i), 1);
		}
		System.out.println(m);
	}
	
	public static String rnaTranscription(String dna)
	{
		Map<String, String> tr = new HashMap<String, String>();
		tr.put("G", "C");
		tr.put("C", "G");
		tr.put("T", "A");
		tr.put("A", "U");
		
		String rna = "";
		
		for(int i = 0; i<dna.length(); ++i)
		{
			rna += tr.get(""+dna.charAt(i));
		}
		System.out.println(rna);
		return rna;
		
	}
	
	
	
}
