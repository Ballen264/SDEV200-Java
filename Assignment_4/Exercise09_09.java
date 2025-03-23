public class Exercise09_09 {

  public static void main(String[] args) {

    RegularPolygon new_inst = new RegularPolygon();

    new_inst.reg_poly(new_inst.create_vals());
    new_inst.reg_poly(new_inst.create_vals(6, 4));
    new_inst.reg_poly(new_inst.create_vals(10, 4, 5.6, 7.8));

  }

}



class RegularPolygon {

  public static double[] create_vals(double... numbers) { // Method for creating default values.

    double n;
    double side;
    double x;
    double y;

    if (numbers.length == 0) {
      n = 3;
      side = 1;
      x = 0;
      y = 0;
    } else if (numbers.length == 1) {
      n = numbers[0];
      side = 1;
      x = 0;
      y = 0;
    } else if (numbers.length == 2) {
      n = numbers[0];
      side = numbers[1];
      x = 0;
      y = 0;
    } else if (numbers.length == 3) {
      n = numbers[0];
      side = numbers[1];
      x = numbers[2];
      y = 0;
    } else {
      n = numbers[0];
      side = numbers[1];
      x = numbers[2];
      y = numbers[3];
    }
    
    double[] ret_value = {n, side, x, y};
    return(ret_value);

  }



  private static double getPerimeter(double n, double side) { // method getPerimeter() that returns the perimeter of the polygon.
    return(side*n);
  }



  private static double getArea(double n, double side) { // method getArea() that returns the area of the polygon. Formula: (n*s**2)/(4*tan(pie/n)). Pie representation not given.

    double ret_area = (n*Math.pow(side,2))/(4*Math.tan(3.14159/n));

    return(ret_area);

  }

  public static void reg_poly(double... n) {// constructor that creates a regular polygon with the specified number of sides, length of side, and x- and y- coordinates.

    double getperim = getPerimeter(n[0], n[1]);
    double getarea = getArea(n[0], n[1]);

    System.out.println("Regular polygon that has " + n[1] + " sides, " + n[0] + " side length, " + getperim + " perimeter, " + getarea + " area, " + "and is at coordinates: (" + n[2] + ", " + n[3] + ").");
    
  }

  // Accessor and mutator methods for all data fields.


}