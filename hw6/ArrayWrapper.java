import java.util.NoSuchElementException;
/**
  *
  *
  *@author Madeline Fox
  *@version 1.0
  */
public class ArrayWrapper<T> implements SimpleCollection<T> {
    private T[] arraywrapper;
    /**
      *
      *
      */
    public ArrayWrapper() {
        this.arraywrapper = (T[]) new Object[5];
    }

    /**
      *
      *@param   initialSize
      *@throws  IllegalArgumentException
      */
    public ArrayWrapper(int initialSize) {
        if (initialSize < 0) {
            throw (new IllegalArgumentException("The initial size must be "
                    + "greater or equal to 0"));
        }
        this.arraywrapper = (T[]) new Object[initialSize];
    }

    /**
      *
      *
      */
    public ArrayWrapper(T[] arraywrapper) {
        this.arraywrapper = (T[]) new Object[arraywrapper.length];
        this.arraywrapper = arraywrapper;
    }

    /**
     * Adds an element into the collection.
     * If the new element would exceed the size of the backing array,
     * instead resize the array, doubling it in size and copy over the
     * old elements.
     *
     * @param elem The element being added.
     */
    public void add(T o) {
        if (this.arraywrapper.length >= size() + 1) {
            arraywrapper[size()] = o;
        } else {
            T[] temp = (T[]) new Object[arraywrapper.length * 2];
            for (int i = 0; i < arraywrapper.length; i++) {
                temp[i] = arraywrapper[i];
            }
            temp[arraywrapper.length] = o;
            arraywrapper = temp;
        }
    }

    /**
     * Clears the collection, resetting size and starting from a fresh
     * backing array of size 5.
     */
    public void clear() {
        arraywrapper = (T[]) new Object[5];
    }

    /**
      *Returns a shallow copy of this ArrayWrapper instance.
      *@return  new ArrayWrapper equal to this instance of ArrayWrapper
      */
    public ArrayWrapper<T> clone() {
        return (new ArrayWrapper<T>(arraywrapper));
    }

    /**
     * Checks to see if the collection contains a given element.
     *
     * @param elem The element we are checking for.
     * @return true if the collection contains elem, false otherwise.
     */
    public boolean contains(T o) {
        for (int i = 0; i < arraywrapper.length; i++) {
            if (arraywrapper[i] != null) {
                if (arraywrapper[i].equals(o)) {
                    return (true);
                }
            }
        }
        return (false);
    }

    /**
     * Gets an element from the collection, using its 0-based index.
     * If the index is within our backing array but more than our last
     * element, rather than returning null, this should throw
     * a java.util.NoSuchElementException.
     *
     * @param index The index of the element we want.
     * @return The element at the specified index.
     */
    public T get(int index) {
        if (arraywrapper[index] == null) {
            throw (new NoSuchElementException("No such element."));
        } else if (index > arraywrapper.length) {
            throw (new NoSuchElementException("This is not in the backing "
                                                + "array."));
        }
        return (arraywrapper[index]);
    }

    /**
      *Returns the index of the first occurrence of the specified element in
      *this list, or -1 if this list does not contain the element.
      *@param   object
      *@return  index
      */
    public int indexOf(T o) {
        for (int i = 0; i <= size(); i++) {
            if (arraywrapper[i] == o) {
                return (i);
            }
        }
        return (-1);
    }

    /**
     * Tests if the collection is empty, i.e. it contains no elements.
     *
     * @return true if the collection has no elements, false otherwise.
     */
    public boolean isEmpty() {
        if (arraywrapper[0] == null) {
            return (true);
        }
        return (false);
    }

    /**
     * Adds all elements in elems to the collection.
     * Hint: can this be implemented in terms of add(T elem)?
     *
     * @param elems Array of elements to be added.
     */
    public void addAll(T[] elems) {
        for (int i = 0; i < elems.length; i++) {
            add(elems[i]);
        }
    }

    /**
     * Remove elem from the collection. Removing an element
     * should shift all the elements behind it forward, ensuring
     * that the backing array is contiguous. For example:
     *
     * Collection = ["hi", "hello", "wsup", "hey", null]
     * Collection after remove("hello") = ["hi", "wsup", "hey", null, null]
     *
     * @param elem Element to be removed.
     * @return true if the element was removed,
     *         false if it was not in the collection.
     */
    public boolean remove(T elem) {
        if (contains(elem)) {
            int i = indexOf(elem);
            for (i = indexOf(elem); i < size() - 1; i++) {
                arraywrapper[i] = arraywrapper[i + 1];
            }
            arraywrapper[size() - 1] = null;
            return true;
        }
        return false;
    }

    /**
     * Removes each element in elems from the collection.
     * Hint: can this be implemented in terms of remove(T elem)?
     *
     * @param elems Array of elements to be removed.
     * @return true if any elements were removed,
     *         false if no elements were removed.
     */
    public boolean removeAll(T[] elems) {
        boolean test;
        boolean fin = false;
        for (int i = 0; i < elems.length; i++) {
            test = remove(elems[i]);
            if (test) {
                fin = true;
            }
        }
        return fin;
    }

    /**
     * Returns the current number of elements in the collection.
     *
     * @return The size of the collection.
     */
    public int size() {
        int j = 0;
        for (int i = 0; i < capacity(); i++) {
            if (arraywrapper[i] != null) {
                j++;
            }
        }
        return (j);
    }

    /**
     * Returns the current capacity of the collection - namely, the
     * size of its backing array.
     *
     * @return The total capacity of the collection.
     */
    public int capacity() {
        return (arraywrapper.length);
    }

    /**
     * While having toString be defined in the interface doesn't force you
     * to override the method in the implementing class, the format we
     * expect the toString() is as follows:
     *
     * [element1, element2, element3, ..., elementN]
     *
     * The end of the list should not contain any nulls, even if the
     * backing array is larger than the number of elements.
     *
     * @return [element1, element2, element3, ..., elementN]
     */
    public String toString() {
        String holding = "[";
        for (int i = 0; i < size(); i++) {
            holding += arraywrapper[i] + ", ";
        }
        holding = holding.substring(0, holding.length() - 2);
        holding += "]";
        return (holding);
    }

}
