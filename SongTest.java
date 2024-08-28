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
 *  Test cases for Song
 * 
 *  @author jasminevarma23
 *  @version April 2, 2024
 */
public class SongTest extends TestCase
{
    private GenreSet genreSet;
    private Song song;
    /**
     * setUp Method
     */
    public void setUp()
    {
        genreSet = new GenreSet(10, 20, 30);
        song = new Song("x", 10, 20, 30, "y");

    }

    /**
     * test case for getters
     */
    public void testGetters()
    {
        assertEquals("x", song.getName());
        assertEquals("y", song.getPlaylistName());
        assertEquals(genreSet, song.getGenreSet());
    }

    /**
     * test case for equals
     */
    public void testEquals()
    {

        Song song2 = new Song("x", 10, 20, 30, "y");
        Song song3 = new Song("x", 20, 30, 40, "y");
        Song song4 = new Song("a", 10, 20, 30, "y");
        Song song5 = new Song("x", 5, 6, 7, "y");
        Song song6 = new Song("x", 10, 20, 30, "z");


        assertTrue(song.equals(song2));
        assertFalse(song.equals(song3));
        assertFalse(song.equals(song4));
        assertFalse(song.equals(song5));
        assertFalse(song.equals(song6));
    }

    /**
     * test case for toString
     */
    public void testToString()
    {
        assertEquals("x Pop:10 Rock:20 Country:30 Suggested: y", 
            song.toString());

        Song noPL = new Song("z", 10, 20, 30, "");
        assertEquals("No-Playlist z Pop:10 Rock:20 Country:30", 
            noPL.toString());
    }


}
