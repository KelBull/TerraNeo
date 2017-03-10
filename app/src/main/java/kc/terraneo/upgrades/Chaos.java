package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class Chaos extends Upgrade {
    private String artPath;

    public Chaos()
    {
        setCost(4);
        setName("Chaos");
        artPath = "card_chaos.png";
    }

}
