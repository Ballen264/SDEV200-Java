

public class Main {



    static int length_check(String number) { // Check if number is between 13 and 16 characters.
    
        if (number.length() >= 14 && number.length() <= 17) {
            return(1);
        } else {
            return(0);
        }

    } // Return True or False (1, 0) Stage_1



    static int check_1(String number) {// Check if number starts with 4, 5, 37, or 6.

        if (String.valueOf(number.charAt(0)).equals("4") == true) {
            return(1);
        } else if (String.valueOf(number.charAt(0)).equals("5") == true) {
            return(1);
        } else if (String.valueOf(number.charAt(0)).equals("6") == true) {
            return(1);
        } else if ((String.valueOf(number.charAt(0)) + String.valueOf(number.charAt(1))).equals("37") == true) {
            return(1);
        } else {
            return(0);
        }

    }// Return True or False (1, 0) Stage_2



    static String step_1(String number) {// Create a new string of every other character starting from the right exempting the last character.

        String new_String = "";

        for (int i = number.length() - 1; i >= 1; i -= 2) {

            new_String += String.valueOf(number.charAt(i));
            
        }

        return(new_String);

    }// Return string Stage_3



    static int seperate(int number) {// Take 2 character long string and add ints together.
    
        if (number >= 10) {

            String temp = Integer.toString(number);

            return(Integer.valueOf(temp.charAt(0)) - 48 + Integer.valueOf(temp.charAt(1)) - 48);
            
        } else {

            return(number);

        }
    
    }// Return int



    static int step_2(String number) {// Take string and double every character. Ints greater than or equal to 10 go through above method.
    
        int sum = 0;

        for (int i = 1; i < number.length(); i++) {

            int temp_int = Integer.valueOf(number.charAt(i - 1)) - 24;

            sum += seperate(temp_int);
            
        }

        return(sum);

    }// Return int Stage_4



    static int step_3(String number) {// Create new int from every other character in number being added together.

        Integer new_int = 0;
    
        for (int i = number.length(); i >= 1; i -= 2) {

            new_int += Integer.valueOf(number.charAt(i - 1));
            
        }

        return(new_int);

    }// Return int Stage_5



    static int step_4(int int1, int int2) {// Add both ints together.
    
        return(int1 + int2);
    
    }// Return sum of ints Stage_6



    static int step_5(int ints) {// Check if sum of ints is divisible by 10.
    
        if (ints%10 == 0) {

            return(1);

        } else {

            return(0);

        }
    
    }// Return True or False (1,0) Stage_7


    static String run_code(String number) {// Takes input and runs through all code.
    
        int stage_1 = length_check(number); // True or False
        int stage_2 = check_1(number); // True or False
        String stage_3 = step_1(number);
        int stage_4 = step_2(stage_3);
        int stage_5 = step_3(number);
        int stage_6 = step_4(stage_4, stage_5);
        int stage_7 = step_5(stage_6); // True or False

        if (stage_1 * stage_2 * stage_7 == 1) {

            return("This number is valid.");

        } else {

            return("This number is invalid.");

        }
    
    }// Returns to main



    public static void main(String[] args) {// main method to run code.

        // String[] number = {"4388576018410707", "0000000000000", "4388576018410707"}; Testing inputs.

        for(int i = 0; i < args.length; i++) {

            System.out.println(run_code(args[i]));

        }

    }// Prints out results.

}