package kc.terraneo;

/**
 * Created by kcb11010 on 3/22/2017.
 */

public class InventionAction extends MinorAction {
    private Temple target;
    private Pawn mover;

    public InventionAction(Temple _target, Pawn _mover)
    {
        mover = _mover;
        target = _target;
    }
    @Override
    public void execute() {
        mover.moveToTemple(target);
    }
}
