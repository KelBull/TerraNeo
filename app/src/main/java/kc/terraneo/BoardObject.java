package kc.terraneo;

/**
 * Created by Kelsey Bull on 1/20/2017.
 */

abstract class BoardObject {
    protected Position location; //may be null if the object hasn't been placed on the board yet
    protected String artPath;
    protected GameBoard theBoard;

    public Position getLocation()
    {
        return location;
    }

    public String getArtPath()
    {
        return artPath;
    }
}
