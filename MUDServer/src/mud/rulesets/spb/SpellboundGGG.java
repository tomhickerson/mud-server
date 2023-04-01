package mud.rulesets.spb;

import mud.game.Ability;
import mud.game.PClass;
import mud.game.Skill;
import mud.interfaces.Ruleset;

import java.util.HashMap;

public final class SpellboundGGG implements Ruleset {
    @Override
    public String getName() {
        return "SpellboundGGG";
    }

    private static final Ability STRENGTH = new Ability("strength", "str", 0);
    private static final Ability DEXTERITY = new Ability("dexterity", "dex", 1);
    private static final Ability CONSTITUTION = new Ability("constitution", "con", 2);
    private static final Ability INTELLIGENCE= new Ability("intelligence", "int", 3);
    private static final Ability CHARISMA = new Ability("charisma", "cha", 4);
    private static final Ability WISDOM = new Ability("wisdom", "wis", 5);

    private static final Ability[] abilities = new Ability[] {
            STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, CHARISMA, WISDOM
    };

    private static final HashMap<String, Ability> abilityMap = new HashMap<String, Ability>() {
        {
            put("STR", STRENGTH);
            put("DEX", DEXTERITY);
            put("CON", CONSTITUTION);
            put("INT", INTELLIGENCE);
            put("CHA", CHARISMA);
            put("WIS", WISDOM);
        }
    };

    @Override
    public Ability getAbility(int id) {
        return abilities[id];
    }

    @Override
    public Ability getAbility(String abilityName) {
        for(final String s : abilityMap.keySet()) {
            if( s.equals(abilityName) ) {
                return abilityMap.get(s);
            }
        }

        return null;
    }

    @Override
    public Ability[] getAbilities() {
        return this.abilities;
    }

    // class less rules, you can do any path
    @Override
    public PClass getClass(int id) {
        return null;
    }

    @Override
    public PClass getClass(String className) {
        return null;
    }

    @Override
    public PClass[] getClasses() {
        return new PClass[0];
    }

    /* skills */
    @Override
    public Skill getSkill(int id) {
        return null;
    }

    @Override
    public Skill getSkill(String skillName) {
        return null;
    }

    @Override
    public Skill[] getSkills() {
        return new Skill[0];
    }

    private static SpellboundGGG spbInstance;

    public static SpellboundGGG getInstance() {
        if (spbInstance == null) {
            spbInstance = new SpellboundGGG();
        }
        return spbInstance;
    }

    public SpellboundGGG() {

    }
}
