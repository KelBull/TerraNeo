package kc.terraneo;

/**
 * Created by Kelsey Bull on 1/27/2017.
 */

public class GameBoard {
    private int numPlayers;
    private int radius;
    private int gridSide;
    private Tile[][] tiles;
    private int scaledSize;


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
            //default: throw new IllegalPlayerCountException("Illegal player count "+ _numPlayers +" is not a legal player count");

        }
        gridSide = 2*radius+1;
        tiles = new Tile[gridSide][gridSide];
        scaledSize = 0;
        for(int i=0; i< gridSide; i++)
        {
            for(int j=0; j<gridSide; j++)
            {
                if(i != radius && j != radius)
                {
                    tiles[i][j] = new EmptyTile(new Position(i,j));
                }else{
                    tiles[radius][radius] = new SourceTile();
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
        int x = t.getLocation().getX();
        int y = t.getLocation().getY();
        tiles[x][y] = t;

        if(x%2==0)
        {//evens columns
            if(x == 0)
            {
                t.addNeighbor(tiles[x+1][y]);
                if(y!=0)
                {
                    t.addNeighbor(tiles[x][y-1]);
                }
                if(y!=gridSide-1)
                {
                    t.addNeighbor(tiles[x][y+1]);
                    t.addNeighbor(tiles[x+1][y+1]);
                }
            }else{//done the 0 column

                if (x == gridSide - 1) {
                    t.addNeighbor(tiles[x - 1][y]);
                    if(y!=0)
                    {
                        t.addNeighbor(tiles[x][y-1]);
                    }
                    if(y!=gridSide-1)
                    {
                        t.addNeighbor(tiles[x][y+1]);
                        t.addNeighbor(tiles[x-1][y+1]);
                    }
                }else{//done the far right column, doing all normal even columns

                    if(y !=0 )
                    {
                        t.addNeighbor(tiles[x][y-1]);
                    }
                    if(y != gridSide-1)
                    {
                        t.addNeighbor(tiles[x][y+1]);
                        t.addNeighbor(tiles[x+1][y+1]);
                        t.addNeighbor(tiles[x-1][y+1]);
                    }
                    t.addNeighbor(tiles[x-1][y]);
                    t.addNeighbor(tiles[x+1][y]);
                }
            }
        }else{//odd columns
            if(y!=0)
            {
                t.addNeighbor(tiles[x][y-1]);
                t.addNeighbor(tiles[x-1][y-1]);
                t.addNeighbor(tiles[x+1][y-1]);
            }
            if(y != gridSide-1)
            {
                t.addNeighbor(tiles[x][y+1]);
            }
            t.addNeighbor(tiles[x+1][y]);
            t.addNeighbor(tiles[x-1][y]);
        }
        for(Tile _t: t.getNeighbors())
        {
            _t.addNeighbor(t);
        }
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
    
    public void setScaledSize(int r)
    {
        scaledSize = r;
    }

    public int getScaledSize()
    {
        return scaledSize;
    }
}
