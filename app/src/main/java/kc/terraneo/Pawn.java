package kc.terraneo;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelsey Bull on 1/20/2017.
 */

class Pawn extends BoardObject {
    private int color;
    private Player owner;
    protected List<Tile> legalMoves = new ArrayList<Tile>();

    public Pawn(int playerColor, Player _owner)
    {
        location = theBoard.getSourceTile().getLocation();
        color = playerColor;
        owner = _owner;
    }

    /**
     *  updates the tile's location to the proposed destination if it is legal.
     * @param destination the tile that the pawn is trying to move to
     * @throws IllegalMoveException throws this error if the destination tile is not a legal move
     */
    public void move(Position destination) throws IllegalMoveException
    {
        updateLegalMoves();
        if(legalMoves.contains(theBoard.getTileAt(destination)))
        {
            theBoard.getTileAt(location).removePlayerPawn();
            location = destination;
            theBoard.getTileAt(destination).addPlayerPawn();
        }else{
            throw new IllegalMoveException("The tile at: "+destination.getX()+", "+destination.getY()+" was not a legal move.");
        }
        updateLegalMoves();
    }

    public void moveToTemple(Temple destination)
    {
        theBoard.getTileAt(location).removePlayerPawn();
        location = destination.getLocation();
        theBoard.getTileAt(location).addPlayerPawn();
        updateLegalMoves();
    }

    private void updateLegalMoves()
    {
        legalMoves.clear();
        List<Tile> possibleMoves = theBoard.getTileAt(location).getNeighbors();
        for (Tile t:possibleMoves){
            if(t.isPassable())
            {//checks if it is a passable tile
                if ((!t.hasTemple()) || (t.hasTemple() && t.getTemple().getOwner().equals(owner)) ||
                        (t.hasTemple() && owner.getGod().hasMagic()))
                {//check temple movement legality

                    if (!t.hasPlayerPawn() || (t.hasPlayerPawn() && owner.getGod().hasCrime()))
                    {//check for pawns
                        legalMoves.add(t);
                    }
                }
            }
        }
    }

    private class IllegalMoveException extends Exception {
        public IllegalMoveException(String s) {
            super(s);
        }
    }
}
