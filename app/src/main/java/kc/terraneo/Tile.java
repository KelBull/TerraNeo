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
    private Temple t;
    protected boolean isPassable;
    protected String artPath;
    protected Position position;
    public static String[] resonanceValues = {"empty","calm","agitated","violent"};
    protected List<Tile> neighbors = new ArrayList<Tile>();


    /**
     *
     * @param _resonance the resonance of the tile as specified by the index in resonanceValues
     * @param _color the color of the tile
     * @param p the position on the gameboard
     */
    public Tile(int _resonance, int _color, Position p)
    {
        hasPlayer = false;
        hasTemple = false;
        isSiphoned = false;
        isPassable = true;
        location = p;
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

    public boolean hasPlayerPawn()
    {
        return hasPlayer;
    }

    public void addPlayerPawn() {hasPlayer=true;}

    public void removePlayerPawn() {hasPlayer=false;}

    public boolean hasTemple()
    {
        return hasTemple;
    }

    public void addTemple(Temple _t)
    {
        hasTemple = true;
        t = _t;
    }

    public boolean isSiphoned()
    {
        return isSiphoned;
    }

    public boolean isPassable() {return isPassable;}

    public List<Tile> getNeighbors()
    {
        return neighbors;
    }

    public void addNeighbor(Tile t)
    {
        neighbors.add(t);
    }

    public void setPassable()
    {
        isPassable = true;
    }

    public void setImpassable()
    {
        isPassable = false;
    }

    public Temple getTemple()
    {
        return t;
    }


}
