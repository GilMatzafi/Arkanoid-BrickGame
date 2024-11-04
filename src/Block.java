import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;


// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called Block that represent a rectangle and is specific Characteristics.
 */

public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private Color color;

    private List<HitListener> hitListeners;

    /**
     * This is constructor that initialize the block.
     *
     * @param rectangle
     * @param color
     */

    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * This is a method that return the rectangle of the block.
     *
     * @return Rectangle object
     */

    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * This is a method that return the new velocity of the ball after his hit in this block.
     *
     * @param collisionPoint
     * @param currentVelocity
     * @return Velocity object
     */

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        if (this.getCollisionRectangle().getRightLine()
                .isPointOnLineWithEdges(collisionPoint, this.getCollisionRectangle().getRightLine())
                || this.getCollisionRectangle().getLeftLine()
                .isPointOnLineWithEdges(collisionPoint, this.getCollisionRectangle().getLeftLine())) {
            this.notifyHit(hitter);
            return new Velocity(-(currentVelocity.getDx()), (currentVelocity.getDy()));

        } else {
            this.notifyHit(hitter);
            return new Velocity((currentVelocity.getDx()), -(currentVelocity.getDy()));
        }
    }


    /**
     * This is a method that draw the block to the screen.
     *
     * @param surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) Math.round(this.rectangle.getUpLine().start().getX()),
                (int) Math.round(this.rectangle.getUpLine().start().getY()),
                (int) Math.round(this.rectangle.getWidth()), (int) Math.round(this.rectangle.getHeight()));
        surface.setColor(Color.black);
        surface.drawRectangle((int) Math.round(this.rectangle.getUpLine().start().getX()),
                (int) Math.round(this.rectangle.getUpLine().start().getY()),
                (int) Math.round(this.rectangle.getWidth()), (int) Math.round(this.rectangle.getHeight()));

    }


    /**
     * This is a method that notify the sprite that time has passed.
     */

    public void timePassed() {
    }

    /**
     * This is a method that add the block to the game.
     *
     * @param g
     */

    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * This is a method that remove the block to the game.
     *
     * @param gameLevel
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * This is a method that add the block to the list of hit listener.
     *
     * @param hl the listener
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * This is a method that remove the block from the list of hit listener.
     *
     * @param hl the listener
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * This method notice that we changed the hit method to include a "Ball hitter" parameter -- update the
     * Collidable interface accordingly.
     *
     * @param hitter
     */

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
