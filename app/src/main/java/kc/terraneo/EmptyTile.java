package kc.terraneo;

/**
 * Created by Kelsey Bull on 2/1/2017.
 */

public class EmptyTile extends Tile {

    public EmptyTile(GameBoard gB, Position p)
    {
        super();
        theBoard = gB;
        location = p;
        artPath = "black_tile.png";
    }

    public boolean isEmptyTile()
    {
        return true;
    }
}
