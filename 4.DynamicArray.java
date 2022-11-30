package pa4;

public class DynamicArray {
	
	private int array[];
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	
	public DynamicArray() {
		   array = new int[DEFAULT_CAPACITY];
		   size = 0;
		}
	
	public DynamicArray(int[] array) {
		   this.array = array;
		   this.size = 0;
		}
	
	public void add(int value) {
	   if (size >= array.length)
	      resize(2 * array.length);
	   array[size] = value;
	   size++;
	}

	public int get(int index) {
	   return array[index];
	}
	
	public void remove(int index) {
	
	if (size > 0) {   
		for (int i = index; i < size - 1; i++) { 
			array[i] = array[i + 1];   
		}   
		array[size - 1] = 0;   
		size--;   
		}   
	}
	
	private void resize(int capacity) {
	   int temp[] = new int[capacity];
	   size = capacity < size ? capacity : size;
	   for (int i = 0; i < size; i++)
	      temp[i] = array[i];
	   array = temp;
	}
	
	public int size() {
	   return size;
	}
	
}