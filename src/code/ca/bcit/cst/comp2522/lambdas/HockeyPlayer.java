package ca.bcit.cst.comp2522.lambdas;

/**
 * Represents a hockey player with basic stats.
 *
 * @author Hailey Kim
 * @author Luis Seberon
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
     * Constructs a HockeyPlayer
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
     * Validates that the player name is not null or empty.
     *
     * @param name the name to validate
     */
    private static void validateName(final String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
    }

    /**
     * Returns the name of the player.
     *
     * @return the player's name
     */
    protected String getPlayerName()
    {
        return name;
    }

    /**
     * Returns the position of the player.
     *
     * @return the player's position
     */
    protected String getPosition()
    {
        return position;
    }

    /**
     * Returns the year the player was born.
     *
     * @return the player's year of birth
     */
    protected int getYearOfBirth()
    {
        return yearOfBirth;
    }

    /**
     * Returns the number of goals scored by the player.
     *
     * @return the number of goals scored
     */
    protected int getGoals()
    {
        return goals;
    }
}
