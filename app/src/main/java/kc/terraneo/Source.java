package kc.terraneo;

/**
 * Created by kcb11010 on 3/7/2017.
 */

public abstract class Source {
    /**
     * This method will shuffle or split the source deck
     */
    public abstract void shuffle();

    /**
     *
     * @return
     */
    public abstract Object pop();

    //public abstract void push(Object o);
}
