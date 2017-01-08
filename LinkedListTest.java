import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTest {
  @Test
  public void construct() {
    LinkedList<Integer> list = new LinkedList<>(1, null);
    list = new LinkedList<>(2, list);
    list = new LinkedList<>(3, list);
    list = new LinkedList<>(4, list);
    assertEquals(4, list.size());
    assertArrayEquals(new Integer[]{4, 3, 2, 1}, list.toArray());
  }

  @Test
  public void insertAt() {
    LinkedList<Integer> list = new LinkedList<>(5, null);
    list = list.insert(3);    
    list = list.insert(2);    
    list = list.insert(1);
    list = list.insert(4, 4);   
    assertEquals(5, list.size());
    assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, list.toArray());    
  }

  @Test
  public void insertBegin() {
    LinkedList<Integer> list = new LinkedList<>(3, null);
    list = list.insert(2);
    list = list.insert(1, 1);
    assertEquals(3, list.size());
    assertArrayEquals(new Integer[]{1, 2, 3}, list.toArray());    
  }

  @Test
  public void deleteStart() {
    LinkedList<Integer> list = new LinkedList<>(3, null);
    list = list.insert(2);    
    list = list.insert(1);    
    list = list.delete(1);
    assertEquals(2, list.size());
    assertArrayEquals(new Integer[]{2, 3}, list.toArray());    
  }

  @Test
  public void delete() {
    LinkedList<Integer> list = new LinkedList<>(3, null);
    list = list.insert(2);    
    list = list.insert(1);    
    list = list.delete(2);
    assertEquals(2, list.size());
    assertArrayEquals(new Integer[]{1, 3}, list.toArray());    
  }

  @Test
  public void deleteEnd() {
    LinkedList<Integer> list = new LinkedList<>(3, null);
    list = list.insert(2);    
    list = list.insert(1);    
    list = list.delete(3);
    assertEquals(2, list.size());
    assertArrayEquals(new Integer[]{1, 2}, list.toArray());    
  }

  @Test
  public void access() {
    LinkedList<Integer> list = new LinkedList<>(3, null);
    list = list.insert(2);    
    list = list.insert(1);    
    Integer a = list.access(2);
    assertEquals(new Integer(2), a);    
    a = list.access(1);
    assertEquals(new Integer(1), a);
  }

  @Test
  public void search() {
    LinkedList<Integer> list = new LinkedList<>(3, null);
    list = list.insert(2);    
    list = list.insert(1);    
    int ind = list.search(2);
    assertEquals(2, ind);
    ind = list.search(1);
    assertEquals(1, ind);
    ind = list.search(10);
    assertEquals(-1, ind);
  }

}