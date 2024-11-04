
import java.util.ArrayList;
import java.util.List;


// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called Point that represented points in the world by two dimensions.
 */

public class Rectangle {

    private double width;
    private double height;
    private Point upperLeft;
    private Line upLine, downLine, rightLine, leftLine;


    /**
     * This is constructor that initialize the rectangle.
     *
     * @param upperLeft
     * @param width
     * @param height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        setLines(upperLeft, width, height);
    }


    /**
     * This is a method that give you a list of intersectionPoints with the rectangle.
     *
     * @param line the method get object of Point.
     * @return List objects points.
     */

    public java.util.List<Point> intersectionPoints(Line line) {
        Line[] lines = toArray(upLine, downLine, rightLine, leftLine);
        List<Point> intersectionPoints = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            if (line.isVerticalToX() && lines[i].isVerticalToX()) {
                if (line.isUnifiedCaseForVerticalToX(lines[i])) {
                    return intersectionPoints;
                }
            }
            if (!line.isVerticalToX() && !lines[i].isVerticalToX()) {
                if (line.getSlope() == lines[i].getSlope() && line.getYIntercept() == lines[i].getYIntercept()) {
                    if (line.isUnified(lines[i])) {
                        return intersectionPoints;
                    }
                }
            }
        }

        for (int i = 0; i < lines.length; i++) {
            if (line.intersectionWith(lines[i]) != null) {
                double x = line.intersectionWith(lines[i]).getX();
                double y = line.intersectionWith(lines[i]).getY();
                Point intersectionPoint = new Point(x, y);
                for (int j = 0; j < intersectionPoints.size(); j++) {
                    if (intersectionPoints.get(j).equals(intersectionPoint)) {
                        return intersectionPoints;
                    }
                }
                intersectionPoints.add(intersectionPoint);
            }
        }
        return intersectionPoints;
    }


    /**
     * This is a method that give return the width of rectangle.
     *
     * @return double.
     */

    public double getWidth() {
        return this.width;
    }

    /**
     * This is a method that give return the height of rectangle.
     *
     * @return double.
     */

    public double getHeight() {
        return this.height;
    }

    /**
     * This is a method that give return the  up left point of rectangle.
     *
     * @return double.
     */

    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * This is a method that give return the  up line of rectangle.
     *
     * @return double.
     */

    public Line getUpLine() {
        return this.upLine;
    }

    /**
     * This is a method that give return the down line of rectangle.
     *
     * @return double.
     */

    public Line getDownLine() {
        return this.downLine;
    }

    /**
     * This is a method that give return the left line of rectangle.
     *
     * @return double.
     */

    public Line getLeftLine() {
        return this.leftLine;
    }

    /**
     * This is a method that give return the right line of rectangle.
     *
     * @return double.
     */

    public Line getRightLine() {
        return this.rightLine;
    }

    /**
     * This is a method that set the lines of rectangle.
     *
     * @param height
     * @param upperLeft
     * @param width
     */

    public void setLines(Point upperLeft, double width, double height) {
        this.upLine = new Line(upperLeft.getX(), upperLeft.getY(),
                upperLeft.getX() + width, upperLeft.getY());

        this.downLine = new Line(upperLeft.getX(), upperLeft.getY() + height,
                upperLeft.getX() + width, upperLeft.getY() + height);

        this.rightLine = new Line(upperLeft.getX() + width, upperLeft.getY(),
                upperLeft.getX() + width, upperLeft.getY() + height);

        this.leftLine = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX(),
                upperLeft.getY() + height);
    }

    /**
     * This is a method that return the borderlines of rectanle in an array.
     *
     * @param upLine
     * @param downLine
     * @param rightLine
     * @param leftLine
     * @return an array of Line objects.
     */


    public Line[] toArray(Line upLine, Line downLine, Line rightLine, Line leftLine) {
        Line[] lines = new Line[4];
        lines[0] = upLine;
        lines[1] = downLine;
        lines[2] = rightLine;
        lines[3] = leftLine;
        return lines;
    }
}
