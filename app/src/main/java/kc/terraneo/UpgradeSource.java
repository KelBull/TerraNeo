package kc.terraneo;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public class UpgradeSource extends Source {

    private Stack<Upgrade> theUpgrades;

    public UpgradeSource(Upgrade[] Upgrades)
    {
        theUpgrades = new Stack<Upgrade>();
        for(int i=0; i<Upgrades.length; i++)
        {
            theUpgrades.push(Upgrades[i]);
        }
        shuffle();
    }

    @Override
    public void shuffle() {
        Collections.shuffle(theUpgrades);
    }

    @Override
    public Upgrade pop() {
        return theUpgrades.pop();
    }


    public void push(Upgrade t) {
        theUpgrades.push(t);
    }

    public Upgrade peek()
    {
        return theUpgrades.peek();
    }
}
