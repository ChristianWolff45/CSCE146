
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
	public GenLL() {
		head = current = previous =null;
	}
	//returns if current has data or not 
	public boolean hasMore() {
		return current != null;
	}
	//adds new node to end of list
	public void add(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if(head == null) {
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.link != null) {
			temp = temp.link;
		}
		temp.link = newNode;
	}
	//moves current and previous one node forward
	public void gotoNext() {
		if(current == null)
			return;
		previous = current;
		current = current.link;
	}
	//resets where current is in the list
	public void reset() {
		current = head;
		previous = null;
	}
	//returns current nodes data
	public T getCurrent() {
		if(current == null)
			return null;
		else
			return current.data;
	}
	//removes current node
	public void removeCurrent() {
		if(current == head) {
			head = current.link;
			current = head;
		}else {
			previous.link = current.link;
			current = current.link;
		}
	}
}
