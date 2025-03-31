// GeometricObject.java: The abstract GeometricObject class
public abstract class GeometricObject {
  private String color = "white";
  private boolean filled;

  /**Default construct*/
  protected GeometricObject() {
  }

  /**Construct a geometric object*/
  protected GeometricObject(String color, boolean filled) {
    this.color = color;
    this.filled = filled;
  }

  /**Getter method for color*/
  public String getColor() {
    return color;
  }

  /**Setter method for color*/
  public void setColor(String color) {
    this.color = color;
  }

  /**Getter method for filled. Since filled is boolean,
     so, the get method name is isFilled*/
  public boolean isFilled() {
    return filled;
  }

  /**Setter method for filled*/
  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  /**Abstract method findArea*/
  public abstract double getArea();

  /**Abstract method getPerimeter*/
  public abstract double getPerimeter();
}



class Triangle extends GeometricObject { // New class holding assignments work. Attemting to use something unfamiliar, "extends class" is something I'm not too sure about and may remove.

  double side1; // Default values for the sides.
  double side2;
  double side3;
  double area;
  double perimeter;

  public Triangle() {
    side1 = 1; // Creating values within the Main method.
    side2 = 1;
    side3 = 1;

    double s = (side1 + side2 + side3)/2; // Area and perimeter formulas for retrieval.
    area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    perimeter = side1 + side2 + side3;
  }

  public Triangle(double d1, double d2, double d3, String color, boolean filled) {
    super(color, filled); // I'm a little bit skeptical about using super. To my understanding, this basically pulls the values of color and filled from the class above. I could very much be wrong. I'll do more research on it.
    side1 = d1;
    side2 = d2;
    side3 = d3;

    double s = (side1 + side2 + side3)/2; // Area and perimeter formulas for retrieval.
    area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    perimeter = side1 + side2 + side3;
  }

  /*

  One of the steps for the assignment is to make the following methods pull out information from the constructed objects. I can't find enough information to actually do that though.
  I was able to make the constructors create new objects with specified variables though, it's just a problem of getting other methods to pull information out of a given method, which I can't figure out how to do.

  Something I may do is simply sidestep a little bit of this stuff, I have variables labeled inside of the constructed objects capable of being called to gain the area, any side, or the perimeter.
  
  */
  
  public double get_side1() { // Gets side one length.
    return side1;
  }
  public double get_side2() { // Gets side two length.
    return side2;
  }
  public double get_side3() { // Gets side three length.
    return side3;
  }


  @Override // I was getting problems without an override, it was a suggested fix. There is most definitely a better way to handle this.
  public double getArea() { // Gets the area.
    return area;
  }
  @Override // I was getting problems without an override, it was a suggested fix. There is most definitely a better way to handle this.
  public double getPerimeter() { // Gets the perimeter.
    return perimeter;
  }



  public String toString() { // Prints out a string with details about an objects sides.
    return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3 + ", color = " + getColor() + ", filled = " + isFilled();
  } // The original toString only had the three sides. I am adding the color and isFilled for simplicity.

}