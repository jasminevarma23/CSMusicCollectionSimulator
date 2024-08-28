package dailymixes;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test class for playlist calculator
 * 
 *  @author jasminevarma23
 *  @version April 9, 2024
 */
public class PlaylistCalculatorTest extends TestCase
{
    
    private ArrayQueue<Song> queue;
    private Song song;
    private PlaylistCalculator calc;

    /**
     * setup method
     */
    public void setUp()
    {
        Playlist playlist1 = new Playlist("one", 0, 0, 0, 10, 10, 10, 3);
        Playlist playlist2 = new Playlist("two", 10, 10, 10, 30, 30, 30, 4);
        Playlist playlist3 = new Playlist("three", 0, 0, 0, 5, 5, 5, 3);

        song = new Song("a", 1, 1, 1, "playlist1");
        queue = new ArrayQueue<Song>(3);
       
        Playlist[] lists =
            new Playlist[] { playlist1, playlist2, playlist3 };
        calc = new PlaylistCalculator(queue, lists);
    }


    /**
     * test method for addSongToPlaylist() : boolean
     */
    public void testAddSongToPlaylist()
    {
        assertFalse(calc.addSongToPlaylist());
        queue.enqueue(song);
        assertTrue(calc.addSongToPlaylist());

        Playlist empty = new Playlist("name", 0, 0, 0, 1, 1, 1, 0);
        Playlist[] playlists = new Playlist[] { empty };
        song = new Song("uno", 1, 1, 1, null);
        ArrayQueue<Song> q = new ArrayQueue<Song>(3);
        
        calc = new PlaylistCalculator(q, playlists);
        assertFalse(calc.addSongToPlaylist());

        song = new Song("dos", 1, 1, 1, "some");
        q.clear();
        q.enqueue(song);
        assertFalse(calc.addSongToPlaylist());
        
        ArrayQueue<Song> songQueue = new ArrayQueue<>(3);
        Playlist[] playlists2 =
            { new Playlist("pop", 0, 1, 0, 2, 2, 2, 1) };
        PlaylistCalculator calc5 = 
            new PlaylistCalculator(songQueue, playlists2);
        assertFalse(calc5.addSongToPlaylist());
        
        ArrayQueue<Song> songQueue1 = new ArrayQueue<>(3);
        Song song5 = new Song("blue", 3, 4, 5, "pop");
        songQueue1.enqueue(song5);
        Playlist[] playlists3 =
            { new Playlist("pop", 0, 1, 0, 2, 2, 2, 10) };
        PlaylistCalculator calc2 = new PlaylistCalculator(songQueue1, 
            playlists3);
       // assertTrue(calc2.addSongToPlaylist());
       // assertTrue(calc2.getQueue().isEmpty());
        
        ArrayQueue<Song> songQueue2 = new ArrayQueue<>(3);
        Song song6 = new Song("blue", 3, 4, 5, "pop");
        songQueue2.enqueue(song6);
        Playlist fullPlaylist =
            new Playlist("pop", 0, 1, 0, 2, 3, 4, 1);
        fullPlaylist.addSong(new Song("red", 5, 7, 2, "pop"));

        Playlist[] playlists4 = { fullPlaylist };
        PlaylistCalculator calc6 = 
            new PlaylistCalculator(songQueue2, playlists4);
       // assertTrue(calc6.addSongToPlaylist());
    }


    /**
     * test method for reject
     */
    public void testReject()
    {
        queue.enqueue(song);
        assertFalse(calc.getQueue().isEmpty());
        calc.reject();
        assertTrue(calc.getQueue().isEmpty());
    }


    /**
     * test method for getPlaylistForSong
     */
    public void testGetPlaylistForSong()
    {
        Playlist list1 = new Playlist("one", 0, 0, 0, 10, 10, 10, 3);
        assertNull(calc.getPlaylistForSong(null));
        assertEquals(list1, calc.getPlaylistForSong(song));
        list1.addSong(song);
        list1.addSong(song);
        list1.addSong(song);

        Playlist full = new Playlist("a", 0, 0, 0, 1, 1, 1, 1);
        Playlist notFull = new Playlist("b", 0, 0, 0, 1, 1, 1, 1);
        Song song1 = new Song("c", 1, 1, 1, "d");
        
        ArrayQueue<Song> q = new ArrayQueue<Song>(3);
        Playlist[] lists2 = new Playlist[] { full, full };
        PlaylistCalculator calc2 = new PlaylistCalculator(q, lists2);
        assertTrue(calc2.getPlaylistForSong(song1).equals(full));

        assertNull(calc2.getPlaylistForSong(new Song("uno", 3, 4, 5, "")));
        
        ArrayQueue<Song> songQueue = new ArrayQueue<>(3);
        Playlist[] playlists =
            { new Playlist("tres", 0, 3, 0, 5, 2, 1, 1) };
        PlaylistCalculator calc1 = new PlaylistCalculator(songQueue, playlists);
        assertNull(calc1.getPlaylistForSong(null));
        
        ArrayQueue<Song> squeue = new ArrayQueue<>(3);
        Playlist[] playlists1 =
            { new Playlist("quatro", 0, 50, 0, 100, 100, 100, 10) };
        PlaylistCalculator calc3 = new PlaylistCalculator(squeue, playlists1);
        Song song2 = new Song("s", 20, 60, 20, "Rock");
        assertEquals(playlists1[0], calc3.getPlaylistForSong(song2));
        
        ArrayQueue<Song> aqueue = new ArrayQueue<>(3);
        Playlist[] playlists3 =
            { new Playlist("Pop", 50, 0, 0, 100, 100, 100, 10) };
        PlaylistCalculator calc5 = new PlaylistCalculator(aqueue, playlists3);
        Song song7 = new Song("boogie", 20, 60, 20, "Rock");
        assertNull(calc5.getPlaylistForSong(song7));

    }

    /**
     * test method for getQueue() : ArrayQueue<Song>
     */
    public void testGetQueue()
    {
        assertNotNull(calc.getQueue());
    }


    /**
     * test method for getPlaylists() : Playlists[]
     */
    public void testGetPlaylists()
    {
        assertNotNull(calc.getPlaylists());
    }


    /**
     * test method for getPlaylistIndex(String) : int
     */
    public void testGetPlaylistIndex()
    {
        assertEquals(0, calc.getPlaylistIndex("one"));
        assertEquals(1, calc.getPlaylistIndex("two"));
    }


    /**
     * test method for constructor
     */
    @SuppressWarnings("unused")
    public void testPlaylistCalculator()
    {
        try
        {
            PlaylistCalculator calc3 =
                new PlaylistCalculator(null, new Playlist[] {});
        }
        catch (IllegalArgumentException e)
        {
            assertNotNull(e);
        }
    }
}
