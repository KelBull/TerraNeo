package kc.terraneo;

import android.graphics.Color;

/**
 * Created by Kelsey Bull on 1/20/2017.
 */

public class Player {
    private God myGod;
    private Pawn myPawn;
    private int myColor;
    private int score;

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

    public int getColor(){
        return myColor;
    }

    public int getScore()
    {
        return score;
    }

    public void updateScore()
    {

    }
}
