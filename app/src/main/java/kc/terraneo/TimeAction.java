package kc.terraneo;


/**
 * Created by kcb11010 on 3/22/2017.
 */

public class TimeAction extends MajorAction {
    private Tile target;
    private TileSource sourceTarget;

    /**
     *
     * @param tar the Tile to be replaced
     * @param sourceTar the Tile Source that is having its top tile swapped with tar
     */
    public TimeAction(Tile tar, TileSource sourceTar)
    {
        target = tar;
        sourceTarget = sourceTar;
    }

    @Override
    public void execute() {
        Position p = target.getLocation();
        Tile temp = sourceTarget.pop();
        target.setOffBoard();
        sourceTarget.push(target);
        temp.place(p);
    }
}
