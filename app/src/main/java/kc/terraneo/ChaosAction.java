package kc.terraneo;

/**
 * Created by kcb11010 on 3/22/2017.
 */

public class ChaosAction extends MajorAction {
    private Tile target1;
    private Tile target2;

    public ChaosAction(Tile tar1, Tile tar2)
    {
        target1 = tar1;
        target2 = tar2;
    }

    @Override
    public void execute() {
        Position tempPos1 = target1.getLocation();
        Position tempPos2 = target2.getLocation();
        target1.setPosition(tempPos2);
        target2.setPosition(tempPos1);
        target1.getBoard().playTile(target1);
        target2.getBoard().playTile(target2);
    }

    /**
     * returns true if the two tiles are valid to be swapped
     * @param tar1 the first tile to be swapped
     * @param tar2 the tile to swap with
     * @return true if they can be swapped
     */
    public static boolean isValid(Tile tar1, Tile tar2)
    {
        if(tar1.hasPlayerPawn()||tar1.hasTemple()||tar1.isSiphoned()||
                tar2.hasPlayerPawn()||tar2.hasTemple()||tar2.isSiphoned())
        {
            return false;
        }else{
            return true;
        }
    }
}
