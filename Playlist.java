package dailymixes;
// -------------------------------------------------------------------------
/**
 *  Represents a playlist
 * 
 *  @author jasminevarma23
 *  @version April 7, 2024
 */
public class Playlist implements Comparable<Playlist>
{

    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;
    // ----------------------------------------------------------
    /**
     * Create a new Playlist object.
     * @param playlistName 
     * @param minPop 
     * @param minRock 
     * @param minCountry 
     * @param maxPop 
     * @param maxRock 
     * @param maxCountry 
     * @param playlistCap 
     */
    public Playlist(String playlistName,  int  minPop,  int  minRock,  
        int  minCountry, int maxPop, int maxRock, int maxCountry,  int 
        playlistCap)
    {
        minGenreSet = new GenreSet(minPop, minRock, minCountry);
        maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        capacity = playlistCap;
        songs = new Song[capacity];
        numberOfSongs = 0;
        name = playlistName;
    }

    /**
     * getter for min genre set
     * @return minimum genre set
     */
    public GenreSet getMinGenreSet()
    {
        return this.minGenreSet;
    }

    /**
     * getter for max genre set
     * @return max genre set
     */
    public GenreSet getMaxGenreSet()
    {
        return this.maxGenreSet;
    }

    /**
     * sets name of playlist
     * @param n param
     */
    public void setName(String n)
    {
        this.name = n;
    }

    /**
     * gets the number of spaces left in the playlist
     * @return an int value
     */
    public int getSpacesLeft() 
    {
        return capacity - numberOfSongs;
    }

    /**
     * gets number of songs
     * @return the num of songs
     */
    public int getNumberOfSongs()
    {
        return this.numberOfSongs;
    }


    /**
     * get the songs
     * @return songs
     */
    public Song[] getSongs()
    {
        return this.songs;
    }

    /**
     * get capacity
     * @return the capacity
     */
    public int getCapacity()
    {
        return this.capacity;
    }

    /**
     * return whether song is qualified for song
     * @param song song
     * @return true or false
     */
    public boolean isQualified(Song song)
    {
        return song.getGenreSet().isWithinRange(minGenreSet, maxGenreSet);
    }

    /**
     * get name
     * @return name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * true or false if playlist is full or not
     * @return a boolean value
     */
    public boolean isFull() 
    {
        return numberOfSongs == capacity;
    }

    /**
     * adds a song to playlist and returns if successful
     * @param newSong new song value to add
     * @return a boolean value
     */
    public boolean addSong(Song newSong)
    {
        if (isFull() || !isQualified(newSong))
        {
            return false;
        }
        songs[numberOfSongs++] = newSong;
        return true;
    }

    /**
     * to string method
     * @return a string
     */
    public String toString()
    {
        StringBuilder playlistInfo = new StringBuilder();
        playlistInfo.append("Playlist: ").append(name)
        .append(", # of songs: ").append(numberOfSongs)
        .append(" (cap: ").append(capacity).append("), Requires: ")
        .append("Pop:").append(minGenreSet.getPop()).append("%-")
        .append(maxGenreSet.getPop()).append("%, ")
        .append("Rock:").append(minGenreSet.getRock()).append("%-")
        .append(maxGenreSet.getRock()).append("%, ")
        .append("Country:").append(minGenreSet.getCountry())
        .append("%-").append(maxGenreSet.getCountry()).append("%");
        return playlistInfo.toString();
    }

    /**
     * equals method
     * @param obj other object
     * @return true or false
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        Playlist other = (Playlist)obj;
        for (int i = 0; i < numberOfSongs; i++)
        {
            if (!songs[i].equals(other.getSongs()[i]))
            {
                return false;
            }
        }
        return name.equals(other.getName())
            && maxGenreSet.equals(other.getMaxGenreSet())
            && minGenreSet.equals(other.getMinGenreSet())
            && capacity == other.getCapacity()
            && numberOfSongs == other.getNumberOfSongs();
    }


    /**
     * compares two playlists
     * @param other the other variable
     * @return the difference in variables
     */
    @Override
    public int compareTo(Playlist other) 
    {
        int capacityComparison = Integer.compare(this.capacity, other.capacity);
        if (capacityComparison != 0)
        {
            return capacityComparison;
        }

        int spacesLeftComparison =
            Integer.compare(this.getSpacesLeft(), other.getSpacesLeft());
        if (spacesLeftComparison != 0)
        {
            return spacesLeftComparison;
        }

        int minGenreSetComparison =
            this.minGenreSet.compareTo(other.getMinGenreSet());
        if (minGenreSetComparison != 0)
        {
            return minGenreSetComparison;
        }

        int maxGenreSetComparison =
            this.maxGenreSet.compareTo(other.getMaxGenreSet());
        if (maxGenreSetComparison != 0)
        {
            return maxGenreSetComparison;
        }

        // If all other attributes are equal, compare based on the name
        return this.name.compareTo(other.name);
    }

}
