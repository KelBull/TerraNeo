package kc.terraneo;

/**
 * Created by iyaerP on 1/20/2017.
 */

public class Refresh extends MinorAction {
    private Source s1;
    private Source s2;

    /**
     *
     * @param source1 the first source to shuffle
     * @param source2 the second source to shuffle
     */
    public Refresh(Source source1, Source source2)
    {
        s1 = source1;
        s2 = source2;
    }

    @Override
    public void execute() {
        s1.shuffle();
        s2.shuffle();
    }
}
