import biuoop.DrawSurface;


// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This interface called Sprite that had two methods.
 */

public interface Sprite {


    /**
     * This is a method that draw the object to the screen.
     *
     * @param d
     */
    void drawOn(DrawSurface d);

    /**
     * This is a method that notify the sprite that time has passed.
     */
    void timePassed();
}
