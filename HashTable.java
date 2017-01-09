import java.util.ArrayList;
import java.util.LinkedList;

class Pair {
  String key;
  Integer value;
  public Pair(String key, Integer value) {
    this.key = key;
    this.value = value;
  }
}

/**
  * A hashtable structure
  * @space O(n)
  */

public class HashTable {
  private static final int LENGTH = 1024;
  ArrayList<LinkedList<Pair>> hash;

  /**
    * Create a new hashtable
    */
  public HashTable() {
    hash = new ArrayList<LinkedList<Pair>>();
    for (int i=0; i<LENGTH; i++) {
      hash.add(i, new LinkedList<>());
    }
  }

  /**
    * Get value for a given key
    * @time O(1) worst O(n)
    */
  public Integer search(String key) {
    int hashCode = key.hashCode();
    LinkedList<Pair> list = hash.get(hashCode % LENGTH);
    for (Pair p: list) {
      if (p.key.equals(key)) {
        return p.value;
      }
    }
    return null;
  }

  /**
    * Add a key/value in the hashtable
    * @param key
    * @param value
    * @time O(1)
    */
  public void insert(String key, Integer element) {
    int hashCode = key.hashCode();
    hash.get(hashCode % LENGTH).add(new Pair(key, element));
  }  

  /**
    * Delete an element from the hastable
    * @param the key of the element to delete
    * @return true if element found, false otherwise
    * @time O(1) worst O(n)
    */
  public boolean delete(String key) {
    int hashCode = key.hashCode();
    LinkedList<Pair> list = hash.get(hashCode % LENGTH);
    for (Pair p: list) {
      if (p.key.equals(key)) {
        list.remove(p);
        return true;
      }
    }
    return false;
  }
}
