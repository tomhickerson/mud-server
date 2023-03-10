package mud.combat;

import mud.events.SayEvent;

public class Wimpy extends Strategy {

    @Override
    public void onRoomChange() {
        // consider the foe, and then hide or flee
    }

    @Override
    public void onDetectHostile() {
        // consider the foe, and then flee
    }

    @Override
    public void handleSayEvent(SayEvent se) {
        String whatWasSaid = se.getMessage();
    }
}
