public class Queue<T> {

  /**
    * Store queue data
    * @space O(n)
    */
  Object data[];

  /**
    * Number of elements in the queue
    * @space O(1)
    */
  int length;

  /**
    * Start of the queue in the data circular buffer
    * @space O(1)
    */
  int start;
  
  /**
    * Create a new queue given an initial size
    * @time O(1)
    */
  public Queue(int initialSize) {
    data = new Object[initialSize];
    length = 0;
    start = 0;
  }

  /**
    * Insert a new element in the queue
    * @time O(1)
    */ 
  public void insert(T value) {
    if (length == data.length) {
      allocateMore();
    }
    data[(start + length++) % data.length] = value;
  }

  /**
    * Delete the first in element
    * @time O(1)
    */
  public void delete() {
    if (length > 0) {
      length--;
    }
    start = (start + 1) % data.length;
  }

  /**
    * Access the first out element of the queue
    * @time O(1)
    */
  public T access() {
    return (T)data[start];
  }

  /**
    * Search an element in the queue 
    * @return the index of the found element or -1 if not found
    * @time O(n)
    */
  public int search(T value) {
    int result = -1;
    Queue tmpQueue = new Queue(length);
    int i = 0;
    while (length > 0) {
      i++;
      T current = access();
      delete();
      tmpQueue.insert(current);
      if (current.equals(value)) {
        result = i;
      }
    }

    while (tmpQueue.length > 0) {
      T current = (T)tmpQueue.access();
      tmpQueue.delete();
      insert(current);
    }
    
    return result;
  }

  /**
    * Return the elements of the queue as an array
    * @time O(n)
    */
  public Object[] toArray() {
    Object result[] = new Object[length];
    for (int i=0; i<length; i++) {
      result[i] = data[(start + i) % data.length];
    }
    return result;
  }

  /**
    * Double the memory allocated for the elements of the queue
    * @time O(n)
    */
  private void allocateMore() {
    Object newData[] = new Object[2 * data.length];
    for (int i=0; i<data.length; i++) {
      newData[i] = data[(i + start) % data.length];
    }
    data = newData;
    start = 0;
  }
}