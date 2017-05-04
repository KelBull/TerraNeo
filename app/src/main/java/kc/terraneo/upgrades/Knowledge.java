package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class Knowledge extends Upgrade {
    public Knowledge(){
        setCost(4);
        setName("Knowledge");
        artPath = "card_knowledge.png";
    }
}
