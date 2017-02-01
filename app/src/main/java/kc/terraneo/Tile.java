package kc.terraneo;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelsey Bull on 1/20/2017.
 */

class Tile extends BoardObject {
    private boolean hasPlayer;
    private boolean isSiphoned;
    private boolean hasTemple;
    private int resonance;
    private int color;
    protected String artPath;
    protected Position position;
    private static String[] resonanceValues = {"empty","calm","agitated","violent"};
    protected List<Tile> neighbors = new ArrayList<Tile>();


    /**
     *
     */
    public Tile(int _resonance, int _color, Position p)
    {
        hasPlayer = false;
        hasTemple = false;
        isSiphoned = false;
        position = p;
        color = _color;
        resonance = _resonance;
        artPath = resonanceValues[_resonance];

        switch(color){
            case Color.RED: artPath += "fire";
                break;
            case Color.BLUE: artPath += "water";
                break;
            case Color.YELLOW: artPath += "air";
                break;
            case Color.GREEN: artPath += "earth";
                break;
            case Color.BLACK: artPath += "blank";
        }
        artPath +=".jpg";
    }

    protected Tile()
    {
        hasPlayer = false;
        hasTemple = false;
        isSiphoned = false;
        position = new Position(0,0);
        color = Color.BLACK;
        resonance = 0;
        artPath = "emptyblank.jpg";
    }

    public int getResonanceNum()
    {
        return resonance;
    }

    public String getResonance()
    {
        return resonanceValues[resonance];
    }

    public int getColorValue()
    {
        return color;
    }

    public boolean hasPlayer()
    {
        return hasPlayer;
    }

    public boolean hasTemple()
    {
        return hasTemple;
    }

    public boolean isSiphoned()
    {
        return isSiphoned;
    }

    public List<Tile> getNeighbors()
    {
        return neighbors;
    }

    public void addNeighbor(Tile t)
    {
        neighbors.add(t);
    }

}
