import Music.Composition;
import Music.Ringtone;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.*;

public class ListTest {
    @Test
    public void testContains() {
        MyList<Composition> myList = new MyList<>();

        // Creating elements for testing
        Composition composition1 = new Ringtone("Ringtone 1", "calm", 2.4F);
        Composition composition2 = new Ringtone("Ringtone 2", "energetic", 3.5F);
        Composition composition3 = new Ringtone("Ringtone 3", "melodic", 4.2F);

        // Adding elements to the list
        myList.add(composition1);
        myList.add(composition2);

        // Testing contains with existing and non-existing elements
        assertTrue(myList.contains(composition1)); // Should return true
        assertTrue(myList.contains(composition2)); // Should return true
        assertFalse(myList.contains(composition3)); // Should return false
    }

    @Test
    public void testContainsAll() {
        MyList<Composition> myList = new MyList<>();

        // Creating elements for testing
        Composition composition1 = new Ringtone("Ringtone 1", "calm", 2.4F);
        Composition composition2 = new Ringtone("Ringtone 2", "energetic", 3.5F);
        Composition composition3 = new Ringtone("Ringtone 3", "melodic", 4.2F);

        // Adding elements to the list
        assertTrue(myList.add(composition1));
        assertTrue(myList.add(composition2));
        assertTrue(myList.add(composition3));

        // Creating a collection with elements to check for
        List<Composition> checkList = new ArrayList<>(Arrays.asList(composition1, composition2, composition3));

        // Testing containsAll with a collection containing all elements
        assertTrue(myList.containsAll(checkList));

        // Modifying the checkList to contain an element not in the list
        checkList.add(new Ringtone("Non-existent Ringtone", "unknown", 1.0F));

        // Testing containsAll with a collection containing an element not in the list
        assertFalse(myList.containsAll(checkList));
    }

    @Test
    public void testIterator() {
        MyList<Composition> myList = new MyList<>();

        // Creating elements for testing
        Composition composition1 = new Ringtone("Ringtone 1", "calm", 2.4F);
        Composition composition2 = new Ringtone("Ringtone 2", "energetic", 3.5F);
        Composition composition3 = new Ringtone("Ringtone 3", "melodic", 4.2F);

        // Adding elements to the list
        myList.add(composition1);
        myList.add(composition2);
        myList.add(composition3);

        // Creating an iterator and iterating through the elements
        Iterator<Composition> iterator = myList.iterator();

        assertTrue(iterator.hasNext()); // Should return true for the first element
        assertEquals(composition1, iterator.next()); // Should return the first element

        assertTrue(iterator.hasNext()); // Should return true for the second element
        assertEquals(composition2, iterator.next()); // Should return the second element

        assertTrue(iterator.hasNext()); // Should return true for the third element
        assertEquals(composition3, iterator.next()); // Should return the third element

        assertFalse(iterator.hasNext()); // Should return false, as there are no more elements
    }

    @Test
    public void testAdd() {
        MyList<Composition> myList = new MyList<>();

        // Creating elements for testing
        Composition composition1 = new Ringtone("Ringtone 1", "calm", 2.4F);
        Composition composition2 = new Ringtone("Ringtone 2", "energetic", 3.5F);
        Composition composition3 = new Ringtone("Ringtone 3", "melodic", 4.2F);

        // Adding elements to the list
        assertTrue(myList.add(composition1)); // Should return true
        assertTrue(myList.add(composition2)); // Should return true
        assertTrue(myList.add(composition3)); // Should return true

        // Verifying that elements are added correctly
        assertEquals(3, myList.size()); // The size of the list should be 3
        assertTrue(myList.contains(composition1)); // Should return true
        assertTrue(myList.contains(composition2)); // Should return true
        assertTrue(myList.contains(composition3)); // Should return true
    }

    @Test
    public void testRemove() {
        MyList<Composition> myList = new MyList<>();

        // Creating elements for testing
        Composition composition1 = new Ringtone("Ringtone 1", "calm", 2.4F);
        Composition composition2 = new Ringtone("Ringtone 2", "energetic", 3.5F);
        Composition composition3 = new Ringtone("Ringtone 3", "melodic", 4.2F);

        // Adding elements to the list
        assertTrue(myList.add(composition1));
        assertTrue(myList.add(composition2));
        assertTrue(myList.add(composition3));

        // Removing elements from the list
        assertTrue(myList.remove(composition2)); // Should return true

        // Verifying that the element is removed correctly
        assertEquals(2, myList.size()); // The size of the list should be 2
        assertTrue(myList.contains(composition1)); // Should return true
        assertFalse(myList.contains(composition2)); // Should return false
        assertTrue(myList.contains(composition3)); // Should return true

        // Removing an element that doesn't exist
        assertFalse(myList.remove(new Ringtone("Non-existent Ringtone", "unknown", 1.0F))); // Should return false

        // Verifying that the list remains unchanged
        assertEquals(2, myList.size()); // The size of the list should still be 2
        assertTrue(myList.contains(composition1)); // Should return true
        assertFalse(myList.contains(composition2)); // Should return false
        assertTrue(myList.contains(composition3)); // Should return true
    }

    @Test
    public void testClear() {
        MyList<Composition> myList = new MyList<>();

        // Creating elements for testing
        Composition composition1 = new Ringtone("Ringtone 1", "calm", 2.4F);
        Composition composition2 = new Ringtone("Ringtone 2", "energetic", 3.5F);
        Composition composition3 = new Ringtone("Ringtone 3", "melodic", 4.2F);

        // Adding elements to the list
        assertTrue(myList.add(composition1));
        assertTrue(myList.add(composition2));
        assertTrue(myList.add(composition3));

        // Testing clear
        myList.clear();

        // Verifying that the list is cleared
        assertEquals(0, myList.size()); // The size of the list should be 0
        assertFalse(myList.contains(composition1)); // Should return false
        assertFalse(myList.contains(composition2)); // Should return false
        assertFalse(myList.contains(composition3)); // Should return false
    }

    @Test
    public void testRetainAll() {
        MyList<Composition> myList = new MyList<>();

        // Creating elements for testing
        Composition composition1 = new Ringtone("Ringtone 1", "calm", 2.4F);
        Composition composition2 = new Ringtone("Ringtone 2", "energetic", 3.5F);
        Composition composition3 = new Ringtone("Ringtone 3", "melodic", 4.2F);

        // Adding elements to the list
        assertTrue(myList.add(composition1));
        assertTrue(myList.add(composition2));
        assertTrue(myList.add(composition3));

        // Creating a collection with elements to retain
        List<Composition> retainList = Arrays.asList(composition1, composition3);

        // Testing retainAll with a collection of elements to retain
        assertTrue(myList.retainAll(retainList));

        // Verifying that the list contains only the retained elements
        assertEquals(2, myList.size()); // The size of the list should be 2
        assertTrue(myList.contains(composition1)); // Should return true
        assertFalse(myList.contains(composition2)); // Should return false
        assertTrue(myList.contains(composition3)); // Should return true
    }

    @Test
    public void testGet() {
        MyList<Composition> myList = new MyList<>();

        // Creating elements for testing
        Composition composition1 = new Ringtone("Ringtone 1", "calm", 2.4F);
        Composition composition2 = new Ringtone("Ringtone 2", "energetic", 3.5F);
        Composition composition3 = new Ringtone("Ringtone 3", "melodic", 4.2F);

        // Adding elements to the list
        assertTrue(myList.add(composition1));
        assertTrue(myList.add(composition2));
        assertTrue(myList.add(composition3));

        // Getting elements from the list
        assertEquals(composition1, myList.get(0)); // Should return the first element
        assertEquals(composition2, myList.get(1)); // Should return the second element
        assertEquals(composition3, myList.get(2)); // Should return the third element

        // Getting an element from an invalid index
        try {
            myList.get(3); // Index out of bounds
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test
    public void testSet() {
        MyList<Composition> myList = new MyList<>();

        // Creating elements for testing
        Composition composition1 = new Ringtone("Ringtone 1", "calm", 2.4F);
        Composition composition2 = new Ringtone("Ringtone 2", "energetic", 3.5F);
        Composition composition3 = new Ringtone("Ringtone 3", "melodic", 4.2F);

        // Adding elements to the list
        assertTrue(myList.add(composition1));
        assertTrue(myList.add(composition2));
        assertTrue(myList.add(composition3));

        // Setting elements in the list
        Composition newComposition = new Ringtone("New Ringtone", "newGenre", 5.0F);
        assertEquals(composition1, myList.set(0, newComposition)); // Should return the old first element

        // Verifying that the element is set correctly
        assertEquals(newComposition, myList.get(0)); // The first element should now be the new one
        assertEquals(composition2, myList.get(1)); // The second element should remain unchanged
        assertEquals(composition3, myList.get(2)); // The third element should remain unchanged

        // Setting an element at an invalid index
        try {
            myList.set(3, newComposition); // Index out of bounds
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test
    public void testIndexOf() {
        MyList<Composition> myList = new MyList<>();

        // Creating elements for testing
        Composition composition1 = new Ringtone("Ringtone 1", "calm", 2.4F);
        Composition composition2 = new Ringtone("Ringtone 2", "energetic", 3.5F);
        Composition composition3 = new Ringtone("Ringtone 3", "melodic", 4.2F);

        // Adding elements to the list
        assertTrue(myList.add(composition1));
        assertTrue(myList.add(composition2));
        assertTrue(myList.add(composition3));

        // Testing indexOf for existing and non-existing elements
        assertEquals(0, myList.indexOf(composition1)); // Should return the index of the first element
        assertEquals(1, myList.indexOf(composition2)); // Should return the index of the second element
        assertEquals(2, myList.indexOf(composition3)); // Should return the index of the third element
        assertEquals(-1, myList.indexOf(new Ringtone("Non-existent Ringtone", "unknown", 1.0F))); // Should return -1 for a non-existing element
        assertEquals(-1, myList.indexOf(null)); // Should return -1 for null when the list doesn't contain null
    }

    @Test
    public void testToArray() {
        MyList<Composition> myList = new MyList<>();

        // Creating elements for testing
        Composition composition1 = new Ringtone("Ringtone 1", "calm", 2.4F);
        Composition composition2 = new Ringtone("Ringtone 2", "energetic", 3.5F);
        Composition composition3 = new Ringtone("Ringtone 3", "melodic", 4.2F);

        // Adding elements to the list
        assertTrue(myList.add(composition1));
        assertTrue(myList.add(composition2));
        assertTrue(myList.add(composition3));

        // Testing toArray
        Composition[] array = myList.toArray();

        // Verifying that the returned array contains the correct elements
        assertEquals(3, array.length); // The length of the array should be 3
        assertEquals(composition1, array[0]); // The first element of the array should be the first element in the list
        assertEquals(composition2, array[1]); // The second element of the array should be the second element in the list
        assertEquals(composition3, array[2]); // The third element of the array should be the third element in the list
    }

}
