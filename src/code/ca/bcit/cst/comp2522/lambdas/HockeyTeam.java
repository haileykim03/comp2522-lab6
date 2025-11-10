package ca.bcit.cst.comp2522.lambdas;

import java.util.List;

/**
 * @author Hailey Kim
 * @version 1.0
 */
public class HockeyTeam
{
    private final String name;
    private final List<HockeyPlayer> roster;

    /**
     *
     * @param name
     * @param roster
     */
    public HockeyTeam(final String name, final List<HockeyPlayer> roster)
    {
        this.name = name;
        this.roster = roster;

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
    public String getName()
    {
        return name;
    }

    /**
     *
     * @return
     */
    public List<HockeyPlayer> getRoster()
    {
        return roster;
    }
}
