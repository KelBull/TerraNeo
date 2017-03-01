package kc.terraneo;

import android.graphics.Color;
import java.util.List;

/**
 * Created by iyaerP on 1/20/2017.
 */

class Temple extends BoardObject {
    private Player owner;
    private Color color;
    private int score;

    public Temple(Player _owner, Position loc)
    {
        location = loc;
        color = _owner.getColor();
        owner = _owner;
        updateScore();
    }

    public void updateScore()
    {
        Tile temp = theBoard.getTileAt(location);
        List<Tile> neighbors = temp.getNeighbors();
        score = 1;
        for(Tile t: neighbors)
        {
            if(t.getResonance()==temp.getResonance())
            {//TODO: Add resonance matching when player has the Death upgrade
                score++;
            }
        }
    }
}
