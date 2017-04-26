package kc.terraneo;

import android.graphics.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Kelsey Bull on 1/20/2017.
 */

public class Player {
    private God myGod;
    private Pawn myPawn;
    private int myColor;
    private int score;
    private String name;
    private GameBoard board;
    private GameWindow window;
    private Action lastActionTaken;
    private ArrayList<Action> legalActions;

    public Player(String _name ,God g, GameBoard gb, GameWindow gw)
    {
        name = _name;
        myGod = g;
        board = gb;
        myGod.setOwner(this);
        myPawn = new Pawn(g.getColor(), this);
        myColor = g.getColor();
        window = gw;
        updateScore();
        updateLegalActions();
    }

    public God getGod()
    {
        return myGod;
    }

    public Pawn getPawn()
    {
        return myPawn;
    }

    public int getColor(){
        return myColor;
    }

    public int getScore()
    {
        return score;
    }

    public void updateScore()
    {
        score = 0;
        ArrayList<Temple> theTemples = myGod.getTemples();
        for(Temple t: theTemples)
        {
            score += t.getScore();
        }
    }

    public String getName()
    {
        return name;
    }

    public GameBoard getBoard(){ return board;}

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

    public ArrayList<Action> getLegalActions() {return legalActions;}

    public void updateLegalActions()
    {
        legalActions = null;
        //add move actions
        for (Tile t: myPawn.getLegalMoves()) {
            legalActions.add(new Move(myPawn, t.getLocation()));
        };
        Tile locT = board.getTileAt(myPawn.getLocation());
        //add create actions
        for (Tile t: locT.getNeighbors()) {
            if(Create.isValid(t.getLocation(), myPawn))
            {
                legalActions.add(new Create(window.getTileSource1().peek(),t.getLocation(),myPawn));
                legalActions.add(new Create(window.getTileSource2().peek(),t.getLocation(),myPawn));
                legalActions.add(new Create(window.getTileSource3().peek(),t.getLocation(),myPawn));
                legalActions.add(new Create(window.getTileSource4().peek(),t.getLocation(),myPawn));
            }
        }
        //adds creates if standing on temple
        if(board.getTileAt(myPawn.getLocation()).hasTemple()) {
            for (Tile t : locT.getExtendedNeighbors()) {
                if (Create.isValid(t.getLocation(), myPawn)) {
                    legalActions.add(new Create(window.getTileSource1().peek(), t.getLocation(), myPawn));
                    legalActions.add(new Create(window.getTileSource2().peek(), t.getLocation(), myPawn));
                    legalActions.add(new Create(window.getTileSource3().peek(), t.getLocation(), myPawn));
                    legalActions.add(new Create(window.getTileSource4().peek(), t.getLocation(), myPawn));
                }
            }
        }
        //refreshes are always legal, don't need to check for them

        //checking temple legality
        if(!locT.hasTemple()&&!locT.isSiphoned())
        {
            if(locT.getColorValue()==myGod.getNativeLand1())
            {
                for (Tile t: locT.getNeighbors())
                {
                    if(t.getColorValue()==myGod.getNativeLand2())
                    {
                        legalActions.add(new PlaceTemple(this, locT.getLocation()));
                        break;
                    }
                }
            }
            if(locT.getColorValue()==myGod.getNativeLand2())
            {
                for (Tile t: locT.getNeighbors())
                {
                    if(t.getColorValue()==myGod.getNativeLand1())
                    {
                        legalActions.add(new PlaceTemple(this, locT.getLocation()));
                        break;
                    }
                }
            }
        }

        //check upgrade legality
        Upgrade u1 = window.getUpgradeSource1().peek();
        Upgrade u2 = window.getUpgradeSource2().peek();
        Upgrade u3 = window.getUpgradeSource3().peek();
        if(BuyUpgrade.isValid(locT, myGod, u1))
        {
            legalActions.add(new BuyUpgrade(this, locT, u1.getCost(), u1));
        }
        if(BuyUpgrade.isValid(locT, myGod, u2))
        {
            legalActions.add(new BuyUpgrade(this, locT, u2.getCost(), u2));
        }
        if(BuyUpgrade.isValid(locT, myGod, u3))
        {
            legalActions.add(new BuyUpgrade(this, locT, u3.getCost(), u3));
        }
    }
}
