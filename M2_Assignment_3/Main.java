public class Main {

    private static String checkValidation(String number) { // This method takes in a string and determines if it is capable of being understood as binary. Anything else will throw the printed exception.

        for (int i = 0; i < number.length(); i++) { // For loop going through given number.

            if (number.charAt(i) != '1' && number.charAt(i) != '0') { // A reverse or gate, it's shorter to use this rather than having the code check if the character is 1, or is 0.

                return("BinaryFormatException"); // This is supposed to throw an error complaining about the number not being binary.

            }

        }

        return(number); // This will return the number back to the code, increased usefullness.

    }

    public static void main(String[] args) { // main method to run the code above with various prompts. The assignment was just to make a custom error message.
        System.out.println("Start test.");

        System.out.println(checkValidation(""));
        System.out.println(checkValidation("101010101010101"));
        System.out.println(checkValidation("111122222111110000"));
        System.out.println(checkValidation("11111111111111"));
        System.out.println(checkValidation("99999999999998"));
        System.out.println(checkValidation("000000"));
        System.out.println(checkValidation("-fdsfsdfds"));

    }

}