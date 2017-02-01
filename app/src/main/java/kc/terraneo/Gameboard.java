package kc.terraneo;

/**
 * Created by Kelsey Bull on 1/27/2017.
 */

public class GameBoard {
    private int numPlayers;
    private int radius;
    private int gridSide;
    private Tile[][] tiles;

    /**
     *
     */
    public GameBoard(int _numPlayers) throws IllegalPlayerCountException {
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
            default: throw new IllegalPlayerCountException("Illegal player count "+ _numPlayers +" is not a legal player count");

        }
        gridSide = 2*radius+1;
        tiles = new Tile[gridSide][gridSide];

        for(int i=0; i< gridSide; i++)
        {
            for(int j=0; j<gridSide; j++)
            {
                tiles[i][j] = new EmptyTile(new Position(i,j));
            }
        }
        tiles[radius][radius] = new SourceTile();
    }

    private class IllegalPlayerCountException extends Exception {
        public IllegalPlayerCountException(String s) {
            super(s);
        }
    }
}
