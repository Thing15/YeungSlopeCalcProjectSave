public class LinearEquation {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public double yIntercept() {
        return roundedToHundredth(y1 - (slope() * x1));
    }

    public double slope() {
        return (double) (y2 - y1) / (x2 - x1);
    }

    public String equation() {
        int changeY = y2 - y1;
        int changeX = x2 - x1;

        String slopeStr;
        if (changeY == 0) {
            return "y = " + yIntercept();
        } else if (slope() == 1) {
            slopeStr = "";
        } else if (slope() == -1) {
            slopeStr = "-";
        } else if (changeX == 1 || changeY % changeX == 0) {
            slopeStr = "" + (changeY / changeX);
        } else {
            if ((changeY > 0 && changeX < 0) || (changeY < 0 && changeX > 0)) {
                slopeStr = "-" + Math.abs(changeY) + "/" + Math.abs(changeX);
            } else {
                slopeStr = Math.abs(changeY) + "/" + Math.abs(changeX);
            }
        }

        String yInterceptStr = "";
        if (yIntercept() > 0) {
            yInterceptStr = " + " + yIntercept();
        } else if (yIntercept() < 0) {
            yInterceptStr = " - " + Math.abs(yIntercept());
        }

        return "y = " + slopeStr + "x" + yInterceptStr;
    }

    public String coordinateForX(double x) {
        return "(" + x + ", " + (slope() * x + yIntercept()) + ")";
    }

    public String lineInfo() {
        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")" + "\nThe equation of the line between these points is: " + equation() + "\nThe y-intercept of this line is: " + yIntercept() + "\nThe slope of this line is: " + slope() + "\nThe distance between these points is: " + distance();
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}
