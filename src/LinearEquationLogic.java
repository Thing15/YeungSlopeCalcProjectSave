import java.util.Scanner;




public class LinearEquationLogic {


    private Scanner scan;


    private LinearEquation newEquation;
    private String coord1;
    private String coord2;
    private int x1;
    private int x2;
    private int y1;
    private int y2;


    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }


    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        getLinearEquationInfo();
        System.out.println(lineInfo());
        System.out.println(getXIntercept());
    }




    private void getLinearEquationInfo() {
        System.out.print("Enter coordinate 1: ");
        coord1 = scan.nextLine();
        if (coord1.contains(".")) {
            System.out.println("Invalid coordinate");
            while (coord1.contains(".")) {
                System.out.print("Enter coordinate 1: ");
                coord1 = scan.nextLine();
            }
        }
/*
       x1 = Integer.parseInt(coord1.substring(coord1.indexOf("("), coord1.indexOf(",")));
       y1 = Integer.parseInt(coord1.substring(coord1.indexOf(",") + 2, coord1.indexOf(")")));
*/
        System.out.print("Enter coordinate 2: ");
        coord2 = scan.nextLine();
        if (coord2.contains(".")) {
            System.out.println("Invalid coordinate");
            while (coord2.contains(".")) {
                System.out.print("Enter coordinate 2: ");
                coord2 = scan.nextLine();
            }
        }
/*
       x2 = Integer.parseInt(coord2.substring(coord2.indexOf("("), coord2.indexOf(",")));
       y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",") + 2, coord2.indexOf(")")));


*/
    }


    private String getXIntercept() {
        System.out.print("Enter a value for x: ");
        double xValue = scan.nextDouble();


        return "The point on the line is " + newEquation.coordinateForX(xValue);
    }
}
