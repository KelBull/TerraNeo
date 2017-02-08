package kc.terraneo;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelsey Bull on 1/20/2017.
 */

class Pawn extends BoardObject {
    private Color c;
    private Player owner;
    protected List<Tile> legalMoves = new ArrayList<Tile>();

    public Pawn(Color playerColor, Player _owner)
    {
        location = theBoard.getSourceTile().getLocation();
        c = playerColor;
        owner = _owner;
    }

    /**
     *  updates the tile's location to the proposed destination if it is legal.
     * @param destination the tile that the pawn is trying to move to
     * @throws IllegalMoveException throws this error if the destination tile is not a legal move
     */
    public void move(Position destination) throws IllegalMoveException
    {
        if(legalMoves.contains(theBoard.getTileAt(destination)))
        {
            location = destination;
        }else{
            throw new IllegalMoveException("The tile at: "+destination.getX()+", "+destination.getY()+" was not a legal move.");
        }
        updateLegalMoves();
    }

    private void updateLegalMoves()
    {
        legalMoves.clear();
        List<Tile> possibleMoves = theBoard.getTileAt(location).getNeighbors();
        for (Tile t:possibleMoves){
            if(t.isPassable()||(t.hasTemple()&&owner.getGod().hasMagic)||(t.hasPlayerPawn()&&owner.getGod().hasCrime))
            {
                legalMoves.add(t);
            }
        }
    }

    private class IllegalMoveException extends Exception {
        public IllegalMoveException(String s) {
            super(s);
        }
    }
}
