package kc.terraneo;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public abstract class Upgrade {

    protected String artPath;
    protected int cost;
    protected String name;

    public int getCost()
    {
        return cost;
    };

    public String getName()
    {
        return name;
    };

    public String getArtPath() {return  artPath;};

    protected void setName(String n)
    {
        name = n;
    }

    protected void setCost(int i)
    {
        cost = i;
    }
}
