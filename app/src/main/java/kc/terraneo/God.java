package kc.terraneo;

import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by Kelsey on 1/20/2017.
 */

class God {
    static final int ORANGE = 0xFFFFA500;
    private String artPath;
    private Player owner;
    private int color;
    private int nativeLand1;
    private int nativeLand2;
    private int upgradeCount;
    private String name;
    private ArrayList<Temple> temples;
    private int templeCount;
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
            case "fskt": name="fskt";
                color = Color.GREEN;
                nativeLand1 = Color.YELLOW;
                nativeLand2 = Color.BLUE;
                break;
            case "shaelys": name="shaelys";
                color = Color.YELLOW;
                nativeLand1 = Color.GREEN;
                nativeLand2 = Color.YELLOW;
                break;
            case "pundr": name="pundr";
                color = Color.RED;
                nativeLand1 = Color.RED;
                nativeLand2 = Color.GREEN;
                break;
            case "lomhae": name="lomhae";
                color = Color.MAGENTA;
                nativeLand1 = Color.RED;
                nativeLand2 = Color.BLUE;
                break;
            case "tkyrll": name="tkyrll";
                color = Color.BLUE;
                nativeLand1 = Color.BLUE;
                nativeLand2 = Color.GREEN;
                break;
            case "zolack": name="zolack";
                color = ORANGE;
                nativeLand1 = Color.YELLOW;
                nativeLand2 = Color.RED;
                break;
        }
        artPath = name + ".png";
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
        temples = new ArrayList<Temple>();
        for(int i = 0; i<4; i++)
        {
            temples.add(new Temple(owner, new OffBoardPosition()));
        }
        templeCount = 4;
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

    public int getUpgradeCount()
    {
        return upgradeCount;
    }

    public boolean hasCrime() {
        return hasCrime;
    }
    public void giveCrime(){
        hasCrime = true;
        upgradeCount++;
    }

    public boolean hasMagic() {
        return hasMagic;
    }
    public void giveMagic(){
        hasMagic = true;
        upgradeCount++;
    }

    public boolean hasDeath() {
        return hasDeath;
    }
    public void giveDeath(){
        hasDeath = true;
        upgradeCount++;
    }

    public boolean hasKnowledge() {
        return hasKnowledge;
    }
    public void giveKnowledge(){
        hasKnowledge = true;
        upgradeCount++;
    }

    public boolean hasChaos() {
        return hasChaos;
    }
    public void giveChaos(){
        hasChaos = true;
        upgradeCount++;
    }

    public boolean hasDestruction() {
        return hasDestruction;
    }
    public void giveDestruction(){
        hasDestruction = true;
        upgradeCount++;
    }


    public boolean hasInvention() {
        return hasInvention;
    }
    public void giveInvention(){
        hasInvention = true;
        upgradeCount++;
    }

    public boolean hasHarvests() {
        return hasHarvests;
    }
    public void giveHarvests(){
        hasHarvests = true;
        upgradeCount++;
    }

    public boolean hasMusic() {
        return hasMusic;
    }
    public void giveMusic(){
        hasMusic = true;
        upgradeCount++;
    }

    public boolean hasWar() {
        return hasWar;
    }
    public void giveWar(){
        hasWar = true;
        upgradeCount++;
    }

    public boolean hasPlague() {
        return hasPlague;
    }
    public void givePlague(){
        hasPlague = true;
        upgradeCount++;
    }

    public boolean hasGames() {
        return hasGames;
    }
    public void giveGames(){
        hasGames = true;
        upgradeCount++;
    }

    public boolean hasCities() {
        return hasCities;
    }

    /**
     * gives the god the effect of the cities upgrade.
     */
    public void giveCities(){
        hasCities = true;
        upgradeCount++;
        temples.add(new Temple(owner, new OffBoardPosition()));
    }

    public int getTempleCount()
    {
        return templeCount;
    }

    public void placeTemple()
    {
        templeCount--;
    }

    public boolean hasTime() {
        return hasTime;
    }
    public void giveTime(){
        hasTime = true;
        upgradeCount++;
    }

    public boolean hasExploration() {
        return hasExploration;
    }
    public void giveExploration(){
        hasExploration = true;
        upgradeCount++;
    }

    public boolean hasDreams() {
        return hasDreams;
    }
    public void giveDreams(){
        hasDreams = true;
        upgradeCount++;
    }

    public boolean hasWealth() {
        return hasWealth;
    }
    public void giveWealth(){
        hasWealth = true;
        upgradeCount++;
    }

    public boolean hasMedicine() {
        return hasMedicine;
    }
    public void giveMedicine(){
        hasMedicine = true;
        upgradeCount++;
    }

    public ArrayList<Temple> getTemples()
    {
        return temples;
    }

}
