import java.util.Scanner;

public class Main {
  public static void main(String[] args) { // main method to run all code.
      Scanner inputs = new Scanner(System.in); // Creating Scanner object as input.
      System.out.println("Enter three sides of the triangle, a color, and a boolean value to indicate whether the triangle is filled: "); // Promts user for information.
      double inputSide1 = inputs.nextDouble(); // Reads input for double.
      double inputSide2 = inputs.nextDouble(); // Reads input for double.
      double inputSide3 = inputs.nextDouble(); // Reads input for double.
      inputs.nextLine(); // THIS STUPID BUG KEPT ON MAKING MY COLOR VARIABLE EMPTY. IT WAS A STUPID "\N" BEING SUBMITTED. I HATE THIS SO MUCH. AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH!!!!!!!!!!!!!!!!!!!!
      String inputColor = inputs.nextLine(); // Reads input for String.
      boolean inputBoolean = inputs.nextBoolean(); // Reads input for boolean.

      Triangle inputTriangle = new Triangle(inputSide1, inputSide2, inputSide3, inputColor, inputBoolean);

      System.out.println("The area of your triangle is " + inputTriangle.getArea() + ", the perimeter of your triangle is " + inputTriangle.getPerimeter() + ", the color of your triangle is " + inputTriangle.getColor() + ", and whether your triangle is filled or not is " + inputTriangle.isFilled());
      System.out.println(inputTriangle.toString());
      inputs.close();
  }
}

/*
I may not be able to submit a diagram of my code.
I was never really able to real or write in the UML diagram language, I have a lot of trouble understanding what it's trying to share.
I've typically used different types of diagrams to plan out my code.
*/