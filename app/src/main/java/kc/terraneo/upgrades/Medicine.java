package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class Medicine extends Upgrade {
    private String artPath;

    public Medicine(){
        setCost(2);
        setName("Medicine");
        artPath = "card_medicine.png";
    }
}
