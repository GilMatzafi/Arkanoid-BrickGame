import biuoop.DrawSurface;

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This interface called Animation.
 */

public interface Animation {


    /**
     * This method is in charge of the logic of the game,
     * and draw to screen one frame.
     *
     * @param d
     */

    void doOneFrame(DrawSurface d);

    /**
     * This method is in charge of stopping condition,
     * stop draw frames.
     *
     * @return boolean.
     */

    boolean shouldStop();
}

