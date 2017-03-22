package kc.terraneo;

/**
 * Created by kcb11010 on 3/22/2017.
 */

public class MedicineAction extends MinorAction {
    Tile target;
    Pawn thePawn;

    /**
     *
     * @param _target the tile to be unsiphoned
     * @param _pawn the pawn that will be doing the action
     */
    public MedicineAction(Tile _target, Pawn _pawn)
    {

    }
    @Override
    public void execute() {

    }

    public static  boolean isValid(Tile t, Pawn p)
    {
        if(t.isSiphoned()&&(p.getBoard().getTileAt(p.getLocation()).getNeighbors().contains(t)||
        p.getBoard().getTileAt(p.getLocation()).hasTemple()&& p.getBoard().getTileAt(p.getLocation()).getExtendedNeighbors().contains(t)))
        {
            return true;
        }else{
            return false;
        }
    }
}
