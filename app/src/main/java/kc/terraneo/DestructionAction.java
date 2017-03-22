package kc.terraneo;

import kc.terraneo.upgrades.Destruction;

/**
 * Created by kcb11010 on 3/22/2017.
 */

public class DestructionAction extends MajorAction {

    private Tile target;
    private TileSource tarSource;

    public DestructionAction(Tile _target, TileSource _tarSource)
    {
        target = _target;
        tarSource = _tarSource;
    }

    @Override
    public void execute() {
        Position p = target.getLocation();
        target.setOffBoard();
        tarSource.push(target);
        EmptyTile t = new EmptyTile(p);
        target.getBoard().playTile(t);
    }

    /**
     * Checks if the tile selected is a valid target for destruction
     * @param _target the target tile
     * @return true if it is a valid target for destruction
     */
    public static boolean isValid(Tile _target)
    {
        if( _target.hasPlayerPawn()||_target.hasTemple()||_target.isSiphoned())
        {
            return false;
        }else{
            return true;
        }
    }
}
