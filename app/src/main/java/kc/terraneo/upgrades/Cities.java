package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class Cities extends Upgrade {
    private String artPath;

    public Cities(){
        setCost(3);
        setName("Cities");
        artPath = "card_cities.png";
    }
}
