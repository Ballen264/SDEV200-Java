public class Main {
    public static void main(String[] args) {

        int[][] arr1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};

        int check_1 = 1;

        if (arr1.length == arr2.length) {

            for (int i = 0; i < arr1.length; i++) {

                if (arr1[i].length == arr2[i].length) {

                    for (int ii = 0; ii < arr1[i].length; ii++) {

                        if (arr1[i][ii] == arr2[i][ii]) {
                            
                            check_1 *= 1;

                        } else {

                            check_1 *= 0;

                        }

                    }

                } else {

                    check_1 *= 0;

                }

            }

        } else {

            check_1 *= 0;

        }

        if (check_1 == 1) {
            System.out.println("Arrays are same.");
        } else {
            System.out.println("Arrays aren't same.");
        }

    }

}