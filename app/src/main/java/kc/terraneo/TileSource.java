package kc.terraneo;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class TileSource extends Source {

    private Stack<Tile> theTiles;

    public TileSource(Tile[] tiles)
    {
        theTiles = new Stack<Tile>();
        for(int i=0; i<tiles.length; i++)
        {
            theTiles.push(tiles[i]);
        }
    }

    @Override
    public void shuffle() {
        ArrayList<Tile> temp = new ArrayList<Tile>();
        while(!theTiles.empty()) {
            temp.add(theTiles.pop());
        }

    }

    @Override
    public Tile pop() {
        return theTiles.pop();
    }


    public void push(Tile t) {
        theTiles.push(t);
    }

    public Tile peek()
    {
        return theTiles.peek();
    }
}
