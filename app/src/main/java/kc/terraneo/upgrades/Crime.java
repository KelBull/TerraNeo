package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class Crime extends Upgrade {

    public Crime()
    {
        setCost(2);
        setName("Crime");
        artPath = "card_crime.png";
    }
}
