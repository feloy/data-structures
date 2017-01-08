/**
  * A stack of elements
  * @space O(n)
  */
public class Stack<T> {

  /**
    * Structure containing the data
    * @space O(n)
    */
  Object data[];

  /**
    * the number of elements in the stack
    * @space O(1)
    */
  int length;

  /**
    * Create a new stack with an initial allocated size
    * @param initialSize the initial space reserved for the stack
    */
  public Stack(int initialSize) {
    data = new Object[initialSize];
    length = 0;
  }

  /**
    * Access the latest element of the stack
    * @time O(1)
    */
  public T access() {
    return (T)data[length-1];
  }

  /**
    * Access an element at a given index
    * @param index 1-based index
    * @time O(n)
    */
  public T access(int index) {
    Stack<T> otherStack = new Stack<T>(index-1);
    // pop first elements
    for (int i=0; i<index - 1; i++) {
      otherStack.insert(access());
      delete();
    }
    T result = access();
    // push back popped elements
    while (otherStack.length > 0) {
      insert(otherStack.access());
      otherStack.delete();
    }
    return result; 
  }

  /**
    * Search an element in the stack and return its index
    * or -1 if not found
    * @param element the element to search
    * @time O(n)
    */
  public int search(T element) {
    int result = -1;
    Stack<T> otherStack = new Stack<T>(data.length);
    // pop first elements
    for (int i=1; i<=data.length; i++) {
      T el = access();
      otherStack.insert(el);
      delete();
      if (element.equals(el)) {
        result = i;
        break;
      }
    }
    // push back popped elements
    while (otherStack.length > 0) {
      insert(otherStack.access());
      otherStack.delete();
    }
    return result;
  }

  /**
    * Insert an element in the stack
    * @time O(1)
    */
  public void insert(T element) {
    if (length == data.length) {
      allocateMore();
    }
    data[length++] = element;   
  }

  /** 
    * Delete an element from the stack
    * @time O(1)
    */
  public void delete() {
    if (length > 0) {
      length--;
    }
  }

   /**
     * Double the size of allocated memory for the stack 
     * @time O(n)
     */
    private void allocateMore() {
        Object newdata[] = new Object[2 * data.length];
        for (int i = 0; i < length; i++) {
            newdata[i] = data[i];
        }
        data = newdata;
    }

}
