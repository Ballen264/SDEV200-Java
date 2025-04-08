import java.util.Scanner;

public class Main {

    public static void addition(double r1_numerator, double r1_denominator, double r2_numerator, double r2_denominator) {

        System.out.println(r1_numerator + '/' + r1_denominator + " + " + r2_numerator + '/' + r2_denominator + " = " + ((r1_numerator * r2_denominator) + (r2_numerator * r1_denominator)) + '/' + (r1_denominator * r2_denominator));

    }

    public static void subtraction(double r1_numerator, double r1_denominator, double r2_numerator, double r2_denominator) {

        System.out.println(r1_numerator + '/' + r1_denominator + " + " + r2_numerator + '/' + r2_denominator + " = " + ((r1_numerator * r2_denominator) - (r2_numerator * r1_denominator)) + '/' + (r1_denominator * r2_denominator));

    }

    public static void multiplication(double r1_numerator, double r1_denominator, double r2_numerator, double r2_denominator) {

        System.out.println(r1_numerator + '/' + r1_denominator + " + " + r2_numerator + '/' + r2_denominator + " = " + (r1_numerator * r2_numerator) + '/' + (r1_denominator * r2_denominator));

    }

    public static void division(double r1_numerator, double r1_denominator, double r2_numerator, double r2_denominator) {

        double new_numerator = r1_numerator * r2_denominator;
        double new_denominator = r2_numerator * r1_denominator;

        System.out.println(r1_numerator + '/' + r1_denominator + " + " + r2_numerator + '/' + r2_denominator + " = " + (new_numerator) + '/' + (new_denominator));

    }

    public static void finall(Double r2_numerator, Double r2_denominator) {

        System.out.println(r2_numerator + '/' + r2_denominator + " is " + (r2_numerator / r2_denominator));

    }

    public static void main(String[] args) {
        Scanner r1 = new Scanner(System.in);
        System.out.println("Enter rational r1 with numerator and denominator seperated by a space: ");
        String[] r1_nums = r1.nextLine().split(" ");

        Scanner r2 = new Scanner(System.in);
        System.out.println("Enter rational r2 with numerator and denominator seperated by a space: ");
        String[] r2_nums = r2.nextLine().split(" ");

        Double r1_numerator = Double.valueOf(r1_nums[0]);
        Double r1_denominator = Double.valueOf(r1_nums[1]);
        Double r2_numerator = Double.valueOf(r2_nums[0]);
        Double r2_denominator = Double.valueOf(r2_nums[1]);

        addition(r1_numerator, r1_denominator, r2_numerator, r2_denominator);
        subtraction(r1_numerator, r1_denominator, r2_numerator, r2_denominator);
        multiplication(r1_numerator, r1_denominator, r2_numerator, r2_denominator);
        division(r1_numerator, r1_denominator, r2_numerator, r2_denominator);
        finall(r2_numerator, r2_denominator);
    }
}