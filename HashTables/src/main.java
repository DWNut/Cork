
public class main {
	
	public static void main(String[] args) {
		HashSet<Integer> list = new HashSet<Integer>(100);
		HashSet<Integer> h = new HashSet<Integer>(100);
		for(int j = 0; j < 1000; j++){
		int x = (int)(Math.random()*100);
		list.add(new Integer(x));
		h.add(new Integer(x));
		}
		HashSetInter<Integer> uni = list.symmetric_difference(h);
		//list.displayLists();
		System.out.println("Percentage of buckets used: "+uni.percentUsed());
		System.out.println("Largest bucket size = "+uni.largestBucket());
		System.out.println("Smallest bucket size = "+uni.smallestBucket());
		int lSizes[] = uni.listSizes();
		
		System.out.println("Frequency list");
		for(int j = 0; j < lSizes.length; j++){
		if(lSizes[j] > 0)
		System.out.printf("Buckets with %d elements = %d\n",j,lSizes[j]);
		}
		System.out.println("Empty buckets = "+list.isEmpty());
	}
	

}
