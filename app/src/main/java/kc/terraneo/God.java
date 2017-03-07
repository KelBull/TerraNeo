package kc.terraneo;

import android.graphics.Color;

/**
 * Created by Kelsey on 1/20/2017.
 */

class God {
    static final int ORANGE = 0xFFFFA500;
    private Player owner;
    private int color;
    private int nativeLand1;
    private int nativeLand2;
    private int upgradeCount;
    private String name;
    private boolean hasCrime;
    private boolean hasMagic;
    private boolean hasDeath;
    private boolean hasKnowledge;
    private boolean hasChaos;
    private boolean hasDestruction;
    private boolean hasInvention;
    private boolean hasHarvests;
    private boolean hasMusic;
    private boolean hasWar;
    private boolean hasPlague;
    private boolean hasGames;
    private boolean hasCities;
    private boolean hasTime;
    private boolean hasExploration;
    private boolean hasDreams;
    private boolean hasWealth;
    private boolean hasMedicine;

    public God(String _name)
    {
        name.toLowerCase();
        switch(name)
        {
            case "fskt": name="Fskt";
                color = Color.GREEN;
                nativeLand1 = Color.YELLOW;
                nativeLand2 = Color.BLUE;
                break;
            case "shaelys": name="Shaelys";
                color = Color.YELLOW;
                nativeLand1 = Color.GREEN;
                nativeLand2 = Color.YELLOW;
                break;
            case "pundr": name="Pundr";
                color = Color.RED;
                nativeLand1 = Color.RED;
                nativeLand2 = Color.GREEN;
                break;
            case "lomhae": name="Lomhae";
                color = Color.MAGENTA;
                nativeLand1 = Color.RED;
                nativeLand2 = Color.BLUE;
                break;
            case "tkyrll": name="Tkyrll";
                color = Color.BLUE;
                nativeLand1 = Color.BLUE;
                nativeLand2 = Color.GREEN;
                break;
            case "zolack": name="Zolack";
                color = ORANGE;
                nativeLand1 = Color.YELLOW;
                nativeLand2 = Color.RED;
                break;
        }
        upgradeCount = 0;
        hasCrime= false;
        hasMagic= false;
        hasDeath= false;
        hasKnowledge= false;
        hasChaos= false;
        hasDestruction= false;
        hasInvention= false;
        hasHarvests= false;
        hasMusic= false;
        hasWar= false;
        hasPlague= false;
        hasGames= false;
        hasCities= false;
        hasTime= false;
        hasExploration= false;
        hasDreams= false;
        hasWealth= false;
        hasMedicine = false;
    }


    public String getName() {
        return name;
    }

    public int getNativeLand1() {
        return nativeLand1;
    }

    public int getNativeLand2() {
        return nativeLand2;
    }

    public int getColor()
    {
        return color;
    }

    public boolean hasCrime() {
        return hasCrime;
    }

    public boolean hasMagic() {
        return hasMagic;
    }

    public boolean hasDeath() {
        return hasDeath;
    }

    public boolean hasKnowledge() {
        return hasKnowledge;
    }

    public boolean hasChaos() {
        return hasChaos;
    }

    public boolean hasDestruction() {
        return hasDestruction;
    }

    public boolean hasInvention() {
        return hasInvention;
    }

    public boolean hasHarvests() {
        return hasHarvests;
    }

    public boolean hasMusic() {
        return hasMusic;
    }

    public boolean hasWar() {
        return hasWar;
    }

    public boolean hasPlague() {
        return hasPlague;
    }

    public boolean hasGames() {
        return hasGames;
    }

    public boolean hasCities() {
        return hasCities;
    }

    public boolean hasTime() {
        return hasTime;
    }

    public boolean hasExploration() {
        return hasExploration;
    }

    public boolean hasDreams() {
        return hasDreams;
    }

    public boolean hasWealth() {
        return hasWealth;
    }

    public boolean hasMedicine() {
        return hasMedicine;
    }

}
