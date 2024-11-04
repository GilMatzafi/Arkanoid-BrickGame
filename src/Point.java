
// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called Point that represented points in the world by two dimensions.
 */
public class Point {

    private double x;
    private double y;


    /**
     * This is constructor that initialize the coordinates of the point.
     *
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This is a set method for x point.
     *
     * @param x the method get object of Point.
     */

    public void setX(double x) {
        this.x = x;
    }

    /**
     * This is a set method for y point.
     *
     * @param y the method get object of Point.
     */

    public void setY(double y) {
        this.y = y;
    }

    /**
     * This is a method that calculate distance between two coordinates of the point.
     *
     * @param other the method get object of Point.
     * @return the method return double.
     */

    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
    }

    /**
     * This is a method that check if two points is equals.
     *
     * @param other the method get object of Point.
     * @return the method return boolean.
     */

    boolean equals(Point other) {
        double epsilon = Math.pow(10, -10);
        return (Math.abs(this.x - other.x) < epsilon) && (Math.abs(this.y - other.y) < epsilon);
    }

    /**
     * This is a method that give you x .
     *
     * @return the method return double.
     */

    public double getX() {
        return this.x;
    }

    /**
     * This is a method that give you y .
     *
     * @return the method return double.
     */

    public double getY() {
        return this.y;
    }


    /**
     * This is a method that give you y .
     *
     * @param l
     * @return boolean.
     */

    public boolean isPointOnLine(Line l) {

        Point p = new Point(this.getX(), l.getSlope() * this.getX() + l.getYIntercept());
        if (this.equals(p) || l.start().getX() == l.end().getX() && l.start().getX() == this.getX()) {
            return true;
        }
        return false;
    }
}

