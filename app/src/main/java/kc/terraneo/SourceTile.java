package kc.terraneo;


/**
 * Created by Kelsey Bull on 2/1/2017.
 */

public class SourceTile extends Tile {

    public SourceTile(GameBoard bG)
    {
        super();
        theBoard = bG;
        artPath = "source_hex.png";
        isPassable = true;
    }

    /**
     *
     * @param radius the radius of the GameBoard
     */
    public SourceTile(GameBoard bG, int radius)
    {
        super();
        theBoard = bG;
        artPath = "source_hex.png";
        isPassable = true;
        location = new Position(radius, radius);
    }
}
