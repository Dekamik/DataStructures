package se.vonbargen.dennis.datastructures.list;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author      Dennis von Bargen
 * @param <T>   Data type
 */
public class LinkedList<T> implements Collection<T>, Iterable<T>, Serializable {

    private class Node {

        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return data != null ? data.equals(node.data) : node.data == null;

        }

        @Override
        public int hashCode() {
            return data != null ? data.hashCode() : 0;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public T getFirst() {
        return first != null ? first.data : null;
    }

    public T getLast() {
        return last != null ? last.data : null;
    }

    @Override
    public boolean add(T obj) throws ClassCastException {
        try {
            Node newNode = new Node(obj);
            if (!isEmpty()) {
                last.next = newNode;
                last = newNode;
            } else {
                first = newNode;
                last = newNode;
            }
            size++;
            return true;
        } catch (ClassCastException ex) {
            throw ex;
        }
    }

    @Override
    public boolean remove(Object obj) {
        Iterator<T> it = iterator();

        while(it.hasNext()) {
            if (obj.equals(it.next())) {
                it.remove();
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object obj) {
        Iterator it = iterator();

        while(it.hasNext()) {
            if (it.next().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private boolean initialized = false;
            private Node current = null;
            private Node previous = null;

            @Override
            public boolean hasNext() {
                return !initialized || current.next != null;
            }

            @Override
            public T next() {
                if (first == null) {
                    throw new NullPointerException();
                }
                initialized = true;
                if (current != null) {
                    previous = current;
                    current = current.next;
                } else {
                    current = first;
                }
                return current.data;
            }

            @Override
            public void remove() {
                if (previous != null) {
                    previous.next = current.next;
                    current = previous;
                } else {
                    current = current.next;
                    first = current;
                }
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Iterator it = iterator();
        Object[] array = new Object[size];
        int i = 0;

        while(it.hasNext()) {
            array[i] = it.next();
            i++;
        }
        return array;
    }

    @Override
    @Deprecated
    public <T1> T1[] toArray(T1[] a) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (contains(o)) {
                continue;
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int added = 0;

        for (T o : c) {
            added += add(o) ? 1 : 0;
        }
        return added == c.size();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int removed = 0;

        for (Object o : c) {
            removed += remove(o) ? 1 : 0;
        }
        return removed == c.size();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Iterator it = iterator();

        while(it.hasNext()) {
            Object current = it.next();
            if (!c.contains(current)) {
                remove(current);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
}
