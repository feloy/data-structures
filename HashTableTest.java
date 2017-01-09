import static org.junit.Assert.*;
import org.junit.Test;

public class HashTableTest {
  @Test
  public void insert() {
    HashTable hash = new HashTable();

    hash.insert("key42", 42);
    hash.insert("key43", 43);
    hash.insert("key44", 44);
    hash.insert("key45", 45);

    assertEquals(new Integer(43), hash.search("key43"));
    assertEquals(null, hash.search("key4"));
  }

  @Test
  public void delete() {
    HashTable hash = new HashTable();

    hash.insert("key42", 42);
    hash.insert("key43", 43);
    hash.insert("key44", 44);
    hash.insert("key45", 45);

    assertEquals(new Integer(43), hash.search("key43"));

    boolean b = hash.delete("key43");    
    assertEquals(true, b);
    b = hash.delete("key43");    
    assertEquals(false, b);
    assertEquals(null, hash.search("key43"));
  }
}
