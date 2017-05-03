package kc.terraneo;

import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelsey Bull on 1/20/2017.
 */

class Tile extends BoardObject {
    protected boolean hasPlayer;
    protected boolean isSiphoned;
    protected boolean hasTemple;
    private int resonance;
    protected int color;
    private Temple myTemple;
    protected boolean isPassable;
    //protected String artPath;
    //protected Position position;
    public static String[] resonanceValues = {"empty","calm","agitated","violent"};
    protected ArrayList<Tile> neighbors = new ArrayList<Tile>();


    /**
     *
     * @param _resonance the resonance of the tile as specified by the index in resonanceValues
     * @param _color the color of the tile
     * @param p the position on the gameboard
     */
    public Tile(GameBoard gB, int _resonance, int _color, Position p)
    {
        theBoard = gB;
        hasPlayer = false;
        hasTemple = false;
        isSiphoned = false;
        isPassable = false;
        location = p;
        color = _color;
        resonance = _resonance;
        artPath = resonanceValues[_resonance] + "_";

        switch(color){
            case Color.RED: artPath += "fire";
                break;
            case Color.BLUE: artPath += "water";
                break;
            case Color.YELLOW: artPath += "wind";
                break;
            case Color.GREEN: artPath += "earth";
                break;
            case Color.BLACK: artPath += "black";
        }
        artPath +=".png";
    }

    protected Tile()
    {
        hasPlayer = false;
        hasTemple = false;
        isSiphoned = false;
        isPassable = false;
        location = new Position(0,0);
        color = Color.BLACK;
        resonance = 0;
        artPath = "black_tile.png";
    }

    public void place(Position p)
    {
        location = p;
        isPassable = true;
        theBoard.playTile(this);
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
        myTemple = _t;
    }

    public boolean isSiphoned()
    {
        return isSiphoned;
    }

    public void siphon()
    {
        isSiphoned = true;
    }

    public void unsiphon(){isSiphoned = false;}

    public boolean isPassable() {return isPassable;}

    public ArrayList<Tile> getNeighbors()
    {
        return neighbors;
    }

    public void updateNeighbors(Tile[][] tiles)
    {
        neighbors.clear();

        int x = location.getX();
        int y = location.getY();
        int gridSide = theBoard.getGridSide();

        if(x%2==0)
        {//evens columns
            if(x == 0)
            {
                addNeighbor(tiles[x+1][y]);
                if(y!=0)
                {
                    addNeighbor(tiles[x][y-1]);
                }
                if(y!=gridSide-1)
                {
                    addNeighbor(tiles[x][y+1]);
                    addNeighbor(tiles[x+1][y+1]);
                }
            }else{//done the 0 column

                if (x == gridSide - 1) {
                    addNeighbor(tiles[x - 1][y]);
                    if(y!=0)
                    {
                        addNeighbor(tiles[x][y-1]);
                    }
                    if(y!=gridSide-1)
                    {
                        addNeighbor(tiles[x][y+1]);
                        addNeighbor(tiles[x-1][y+1]);
                    }
                }else{//done the far right column, doing all normal even columns

                    if(y !=0 )
                    {
                        addNeighbor(tiles[x][y-1]);
                    }
                    if(y != gridSide-1)
                    {
                        addNeighbor(tiles[x][y+1]);
                        addNeighbor(tiles[x+1][y+1]);
                        addNeighbor(tiles[x-1][y+1]);
                    }
                    addNeighbor(tiles[x-1][y]);
                    addNeighbor(tiles[x+1][y]);
                }
            }
        }else{//odd columns
            if(y!=0)
            {
                addNeighbor(tiles[x][y-1]);
                addNeighbor(tiles[x-1][y-1]);
                addNeighbor(tiles[x+1][y-1]);
            }
            if(y != gridSide-1)
            {
                addNeighbor(tiles[x][y+1]);
            }
            addNeighbor(tiles[x+1][y]);
            addNeighbor(tiles[x-1][y]);
        }
        for(Tile t:neighbors)
        {
            t.updateNeighbors(tiles);
        }
    }

    public ArrayList<Tile> getExtendedNeighbors()
    {
        Log.i("getExtendedNeighbors", this.toString());
        ArrayList<Tile> eNeighbors = new ArrayList<>();
        for (Tile t: neighbors)
        {
            eNeighbors.add(t);
            ArrayList<Tile> temp = (ArrayList<Tile>) t.getNeighbors();
            for (Tile tt: temp){
                if(!eNeighbors.contains(tt))
                {
                    eNeighbors.add(tt);
                }
            }
        }
        eNeighbors.remove(this);
        return eNeighbors;
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

    public void setOffBoard(){
        location = new OffBoardPosition();
    }

    /**
     * This should only ever be called if the position is being changed via chaos
     *
     */
    public void setPosition(Position p)
    {
        location = p;
    }

    public Temple getTemple()
    {
        return myTemple;
    }

    public boolean isEmptyTile()
    {
        return false;
    }

    public String toString()
    {
        String result = "Tile at " + location.toString() +" "+ resonanceValues[resonance]+ " "+color;
        return result;
    }
}
