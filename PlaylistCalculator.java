package dailymixes;

import java.util.Arrays;
import list.AList;

// -------------------------------------------------------------------------
/**
 *  Handles the accept and addSongToPlaylist logic as well as the reject 
 *  song logic, and it contains the queue of songs and the Playlist objects.   
 * 
 *  @author jasminevarma23
 *  @version April 7, 2024
 */
public class PlaylistCalculator
{
    private Playlist[] playlists;
    /**
     * num playlists
     */
    public static final int NUM_PLAYLISTS = 3;
    /**
     * min percent
     */
    public static final int MIN_PERCENT = 0;
    /**
     * max percent
     */
    public static final int MAX_PERCENT = 100;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;


    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     * @param queue queue
     * @param lists lists
     */
    public PlaylistCalculator(ArrayQueue<Song> queue, Playlist[] lists)
    {
        if (queue == null)
        {
            throw new IllegalArgumentException();
        }
        playlists = lists;
        songQueue = queue;
        rejectedTracks = new AList<Song>();
    }
    /**
     * @param aSong to add to playlist
     * @return a playlist
     */
    private Playlist getPlaylistWithMaximumCapacity(Song aSong)
    {
        Playlist[] sortedPlaylists = Arrays.copyOf(playlists, playlists.length);
        Arrays.sort(sortedPlaylists);
        for (int i = sortedPlaylists.length - 1; i >= 0; i--) 
        {
            if (!sortedPlaylists[i].isFull()
                && canAccept(sortedPlaylists[i], aSong)) 
            {
                return sortedPlaylists[i];
            }
        }
        return null; 
    }

    /**
     * gets a playlist for song
     * @param nextSong to add to playlist
     * @return a playlist for song
     */
    public Playlist getPlaylistForSong(Song nextSong)
    {
        if (nextSong != null)
        {
            String suggestedPlaylistName = nextSong.getPlaylistName();

            if (suggestedPlaylistName == null || suggestedPlaylistName
                .equals("")
                || getPlaylistIndex(suggestedPlaylistName) == -1)
            {
                return getPlaylistWithMaximumCapacity(nextSong);
            }

            for (Playlist playlist : playlists)
            {
                if (playlist.getName().equals(nextSong.getPlaylistName())
                    && canAccept(playlist, nextSong))
                {
                    return playlist;
                }
            }
        }


        return null;
    }



    private boolean canAccept(Playlist playlist, Song song)
    {
        return song.getGenreSet().isWithinRange(
            playlist.getMinGenreSet(),
            playlist.getMaxGenreSet());
    }

    /**
     * adds a new song
     * @return if added or not
     */
    public boolean addSongToPlaylist() 
    {
        if (!songQueue.isEmpty())
        {
            Song nextSong = songQueue.getFront();

            Playlist targetPlaylist = getPlaylistForSong(nextSong);

            if (targetPlaylist != null)
            {
                targetPlaylist.addSong(nextSong);
                songQueue.dequeue();
                return true;
            }
        }
        return false;
    }

    /**
     * reject the song  
     */
    public void reject()  
    {

        rejectedTracks.add(songQueue.dequeue());

    }

    /**
     * gets the index of the playlist
     * @param playlist 
     * @return the index
     */
    public int getPlaylistIndex(String playlist) 
    {
        for (int i = 0; i < playlists.length; i++) 
        {
            if (playlists[i].getName().equals(playlist)) {
                return i;
            }
        }
        return -1;

    }

    /**
     * returns the queue
     * @return the queue
     */
    public ArrayQueue<Song> getQueue()  
    {
        return this.songQueue;
    }

    /**
     * gets the playlist
     * @return the playlist
     */
    public Playlist[] getPlaylists()  
    {
        return this.playlists;
    }

}
