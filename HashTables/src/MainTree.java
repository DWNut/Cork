
public class MainTree {

	public static void main(String[] args) {

		BSTNode<Integer> newNode = new BSTNode<Integer>(null, 1, null);
		TreeSet<Integer> t1 = new TreeSet<Integer>(newNode);
		t1.add(5);
		t1.add(1);
		t1.add(6);
		t1.add(2);
		t1.add(8);
		System.out.println(t1.contains(11));

	}

}
