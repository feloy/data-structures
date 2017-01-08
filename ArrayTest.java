import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayTest {
  @Test
  public void construct() {
    Array<Integer> arr = new Array<Integer>(5);
    assertEquals(5, arr.data.length);
    assertEquals(0, arr.length);
  }

  @Test
  public void outOfBoundd() {
    Array<Integer> arr = new Array<Integer>(5);
    arr.insert(10, 1);
    assertEquals(0, arr.length);
  }

  @Test
  public void insertAtEnd() {
    Array<Integer> arr = new Array<Integer>(5);
    arr.insert(1, 0);
    arr.insert(2, 1);
    arr.insert(3, 2);
    arr.insert(4, 3);
    assertEquals(4, arr.length);
    assertArrayEquals(new Integer[] {1, 2, 3, 4, null}, arr.data);
  }

  @Test
  public void insertAtStart() {
    Array<Integer> arr = new Array<Integer>(5);
    arr.insert(4, 0);
    arr.insert(3, 0);
    arr.insert(2, 0);
    arr.insert(1, 0);
    assertEquals(4, arr.length);
    assertArrayEquals(new Integer[] {1, 2, 3, 4, null}, arr.data);
  }

  @Test
  public void reallocSize() {
    Array<Integer> arr = new Array<Integer>(1);
    assertEquals(1, arr.data.length);    
    arr.insert(1, 0);
    assertEquals(1, arr.data.length);    
    arr.insert(1, 0);
    assertEquals(2, arr.data.length);    
    arr.insert(1, 0);
    assertEquals(4, arr.data.length);    
    arr.insert(1, 0);
    assertEquals(4, arr.data.length);    
    arr.insert(1, 0);
    assertEquals(8, arr.data.length);    
  }

  @Test
  public void deleteAtEnd() {
    Array<Integer> arr = new Array<Integer>(4);
    arr.insert(4, 0);
    arr.insert(3, 0);
    arr.insert(2, 0);
    arr.insert(1, 0);
    assertArrayEquals(new Integer[] {1, 2, 3, 4}, arr.data);
    assertEquals(4, arr.length);
    arr.delete(3);
    assertArrayEquals(new Integer[] {1, 2, 3, 4}, arr.data);
    assertEquals(3, arr.length);
  }

  @Test
  public void deleteAtStart() {
    Array<Integer> arr = new Array<Integer>(4);
    arr.insert(4, 0);
    arr.insert(3, 0);
    arr.insert(2, 0);
    arr.insert(1, 0);
    assertArrayEquals(new Integer[] {1, 2, 3, 4}, arr.data);
    assertEquals(4, arr.length);
    arr.delete(0);
    assertArrayEquals(new Integer[] {2, 3, 4, 4}, arr.data);
    assertEquals(3, arr.length);
  }

  @Test
  public void access() {
    Array<Integer> arr = new Array<Integer>(4);
    arr.insert(4, 0);
    arr.insert(3, 0);
    arr.insert(2, 0);
    arr.insert(1, 0);
    assertEquals(new Integer(2), arr.access(1));    
  }

  @Test
  public void search() {
    Array<Integer> arr = new Array<Integer>(4);
    arr.insert(4, 0);
    arr.insert(3, 0);
    arr.insert(2, 0);
    arr.insert(1, 0);
    assertEquals(1, arr.search(new Integer(2)));    
  }
}