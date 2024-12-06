
//Christian Wolff

//classes responsibility is to create a Linked List that can be used for any variable
public class GenLL<T> {
	//class who sets up the data storage for linked list using data and links
	private class ListNode{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	//starts the linked list
	private ListNode Head, Current, Previous;
	public GenLL(){
		Head = Current = Previous = null;
	}
	//add new node to end of list
	public void add(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if(Head == null) {
			Head = newNode;
			Current = Head;
		}else {
			ListNode temp = Head;
			while(temp.link != null) {
				temp = temp.link;
			}
			temp.link = newNode;
		}
	}
	//returns data of current node
	public T getCurrent() {
		if(Current != null)
			return Current.data;
		return null;
	}
	//returns last node of list
	public GenLL<T>.ListNode getLast() {
		GenLL<T>.ListNode temp = this.Head;
		while(temp.link!=null) {
			temp = temp.link;
		}
		return temp;
	}
	//returns boolean true if list has no more data, false otherwise
	public boolean isEnd() {
		if(Current.link == null) {
			return true;
		}
		return false;
	}
	//goes to the next data point
	public void goNext() {
		if(Current.link != null) {
			Previous = Current;
			Current = Current.link;
		}
	}
	//resets where the user is in the list
	public void reset() {
		Current = Head;
		Previous = null;
	}
	//combines the two lists into one list
	public GenLL<T> combine(GenLL<T> newLL){
		if(newLL != null)
			this.getLast().link = newLL.Head;
		return this;
	}
}
