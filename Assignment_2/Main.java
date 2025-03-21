public class Main {

    public static int split(int args) {

        if (args >= 10) {

            String temp = Integer.toString(args);

            return Integer.valueOf(temp.charAt(0)) - 48 + Integer.valueOf(temp.charAt(1)) - 48;

            } else {

                return args;

            }
        }

    public static void custom_main(String number) {

        int temp = 0;
        int sum = 0;

        for (int i = 0; i < number.length(); i += 2) {

            temp = Integer.valueOf(number.charAt(i)) - 48;
            temp = temp * 2;
            split(temp);
            sum += temp;

        }

        for (int i = 1; i < number.length(); i += 2) {
            

            temp = Integer.valueOf(number.charAt(i)) - 48;
            sum += temp;

        }

        if (sum % 10 > 0) {

            System.out.println("This credit card number is invalid.");

        } else {

            System.out.println("This credit card number is valid.");

        }
    }

    public static void main(String[] args) {

        custom_main("4388576018402626");
        custom_main("1234567890");
        custom_main("4388576018402626");
        custom_main("4388576018410707");

    }

}