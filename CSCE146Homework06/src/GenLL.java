
//written by Christian Wolff
public class GenLL <T>{
	private class ListNode{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	private ListNode head;//reference the first element
	private ListNode current;
	private ListNode previous;
	private int size;
	public GenLL() {
		head = current = previous =null;
	}
	public boolean hasMore() {
		return current != null;
	}
	public void add(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if(head == null) {
			head = current = newNode;
			return;
		}
		//Not an empty lsit
		ListNode temp = head;
		while(temp.link != null) {
			temp = temp.link;
		}
		temp.link = newNode;
		this.size++;
	}
	public void gotoNext() {
		if(current == null)
			return;
		previous = current;
		current = current.link;
	}
	public void reset() {
		current = head;
		previous = null;
	}
	public T getCurrent() {
		if(current == null)
			return null;
		else
			return current.data;
	}
	public void removeCurrent() {
		if(current == head) {
			head = current.link;
			current = head;
		}else {
			previous.link = current.link;
			current = current.link;
		}
		if(size >0) {
			size--;
		}
	}
	public int length() {
		int count = 0;
		while(this.hasMore()) {
			count ++;
		}
		return count;
	}
}
