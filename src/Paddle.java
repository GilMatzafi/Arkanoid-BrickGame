import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called Paddle that represent a paddle with keybors sensor and rectangle.
 */

public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle paddle;

    private int speed;


    private int rightBorder, leftBorder;

    /**
     * This is constructor that initialize the paddle.
     *
     * @param paddle
     * @param speed
     */

    public Paddle(Rectangle paddle, int speed) {
        this.paddle = paddle;
        this.rightBorder = 780;
        this.leftBorder = 20;
        this.speed = speed;
    }

    /**
     * This is a method that set the keyboard to the paddle.
     *
     * @param keyboard
     */

    public void setKeyboard(KeyboardSensor keyboard) {
        this.keyboard = keyboard;
    }

    /**
     * This is a method that return the left border of the paddle.
     *
     * @return int
     */

    public int getLeftBorder() {
        return leftBorder;
    }


    /**
     * This is a method that return the right border of the paddle.
     *
     * @return int
     */

    public int getRightBorder() {
        return rightBorder;
    }

    /**
     * This is a method that set the paddle by the point upperLeft of rectangle.
     *
     * @param upperLeft
     */

    public void setPaddle(Point upperLeft) {
        this.paddle = new Rectangle(upperLeft, this.paddle.getWidth(), this.paddle.getHeight());
    }

    /**
     * This is a method that moving left the paddle.
     */

    public void moveLeft() {

        if (this.paddle.getLeftLine().start().getX() >= this.leftBorder) {
            Point upperLeft = new Point(this.paddle.getUpperLeft().getX()
                    - this.speed, this.paddle.getUpperLeft().getY());
            this.setPaddle(upperLeft);
        }
    }

    /**
     * This is a method that moving right the paddle.
     */

    public void moveRight() {
        if (this.paddle.getRightLine().start().getX() <= this.rightBorder) {
            Point upperLeft = new Point(this.paddle.getUpperLeft().getX()
                    + this.speed, this.paddle.getUpperLeft().getY());
            this.setPaddle(upperLeft);
        }
    }

    /**
     * This is a method that make the paddle move.
     */

    // Sprite
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
    }

    /**
     * This is method that print the paddle on the screen.
     *
     * @param d
     */

    public void drawOn(DrawSurface d) {
        d.setColor(Color.orange);
        d.fillRectangle((int) Math.round(this.paddle.getUpLine().start().getX()),
                (int) Math.round(this.paddle.getUpLine().start().getY()),
                (int) Math.round(this.paddle.getWidth()), (int) Math.round(this.paddle.getHeight()));
        d.setColor(Color.black);
        d.drawRectangle((int) Math.round(this.paddle.getUpLine().start().getX()),
                (int) Math.round(this.paddle.getUpLine().start().getY()),
                (int) Math.round(this.paddle.getWidth()), (int) Math.round(this.paddle.getHeight()));
    }

    /**
     * This is a method that return the rectangle of the paddle.
     *
     * @return Rectangle object
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    /**
     * This is a method that return the new velocity of the ball after his hit in this paddle.
     *
     * @param collisionPoint
     * @param currentVelocity
     * @return Velocity object
     */

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        if (this.getRegion(collisionPoint) == -1) {
            return null;
        }
        if (this.getRegion(collisionPoint) == 1) {
            return Velocity.fromAngleAndSpeed(300, currentVelocity.speedFromVelocityFormula());
        }
        if (this.getRegion(collisionPoint) == 2) {
            return Velocity.fromAngleAndSpeed(330, currentVelocity.speedFromVelocityFormula());
        }
        if (this.getRegion(collisionPoint) == 3) {
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        if (this.getRegion(collisionPoint) == 4) {
            return Velocity.fromAngleAndSpeed(60, currentVelocity.speedFromVelocityFormula());
        }
        if (this.getRegion(collisionPoint) == 5) {
            return Velocity.fromAngleAndSpeed(30, currentVelocity.speedFromVelocityFormula());
        }
        return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
    }


    /**
     * This is a method that add the paddle to the game.
     *
     * @param g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * This method is give the paddle area.
     *
     * @param collisionPoint
     * @return - int
     */
    public int getRegion(Point collisionPoint) {
        if (collisionPoint.getX() >= this.paddle.getUpLine().start().getX()
                && collisionPoint.getX() <= this.paddle.getUpLine().length()
                * ((double) 1 / 5) + this.paddle.getUpLine().start().getX()) {
            return 1;
        } else if (collisionPoint.getX() > this.paddle.getUpLine().length()
                * ((double) 1 / 5) + this.paddle.getUpLine().start().getX()
                && collisionPoint.getX() <= this.paddle.getUpLine().length()
                * ((double) 2 / 5) + this.paddle.getUpLine().start().getX()) {
            return 2;
        } else if (collisionPoint.getX() > this.paddle.getUpLine().length()
                * ((double) 2 / 5) + this.paddle.getUpLine().start().getX()
                && collisionPoint.getX() <= this.paddle.getUpLine().length()
                * ((double) 3 / 5) + this.paddle.getUpLine().start().getX()) {
            return 3;
        } else if (collisionPoint.getX() > this.paddle.getUpLine().length()
                * ((double) 3 / 5) + this.paddle.getUpLine().start().getX()
                && collisionPoint.getX() <= this.paddle.getUpLine().length()
                * ((double) 4 / 5) + this.paddle.getUpLine().start().getX()) {
            return 4;
        } else if (collisionPoint.getX() > this.paddle.getUpLine().length()
                * ((double) 4 / 5) + this.paddle.getUpLine().start().getX()
                && collisionPoint.getX() <= this.paddle.getUpLine().length()
                + this.paddle.getUpLine().start().getX()) {
            return 5;
        }
        return 0;
    }
}