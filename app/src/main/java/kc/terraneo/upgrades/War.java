package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class War extends Upgrade {

    public War()
    {
        setCost(4);
        setName("War");
        artPath = "card_war.png";
    }
}
