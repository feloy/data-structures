/**
  * A linked list of elements
  * @space O(n)
  */
public class LinkedList<T> {
  /**
    * The value at this node
    */
  T value;

  /**
    * The next node of the list
    */
  LinkedList<T> next;

  public LinkedList(T value, LinkedList<T> next) {
    this.value = value;
    this.next = next;
  }

  /**
    * Return the number of elements in the linked list
    * @time O(n)
    */
  public int size() {
    if (next == null) {
      return 1;
    } else {
      return 1 + next.size();
    }
  }

  /**
    * Return a Java array containing the elements of the list 
    * @time O(n)
    */
  public T[] toArray() {
    Object[] result = new Object[size()];
    result[0] = value;
    int i = 1;
    LinkedList<T> p = next;
    while (p != null) {
      result[i++] = p.value;
      p = p.next;
    }
    return (T[])result;        
  }

  /** 
    * Return element at the given index in the list 
    * @time O(n)
  */
  public T access(int index) {
    if (index == 1) {
      return value;
    } else {
      return next.access(index - 1);
    }
  }

  /** 
    * Search an element in the list and return index or -1 if not found 
    * @time O(n)
  */
  public int search(T element) {
    if (element.equals(value)) {
      return 1;
    } else if (next == null) {
      return -1;
    } else {
      int res = next.search(element);
      if (res == -1) {
        return -1;
      } else {
        return 1 + res;
      }
    }
  }

  /**
    * Insert an element at the beginning of the list
    * @time O(1)
    */
  public LinkedList<T> insert(T element) {
    return new LinkedList<>(element, this);
  }

  /**
    * Insert an element at index 
    * @param element element to insert
    * @param index 1-based index
    * @time O(n)
    */
  public LinkedList<T> insert(T element, int index) {
    if (index == 1) {
      return insert(element);
    } else {
      next = next.insert(element, index - 1);
      return this;
    }
  }

  /**
    * Delete first element of the list
    * @time O(1)
    */
    public LinkedList<T> delete() {
      return next;
    }

  /**
    * Delete the element at a given index 
    * @time O(n)
    */
    public LinkedList<T> delete(int index) {
      if (index == 1) {
        return delete();
      } else {
        next = next.delete(index-1);
        return this;
      }
    }
}
