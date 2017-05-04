package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class Wealth extends Upgrade {
    public Wealth(){
        setCost(3);
        setName("Wealth");
        artPath = "card_wealth.png";
    }
}
