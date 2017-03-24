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
        target = _target;
        thePawn = _pawn;
    }
    @Override
    public void execute() {
        target.unsiphon();
    }

    /**
     * checks the validity of using medicine on the target tile from the chosen pawn
     * @param t the tile to be unsiphoned
     * @param p the pawn that will unsiphon it
     * @return true if this is a valid action, false otherwise
     */
    public static  boolean isValid(Tile t, Pawn p)
    {
        if(t.isSiphoned()&&p.isInRange(t))
        {
            return true;
        }else{
            return false;
        }
    }
}
