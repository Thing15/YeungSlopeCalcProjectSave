import java.util.Scanner;

public class LinearEquationLogic {

    private Scanner scan;

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private LinearEquation newEquation;

    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }

    public void start() {
        boolean repeat = true;

        System.out.println("Welcome to the linear equation calculator!");

        while (repeat) {
            getLinearEquationInfo();
            System.out.println();
            newEquation = new LinearEquation(x1, y1, x2, y2);
            if (x1 == x2) {
                System.out.println("These points are on a vertical line: x = " + x1);
            } else {
                System.out.println(newEquation.lineInfo());
                System.out.println();
                System.out.println(getXIntercept());
            }

            System.out.println();
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            String choice = scan.nextLine().toLowerCase();
            if (choice.equals("n")) {
                repeat = false;
                System.out.println("Thank you for using the slope calculator, goodbye!");
            }
        }
    }

    public void getLinearEquationInfo() {
        System.out.print("Enter coordinate 1: ");
        String coord1 = scan.nextLine();
        if (coord1.contains(".")) {
            System.out.println("Invalid coordinate");
            while (coord1.contains(".")) {
                System.out.print("Enter coordinate 1: ");
                coord1 = scan.nextLine();
            }
        }

       x1 = Integer.parseInt(coord1.substring(coord1.indexOf("(") + 1, coord1.indexOf(",")));
       y1 = Integer.parseInt(coord1.substring(coord1.indexOf(",") + 2, coord1.indexOf(")")));

        System.out.print("Enter coordinate 2: ");
        String coord2 = scan.nextLine();
        if (coord2.contains(".")) {
            System.out.println("Invalid coordinate");
            while (coord2.contains(".")) {
                System.out.print("Enter coordinate 2: ");
                coord2 = scan.nextLine();
            }
        }

       x2 = Integer.parseInt(coord2.substring(coord2.indexOf("(") + 1, coord2.indexOf(",")));
       y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",") + 2, coord2.indexOf(")")));
    }

    private String getXIntercept() {
        System.out.print("Enter a value for x: ");
        double xValue = scan.nextDouble();
        scan.nextLine();

        System.out.println();
        return "The point on the line is " + newEquation.coordinateForX(xValue);
    }
}
