package kc.terraneo;

import android.graphics.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;

import kc.terraneo.upgrades.Chaos;
import kc.terraneo.upgrades.Cities;
import kc.terraneo.upgrades.Crime;
import kc.terraneo.upgrades.Death;
import kc.terraneo.upgrades.Destruction;
import kc.terraneo.upgrades.Dreams;
import kc.terraneo.upgrades.Exploration;
import kc.terraneo.upgrades.Games;
import kc.terraneo.upgrades.Harvests;
import kc.terraneo.upgrades.Invention;
import kc.terraneo.upgrades.Knowledge;
import kc.terraneo.upgrades.Magic;
import kc.terraneo.upgrades.Medicine;
import kc.terraneo.upgrades.Music;
import kc.terraneo.upgrades.Plague;
import kc.terraneo.upgrades.Time;
import kc.terraneo.upgrades.War;
import kc.terraneo.upgrades.Wealth;

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
    private int maxActionCount;
    private String name;
    private ArrayList<Temple> temples;
    private ArrayList<Upgrade> upgrades;
    private final static String[] godNames = {"fskt","shaelys","pundr","lomhae","tkyrll","zolack"};
    private int templeCount;
    private Action lastActionTaken;
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
        _name.toLowerCase();
        switch(_name)
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
        maxActionCount = 4;
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
        templeCount = 4;
        upgrades = new ArrayList<Upgrade>();
    }

    public void setOwner(Player p)
    {
        owner = p;
        for(int i = 0; i<4; i++)
        {
            temples.add(new Temple(owner, new OffBoardPosition()));
        }
    }
    public static String[] getGodNames(){return godNames;}

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

    public int getMaxActionCount(){return maxActionCount;}

    /**
     *
     * @param a the last action taken by the god. Null at the start of the turn
     */
    public void setLastActionTaken(Action a)
    {
        lastActionTaken = a;
    }

    public Action getLastActionTaken()
    {
        return lastActionTaken;
    }

    public boolean hasCrime() {
        return hasCrime;
    }
    public void giveCrime(){
        hasCrime = true;
        upgradeCount++;
        upgrades.add(new Crime());
    }

    public boolean hasMagic() {
        return hasMagic;
    }
    public void giveMagic(){
        hasMagic = true;
        upgradeCount++;
        upgrades.add(new Magic());
    }

    public boolean hasDeath() {
        return hasDeath;
    }
    public void giveDeath(){
        hasDeath = true;
        upgradeCount++;
        upgrades.add(new Death());
    }

    public boolean hasKnowledge() {
        return hasKnowledge;
    }
    public void giveKnowledge(){
        hasKnowledge = true;
        upgradeCount++;
        upgrades.add(new Knowledge());
    }

    public boolean hasChaos() {
        return hasChaos;
    }
    public void giveChaos(){
        hasChaos = true;
        upgradeCount++;
        upgrades.add(new Chaos());
    }

    public boolean hasDestruction() {
        return hasDestruction;
    }
    public void giveDestruction(){
        hasDestruction = true;
        upgradeCount++;
        upgrades.add(new Destruction());
    }


    public boolean hasInvention() {
        return hasInvention;
    }
    public void giveInvention(){
        hasInvention = true;
        upgradeCount++;
        upgrades.add(new Invention());
    }

    public boolean hasHarvests() {
        return hasHarvests;
    }
    public void giveHarvests(){
        hasHarvests = true;
        upgradeCount++;
        upgrades.add(new Harvests());
    }

    public boolean hasMusic() {
        return hasMusic;
    }
    public void giveMusic(){
        hasMusic = true;
        upgradeCount++;

        upgrades.add(new Music());
    }

    public boolean hasWar() {
        return hasWar;
    }
    public void giveWar(){
        hasWar = true;
        upgradeCount++;
        upgrades.add(new War());
    }

    public boolean hasPlague() {
        return hasPlague;
    }
    public void givePlague(){
        hasPlague = true;
        upgradeCount++;
        upgrades.add(new Plague());
    }

    public boolean hasGames() {
        return hasGames;
    }
    public void giveGames(){
        hasGames = true;
        upgradeCount++;
        upgrades.add(new Games());
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
        templeCount++;
        upgrades.add(new Cities());
    }

    public int getTempleCount()
    {
        return templeCount;
    }

    public void placeTemple()
    {
        templeCount--;
        temples.remove(templeCount);
    }

    public boolean hasTime() {
        return hasTime;
    }
    public void giveTime(){
        hasTime = true;
        upgradeCount++;
        upgrades.add(new Time());
    }

    public boolean hasExploration() {
        return hasExploration;
    }
    public void giveExploration(){
        hasExploration = true;
        upgradeCount++;
        upgrades.add(new Exploration());
    }

    public boolean hasDreams() {
        return hasDreams;
    }
    public void giveDreams(){
        hasDreams = true;
        upgradeCount++;
        upgrades.add(new Dreams());
    }

    public boolean hasWealth() {
        return hasWealth;
    }
    public void giveWealth(){
        hasWealth = true;
        upgradeCount++;

        upgrades.add(new Wealth());
    }

    public boolean hasMedicine() {
        return hasMedicine;
    }
    public void giveMedicine(){
        hasMedicine = true;
        upgradeCount++;

        upgrades.add(new Medicine());
    }

    public ArrayList<Temple> getTemples()
    {
        return temples;
    }

}
