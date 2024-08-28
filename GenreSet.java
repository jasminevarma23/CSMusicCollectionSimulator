package dailymixes;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
// -- Jasmine Varma (jasminevarma23)
// -------------------------------------------------------------------------
/**
 *  Determines the values for genres
 * 
 *  @author jasminevarma23
 *  @version April 2, 2024
 */
public class GenreSet implements Comparable<GenreSet>
{
    private int rock;
    private int pop;
    private int country;


    // ----------------------------------------------------------
    /**
     * Create a new GenreSet object.
     * @param pop pop
     * @param rock rock
     * @param country country
     */
    public GenreSet(int pop, int rock, int country)
    {
        this.pop = pop;
        this.rock = rock;
        this.country = country;
    }

    /**
     * get rock field
     * @return rock
     */
    public int getRock()
    {
        return this.rock;
    }

    /**
     * get pop field
     * @return pop
     */
    public int getPop()
    {
        return this.pop;
    }

    /**
     * get country field
     * @return country
     */
    public int getCountry()
    {
        return this.country;
    }


    /**
     * used for checking if a song's genreset is accepted based on a 
     * playlist's required genreset range.
     * @param other passes in a value to compare
     * @return returns true or false
     */
    private boolean isLessThanOrEqualTo(GenreSet other)
    {
        return this.pop <= other.pop && this.rock <= other.rock
            && this.country <= other.country;
        
    }

    /**
     * checks if the genre value x is within the accepted range
     * @param minGenreSet the minimum value
     * @param maxGenreSet the maximum value
     * @return true or false whether in range or not
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet)
    {
        return isLessThanOrEqualTo(maxGenreSet)
            && minGenreSet.isLessThanOrEqualTo(this);
    }

    /**
     * equals method
     * @param other comparison object
     * @return true or false
     */
    public boolean equals(Object other)
    {
        if (this == other)
        {
            return true;
        }
        if (other == null || this.getClass() != other.getClass())
        {
            return false;
        }
        GenreSet otherSet = (GenreSet)other;

        return this.pop == otherSet.pop && this.rock == otherSet.rock
            && this.country == otherSet.country;
    }

    /**
     * compares two genre sets
     * @param o the other genre set
     * @return the difference
     */
    @Override
    public int compareTo(GenreSet o)
    {
        int thisSum = this.pop + this.rock + this.country;
        int oSum = o.getPop() + o.getRock() + o.getCountry();
        return Integer.compare(thisSum, oSum);
    }

    /**
     * to string method
     * @return a string of the genres
     */
    public String toString()
    {
        return "Pop:" + this.pop + " Rock:" 
            + this.rock + " Country:" + this.country;
    }

}
