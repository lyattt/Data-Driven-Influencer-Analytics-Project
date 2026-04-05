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

// -------------------------------------------------------------------------
/**
 * A singly-linked node storing generic data. Used by the custom LinkedList
 * implementation required for Project 5.
 *
 * @param <T>
 *            The type of the data stored in this node
 * @author May Vo (akamay219)
 * @version Nov 18, 2025
 */
public class Node<T>
{
    /**
     * The data stored in this node.
     */
    public T data;
    /**
     * Reference to the next node in the list.
     */
    public Node<T> next;

    // ----------------------------------------------------------
    /**
     * Creates a new node containing the specified data.
     *
     * @param data
     *            data to store in this node
     */
    public Node(T data)
    {
        this.data = data;
        this.next = null;
    }
}
