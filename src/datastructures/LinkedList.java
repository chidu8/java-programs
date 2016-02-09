package datastructures;

public class LinkedList {
	
	public LinkedListNode head;
	public LinkedListNode tail;
	
	public LinkedList() {
		head=null;
		tail=null;
	}
	
	public void insert(LinkedListNode node) {
		if (head==null) {
			head = node;
			tail = node;
		}
		else {
			tail.next = node;
			tail = node;
		}
	}
	
	public void insert(int[] array) {
		if(array.length==0)
			return;
		if (head==null) {
			head = new LinkedListNode(array[0]);
			tail = head;
			insert(array,1);
		}
		else {
			insert(array,0);		
		}
	}
	
	public void insert(int[] array, int startIndex) {
		for (int i=startIndex;i<array.length;i++) {
			LinkedListNode node = new LinkedListNode(array[i]);
			tail.next = node;
			tail = node;
		}	
	}
	
	public void traverseAndPrint() {
		LinkedListNode current = head;
		while(current.next!=null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println(current.data);
	}
	
	public static void main(String[] args) {

	}

}
