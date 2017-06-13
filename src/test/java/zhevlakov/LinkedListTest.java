package zhevlakov;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by zhevlakov on 12.06.17.
 */
public class LinkedListTest {

    @Test
    public void size() throws Exception {
        LinkedList<String> linkedList = new LinkedList<String>();
        assertEquals(0, linkedList.size());
        linkedList.add("First");
        assertEquals(1, linkedList.size());
        linkedList.removeTail();
        assertEquals(0, linkedList.size());
    }

    @Test
    public void removeGreatThan() throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(10);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(20);
        linkedList.add(50);
        linkedList.removeGreatThan(25);

        assertEquals(2, linkedList.size());
        assertEquals(10, (int)linkedList.getFirst());
        assertEquals(20, (int)linkedList.getLast());
        assertEquals("[10, 20]", Arrays.toString(linkedList.toArray()));

    }

}