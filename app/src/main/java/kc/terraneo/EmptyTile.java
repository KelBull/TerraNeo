package kc.terraneo;

/**
 * Created by Kelsey Bull on 2/1/2017.
 */

public class EmptyTile extends Tile {

    public EmptyTile(Position p)
    {
        super();
        position = p;
        artPath = "black_tile.png";
    }

    public boolean isEmptyTile()
    {
        return true;
    }
}
