package mud.utils.services;

import mud.game.PClass;
import mud.game.Race;
import mud.objects.Player;
import mud.rulesets.d20.Classes;
import mud.rulesets.d20.Races;

/**
 * Player Validation Service, Tom Hickerson, March 2023
 * taking some of the logic out of the main MUDServer.java file and placing it here
 */
public class PlayerValidationService {

    public PlayerValidationService() {
        // instantiate here
    }

    /**
     * Determine if the specified Player has a valid class set. Checks to see if
     * you have a class other than Classes.NONE and which is not an NPC class.
     * Also checks for null (which would be equally invalid).
     *
     * @param player
     * @return
     */
    public static boolean hasValidClass(final Player player) {
        final PClass pcl = player.getPClass();

        boolean valid = false;

        if (pcl != null && pcl != Classes.NONE && !pcl.isNPC()) {
            valid = true;
        }

        return valid;
    }

    /**
     * Determine if the specified Player has a valid race set. Checks to see if
     * you have a race other than Races.NONE and which is not a restricted race.
     * Also checks for null (which would be equally invalid).
     *
     * @param player
     * @return
     */
    public static boolean hasValidRace(Player player) {
        final Race race = player.getRace();

        boolean valid = false;

        if( race != null && race != Races.NONE && !race.isRestricted() ) {
            valid = true;
        }

        return valid;
    }
}
