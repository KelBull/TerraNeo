package kc.terraneo;

import android.graphics.Color;

/**
 * Created by Kelsey Bull on 1/20/2017.
 */

public class Player {
    private God myGod;
    private Pawn myPawn;
    private Color myColor;
    public int score;

    public Player(God g)
    {
        myGod = g;
        myPawn = new Pawn(g.getColor(), this);
        myColor = g.getColor();
    }

    public God getGod()
    {
        return myGod;
    }

    public Pawn getMyPawn()
    {
        return myPawn;
    }

    public Color getColor(){
        return myColor;
    }
}
