package kc.terraneo;

/**
 * Created by Kelsey Bull on 1/20/2017.
 */

public class Player {
    private God myGod;
    private Pawn myPawn;
    public int score;

    public Player(God g)
    {
        myGod = g;
        myPawn = new Pawn(g.getColor(), this);
    }

    public God getGod()
    {
        return myGod;
    }

    public Pawn getMyPawn()
    {
        return myPawn;
    }
}
