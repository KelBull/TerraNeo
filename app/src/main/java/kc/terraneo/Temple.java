package kc.terraneo;

import android.graphics.Color;
import java.util.List;

/**
 * Created by iyaerP on 1/20/2017.
 */

class Temple extends BoardObject {
    private Player owner;
    private God g;
    private int color;
    private int score;
    private boolean isPlaced;

    public Temple(Player _owner, Position loc)
    {
        location = loc;
        color = _owner.getColor();
        owner = _owner;
        g = _owner.getGod();
        updateScore();
    }

    public void updateScore()
    {
        if(!location.isOnBoard())
        {
            score =0;
            return;
        }
        Tile temp = theBoard.getTileAt(location);
        List<Tile> neighbors = temp.getNeighbors();
        score = 1;
        for(Tile t: neighbors)
        {
            if((t.getResonance()==temp.getResonance()&& !t.isSiphoned())
                    ||(owner.getGod().hasDeath()&&t.isSiphoned()))
            {
                score++;
            }
        }
    }

    public void place(Position p)
    {
        location = p;
        updateScore();
        isPlaced = true;
        g.placeTemple();
    }

    public Player getOwner()
    {
        return owner;
    }

    public God getGod()
    {
        return g;
    }

    public int getScore()
    {
        return score;
    }

    public boolean isPlaced()
    {
        return isPlaced;
    }
}
