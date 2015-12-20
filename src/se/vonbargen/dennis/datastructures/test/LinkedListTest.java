package se.vonbargen.dennis.datastructures.test;

import se.vonbargen.dennis.datastructures.list.LinkedList;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by root on 2015-12-20.
 */
public class LinkedListTest {

    private LinkedList<Integer> list;

    @org.junit.Before
    public void setUp() throws Exception {
        list = new LinkedList<>();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        list = null;
    }

    @org.junit.Test
    public void testAdd() throws Exception {
        assertTrue(list.add(1));
    }

    @org.junit.Test
    public void testRemove() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertTrue(list.remove(2));
        assertTrue(list.remove(3));
        assertTrue(list.remove(4));
        assertTrue(list.remove(1));
    }

    @org.junit.Test
    public void testGetFirst() throws Exception {
        list.add(1);
        assertEquals(new Integer(1), list.getFirst());

        list.remove(1);
        assertEquals(null, list.getFirst());

        list.add(2);
        assertEquals(new Integer(2), list.getFirst());
    }

    @org.junit.Test
    public void testGetLast() throws Exception {
        list.add(1);
        assertEquals(list.getLast(), new Integer(1));

        list.add(2);
        assertEquals(list.getLast(), new Integer(2));
    }

    @org.junit.Test
    public void testIsEmpty() throws Exception {
        assertTrue(list.isEmpty());
        assertNull(list.getFirst());
        assertNull(list.getLast());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertFalse(list.isEmpty());
        assertNotNull(list.getFirst());
        assertNotNull(list.getLast());
    }

    @org.junit.Test
    public void testIterator() throws Exception {
        Iterator<Integer> it = list.iterator();
        Integer[] arr = new Integer[4];

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;

        for (Integer i : arr) {
            list.add(i);
        }

        for (Integer i : arr) {
            Integer data = it.next();
            assertEquals(i, data);
            if (data.equals(2)) {
                it.remove();
            }
        }

        Iterator<Integer> it2 = list.iterator();

        assertEquals(new Integer(1), it2.next());
        assertEquals(new Integer(3), it2.next());
        assertEquals(new Integer(4), it2.next());
    }

    //@org.junit.Test
    public void testContains() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertTrue(list.contains(2));
        assertTrue(list.contains(4));
        assertTrue(list.contains(1));
    }

    @org.junit.Test
    public void testSize() throws Exception {
        assertEquals(0, list.size());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertEquals(4, list.size());

        list.remove(3);

        assertEquals(3, list.size());
    }

    @org.junit.Test
    public void testToArray() throws Exception {
        Integer[] arr = new Integer[4];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;

        for (Integer i : arr) {
            list.add(i);
        }

        Object[] arr2 = list.toArray();

        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], arr2[i]);
        }
    }

    @org.junit.Test
    public void testToArray1() throws Exception {

    }

    @org.junit.Test
    public void testContainsAll() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Integer[] arr = new Integer[4];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;

        for (Integer i : arr) {
            list.add(i);
            arrayList.add(i);
            linkedList.add(i);
        }

        assertTrue(list.containsAll(arrayList));
        assertTrue(list.containsAll(linkedList));

        list.remove(3);

        assertFalse(list.containsAll(arrayList));
        assertFalse(list.containsAll(linkedList));
    }

    @org.junit.Test
    public void testAddAll() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        list.addAll(arrayList);

        assertTrue(list.containsAll(arrayList));
    }

    @org.junit.Test
    public void testRemoveAll() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        list.addAll(arrayList);
        list.add(5);

        assertTrue(list.removeAll(arrayList));
        assertEquals(1, list.size());
        assertTrue(list.contains(5));
    }

    @org.junit.Test
    public void testRetainAll() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(-1);
        arrayList2.add(-32);
        arrayList2.add(9);
        arrayList2.add(44);

        list.addAll(arrayList);
        list.addAll(arrayList2);

        assertTrue(list.containsAll(arrayList));
        assertTrue(list.containsAll(arrayList2));
        assertTrue(list.retainAll(arrayList));
        assertTrue(list.containsAll(arrayList));
        assertFalse(list.containsAll(arrayList2));
        assertEquals(4, list.size());
    }

    @org.junit.Test
    public void testClear() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertEquals(4, list.size());
        assertFalse(list.isEmpty());
        assertNotNull(list.getFirst());
        assertNotNull(list.getLast());
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }
}