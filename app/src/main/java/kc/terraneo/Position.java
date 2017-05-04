package kc.terraneo;

/**
 * Created by Kelsey Bull on 1/27/2017.
 */

public class Position {
    private int x;
    private int y;

    public Position(int _x,int _y)
    {
        x = _x;
        y = _y;
    }

    public Position(Position p)
    {
        x = p.getX();
        y = p.getY();
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public boolean isOnBoard()
    {
        return true;
    }

    public boolean equals(Position p)
    {
        if(p.getX()==x && p.getY() == y)
        {
            return true;
        }else
        {
            return false;
        }
    }

    public String toString()
    {
        return "Position: "+x+", "+y;
    }
}
