package kc.terraneo;

import android.graphics.Color;

/**
 * Created by kcb11010 on 2/3/2017.
 */

public class IllegalTile extends Tile {

    public IllegalTile(GameBoard gB, Position p)
    {
        theBoard = gB;
        isPassable = false;
        hasPlayer = false;
        hasTemple = false;
        isSiphoned = false;
        artPath = "black_tile.png";
        color = Color.BLACK;
        location = p;
    }
}
