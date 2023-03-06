package mud.modules;


import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import mud.MUDObject;
import mud.game.*;
import mud.interfaces.Ruleset;
import mud.misc.Slot;
import mud.misc.SlotType;
import mud.misc.SlotTypes;
import mud.objects.*;
import mud.rulesets.spb.*;

public class Spellbound extends GameModule {
    private String name = "Spellbound";

    private List<Faction> factions;
    private Hashtable<String, ItemType> itemTypes;

    public Spellbound(final String moduleName) {
        this.name = moduleName;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getShortName() {
        //return this.name;
        return "GGG";
    }

    @Override
    public Integer getVersion() {
        return 0;
    }

    @Override
    public Ruleset getRuleset() {
        return SpellboundGGG.getInstance();
    }

    // classless mud
    @Override
    public boolean hasClasses() {
        return false;
    }

    @Override
    public void init() {
    }

    @Override
    public void init(final String dataDir) {
    }

    @Override
    public void init2(final List<Faction> mFactions, Hashtable<String, ItemType> mItemTypes) {
        this.factions = mFactions;
        this.itemTypes = mItemTypes;
    }

    @Override
    public void PCInit(Player player) {
        // TODO Auto-generated method stub
        // add/initialize slots
        player.addSlot("helmet",   new Slot(SlotTypes.HEAD,   ItemTypes.ARMOR));
        if (player.getRace().toString().equals("Two Headed Troll")) {
            player.addSlot("helmet2",   new Slot(SlotTypes.HEAD,   ItemTypes.ARMOR));
            player.addSlot("necklace2", new Slot(SlotTypes.NECK,   ItemTypes.NECKLACE));
        }
        player.addSlot("necklace", new Slot(SlotTypes.NECK,   ItemTypes.NECKLACE));
        player.addSlot("armor",    new Slot(SlotTypes.CHEST,  ItemTypes.ARMOR));
        player.addSlot("cloak",    new Slot(SlotTypes.BACK,   ItemTypes.CLOTHING));
        player.addSlot("ring1",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
        player.addSlot("ring2",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
        player.addSlot("ring3",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
        player.addSlot("ring4",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
        player.addSlot("ring5",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
        player.addSlot("ring6",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
        player.addSlot("gloves",   new Slot(SlotTypes.HANDS,  ItemTypes.CLOTHING));
        player.addSlot("weapon",   new Slot(SlotTypes.RHAND,  ItemTypes.WEAPON, ItemTypes.WAND));
        player.addSlot("weapon1",  new Slot(SlotTypes.LHAND,  ItemTypes.WEAPON, ItemTypes.WAND));
        player.addSlot("weapon2",  new Slot(SlotTypes.HANDS,  ItemTypes.WEAPON));
        if (player.getRace().toString().equals("Four Armed Troll")) {
            player.addSlot("ring7",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
            player.addSlot("ring8",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
            player.addSlot("ring9",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
            player.addSlot("ring10",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
            player.addSlot("ring11",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
            player.addSlot("ring12",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
            player.addSlot("gloves2",   new Slot(SlotTypes.HANDS,  ItemTypes.CLOTHING));
            player.addSlot("weapon3",   new Slot(SlotTypes.RHAND,  ItemTypes.WEAPON, ItemTypes.WAND));
            player.addSlot("weapon4",  new Slot(SlotTypes.LHAND,  ItemTypes.WEAPON, ItemTypes.WAND));
            player.addSlot("weapon5",  new Slot(SlotTypes.HANDS,  ItemTypes.WEAPON));
        }
        player.addSlot("belt",     new Slot(SlotTypes.WAIST,  ItemTypes.CLOTHING));
        player.addSlot("boots",    new Slot(SlotTypes.FEET,   ItemTypes.CLOTHING));
        player.addSlot("other",    new Slot(SlotTypes.NONE,   ItemTypes.NONE ));

        // TODO we will probably have to change the underlying storage to hashmap
        player.addMana(new Mana(Colors.RED.toString(),
                Virtues.FORTITUDE.toString(), Vices.ANGER.toString(), new Integer(0)));
        player.addMana(new Mana(Colors.ORANGE.toString(),
                Virtues.SACRIFICE.toString(), Vices.GLUTTONY.toString(), new Integer(0)));
        player.addMana(new Mana(Colors.YELLOW.toString(),
                Virtues.JUSTICE.toString(), Vices.AVARICE.toString(), new Integer(0)));
        player.addMana(new Mana(Colors.GREEN.toString(),
                Virtues.HOPE.toString(), Vices.ENVY.toString(), new Integer(0)));
        player.addMana(new Mana(Colors.BLUE.toString(),
                Virtues.COMPASSION.toString(), Vices.SLOTH.toString(), new Integer(0)));
        player.addMana(new Mana(Colors.INDIGO.toString(),
                Virtues.HUMILITY.toString(), Vices.PRIDE.toString(), new Integer(0)));
        player.addMana(new Mana(Colors.VIOLET.toString(),
                Virtues.FAITH.toString(), Vices.LUST.toString(), new Integer(0)));
    }

    @Override
    public List<Faction> getFactions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemType getItemType(final Integer typeId) {
        return null;
    }

    public ItemType getItemType(final String typeName) {
        return null;
    }

    @Override
    public SlotType getSlotType(final Integer typeId) {
        return null;
    }

    @Override
    public SlotType getSlotType(final String typeName) {
        return null;
    }

    @Override
    public ThingType getThingType(final Integer typeId) {
        return null;
    }

    @Override
    public ThingType getThingType(final String typeName) {
        return null;
    }

    @Override
    public Map<String, Item> getItemPrototypes() {
        return null;
    }

    @Override
    public Map<String, Thing> getThingPrototypes() {
        return null;
    }

    @Override
    public Item loadItem(final String itemData) {
        return null;
    }

    @Override
    public Thing loadThing(final String itemData) {
        return null;
    }

    @Override
    public void run() {
    }

    @Override
    public void op(String input, Player player) {
    }

    @Override
    public boolean use(Player p, MUDObject m) {
        return false;
    }

    @Override
    public void test() {
        // TODO Auto-generated method stub

    }

    @Override
    public void levelup(Player player) {
    }
}
