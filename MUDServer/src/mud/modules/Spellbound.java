package mud.modules;


import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import mud.MUDObject;
import mud.game.Ability;
import mud.game.Faction;
import mud.game.PClass;
import mud.game.Skill;
import mud.interfaces.Ruleset;
import mud.misc.SlotType;
import mud.objects.Item;
import mud.objects.ItemType;
import mud.objects.Player;
import mud.objects.Thing;
import mud.objects.ThingType;

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

    // TODO create a spellbound instance of the ruleset
    @Override
    public Ruleset getRuleset() {
        return null;
    }

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
