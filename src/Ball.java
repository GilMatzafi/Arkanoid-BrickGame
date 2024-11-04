
import biuoop.DrawSurface;

import java.awt.Color;


// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called Ball that represent a ball with radios,color,middle point of the ball,velocity and limits.
 */

public class Ball implements Sprite {

    private Point center;
    private int r;

    private int leftLimit, rightLimit, upLimit, downLimit;
    private java.awt.Color color;

    private Velocity v;

    private GameEnvironment gameEnvironment;


    /**
     * This is constructor that initialize the ball.
     *
     * @param center
     * @param r
     * @param color
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }


    /**
     * This is method that return the x point of the ball.
     *
     * @return int.
     */

    public int getX() {
        return (int) Math.round(this.center.getX());
    }

    /**
     * This is method that return the y point of the ball.
     *
     * @return int.
     */

    public int getY() {
        return (int) Math.round(this.center.getY());
    }

    /**
     * This is method that set the limits of the ball.
     *
     * @param leftLimit
     * @param rightLimit
     * @param upLimit
     * @param downLimit
     */

    public void setLimit(int leftLimit, int rightLimit, int upLimit, int downLimit) {
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
        this.downLimit = downLimit;
        this.upLimit = upLimit;
    }

    /**
     * This is method that set the game enviorment for the ball.
     *
     * @param gameEnvironment
     */

    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * This is method that get the game enviorment for the ball.
     *
     * @return game enviorment object.
     */

    public GameEnvironment getGameEnviorment() {
        return this.gameEnvironment;
    }

    /**
     * This is method that return the size(radios) of the ball.
     *
     * @return int.
     */

    public int getSize() {
        return r;
    }

    /**
     * This is method that return the color of the ball.
     *
     * @return color.
     */

    public java.awt.Color getColor() {
        return color;
    }

    /**
     * This is method that set the velocity of the ball.
     *
     * @param dx
     * @param dy
     */

    public void setVelocity(double dx, double dy) {
        Velocity v = new Velocity(dx, dy);
        this.v = v;
    }

    /**
     * This is method that set the velocity of the ball.
     *
     * @param v
     */

    public void setVelocity(Velocity v) {
        this.v = v;
    }

    /**
     * This is method return the velocity of the ball.
     *
     * @return object of Velocity.
     */

    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * This is method return the left limit of the ball.
     *
     * @return int.
     */

    public int getLeftLimit() {
        return this.leftLimit;
    }

    /**
     * This is method return the right limit of the ball.
     *
     * @return int.
     */

    public int getRightLimit() {
        return this.rightLimit;
    }

    /**
     * This is method return the up limit of the ball.
     *
     * @return int.
     */

    public int getUpLimit() {
        return this.upLimit;
    }

    /**
     * This is method return the down limit of the ball.
     *
     * @return int.
     */

    public int getDownLimit() {
        return this.downLimit;
    }

    /**
     * This is method that move the ball one step on the screen.
     */

    public void moveOneStep() {
        CollisionInfo checkIfHit = this.gameEnvironment.getClosestCollision(computeBallTrajectory());
        //if there is no collision point move the ball to the end of the trajectory.
        if (checkIfHit == null) {
            this.center = this.getVelocity().applyToPoint(center);
        } else {
            //if there is a collision point in the corner of the rectangle.
            if (checkIfHit.collisionPoint()
                    .equals(checkIfHit.collisionObject().getCollisionRectangle().getUpLine().start())
                    || checkIfHit.collisionPoint()
                    .equals(checkIfHit.collisionObject().getCollisionRectangle().getUpLine().end())
                    || checkIfHit.collisionPoint()
                    .equals(checkIfHit.collisionObject().getCollisionRectangle().getDownLine().start())
                    || checkIfHit.collisionPoint()
                    .equals(checkIfHit.collisionObject().getCollisionRectangle().getDownLine().end())) {


                //move the ball to "almost" the hit point, but just slightly before it.
                if (this.center.getY() < checkIfHit.collisionPoint().getY()) {
                    this.center.setX(checkIfHit.collisionPoint().getX() - 1);
                }
                if (this.center.getY() > checkIfHit.collisionPoint().getY()) {
                    this.center.setX(checkIfHit.collisionPoint().getX() + 1);
                }
                if (this.center.getX() < checkIfHit.collisionPoint().getX()) {
                    this.center.setX(checkIfHit.collisionPoint().getX() - 1);
                }
                if (this.center.getX() > checkIfHit.collisionPoint().getX()) {
                    this.center.setX(checkIfHit.collisionPoint().getX() + 1);
                }
                //move the ball to "almost" the hit point, but just slightly before it.
            } else {
                if (checkIfHit.collisionPoint()
                        .isPointOnLine(checkIfHit.collisionObject().getCollisionRectangle().getLeftLine())) {
                    this.center.setX(checkIfHit.collisionPoint().getX() - 1);
                }

                if (checkIfHit.collisionPoint()
                        .isPointOnLine(checkIfHit.collisionObject().getCollisionRectangle().getRightLine())) {
                    this.center.setX(checkIfHit.collisionPoint().getX() + 1);
                }
                if (checkIfHit.collisionPoint()
                        .isPointOnLine(checkIfHit.collisionObject().getCollisionRectangle().getDownLine())) {
                    this.center.setY(checkIfHit.collisionPoint().getY() + 1);
                }

                if (checkIfHit.collisionPoint()
                        .isPointOnLine(checkIfHit.collisionObject().getCollisionRectangle().getUpLine())) {
                    this.center.setY(checkIfHit.collisionPoint().getY() - 1);
                }
            }
            //update the velocity to the new velocity returned by the hit() method.
            this.setVelocity(checkIfHit.collisionObject().hit(this, checkIfHit.collisionPoint(), v));
        }
    }

    /**
     * This is method that compute the ball trajectory
     * if there is no hit point.
     *
     * @return Line object.
     */

    public Line computeBallTrajectory() {
        return new Line(this.center.getX(), this.center.getY(), this.center.getX() + this.v.getDx(),
                this.center.getY() + this.v.getDy());

    }

    /**
     * This is method that print the ball on the screen.
     *
     * @param surface
     */

    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) Math.round(this.center.getX()), (int) Math.round(this.center.getY()), this.r);
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) Math.round(this.center.getX()), (int) Math.round(this.center.getY()), this.r);
    }


    /**
     * This is method that called to moveOneStep.
     */
    // notify the sprite that time has passed
    public void timePassed() {
        moveOneStep();
    }

    /**
     * This is method added the object to the game.
     *
     * @param g
     */

    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Remove the ball from the game.
     *
     * @param g the game
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}
