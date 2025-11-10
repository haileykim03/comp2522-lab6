package ca.bcit.cst.comp2522.lambdas;

/**
 * Represents a hockey player with basic stats.
 *
 * @author Hailey Kim
 * @version 1.0
 */
public class HockeyPlayer
{
    private static final String FORWARD = "F";
    private static final String DEFENCE = "D";
    private static final String GOALIE  = "G";

    private final String name;
    private final String position;
    private final int yearOfBirth;
    private final int goals;

    /**
     * Creates a HockeyPlayer with given attributes.
     *
     * @param name        player's name
     * @param position    player's position (F, D, or G)
     * @param yearOfBirth player's birth year
     * @param goals       number of goals scored
     */
    public HockeyPlayer(final String name,
                        final String position,
                        final int yearOfBirth,
                        final int goals)
    {
        this.name        = name;
        this.position    = position;
        this.yearOfBirth = yearOfBirth;
        this.goals       = goals;

        validateName(name);
    }

    /**
     *
     * @param name
     */
    private static void validateName(final String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
    }

    /**
     *
     * @return
     */
    protected String getPlayerName()
    {
        return name;
    }

    /**
     *
     * @return
     */
    protected String getPosition()
    {
        return position;
    }

    /**
     *
     * @return
     */
    protected int getYearOfBirth()
    {
        return yearOfBirth;
    }

    /**
     *
     * @return
     */
    protected int getGoals()
    {
        return goals;
    }
}
