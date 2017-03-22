package kc.terraneo;


/**
 * Created by iyaerP on 1/20/2017.
 */

public class PlaceTemple extends MajorAction {
    private Temple t;
    private Position p;
    private Player owner;

    public PlaceTemple(Player _owner, Position _p)
    {
        p = _p;
        owner = _owner;
    }

    @Override
    public void execute() {
        t.place(p);
    }
}
