package kc.terraneo;

import android.graphics.Color;

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

    public Player(String _name ,God g)
    {
        name = _name;
        myGod = g;
        myGod.setOwner(this);
        myPawn = new Pawn(g.getColor(), this);
        myColor = g.getColor();
        updateScore();
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
}
