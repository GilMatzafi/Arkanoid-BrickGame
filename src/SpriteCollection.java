import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called Point that represented points in the world by two dimensions.
 */

public class SpriteCollection {

    private List<Sprite> sprites;

    /**
     * This is constructor that initialize the sprite Collection.
     */

    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }


    /**
     * This is a method that add the sprite to the sprite Collection.
     *
     * @param s
     */

    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * This is a method that get Sprite and add remove him from the array list of Sprites.
     *
     * @param s
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * This is a method that call to all time passed on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites = new ArrayList<>(this.sprites);
        for (Sprite s : sprites) {
            s.timePassed();
        }
    }

    /**
     * This is a method that call drawOn(d) on all sprites.
     *
     * @param d
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }

}