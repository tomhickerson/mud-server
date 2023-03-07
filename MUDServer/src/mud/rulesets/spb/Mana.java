package mud.rulesets.spb;

public class Mana {
    private String color;
    private String virtue;
    private String vice;
    private Integer score; // range from 1000 to -1000

    public Mana(String color, String virtue, String vice, Integer score) {
        this.color = color;
        this.virtue = virtue;
        this.vice = vice;
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public String getColor() {
        return color;
    }

    public String getVirtue() {
        return virtue;
    }

    public String getVice() {
        return vice;
    }


}
