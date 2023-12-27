import java.util.*;

public class MyList<Composition extends Music.Composition> implements List<Composition> {
    private Node head;
    private int size;

    public MyList() {
        head = null;
        size = 0;
    }

    public MyList(Composition comp) {
        head = new Node(comp);
        size = 1;
    }
    public MyList(Collection<Composition> comp) {
        this.addAll(comp);
    }

    private class Node {
        Composition data;
        Node next;

        Node(Composition element) {
            this.data = element;
            this.next = null;
        }

        // Helper method to get the node at a specific index
        private Node getNode(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }

            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    //@Override
    public boolean contains(Object o) {
        if (o == null) {
            // If the object to be checked is null, we need to iterate over the list
            // and find if any element is null.
            Node current = head;
            while (current != null) {
                if (current.data == null) {
                    return true;
                }
                current = current.next;
            }
        } else {
            // If the object is not null, we can use equals() to check for equality.
            Node current = head;
            while (current != null) {
                if (o.equals(current.data)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public Iterator<Composition> iterator() {
        return new Iterator<Composition>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Composition next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements to iterate");
                }
                Composition data = current.data;
                current = current.next;
                return data;
            }


        };
    }

    @Override
    public Music.Composition[] toArray() {
        Music.Composition[] array = new Music.Composition[size];
        Node current = head;
        int index = 0;

        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }

        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size
            );
            a = newArray;
        }

        Node current = head;
        int index = 0;

        while (current != null) {
            a[index++] = (T) current.data;
            current = current.next;
        }

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(Composition element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        Node current = head;
        Node prev = null;

        if (obj == null) {

            // Handle removal of null elements
            while (current != null) {
                if (current.data == null) {
                    if (prev == null) {
                        // If the element to be removed is the head
                        head = current.next;
                    } else {
                        // If the element to be removed is not the head
                        prev.next = current.next;
                    }
                    size--;
                    return true;
                }
                prev = current;
                current = current.next;
            }
        } else {

            // Handle removal of non-null elements
            while (current != null) {
                if (obj.equals(current.data)) {
                    if (prev == null) {
                        // If the element to be removed is the head
                        head = current.next;
                    } else {
                        // If the element to be removed is not the head
                        prev.next = current.next;
                    }
                    size--;
                    return true;
                }
                prev = current;
                current = current.next;
            }
        }

        return false; // Element not found
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Composition> c) {
        boolean modified = false;

        for (Composition element : c) {
            add(element);
            modified = true;
        }

        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Composition> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node current = head.getNode(index); // Get the node at the specified index

        for (Composition element : c) {
            Node newNode = new Node(element);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode;
            size++;
        }

        return !c.isEmpty(); // Return true if the collection was not empty
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        // Iterate over the list and remove elements present in the collection
        Iterator<Composition> iterator = iterator();
        while (iterator.hasNext()) {
            Composition element = iterator.next();
            if (c.contains(element)) {
                iterator.remove();
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;

        // Use MyListIterator instead of Iterator
        MyListIterator myListIterator = new MyListIterator();

        while (myListIterator.hasNext()) {
            Composition element = myListIterator.next();
            if (!c.contains(element)) {
                myListIterator.remove();
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Composition get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public Composition set(int index, Composition element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node current = head.getNode(index); // Get the node at the specified index
        Composition oldElement = current.data; // Store the old element to return later
        current.data = element; // Set the new element at the specified index
        return oldElement; // Return the old element
    }

    @Override
    public void add(int index, Composition element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node newNode = new Node(element);

        if (index == 0) {
            // Insert at the beginning
            newNode.next = head;
            head = newNode;
        } else {
            // Insert at a non-zero index
            Node current = head.getNode(index - 1);
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    @Override
    public Composition remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Composition removedElement;

        if (index == 0) {
            // Remove the element at the beginning
            removedElement = head.data;
            head = head.next;
        } else {
            // Remove an element at a non-zero index
            Node prev = head.getNode(index - 1);
            removedElement = prev.next.data;
            prev.next = prev.next.next;
        }

        size--;
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node current = head;

        if (o == null) {
            // Handle the case when the object to be searched is null
            while (current != null) {
                if (current.data == null) {
                    return index;
                }
                current = current.next;
                index++;
            }
        }
        else {
            // Handle the case when the object is not null
            while (current != null) {
                if (o.equals(current.data)) {
                    return index;
                }
                current = current.next;
                index++;
            }
        }

        return -1; // Element not found
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        int lastIndex = -1;
        Node current = head;

        if (o == null) {
            // Handle the case when the object to be searched is null
            while (current != null) {
                if (current.data == null) {
                    lastIndex = index;
                }
                current = current.next;
                index++;
            }
        } else {
            // Handle the case when the object is not null
            while (current != null) {
                if (o.equals(current.data)) {
                    lastIndex = index;
                }
                current = current.next;
                index++;
            }
        }

        return lastIndex;
    }

    @Override
    public ListIterator<Composition> listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator<Composition> listIterator(int index) {
        return new MyListIterator(index);
    }

    @Override
    public MyList<Composition> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + ", toIndex: " + toIndex + ", Size: " + size);
        }

        MyList<Composition> subList = new MyList<>();
        Node current = head.getNode(fromIndex);

        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(current.data);
            current = current.next;
        }

        return subList;
    }

    private class MyListIterator implements ListIterator<Composition> {
        private Node current;
        private Node lastReturned;
        private int nextIndex;

        public MyListIterator() {
            this(0);
        }
        public MyListIterator(int index) {
            if (index == size) {
                // If the index is at the end, set current to null
                current = null;
            } else {
                // Otherwise, get the node at the specified index
                current = head.getNode(index);
            }
            lastReturned = null;
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Composition next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = current;
            current = current.next;
            nextIndex++;
            return lastReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public Composition previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (current == null) {
                current = head.getNode(nextIndex - 1);
            } else {
                current = current.next;
            }
            lastReturned = current;
            nextIndex--;
            return lastReturned.data;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }

            Node prev = head.getNode(nextIndex - 2);
            if (prev == null) {
                head = current;
            } else {
                prev.next = current;
            }

            size--;
            if (current == null) {
                nextIndex--;
            }

            lastReturned = null;
        }

        @Override
        public void set(Composition element) {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }

            lastReturned.data = element;
        }

        @Override
        public void add(Composition element) {
            Node newNode = new Node(element);

            if (lastReturned == null) {
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = lastReturned.next;
                lastReturned.next = newNode;
            }

            size++;
            nextIndex++;
            lastReturned = null;
        }


    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        ListIterator<Composition> iterator = listIterator();

        while (iterator.hasNext()) {
            result.append(iterator.next());
            if (iterator.hasNext()) {
                result.append(", ").append(System.lineSeparator());
            }
        }

        result.append("]");
        return result.toString();
    }
}
