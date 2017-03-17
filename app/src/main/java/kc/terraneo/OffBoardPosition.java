package kc.terraneo;

/**
 * Created by kcb11010 on 3/17/2017.
 */

public class OffBoardPosition extends Position {
    public OffBoardPosition() {
        super(-1, -1);
    }

    @Override
    public boolean isOnBoard() {
        return false;
    }
}
