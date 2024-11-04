
// 318597879 Gil Matzafi


/**
 * @author Gil Matzafi
 * This interface called Collidable that had two methods to impliment.
 */

public interface Collidable {

    /**
     * This is a method that return the "collision shape" of the object.
     *
     * @return Rectangle object
     */
    Rectangle getCollisionRectangle();

    /**
     * This is a method that return the new velocity of the ball after his hit in this object.
     *
     * @param collisionPoint
     * @param currentVelocity
     * @param hitter
     * @return Velocity object
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

}