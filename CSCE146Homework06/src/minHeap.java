//written by Christian Wolff
public class minHeap <T extends Comparable<T>> {
	T[] heap;
	int size;
	public static final int DEF_SIZE = 128;
	public minHeap() {
		init(DEF_SIZE);
	}
	public minHeap(int size) {
		init(size);
	}
	public void init(int aSize) {
		if(aSize < 1) {
			aSize = DEF_SIZE;
		}
		heap = (T[])(new Comparable[aSize]);
		size = 0;
	}
	public void add(T aData) {
		if(aData == null)
			return;
		if(size == heap.length) {
			return;
		}
		heap[size] = aData;
		bubbleUp();
		size++;
	}
	public void bubbleUp() {
		int index = size;
		while(index > 0 && heap[index].compareTo(heap[(index-1)/2]) < 0){
			swap(index, (index-1)/2);
			index = (index-1)/2;
		}
	}
	public void swap(int i, int j) {
		T temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	public T remove() {
		if(heap[0] == null)
			return null;
		T ret = heap[0];
		heap[0] = heap[size-1];
		heap[size-1] = null;
		size--;
		bubbleDown();
		return ret;
	}
	public void bubbleDown() {
		int index = 0;
		while(index*2+1 < size)
		{
			int smallIndex = index *2 +1;
			if(index*2+2 < size && heap[smallIndex].compareTo(heap[smallIndex+1]) > 0) {
				smallIndex +=1;
			}
			if(heap[index].compareTo(heap[smallIndex]) > 0) {
				swap(index, smallIndex);
				index =smallIndex;
			}
			else {
				return;
			}
		}
	}
}
