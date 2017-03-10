package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class Death extends Upgrade {
    private String artPath;

    public Death(){
        setCost(4);
        setName("Death");
        artPath = "card_death.png";
    }
}
