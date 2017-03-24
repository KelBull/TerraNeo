package kc.terraneo;

/**
 * Created by iyaerP on 1/20/2017.
 */

public class Create extends MinorAction {
    Tile target;
    Position p;
    Pawn owner;


    public Create(Tile _t, Position _p, Pawn _owner)
    {
        target= _t;
        p = _p;
        owner = _owner;
    }

    @Override
    public void execute() {
        target.place(p);
    }


    public static boolean isValid(Tile _target, Position _p, Pawn _owner)
    {
        if(_owner.isInRange(_target) && _owner.getBoard().getTileAt(_p).isEmptyTile())
        {
            return true;
        }else{
            return false;
        }

    }
}
