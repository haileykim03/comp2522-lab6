package ca.bcit.cst.comp2522.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.function.Supplier;

/**
 * Demonstrates the use of the HockeyPlayer and HockeyTeam classes
 *
 * @author Hailey Kim
 * @author Luis Sebaron
 * @version 1.0
 */
public class Main {

    private static final int CURRENT_YEAR = 2025;
    private static final int HIGH_SCORE = 20;
    private static final String FORWARD_POSITION = "F";
    private static final int STARTER = 0;
    private static final int MIN_AGE = 20;
    private static final int MIN_GOALS = 15;

    /**
     * Creates a sample HockeyTeam populated with a predefined list of players.
     *
     * @return a HockeyTeam instance containing the sample players
     */
    private static HockeyTeam sampleTeam()
    {
        final List<HockeyPlayer> ps;
        ps = new ArrayList<>();

        ps.add(new HockeyPlayer("Alex Morgan", "F", 2002, 21));
        ps.add(new HockeyPlayer("Ben Carter", "D", 1999, 6));
        ps.add(new HockeyPlayer("Casey Young", "F", 2004, 28));
        ps.add(new HockeyPlayer("Drew Singh", "G", 2000, 0));
        ps.add(new HockeyPlayer("Eva Chen", "D", 2001, 5));

        return new HockeyTeam("BCIT Blizzards", ps);
    }

    /**
     * The entry point of the program
     *
     * @param args not used
     */
    public static void main(final String[] args) {
        final int currentYear;
        final HockeyTeam team;
        final List<HockeyPlayer> roster;

        currentYear = CURRENT_YEAR;
        team = sampleTeam();
        roster = team.getRoster();

        // 1) Supplier — create a call-up and add it
        // TODO: Write a Supplier<HockeyPlayer> lambda here
        // Supplier<HockeyPlayer> callUp = ...
        // roster.add(callUp.get());

        final Supplier<HockeyPlayer> callUp =
                () -> new HockeyPlayer("Hailey Kim", "F", 2003, 15);

        roster.add(callUp.get());


        // 2) Predicate — forwards with 20+ goals
        // TODO: Write Predicate<HockeyPlayer> lambdas: isForward, has20Plus
        // Use them in a loop to print forwards with >=20 goals

        final Predicate<HockeyPlayer> isForward =
                p -> p.getPosition().equalsIgnoreCase(FORWARD_POSITION);
        final Predicate<HockeyPlayer> highScore =
                p -> p.getGoals() >= HIGH_SCORE;

        for (final HockeyPlayer hockeyPlayer : roster) {
            if (isForward.and(highScore).test(hockeyPlayer)) {
                System.out.println(hockeyPlayer);
            }
        }


        // 3) Function — map player to a label string
        // TODO: Write Function<HockeyPlayer,String> lambda

        final Function<HockeyPlayer, String> playerFunction =
                p -> p.getPlayerName() + " — " + p.getGoals() + "G";

        for (final HockeyPlayer hockeyPlayer : roster) {
            System.out.println(playerFunction.apply(hockeyPlayer));
        }


        // 4) Consumer — print names
        // TODO: Write Consumer<HockeyPlayer> lambda

        final Consumer<HockeyPlayer> hockeyPlayerConsumer =
                p -> System.out.println(p.getPlayerName());

        for (final HockeyPlayer hockeyPlayer : roster) {
            hockeyPlayerConsumer.accept(hockeyPlayer);
        }


        // 5) UnaryOperator — uppercase names
        // TODO: Write UnaryOperator<String> lambda

        final UnaryOperator<String> toUpper =
                (inputString) -> inputString.toUpperCase();

        for (final HockeyPlayer hockeyPlayer : roster) {
            System.out.println(toUpper.apply(hockeyPlayer.getPlayerName()));
        }


        // 6) Comparator — sort by goals DESC (no chaining)
        // TODO: Write Comparator<HockeyPlayer> lambda
        // Collections.sort(roster, yourComparator);

        final Comparator<HockeyPlayer> byGoalsDesc =
                (p1, p2) -> p2.getGoals() - p1.getGoals();

        Collections.sort(roster, byGoalsDesc);

        System.out.println("Players sorted by goals (desc):");
        for (final HockeyPlayer hockeyPlayer : roster) {
            System.out.println(hockeyPlayer.getPlayerName() + ": " + hockeyPlayer.getGoals());
        }


        // 7) Aggregation (loop) — total goals
        // TODO: Use a loop to sum goals across the roster

        int totalGoals;
        totalGoals = STARTER;

        for (final HockeyPlayer hockeyPlayer : roster) {
            totalGoals += hockeyPlayer.getGoals();
        }
        System.out.println("Total goals: " + totalGoals);


        // 8) Custom FI (EligibilityRule)
        // TODO: Write an EligibilityRule lambda
        // A player is eligible if age >= minAge AND goals >= minGoals

        final EligibilityRule rule =
                (player, minAge, minGoals, year) ->
                        (year - player.getYearOfBirth()) >= minAge &&
                                player.getGoals() >= minGoals;

        System.out.println("Eligible players (age >= " + MIN_AGE + ", goals >= " + MIN_GOALS + "):");

        for (final HockeyPlayer hockeyPlayer : roster) {
            if (rule.test(hockeyPlayer, MIN_AGE, MIN_GOALS, currentYear)) {
                System.out.println(hockeyPlayer.getPlayerName());
            }
        }
    }
}