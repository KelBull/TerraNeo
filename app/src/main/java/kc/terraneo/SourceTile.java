package kc.terraneo;


/**
 * Created by Kelsey Bull on 2/1/2017.
 */

public class SourceTile extends Tile {

    public SourceTile()
    {
        super();
        artPath = "source_hex.png";
        isPassable = true;
    }

    /**
     *
     * @param radius the radius of the GameBoard
     */
    public SourceTile(int radius)
    {
        location = new Position(radius, radius);
    }
}
