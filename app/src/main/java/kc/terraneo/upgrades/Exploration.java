package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class Exploration extends Upgrade {
    private String artPath;

    public Exploration(){
        setCost(2);
        setName("Exploration");
        artPath = "card_exploration.png";
    }
}
