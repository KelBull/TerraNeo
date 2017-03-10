package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class Destruction extends Upgrade {
    private String artPath;

    public Destruction(){
        setCost(3);
        setName("Destruction");
        artPath = "card_destruction.png";
    }
}
