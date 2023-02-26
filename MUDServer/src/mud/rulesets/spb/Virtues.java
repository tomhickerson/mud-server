package mud.rulesets.spb;

public enum Virtues {
    FAITH("Faith"),// 0
    HOPE("Hope"),// 1
    COMPASSION("Compassion"),// 2
    HUMILITY("Humility"),// 3
    JUSTICE("Justice"),// 4
    SACRIFICE("Sacrifice"),// 5
    FORTITUDE("Fortitude");// 6

    private String stringRep;

    private Virtues(String stringRep) {
        this.stringRep = stringRep;
    }

    @Override
    public String toString() {
        return this.stringRep;
    }
}
