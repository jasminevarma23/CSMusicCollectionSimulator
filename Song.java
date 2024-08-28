package dailymixes;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Jasmine Varma (jasminevarma23)
// -------------------------------------------------------------------------
/**
 *  Creates a song object to add to playlists 
 * 
 *  @author jasminevarma23
 *  @version April 2, 2024
 */
public class Song
{
    private String name;
    private String suggestedPlaylist;
    private GenreSet genreSet;

    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     * @param name name
     * @param pop pop
     * @param rock rock
     * @param country c
     * @param suggested s
     */
    public Song(String name, int pop, int rock, int country, String suggested)
    {
        this.genreSet = new GenreSet(pop, rock, country);
        this.name = name;
        this.suggestedPlaylist = suggested;
    }

    /**
     * get playlist name
     * @return the name of the playlist
     */
    public String getPlaylistName() 
    {
        return this.suggestedPlaylist;
    }

    /**
     * tostring method
     * @return the string
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        if (this.suggestedPlaylist == null || suggestedPlaylist.isEmpty())
        {
            sb.append("No-Playlist ");
        }

       
        sb.append(name);
        sb.append(" Pop:").append(genreSet.getPop());
        sb.append(" Rock:").append(genreSet.getRock());
        sb.append(" Country:").append(genreSet.getCountry());

        if (suggestedPlaylist.length() > 0) 
        {
            sb.append(" Suggested: ").append(suggestedPlaylist);
        } 
        

        return sb.toString();
    }

    /**
     * get name of song
     * @return name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * get genre set
     * @return genreset
     */
    public GenreSet getGenreSet()
    {
        return this.genreSet;
    }

    /**
     * equals method
     * @param obj the comparison object
     * @return true or false
     */
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
        Song otherSong = (Song)obj;
        return this.name.equals(otherSong.name)
            && this.genreSet.equals(otherSong.genreSet)
            && this.suggestedPlaylist.equals(otherSong.suggestedPlaylist);
    }


}
