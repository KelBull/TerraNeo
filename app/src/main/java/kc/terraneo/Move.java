package kc.terraneo;

import android.util.Log;

/**
 * Created by iyaerP on 1/20/2017.
 */

public class Move extends MinorAction {

    private Pawn pawn;
    private Position start;
    private Position destination;

    /**
     *
     * @param p the Pawn that wants to move. Nevernull
     * @param dest the Position that the pawn wants to move to
     */
    public Move(Pawn p, Position dest)
    {
        pawn = p;
        start = p.getLocation();
        destination = dest;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public Position getStart(){
        return start;
    }

    public Position getDestination(){
        return destination;
    }

    public void execute()
    {
        try{
            pawn.move(destination);
        }catch(Exception e)
        {
            Log.e("illegal move", e.getMessage());
        }
    }
}
