//written by Christian Wolff
public interface QueueI <T>{
	public void Enqueue(T aData);
	public T Dequeue();
	public T peek();
	public void Print();
}
