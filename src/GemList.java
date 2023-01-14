import java.util.Queue;

public class GemList 
{
	private class Node {
		public Gem gem;
		public Node next;
	}

	private Node head;

	public int size() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void draw(double y) {
		Node current = head;
		double x = 0.5; // left margin

		while (current != null) {
			current.gem.draw(x++ / 16, y);
			current = current.next;
		}
	}

	public void insertBefore(Gem gem, int index) {
		Node newNode = new Node();
		newNode.gem = gem;

		if (index == 0 || head == null) {
			newNode.next = head;
			head = newNode;
		} 
		else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				if (current.next == null) 
					break;

				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
	}}

	public int score() {
		if (head == null)
			return 0; // no gems

		Node currentNode = head;
		int series = currentNode.gem.getPoints();
		int seriesLength = 1;
		int score = 0;

		while (currentNode.next != null) {
			Node nextNode = currentNode.next;
			Gem nextGem = nextNode.gem;

			if (currentNode.gem.getType().equals(nextGem.getType())) {
				series += nextGem.getPoints();
				seriesLength++;
			} 
			else {
				score += series * seriesLength;
				series = nextGem.getPoints();
				seriesLength = 1;
			}
			currentNode = nextNode;
		}
		score += series * seriesLength;
		return score;
	}

	public String toString() {
		String output = "";
		Node current = head;
		while (current != null) {
			output += current.gem + ", ";
			current = current.next;
		}
		if (output.length() > 0)
			output = output.substring(0, output.length() - 2);

		return "[" + output + "]";
	}


	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		
		
		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
		
		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
	}	
}
