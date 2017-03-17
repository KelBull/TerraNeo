package kc.terraneo;

import java.util.List;

/**
 * Created by iyaerP on 1/20/2017.
 */

public class BuyUpgrade extends MajorAction {
    private Player owner;
    private Tile t;
    private int cost;
    private int value;
    Upgrade u;


    public BuyUpgrade(Player _p, Tile _t, int _upgradeCost, Upgrade _u)
    {
        owner = _p;
        t = _t;
        cost= _upgradeCost;
        u = _u;
        calculateValue();
    }

    public void calculateValue()
    {
        value = 0;
        List<Tile> neighbors = t.getNeighbors();
        for(Tile t: neighbors)
        {
            if(t.getColorValue()== owner.getGod().getNativeLand1()||t.getColorValue()== owner.getGod().getNativeLand2())
            {
                value++;
            }
        }
    }

    /**
     * This function allows an outside class to check if an upgrade would be valid with
     * the specified god, tile and upgrade given the current board-state.
     * @param _t the tile that is being checked
     * @param g the god that wants to upgrade
     * @param u the upgrade being considered for purchase
     * @return
     */
    public static boolean isValid(Tile _t, God g, Upgrade u)
    {
        int v = 0;
        List<Tile> neighbors = _t.getNeighbors();
        for(Tile t2: neighbors)
        {
            if(t2.getColorValue()== g.getNativeLand1()||t2.getColorValue()== g.getNativeLand2())
            {
                v++;
            }
        }
        if( v <= u.getCost())
        {
            return true;
        }else{
            return false;
        }
    }

    public int getValue()
    {
        return value;
    }

    @Override
    public void execute() {
        String name = u.getName();
        switch(name)
        {
            case "Chaos":
                owner.getGod().giveChaos();
                break;
            case "Cities":
                owner.getGod().giveCities();
                break;
            case "Crime":
                owner.getGod().giveCrime();
                break;
            case "Death":
                owner.getGod().giveDeath();
                break;
            case "Destruction":
                owner.getGod().giveDestruction();
                break;
            case "Dreams":
                owner.getGod().giveDreams();
                break;
            case "Exploration":
                owner.getGod().giveExploration();
                break;
            case "Games":
                owner.getGod().giveGames();
                break;
            case "Harvests":
                owner.getGod().giveHarvests();
                break;
            case "Invention":
                owner.getGod().giveInvention();
                break;
            case "Knowledge":
                owner.getGod().giveKnowledge();
                break;
            case "Magic":
                owner.getGod().giveMagic();
                break;
            case "Medicine":
                owner.getGod().giveMedicine();
                break;
            case "Music":
                owner.getGod().giveMusic();
                break;
            case "Plague":
                owner.getGod().givePlague();
                break;
            case "Time":
                owner.getGod().giveTime();
                break;
            case "War":
                owner.getGod().giveWar();
                break;
            case "Wealth":
                owner.getGod().giveWealth();
                break;

        }
        t.siphon();
    }
}
