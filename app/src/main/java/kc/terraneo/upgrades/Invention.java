package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class Invention extends Upgrade {
    private String artPath;

    public Invention(){
        setCost(2);
        setName("Invention");
        artPath = "card_invention.png";
    }
}
