package mud.rulesets.spb;

import mud.game.Ability;
import mud.game.PClass;
import mud.game.Skill;
import mud.interfaces.Ruleset;

public final class SpellboundGGG implements Ruleset {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Ability getAbility(int id) {
        return null;
    }

    @Override
    public Ability getAbility(String abilityName) {
        return null;
    }

    @Override
    public Ability[] getAbilities() {
        return new Ability[0];
    }

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
