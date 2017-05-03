package kc.terraneo;

import android.util.Log;

/**
 * Created by Kelsey Bull on 1/27/2017.
 */

public class GameBoard {
    private int numPlayers;
    private int radius;
    private int gridSide;
    private Tile[][] tiles;
    private int scaledSize;
    private float tileRadius = 30;

    public float getTileRadius() {
        return tileRadius;
    }

    public void setTileRadius(float tileRadius) {
        this.tileRadius = tileRadius;
    }

    /**
     * Creates a new GameBoard
     * @param _numPlayers the number of players in the game, between 2 and 6 inclusive
     * @throws IllegalPlayerCountException if there aren't a legal number of players
     */
    public GameBoard(int _numPlayers)
    {
        numPlayers = _numPlayers;
        switch(_numPlayers){
            case 2: radius = 3;
                break;
            case 3: radius = 3;
                break;
            case 4: radius = 4;
                break;
            case 5: radius = 5;
                break;
            case 6: radius = 5;
                break;

        }
        gridSide = 2*radius+1;
        tiles = new Tile[gridSide][gridSide];
        scaledSize = 0;
        for(int i=0; i< gridSide; i++)
        {
            for(int j=0; j<gridSide; j++)
            {
                if(i==radius&&j==radius)
                {
                    tiles[radius][radius] = new SourceTile(radius);
                }else {
                    tiles[i][j] = new EmptyTile(this, new Position(i, j));
                }
            }
        }
    }

    /**
     * Places a new tile and gives it its neighbors
     * @param t the tile to place
     */
    public void playTile(Tile t)
    {
        Log.i("GameBoard Playing Tile:", toString());
        int x = t.getLocation().getX();
        int y = t.getLocation().getY();
        tiles[x][y] = t;

        //t.updateNeighbors(tiles);
    }

    public void movePawn(Pawn p, Position destination)
    {
        try{
            Position previous = p.getLocation();
            p.move(destination);
            tiles[destination.getX()][destination.getY()].addPlayerPawn();
            tiles[previous.getX()][previous.getY()].removePlayerPawn();
        }catch(Exception e){
            //do something later
        }
    }

    public Tile getSourceTile()
    {
        return tiles[radius][radius];
    }

    public Tile getTileAt(int x, int y)
    {
        return tiles[x][y];
    }

    public int getRadius(){return radius;}

    public Tile getTileAt(Position p)
    {
        return tiles[p.getX()][p.getY()];
    }

    private class IllegalPlayerCountException extends Exception {
        public IllegalPlayerCountException(String s) {
            super(s);
        }
    }

    public int getPlayerCount()
    {
        return numPlayers;
    }

    public int getGridSide(){return gridSide;}

    public void setScaledSize(int r)
    {
        scaledSize = r;
    }

    public int getScaledSize()
    {
        return scaledSize;
    }
}
