package ca.bcit.cst.comp2522.lambdas;

/**
 * Defines a rule to determine if a hockey player is eligible
 * based on specific criteria.
 *
 * @author  Hailey Kim
 * @author Luis Sebaron
 * @version 1.0
 */
public interface EligibilityRule
{
    /**
     * Tests whether a hockey player meets the specified eligibility requirements.
     *
     * @param player the HockeyPlayer to evaluate
     * @param minAge the minimum age required for eligibility
     * @param minGoals the minimum number of goals required for eligibility
     * @param currentYear the current year, used to calculate the player's age
     * @return true if the player meets the criteria; false otherwise
     */
    boolean test(HockeyPlayer player,
                       int minAge,
                       int minGoals,
                       int currentYear);
}
