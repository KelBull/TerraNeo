package kc.terraneo;

/**
 * Created by iyaerP on 1/20/2017.
 */

public class Create extends MinorAction {
    Tile t;
    Position p;


    public Create(Tile _t, Position _p)
    {
        t= _t;
        p = _p;
    }

    @Override
    public void execute() {
        t.place(p);
    }
}
