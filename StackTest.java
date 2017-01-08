import static org.junit.Assert.*;
import org.junit.Test;

public class StackTest {
  @Test
  public void construct() {
      Stack<Integer> stack = new Stack<>(3);
      assertEquals(3, stack.data.length);
      assertEquals(0, stack.length);
  }

  @Test
  public void insert() {
      Stack<Integer> stack = new Stack<>(3);
      stack.insert(1);
      stack.insert(2);
      stack.insert(3);
      assertEquals(3, stack.length);
      assertArrayEquals(new Integer[]{1, 2, 3}, stack.data);
  }

  @Test
  public void reallocSize() {
      Stack<Integer> stack = new Stack<>(3);
      stack.insert(1);
      stack.insert(2);
      stack.insert(3);
      assertEquals(3, stack.data.length);
      stack.insert(4);
      assertEquals(6, stack.data.length);
  }

  @Test
  public void delete() {
      Stack<Integer> stack = new Stack<>(3);
      stack.insert(1);
      stack.insert(2);
      stack.insert(3);
      assertEquals(3, stack.length);
      stack.delete();
      assertEquals(2, stack.length);      
  }

  @Test
  public void access() {
      Stack<Integer> stack = new Stack<>(3);
      stack.insert(1);
      stack.insert(2);
      stack.insert(3);
      Integer i = stack.access();
      assertEquals(new Integer(3), i);
  }  

  @Test
  public void accessDeep() {
      Stack<Integer> stack = new Stack<>(3);
      stack.insert(1);
      stack.insert(2);
      stack.insert(3);
      Integer i = stack.access(3);
      assertEquals(new Integer(1), i);    
      assertEquals(3, stack.length);
  }

  @Test
  public void search() {
      Stack<Integer> stack = new Stack<>(3);
      stack.insert(1);
      stack.insert(2);
      stack.insert(3);
      assertArrayEquals(new Integer[]{1, 2, 3}, stack.data);

      int i = stack.search(3);
      assertArrayEquals(new Integer[]{1, 2, 3}, stack.data);
      assertEquals(1, i);    

      i = stack.search(2);
      assertArrayEquals(new Integer[]{1, 2, 3}, stack.data);
      assertEquals(2, i);    

      i = stack.search(1);
      assertArrayEquals(new Integer[]{1, 2, 3}, stack.data);
      assertEquals(3, i);    
  }
}
