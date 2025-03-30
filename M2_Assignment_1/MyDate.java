public class MyDate {

    int year = 0;
    int month = 0; // 0 = January, 1 = Febuary, 2 = March, 3 = April, 4 = May, 5 = June, 6 = July, 7 = August, 8 = September, 9 = October, 10 = November, 11 = December.
    int day = 0;

    int cur_year = 2025; // As I have no idea how to get the current date using code, I simply placed them into values.
    int cur_month = 2; // These aren't meant to be changed unless you wish to check for specific days.
    int cur_day = 31;

    static long[] elaps_time = {1970, 0, 1};


    public long[] setDate(long elapsedTime) {
        long year = elapsedTime % 31536000000l;

        long month = elapsedTime % (31536000000l/12);

        while (month > 12) {
            month -= 12;
        }

        long day = elapsedTime % ((31536000000l/12)/30);

        while (day > 30) {
            day -= 30;
        }

        long[] array = {year, month, day};
        elaps_time = array;

        return(array);
    }


    public Object no_argObject() { // no arg that creates a MyDate object using the current date.
        int[] date = {cur_year, cur_month, cur_day};
        return(date);
    }


    static long[] elapsObject(long subject_year, long subject_month, long subject_day) { // elapsObject takes in a year, month, and day in integer form and calculates how much time has elapsed between that time and January 1, 1970.
        long elaps_year = elaps_time[0];
        long elaps_month = elaps_time[1];
        long elaps_day = elaps_time[2];
        long milliseconds_year = 31536000000l;

        long[] elapsed_time = {subject_year - elaps_year, subject_month - elaps_month, subject_day - elaps_day};

        return(elapsed_time);
    }


    static Object createObject(int subject_year, int subject_month, int subject_day) { // Creates a date for a specific date. Very simple.
        int[] date = {subject_year, subject_month, subject_day};
        return(date);
    }


    static long getYear(long[] date) { // This one is confusing, I don't know if the assignment wants me to grab the year out of a date from the other methods or what. I'm using the mentioned interpretation.
        return(date[0]);
    }


    static long getMonth(long[] date) { // This one is confusing, I don't know if the assignment wants me to grab the year out of a date from the other methods or what. I'm using the mentioned interpretation.
        return(date[1]);
    }


    static long getDay(long[] date) { // This one is confusing, I don't know if the assignment wants me to grab the year out of a date from the other methods or what. I'm using the mentioned interpretation.
        return(date[2]);
    }


    public static void main(String[] args) {
        // new MyDate(); // I don't understand what these are supposed to do.
        // System.out.println(getYear(elaps_time));
        // System.out.println(getMonth(elaps_time));
        // System.out.println(getDay(elaps_time));

        // new MyDate(34355555133101L); // I don't understand what these are supposed to do.
        // println(getYear(elapsObject(elaps_time))); // No date is provided for the elapsed time to calculate too.

        /*
        All the commented code is stuff that will crash.
        
        !!!!!!!!!!!!!!!!!!!!!!!!!!!!

        To my understanding, the elapsed time method is supposed to take a date, and compare it to a set date, returning the ekapsed time leftover.
        The textbook never grants a date that is supposed to be given as an argument to the method, so I have no idea of how that method is supposed to work now.

        Also to my understanding, the majority of the code should work period. It probably doesn't work as intended though.
        The main problem is my failure to understand what the textbook wants.
        I understand that in the work force, failure like this will get me kicked out, so I wish to remove that weakness while I am still learning.

        I could place the println statements inside of the elapsed time method so every time it compares, it prints it to the system.
        Another thing that I could be getting wrong is where the MyDate(numbers...) is actually going, this number may actually be going to the argument for the elapsed time method.
        If this is the case, then I shall create the code below.
        */
        long longNumber = 34355555133101L;
        long year = longNumber / 31536000000l;

        long month = longNumber / (31536000000l/12);

        while (month > 12) {
            month -= 12;
        }

        long day = longNumber / ((31536000000l/12)/30);

        while (day > 30) {
            day -= 30;
        }

        long[] array = {year, month, day};

        System.out.println(getYear(elapsObject(year, month, day))); // This here says that it is negative, this is correct. The sample number was smaller than the preset number.
        System.out.println(getMonth(elapsObject(year, month, day))); // This is the elapsed time after changing how the code works with the new interpretation.
        System.out.println(getDay(elapsObject(year, month, day)));

    }

}