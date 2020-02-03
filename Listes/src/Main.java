
public class Main {

	public static void main(String[] args)
	{
		Queue<String> list = new Queue<String>();
		list.enqueue("chat");
		list.enqueue("chien");
		list.enqueue("poisson");
		list.enqueue("kiwi");
		list.enqueue("ponay");
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		for (int i = 0; i<5;++i)
		{
			list.dequeue();
			System.out.println(list.front());
		}
		
	}
}
