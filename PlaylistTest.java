package dailymixes;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test class for playlist 
 * 
 *  @author jasminevarma23
 *  @version April 9, 2024
 */
public class PlaylistTest extends TestCase
{
    private Playlist list;
    private GenreSet min;
    private GenreSet max;
    private Song song1;
    private Song song2;
    private Song song3;
    private Song[] songs;

    /**
     * setup
     */
    public void setUp()
    {
        list = new Playlist("MySongs", 10, 10, 10, 50, 50, 50, 3);
        min = new GenreSet(10, 10, 10);
        max = new GenreSet(50, 50, 50);
        song1 = new Song("a", 12, 24, 36, "country");
        song2 = new Song("b", 10, 20, 30, "pop");
        song3 = new Song("c", 15, 30, 45, "rock");
        list.addSong(song1);
        list.addSong(song2);
        list.addSong(song3);
        songs = new Song[3];
        songs[0] = song1;
        songs[1] = song2;
        songs[2] = song3;

    }
    
    /**
     * test getters
     */
    public void testGetters()
    {
        assertEquals(list.getMinGenreSet(), min);
        assertEquals(list.getMaxGenreSet(), max);
        assertEquals(list.getName(), "MySongs");
        assertEquals(list.getSpacesLeft(), 0);
        assertEquals(list.getNumberOfSongs(), 3);
        assertEquals(list.getSongs()[0], songs[0]);
        assertEquals(list.getSongs()[1], songs[1]);
        assertEquals(list.getSongs()[2], songs[2]);
        assertEquals(list.getCapacity(), 3);
    }
    
    /**
     * test three small methods
     */
    public void testisQualifiedAndisFull()
    {
        assertTrue(list.isQualified(song1));
        assertTrue(list.isFull());
        Playlist newList =  new Playlist("MySongs", 10, 10, 10, 50, 50, 50, 3);
        newList.addSong(song1);
        assertFalse(newList.isFull());
        assertTrue(newList.addSong(song2));
    }
    
    /**
     * test tostring
     */
    public void testToString()
    {
        assertEquals(list.toString(), "Playlist: MySongs, # of songs: "
            + "3 (cap: 3), Requires: Pop:10%-50%, Rock:10%-50%, "
            + "Country:10%-50%");
    }
    
    /**
     * test equals
     */
    public void testEquals() 
    {
        Playlist  playlist = 
            new Playlist("MySongs", 10, 10, 10, 50, 50, 50, 3);
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);
        assertTrue(list.equals(playlist));
        
       
        assertFalse(playlist.equals(null));
        assertFalse(playlist.equals("Not a Playlist"));
        
        Playlist playlist2 =  
            new Playlist("Playlist", 10, 10, 10, 50, 50, 50, 3);
       
        assertFalse(playlist.equals(playlist2));
        
        Playlist playlist3 =  
            new Playlist("MySongs", 11, 11, 11, 50, 50, 50, 3);
        assertFalse(playlist.equals(playlist3));

        Playlist playlist4 =  
            new Playlist("MySongs", 11, 11, 11, 55, 55, 55, 3);
        assertFalse(playlist.equals(playlist4));
        
        Playlist playlist5 =  
            new Playlist("MySongs", 10, 10, 10, 55, 55, 55, 3);
        assertFalse(playlist.equals(playlist5));
        
        Playlist playlist6 =  
            new Playlist("Songs", 11, 11, 11, 55, 55, 55, 3);
        assertFalse(playlist.equals(playlist6));
        
        Playlist playlist7 =  
            new Playlist("Songs", 11, 11, 11, 55, 55, 55, 4);
        assertFalse(playlist.equals(playlist7));
    }
    
    /**
     * test compare to
     */
    public void testCompareTo()
    {
        assertEquals(list, list);
        Playlist  playlist = 
            new Playlist("MySongs", 10, 10, 10, 50, 50, 50, 4);
        assertEquals(list.compareTo(playlist), -1);
        
        Playlist  playlist1 = 
            new Playlist("MySongs", 10, 10, 10, 50, 50, 50, 3);
        playlist1.addSong(song1);
        playlist1.addSong(song2);
        assertEquals(list.compareTo(playlist1), -1);
        
        Playlist  playlist2 = 
            new Playlist("MySongs", 11, 11, 11, 50, 50, 50, 3);
        assertEquals(list.compareTo(playlist2), -1);
        
        Playlist  playlist3 = 
            new Playlist("MySongs", 10, 10, 10, 51, 51, 51, 3);
        assertEquals(list.compareTo(playlist3), -1);
        
        Playlist  playlist4 = 
            new Playlist("Songs", 10, 10, 10, 50, 50, 50, 3);
        assertEquals(list.compareTo(playlist4), -1);
    }
    
}
