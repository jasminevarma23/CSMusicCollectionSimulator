package dailymixes;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

// -------------------------------------------------------------------------
/**
 *  Project runner
 * 
 *  @author jasminevarma23
 *  @version April 7, 2024
 */
public class ProjectRunner
{

    // ----------------------------------------------------------
    /**
     * Create a new ProjectRunner object.
     */
    public ProjectRunner()
    {
        // TODO Auto-generated constructor stub
    }
   
    /**
     * main method
     * @param args arg
     * @throws ParseException 
     * @throws DailyMixDataException 
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws ParseException,
    DailyMixDataException,
    FileNotFoundException
    {
      
        if (args.length == 2)
        {
            PlaylistReader reader = new PlaylistReader(args[0], args[1]);
        }
        
        else
        {
            PlaylistReader reader = 
                new PlaylistReader("input.txt", "playlists.txt");
        }
        
    }


}
