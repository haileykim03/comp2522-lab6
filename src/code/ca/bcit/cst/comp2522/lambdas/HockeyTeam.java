package ca.bcit.cst.comp2522.lambdas;

import java.util.List;

/**
 * Represents a hockey team consisting of a name and a roster of players.
 *
 * @author Hailey Kim
 * @author Luis Sebaron
 * @version 1.0
 */
public class HockeyTeam
{
    private final String name;
    private final List<HockeyPlayer> roster;

    /**
     * Constructs a HockeyTeam
     *
     * @param name the name of the hockey team
     * @param roster the list of players in the team
     */
    public HockeyTeam(final String name,
                      final List<HockeyPlayer> roster)
    {
        this.name = name;
        this.roster = roster;

        validateName(name);
    }

    /**
     * Validates that the team name is not null or empty.
     *
     * @param name the name to validate
     * @throws IllegalArgumentException if the name is null or empty
     */
    private static void validateName(final String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
    }

    /**
     * Returns the name of the hockey team.
     *
     * @return the team name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the roster of players in the team.
     *
     * @return a list of HockeyPlayer objects representing the roster
     */
    public List<HockeyPlayer> getRoster()
    {
        return roster;
    }
}
