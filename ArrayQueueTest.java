package dailymixes;
import queue.EmptyQueueException;
import student.TestCase;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Jasmine Varma (jasminevarma23)
// -------------------------------------------------------------------------
/**
 *  Test cases for ArrayQueue
 *  @author jasminevarma23
 *  @version April 2, 2024
 */
public class ArrayQueueTest extends TestCase
{
    private ArrayQueue<String> queue;

    /**
     * setup method
     */
    public void setUp() 
    {
        queue = new ArrayQueue<>();
    }

    /**
     * tests enqeue, dequeue and getFront
     */
    public void testEnqueueDequeue() 
    {
        assertTrue(queue.isEmpty());
        Exception exception = null;
        try
        {
            queue.dequeue();
            fail("dequeue() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("dequeue() is throwing the wrong type of exceptions",
            exception instanceof EmptyQueueException);


        queue.enqueue("A");
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.getSize());
        assertEquals(21, queue.getLengthOfUnderlyingArray());

        assertEquals("A", queue.getFront());

        queue.enqueue("B");
        assertEquals(2, queue.getSize());
        assertEquals("A", queue.getFront());

        assertEquals("A", queue.dequeue());
        assertEquals(1, queue.getSize());
        assertEquals("B", queue.getFront());

        assertEquals("B", queue.dequeue());
        assertTrue(queue.isEmpty());
        
        for (int i = 0; i < 20; i++)
        {
            queue.enqueue("A");
        }
        queue.enqueue("B");
        String copy = queue.toString();
        String expected = "[A, A, A, A, A, A, A, A, A, A, A, A, A, A, A,"
            + " A, A, A, A, A, B]";
        
        assertEquals(copy, expected);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("C");
        String copy2 = queue.toString();
        String expected2 = "[A, A, A, A, A, A, A, A, A, A, A, A, A,"
            + " A, A, A, A, A, B, C]";
        assertEquals(copy2, expected2) ;
        ArrayQueue<String> three = new ArrayQueue<String>(3);
        three.enqueue("A");
        three.enqueue("B");
        three.enqueue("C");
        three.dequeue();
        assertEquals(three.toString(), "[B, C]");
        three.enqueue("A");
        three.enqueue("D");
        assertEquals(three.toString(), "[B, C, A, D]");

    }

    /**
     * tests get size
     */
    public void testSize() 
    {
        assertEquals(0, queue.getSize());

        queue.enqueue("A");
        assertEquals(1, queue.getSize());

        queue.dequeue();
        assertEquals(0, queue.getSize());
    }

    /**
     * test for is empty
     */
    public void testIsEmpty() 
    {
        assertTrue(queue.isEmpty());

        queue.enqueue("A");
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    /**
     * test for is clear
     */
    public void testClear() 
    {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.clear();

        assertTrue(queue.isEmpty());
    }

    /**
     * test to array
     */
    public void testToArray() 
    {
        Exception exception = null;
        try
        {
            queue.toArray();
            fail("toArray() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("toArray() is throwing the wrong type of exceptions",
            exception instanceof EmptyQueueException);

        queue.enqueue("A");
        queue.enqueue("B");

        Object[] array = queue.toArray();
        assertEquals("A", array[0]);
        assertEquals("B", array[1]);
    }

    /**
     * test to string
     */
    public void testToString() 
    {
        assertEquals("[]", queue.toString());

        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals("[A, B]", queue.toString());
    }

    /**
     * test equals
     */
    public void testEquals() 
    {
        ArrayQueue<String> otherQueue = new ArrayQueue<>();
        queue.enqueue("A");
       // assertFalse(queue.equals(otherQueue));
        otherQueue.enqueue("A");
        assertTrue(queue.equals(otherQueue));

        otherQueue.enqueue("B");
        assertFalse(queue.equals(otherQueue));

        queue.dequeue();
        queue.enqueue("B");
        queue.enqueue("A");
        assertFalse(queue.equals(otherQueue));
        
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(queue, otherQueue);



    }
}
