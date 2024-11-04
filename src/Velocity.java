
// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called Velocity that specifies the change in position on the `x` and the `y` axes.
 */

public class Velocity {

    private double dx;
    private double dy;


    /**
     * This is constructor that initialize the velocity.
     *
     * @param dx
     * @param dy
     */

    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }


    /**
     * This is method that return the dx of the velocity.
     *
     * @return double.
     */

    public double getDx() {
        return this.dx;
    }

    /**
     * This is method that return the dy of the velocity.
     *
     * @return double.
     */

    public double getDy() {
        return this.dy;
    }

    /**
     * This is method that calculate angel and speed.
     *
     * @param angle
     * @param speed
     * @return object of velocity.
     */

    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * (Math.sin(Math.toRadians(angle)));
        double dy = -1 * speed * (Math.cos(Math.toRadians(angle)));
        return new Velocity(dx, dy);
    }

    /**
     * This is method that set dx.
     *
     * @param dx
     */


    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * This is method that set dy.
     *
     * @param dy
     */


    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * This is method that Take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy).
     *
     * @param p
     * @return object of Point.
     */

    public Point applyToPoint(Point p) {
        Point newPoint = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return newPoint;
    }

    /**
     * This is method that return the angle.
     *
     * @return double.
     */

    public double getAngle() {
        return (Math.toDegrees(Math.atan2(this.getDy(), this.getDx())) + 90);
    }

    /**
     * This is method that return the speed.
     *
     * @return double.
     */

    public double getSpeed() {
        double insideRoot = (Math.pow(dx, 2) + Math.pow(dy, 2));
        return Math.sqrt(insideRoot);
    }

    /**
     * This is method that calculate the speed.
     *
     * @return double.
     */

    public double speedFromVelocityFormula() {
        double res = Math.sqrt(Math.pow(getDx(), 2) + Math.pow(getDy(), 2));
        return res;
    }

}
