package ca.bcit.cst.comp2522.lambdas;

/**
 *
 */
public interface EligibilityRule
{
    /**
     *
     * @param player
     * @param minAge
     * @param minGoals
     * @param currentYear
     * @return
     */
    boolean test(HockeyPlayer player,
                       int minAge,
                       int minGoals,
                       int currentYear);
}
