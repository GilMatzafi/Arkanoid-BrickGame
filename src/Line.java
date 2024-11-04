

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called Line that represented two points in the world by two dimensions.
 */


public class Line {

    private Point start;
    private Point end;

    /**
     * This is constructor that initialize the points of the line.
     *
     * @param start
     * @param end
     */

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * This is constructor that initialize the points of the line.
     *
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     */

    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * This method calculate the length of the line.
     *
     * @return the method return a double.
     */

    public double length() {
        return Math.sqrt((Math.pow((this.start.getX() - this.end.getX()), 2))  //root of ((x1-x2)^2)+((y1-y2)^2)
                + (Math.pow((this.start.getY() - this.end.getY()), 2)));

    }


    /**
     * This method calculate the middle point of the line.
     *
     * @return the method return a class of Point.
     */

    public Point middle() {
        double middleOfx = (this.start.getX() + this.end.getX()) / 2; //(x1+x2)/2
        double middleOfy = (this.start.getY() + this.end.getY()) / 2; //(y1+y2)/2
        Point middle = new Point(middleOfx, middleOfy);
        return middle;
    }


    /**
     * This method return the start point of the line.
     *
     * @return the method return an object of Point.
     */

    public Point start() {
        return this.start;
    }

    /**
     * This method return the end point of the line.
     *
     * @return the method return an object of Point.
     */

    public Point end() {
        return this.end;
    }

    /**
     * This method return the slope of the line.
     *
     * @return the method return a double.
     */

    //if divide by zero-need to do something.
    public double getSlope() {
        return (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()); //(y2-y1)/(x2-x1)
    }

    /**
     * This method return the YIntercept of the line.
     *
     * @return the method return a double.
     */

    public double getYIntercept() {
        return (this.start.getY() - (this.getSlope() * this.start.getX())); //b=y-m*x
    }

    /**
     * This method check if two line is equals.
     *
     * @param other
     * @return the method return a boolean.
     */

    public boolean equals(Line other) {
        if ((this.start.equals(other.start) && (this.end.equals(other.end)))) {
            return true;
        }
        return false;
    }

    /**
     * This method check if line is vertical to X.
     *
     * @return the method return a boolean.
     */

    public boolean isVerticalToX() {
        if ((this.end.getX() - this.start.getX()) == 0) {
            return true;
        }
        return false;
    }

    /**
     * This method check if two line is parallel.
     *
     * @param other
     * @return the method return a boolean.
     */

    public boolean isParallel(Line other) {
        if (this.getSlope() == other.getSlope()) {
            if (this.getYIntercept() == other.getYIntercept()) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * This method check if two line that vertical to x is parallel.
     *
     * @param other
     * @return the method return a boolean.
     */

    public boolean twoLinesIsVerticalToXisParallel(Line other) {
        if (this.isVerticalToX() && other.isVerticalToX()) {
            if (this.start().getX() == other.start().getX()) {
                return false;
            }
        }
        return true;
    }


    /**
     * This method calculate the point of intersection of two lines.
     *
     * @param other
     * @return the method return a Point.
     */

    public Point pointOfLinearIntersection(Line other) {
        if (!isParallel(other)) {
            // x=(b2-b1)/(m1-m2)
            double x = ((other.getYIntercept()) - (this.getYIntercept())) / ((this.getSlope()) - (other.getSlope()));
            //y1=m1*x+b1
            double y = (x * this.getSlope()) + this.getYIntercept();
            Point pointOfLinearIntersection = new Point(x, y);
            return pointOfLinearIntersection;
        }
        return null;
    }

    /**
     * This method check if point is between two segments.
     *
     * @param point
     * @param other
     * @return the method return a boolean.
     */

    public boolean onSegment(Point point, Line other) {
        if ((isPointOnLineWithEdges(point, this) && isPointOnLineWithEdges(point, other))) {
            return true;
        }
        return false;
    }


    /**
     * This method check if point is between two segments with edges.
     *
     * @param point
     * @param other
     * @return the method return a boolean.
     */

    public boolean isPointOnLineWithEdges(Point point, Line other) {
        if ((((other.start.getX() <= point.getX()) && (point.getX() <= other.end.getX()))
                || ((other.start.getX() >= point.getX()) && (point.getX() >= other.end.getX())))) {
            return true;
        }
        return false;
    }


    /**
     * This method check if point is between two segments without edges.
     *
     * @param point
     * @param other
     * @return the method return a boolean.
     */

    public boolean isPointOnLineWithoutEdges(Point point, Line other) {
        if ((((other.start.getX() < point.getX()) && (point.getX() < other.end.getX()))
                || ((other.start.getX() > point.getX()) && (point.getX() > other.end.getX())))) {
            return true;
        }
        return false;
    }

    /**
     * This method check if two segments is intersecting.
     *
     * @param other
     * @return the method return a boolean.
     */

    public boolean isIntersecting(Line other) {
        if (!this.twoLinesIsVerticalToXisParallel(other)) {
            if (this.isUnifiedCaseForVerticalToX(other)) {
                return true;
            }
            if (this.intersectionPointIfTwoLinesVerticalToXAndDontUnified(other) != null) {
                return true;
            }
            return false;
        }

        if (this.isVerticalToX()) {
            if (!other.isVerticalToX()) {
                if (this.intersectionPointIfOneLineVerticalToX(other) != null) {
                    return true;
                }
            }
            return false;
        }
        if (other.isVerticalToX()) {
            if (!this.isVerticalToX()) {
                if (other.intersectionPointIfOneLineVerticalToX(this) != null) {
                    return true;
                }
            }
            return false;
        }
        if (this.isParallel(other)) {
            return false;
        }
        if (this.getSlope() == other.getSlope()) {
            if (this.getYIntercept() == other.getYIntercept()) {
                if (this.isUnified(other)) {
                    return true;
                }
                if (this.intersectionPointIfTwoLinesParllalToSameYAndDontUnified(other) != null) {
                    return true;
                }
            }
        }
        if ((onSegment(pointOfLinearIntersection(other), other))) {
            return true;
        }
        return false;
    }

    /**
     * This method return the point of intersection between two segments.
     *
     * @param other
     * @return the method return a Point.
     */

    public Point intersectionWith(Line other) {
        if (this.isVerticalToX() && !other.isVerticalToX()
                && this.intersectionPointIfOneLineVerticalToX(other) != null) {
            Point intersectionPoint = new Point(this.intersectionPointIfOneLineVerticalToX(other).getX(),
                    this.intersectionPointIfOneLineVerticalToX(other).getY());
            return intersectionPoint;
        }
        if (other.isVerticalToX() && !this.isVerticalToX()
                && other.intersectionPointIfOneLineVerticalToX(this) != null) {
            Point intersectionPoint = new Point(other.intersectionPointIfOneLineVerticalToX(this).getX(),
                    other.intersectionPointIfOneLineVerticalToX(this).getY());
            return intersectionPoint;
        }
        if (other.isVerticalToX() && this.isVerticalToX()
                && !this.isUnifiedCaseForVerticalToX(other) && this.start.getX() == other.start.getX()) {
            Point intersectionPoint = new Point(this.intersectionPointIfTwoLinesVerticalToXAndDontUnified(other).getX(),
                    this.intersectionPointIfTwoLinesVerticalToXAndDontUnified(other).getY());
            return intersectionPoint;
        }
        if (isIntersecting(other)) {
            if ((pointOfLinearIntersection(other) != null) && (onSegment(pointOfLinearIntersection(other), other))) {
                Point intersectionPoint = new Point(this.pointOfLinearIntersection(other).getX(),
                        this.pointOfLinearIntersection(other).getY());
                return intersectionPoint;
            }
            if (this.getSlope() == other.getSlope()) {
                if (this.getYIntercept() == other.getYIntercept()) {
                    if (!this.isUnified(other)) {
                        Point intersectionPoint = new Point(this.
                                intersectionPointIfTwoLinesParllalToSameYAndDontUnified(other).getX(),
                                this.intersectionPointIfTwoLinesParllalToSameYAndDontUnified(other).getY());
                        return intersectionPoint;

                    }
                }
            }

        }
        return null;
    }

    /**
     * This method check if two lines is unified.
     *
     * @param other
     * @return the method return a boolean.
     */


    public boolean isUnified(Line other) {
        if (isPointOnLineWithoutEdges(other.start, this)
                || isPointOnLineWithoutEdges(other.end, this)
                || isPointOnLineWithoutEdges(this.start, other)
                || isPointOnLineWithoutEdges(this.end, other) || this.equals(other)) {
            return true;
        }
        return false;
    }

    /**
     * This method check if two lines is unified.
     *
     * @param other
     * @return the method return a boolean.
     */

    public boolean isUnifiedCaseForVerticalToX(Line other) {
        if (this.start.getX() != other.start.getX()) {
            return false;
        }
        if (isPointOnLineWithoutEdgesCaseForVerticalToX(other.start, this)
                || isPointOnLineWithoutEdgesCaseForVerticalToX(other.end, this)
                || isPointOnLineWithoutEdgesCaseForVerticalToX(this.start, other)
                || isPointOnLineWithoutEdgesCaseForVerticalToX(this.end, other) || this.equals(other)) {
            return true;
        }
        return false;
    }

    /**
     * This method check if is point on line without Edges case for vertical to x.
     *
     * @param other
     * @param point
     * @return the method return a boolean.
     */

    public boolean isPointOnLineWithoutEdgesCaseForVerticalToX(Point point, Line other) {
        if ((((other.start.getY() < point.getY()) && (point.getY() < other.end.getY()))
                || ((other.start.getY() > point.getY()) && (point.getY() > other.end.getY())))) {
            return true;
        }
        return false;
    }

    /**
     * This method return a intersecion point if one line is vertical to x.
     *
     * @param noVerticalLine
     * @return the method return a point.
     */


    public Point intersectionPointIfOneLineVerticalToX(Line noVerticalLine) {
        if (((noVerticalLine.start.getX() <= this.start.getX()) && (this.start.getX() <= noVerticalLine.end.getX())
                || (noVerticalLine.end.getX() <= this.start.getX())
                && (this.start.getX() <= noVerticalLine.start.getX()))
                && ((this.start.getY() <= noVerticalLine.start.getY())
                && (noVerticalLine.start.getY() <= this.end.getY())
                || (this.end.getY() <= noVerticalLine.start.getY())
                && (noVerticalLine.start.getY() <= this.start.getY())
                || (this.start.getY() <= noVerticalLine.end.getY())
                && (noVerticalLine.end.getY() <= this.end.getY()
                || (this.end.getY() <= noVerticalLine.end.getY())
                && (noVerticalLine.end.getY() <= this.start.getY())))) {
            double x = this.start.getX();
            double y = ((noVerticalLine.getSlope()) * this.start.getX()) + noVerticalLine.getYIntercept();
            Point intersectionPoint = new Point(x, y);
            return intersectionPoint;
        }
        return null;
    }

    /**
     * This method return a intersecion point if two line is vertical to x and don't unify.
     *
     * @param other
     * @return the method return a point.
     */


    public Point intersectionPointIfTwoLinesVerticalToXAndDontUnified(Line other) {
        if (this.start.getY() == other.start.getY()) {
            double x = this.start.getX();
            double y = this.start.getY();
            Point intersectionPoint = new Point(x, y);
            return intersectionPoint;
        } else if (this.start.getY() == other.end.getY()) {
            double x = this.start.getX();
            double y = this.start.getY();
            Point intersectionPoint = new Point(x, y);
            return intersectionPoint;


        } else if (this.end.getY() == other.start.getY()) {
            double x = this.start.getX();
            double y = this.end.getY();
            Point intersectionPoint = new Point(x, y);
            return intersectionPoint;

        } else if (this.end.getY() == other.end.getY()) {
            double x = this.start.getX();
            double y = this.end.getY();
            Point intersectionPoint = new Point(x, y);
            return intersectionPoint;
        }
        return null;
    }

    /**
     * This method return a intersecion point if two line is parllal to same Y and don't unify.
     *
     * @param other
     * @return the method return a point.
     */

    public Point intersectionPointIfTwoLinesParllalToSameYAndDontUnified(Line other) {
        if (this.start.getX() == other.start.getX()) {
            double x = this.start.getX();
            double y = this.start.getY();
            Point intersectionPoint = new Point(x, y);
            return intersectionPoint;
        } else if (this.start.getX() == other.end.getX()) {
            double x = this.start.getX();
            double y = this.start.getY();
            Point intersectionPoint = new Point(x, y);
            return intersectionPoint;


        } else if (this.end.getX() == other.start.getX()) {
            double x = this.end.getX();
            double y = this.end.getY();
            Point intersectionPoint = new Point(x, y);
            return intersectionPoint;

        } else if (this.end.getX() == other.end.getX()) {
            double x = this.end.getX();
            double y = this.end.getY();
            Point intersectionPoint = new Point(x, y);
            return intersectionPoint;
        }
        return null;
    }

    /**
     * This method return a point that closest intersection to start of the line.
     *
     * @param rect
     * @return the method return a point.
     */

    public Point closestIntersectionToStartOfLine(Rectangle rect) {

        if (rect.intersectionPoints(this).size() == 0) {
            return null;
        }
        if (rect.intersectionPoints(this).size() == 1) {
            return rect.intersectionPoints(this).get(0);
        }
        if (rect.intersectionPoints(this).size() == 2) {
            double distance1 = this.start.distance(rect.intersectionPoints(this).get(0));
            double distance2 = this.start.distance(rect.intersectionPoints(this).get(1));
            if (distance1 < distance2) {
                return rect.intersectionPoints(this).get(0);
            }
            return rect.intersectionPoints(this).get(1);
        }
        return null;
    }

}


