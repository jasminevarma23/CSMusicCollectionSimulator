package dailymixes;

import student.TestCase;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Jasmine Varma (jasminevarma23)
// -------------------------------------------------------------------------
/**
 *  Test cases for GenreSet class
 * 
 *  @author jasminevarma23
 *  @version April 2, 2024
 */
public class GenreSetTest extends TestCase
{
    private GenreSet genreSet;
    
    /** setUp method
     */
    public void setUp()
    {
        genreSet = new GenreSet(10, 20, 30);
    }

    /**
     * test case for within range method
     */
    public void testIsWithinRange()
    {
        GenreSet minGenreSet = new GenreSet(5, 10, 15);
        GenreSet maxGenreSet = new GenreSet(15, 30, 45);

        GenreSet setInRange = new GenreSet(7, 12, 20);
        assertTrue(setInRange.isWithinRange(minGenreSet, maxGenreSet));

        GenreSet setOutOfRange = new GenreSet(17, 32, 50);
        assertFalse(setOutOfRange.isWithinRange(minGenreSet, maxGenreSet));
    }

    /**
     * test case for equals method
     */
    public void testEquals()
    {
        GenreSet genreSet1 = new GenreSet(10, 20, 30);
        GenreSet genreSet2 = new GenreSet(15, 25, 35);
        GenreSet genreSet3 = new GenreSet(10, 25, 35);
        GenreSet genreSet4 = new GenreSet(15, 20, 35);
        GenreSet genreSet5 = new GenreSet(15, 20, 30);

        assertTrue(genreSet.equals(genreSet1));
        assertFalse(genreSet.equals(genreSet2));
        assertFalse(genreSet.equals(genreSet3));
        assertFalse(genreSet.equals(genreSet4));
        assertFalse(genreSet.equals(genreSet5));
    }

    /**
     * test case for compare to method
     */
    public void testCompareTo()
    {
        GenreSet genreSet2 = new GenreSet(15, 25, 35);
        GenreSet genreSet3 = new GenreSet(5, 15, 25);

        assertTrue(genreSet.compareTo(genreSet2) < 0); 
        assertTrue(genreSet2.compareTo(genreSet3) > 0); 
        assertEquals(0, genreSet.compareTo(genreSet)); 
    }

    /**
     * test cases for getters
     */
    public void testGetters()
    {
        assertEquals(10, genreSet.getPop());
        assertEquals(20, genreSet.getRock());
        assertEquals(30, genreSet.getCountry());
    }

    /**
     * test case for tostring
     */
    public void testToString()
    {
        assertEquals("Pop:10 Rock:20 Country:30", genreSet.toString());
    }
}
