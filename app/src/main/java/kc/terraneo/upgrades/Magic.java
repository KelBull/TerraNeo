package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class Magic extends Upgrade {
    private String artPath;

    public Magic()
    {
        setCost(3);
        setName("Magic");
        artPath = "card_magic.png";
    }
}
