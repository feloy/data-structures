import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest {

  @Test
  public void construct() {
    Queue queue = new Queue(2);
    assertEquals(2, queue.data.length);
    assertEquals(0, queue.length);
  }

  @Test
  public void insert() {
    Queue queue = new Queue(2);
    queue.insert(1);
    queue.insert(2);
    assertEquals(2, queue.length);    
  }

  @Test
  public void insertAllocateMore() {
    Queue queue = new Queue(2);
    queue.insert(10);
    queue.insert(20);
    assertEquals(2, queue.length);    
    assertEquals(2, queue.data.length);    
    queue.insert(30);
    assertEquals(3, queue.length);    
    assertEquals(4, queue.data.length);    
  }

  @Test 
  public void delete() {
    Queue queue = new Queue(2);
    queue.insert(1);
    queue.insert(2);
    assertEquals(2, queue.length);
    assertArrayEquals(new Integer[]{1, 2}, queue.toArray());    

    queue.delete();
    assertEquals(1, queue.length);
    assertArrayEquals(new Integer[]{2}, queue.toArray());    

    queue.delete();
    assertEquals(0, queue.length);
    assertArrayEquals(new Integer[]{}, queue.toArray());    

  }

  @Test
  public void search() {
    Queue queue = new Queue(8);
    for (int i=1; i<6; i++) {
      queue.insert(10 * i);
    }
    assertArrayEquals(new Integer[]{10, 20, 30, 40, 50}, queue.toArray());
    int foundPos = queue.search(new Integer(30));
    assertEquals(3, foundPos);
    assertArrayEquals(new Integer[]{10, 20, 30, 40, 50}, queue.toArray());
  }
}
