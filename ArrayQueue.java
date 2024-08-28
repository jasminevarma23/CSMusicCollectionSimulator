package dailymixes;
import queue.EmptyQueueException;
import queue.QueueInterface;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who 
//do.
//-- Jasmine Varma (jasminevarma23)
// -------------------------------------------------------------------------
/**
 *  Implementation of ArrayQueue interface
 * 
 *  @author jasminevarma23
 *  @version April 2, 2024
 *  @param <T> 
 */
public class ArrayQueue<T> implements QueueInterface<T> 
{

    /**
     * default capacity constant
     */
    public static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int dequeueIndex;
    private int size;
    private int enqueueIndex;

    /**
     * constructor
     */
    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * constructor
     * @param cap passes in capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int cap)
    {
        queue = (T[]) new Object[cap];
        this.dequeueIndex = 0;
        this.enqueueIndex = 0;
        this.size = 0;
    }


    //~ Fields ................................................................

    /**
     * getter for size field
     * @return an int for size
     */
    public int getSize()
    {
        return this.size;
    }
    /**
     * get length of the underlying array
     * @return the length as an int
     */
    public int getLengthOfUnderlyingArray() 
    {
        return queue.length + 1;
    }


    /**
     * ensure capacity method
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity()
    {
        if (size >= queue.length)
        {
            int newSize = 2 * queue.length;
            T[] newQ = (T[]) new Object[newSize];

            for (int i = 0; i < size; i++)
            {
                newQ[i] = queue[(dequeueIndex + i) % queue.length];
            }

            queue = newQ;
            dequeueIndex = 0;
            enqueueIndex = size;
        }
    }

    /**
     * increments the index of the queue
     * @param index the indext to increment
     * @return an int of the incrementation
     */
    private int incrementIndex(int index)
    {
        return (index + 1) % queue.length;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < size; i++)
        {
            queue[(dequeueIndex + i) % queue.length] = null;
        }
        this.dequeueIndex = 0;
        this.enqueueIndex = 0;
        this.size = 0;
    }
    /**
     * to array method, converts to array
     * @return a object array
     */
    public Object[] toArray()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException("Queue is empty");
        }
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) 
        {
            array[i] = queue[(dequeueIndex + i) % queue.length];
        }
        return array;
    }

    /**
     * toString
     * @return a string
     */
    @Override
    public String toString()
    {

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) 
        {
            sb.append(queue[(dequeueIndex + i) % queue.length]);
            if (i < size - 1) 
            {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * equals method
     * @param obj to compare
     * @return true or false
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass())
        {
            return false;
        }
        @SuppressWarnings("unchecked")
        ArrayQueue<T> other = (ArrayQueue<T>)obj;
        if (this.size != other.size)
        {
            return false;
        }
        for (int i = 0; i < this.size; i++)
        {
            if (!this.queue[(this.dequeueIndex + i) % this.queue.length].equals(
                other.queue[(other.dequeueIndex + i) % other.queue.length]))
            {
                return false;
            }
        }
        return true;
    }


    /**
     * dequeue method
     * @return the value that is dequeued
     */
    @Override
    public T dequeue()
    {
        if (isEmpty()) 
        {
            throw new EmptyQueueException("Queue is empty");
        }
        T front = queue[dequeueIndex];
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return front;
    }

    /**
     * enqueue method
     * @param entry is the value to add to the queue
     */
    @Override
    public void enqueue(T entry)
    {

        ensureCapacity();
        queue[enqueueIndex] = entry;

        enqueueIndex = incrementIndex(enqueueIndex);
        size++;

    }

    /**
     * gets the front of the queue
     * @return the front most value of the queue
     */
    @Override
    public T getFront()
    {
        if (isEmpty()) 
        {
            throw new EmptyQueueException("Queue is empty");
        }
        return queue[dequeueIndex];

    }

    /**
     * checks if queue is empty
     * @return true or false
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

}
