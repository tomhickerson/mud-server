package mud.rulesets.spb;

public enum Vices {
    LUST("Lust"),
    ENVY("Envy"),
    SLOTH("Sloth"),
    PRIDE("Pride"),
    AVARICE("Avarice"),
    GLUTTONY("Gluttony"),
    ANGER("Anger"); // sometimes called Wrath

    private String stringRep;

    private Vices(String stringRep) {
        this.stringRep = stringRep;
    }

    @Override
    public String toString() {
        return stringRep;
    }
}
