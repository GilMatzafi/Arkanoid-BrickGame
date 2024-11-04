
// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called CollisionInfo that represented a collison point and collision object.
 */

public class CollisionInfo {

    private Point collisionPoint;
    private Collidable collisionObject;


    /**
     * This is constructor that initialize the coordinates of the point.
     *
     * @param collisionPoint
     * @param collisionObject
     */

    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * this is a method that get the collison point.
     *
     * @return Point object.
     */

    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * this is a method that get the collision object.
     *
     * @return Collidable object.
     */

    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
