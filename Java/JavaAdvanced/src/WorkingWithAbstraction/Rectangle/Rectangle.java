package WorkingWithAbstraction.Rectangle;


public class Rectangle {
    private Point2D bottomLeft;
    private Point2D topRight;

    public Rectangle(Point2D bottomLeft, Point2D topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point2D point2D) {
        return point2D.getX() >= bottomLeft.getX()
                && point2D.getY() >= bottomLeft.getY()
                && point2D.getY() <= topRight.getY();
    }
}
