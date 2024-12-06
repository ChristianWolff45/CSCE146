//written by Christian Wolff
public class LLQueue<T> implements QueueI<T> {
	public class ListNode{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) {
			link = aLink;
			data = aData;
		}
	}
	private ListNode head, tail;
	public LLQueue(){
		head = tail = null;
	}
	
	public void Enqueue(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if(head == null) {
			head = tail = newNode;
			return;
		}else {
			tail.link = newNode;
			tail = tail.link;
		}
	}

	public T Dequeue() {
		if(head == null)
			return null;
		T data = head.data;
		head = head.link;
		return data;
	}

	public T peek() {
		if(head == null)
			return null;
		return head.data;
	}

	public void Print() {
		for(ListNode temp = head; temp != null; temp = temp.link) {
			System.out.println(temp.data);
		}
		
	}
	
}
