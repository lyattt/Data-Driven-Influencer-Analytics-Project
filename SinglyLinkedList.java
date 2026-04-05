// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- May Vo (akamay219)

// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.
package prj5;

import java.util.Iterator;
import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Custom singly-linked list used for Project 5. Supports add, remove, get,
 * iterator, and insertionSort with Comparator.
 *
 * @param <T>
 *            the type stored in the list
 * @author May Vo (akamay219)
 * @version Nov 18, 2025
 */
public class SinglyLinkedList<T>
    implements Iterable<T>
{
    private Node<T> head;
    private int size;
    /**
     * Creates an empty linked list.
     */
    public SinglyLinkedList()
    {
        head = null;
        size = 0;
    }


    /**
     * Adds an element to the END of the list.
     *
     * @param item
     *            the element to add
     */
    public void add(T item)
    {
        Node<T> newNode = new Node<>(item);

        if (head == null)
        {
            head = newNode;
        }
        else
        {
            Node<T> curr = head;
            while (curr.next != null)
            {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    /**
     * Removes the first occurrence of the specified item from the list.
     *
     * @param item
     *            the element to remove
     * @return true if the item was found and removed; false otherwise
     */
    public boolean remove(T item)
    {
        if (head == null)
        {
            return false;
        }

        if (head.data.equals(item))
        {
            head = head.next;
            size--;
            return true;
        }

        Node<T> curr = head;
        while (curr.next != null)
        {
            if (curr.next.data.equals(item))
            {
                curr.next = curr.next.next;
                size--;
                return true;
            }
            curr = curr.next;
        }

        return false;
    }


    /**
     * Returns the element at index.
     *
     * @param index
     *            location
     * @return the data stored
     */
    public T get(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }

        Node<T> curr = head;
        for (int i = 0; i < index; i++)
        {
            curr = curr.next;
        }
        return curr.data;
    }


    /**
     * Gets the number of elements stored in the list.
     *
     * @return The list size.
     */
    public int size()
    {
        return size;
    }


    /**
     * Performs insertion sort on the list using the given comparator.
     *
     * @param cmp
     *            comparator to define ordering
     */
    public void insertionSort(Comparator<T> cmp)
    {

        if (head == null || head.next == null)
        {
            return;
        }

        Node<T> sorted = null;
        Node<T> current = head;

        while (current != null)
        {
            Node<T> next = current.next;

            sorted = insertIntoSorted(sorted, current, cmp);

            current = next;
        }

        head = sorted;
    }


    /**
     * Helper: inserts a node into a sorted chain.
     */
    private
        Node<T>
        insertIntoSorted(Node<T> sorted, Node<T> newNode, Comparator<T> cmp)
    {

        newNode.next = null;

        if (sorted == null || cmp.compare(newNode.data, sorted.data) < 0)
        {
            newNode.next = sorted;
            return newNode;
        }

        Node<T> curr = sorted;
        while (curr.next != null
            && cmp.compare(newNode.data, curr.next.data) >= 0)
        {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        return sorted;
    }


    /**
     * Returns an iterator over the elements in the list from head to tail.
     *
     * @return An iterator for this linked list.
     */
    @Override
    public Iterator<T> iterator()
    {

        return new Iterator<T>() {

            private Node<T> curr = head;

            @Override
            public boolean hasNext()
            {
                return curr != null;
            }


            @Override
            public T next()
            {
                T result = curr.data;
                curr = curr.next;
                return result;
            }
        };
    }
}
