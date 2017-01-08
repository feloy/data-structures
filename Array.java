/**
  * An array of elements
  * @space O(n)
  */
public class Array<T> {

    /**
     * structure containing the data
     * @space O(n)
     */
    Object data[]; // space O(n)
    /**
     * the number of elements in the array
     * @space O(1)
     */
    int length;

    /**
     * Create a new array with an initial allocated size
     * @param initialSize the initial space reserved for the array
     */
    public Array(int initialSize) {
        data = new Object[initialSize];
        length = 0;
    }

    /**
      * Return element at index
      * @param index
      * @time O(1)
      */
    public T access(int index) {
        return (T)data[index];
    }

    /**
      * Search an element in the array and return its index 
      * or -1 if not found
      * @param element the element to search  
      * @time O(n)   
      */
    public int search(T element) {
        for (int i=0; i < length; i++) {
            if (element.equals((T)data[i])) {
              return i;
            }
        }
        return -1;
    }

    /**
    * Insert in element at a given index
    * @time O(n)
    * @param element the element to insert
    * @param index the element is inserted at this index.
    */
    public void insert(T element, int index) {
        if (length >= data.length) {
            allocateMore(); // O(n)
        }
        if (index > length) {
            return; // out of bound
        }

        shiftRight(index); // O(n)

        data[index] = element;
        length++;
    }

    /**
      * Delete the element at the index
      * @param index the element at given index is deleted
      * @time O(n) 
      */
    public void delete(int index) {
        shiftLeft(index); // O(n)
        length--;
    }

    /**
     * Double the size of allocated memory for the array 
     * @time O(n)
     */
    private void allocateMore() {
        Object newdata[] = new Object[2 * data.length];
        for (int i = 0; i < length; i++) {
            newdata[i] = data[i];
        }
        data = newdata;
    }

    /**
      * Shift to the right the elements from index to the end
      * @time O(n)
      */
    private void shiftRight(int index) {
        for (int i = length - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
    }

    /**
      * Shift to the left the elements from index to end 
      * @time O(n) 
      */
    private void shiftLeft(int index) {
        for (int i=index; i < length-1; i++) {
            data[i] = data[i + 1];
        }
    } 
}
