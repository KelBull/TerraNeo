package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class Time extends Upgrade {
    private String artPath;

    public Time(){
        setCost(4);
        setName("Time");
        artPath = "card_time.png";
    }
}
