package kc.terraneo.upgrades;

import kc.terraneo.Upgrade;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class Games extends Upgrade {

    public Games(){
        setCost(3);
        setName("Games");
        artPath = "card_games.png";
    }
}
