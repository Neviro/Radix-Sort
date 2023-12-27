import java.util.Random;

//This program contains two 1D arrays
public class RadixSort2 {
    // declare counter to count number of operations
    static int p_counter = 0;
    // number of input need to be generated
    private static int input_size = 8;
    // maximum value of input to be generated
    private static int MAX_VALUE = 1000;

    // main function
    public static void main(String[] args) {
        // The numbers are automatically generated & saved in first array
        int[] first_array = RandomNum(MAX_VALUE, input_size);
        p_counter += 3;

        // Second array doesnt contains any numbers at the beginning
        int[] sec_array = new int[input_size];
        p_counter += 3;

        // The random generated number which is saved by first array will be printed
        System.out.print("Initial array:\t");
        printResult(first_array);
        p_counter += 2;

        // Get the maximum value of first array
        int MAX_VALUE = getMaxValue(first_array);
        p_counter += 2;

        // Initial the pass number as one
        int pass = 1;
        p_counter++;

        // Digit indicates the position of the numbers(1,10,100)
        // The looping wont be stopped unless the maximum value divide by number equal
        // to zero
        // Alternative sorting between first and second arrays
        p_counter++;
        for (int digit = 1; MAX_VALUE / digit > 0; digit *= 10) {
            p_counter += 3;

            // First array will sort the numbers, but the result will be saved in second
            // array
            if (pass % 2 == 1) {
                radixsort(first_array, sec_array, digit);
                System.out.print("\nAfter pass " + pass + ":\t");
                printResult(sec_array);
                p_counter += 5;
            }

            // Second array will sort the numbers, but the result will be saved in first
            // array
            else {
                radixsort(sec_array, first_array, digit);
                System.out.print("\nAfter pass " + pass + ":\t");
                printResult(first_array);
                p_counter += 3;
            }
            p_counter++;
            pass++;
        }

        // display number of primitive operations done
        System.out.println("Total primitive operations: " + p_counter);
    }

    // function to randomly generate a list of numbers
    private static int[] RandomNum(int maxNum, int size) {
        Random random = new Random();
        int[] array = new int[size];
        p_counter += 2;

        p_counter++;
        for (int i = 0; i < size; i++) {
            // random generate a number to ith index
            // the numbers is generated between 0 and a max value
            array[i] = random.nextInt(maxNum);
            p_counter += 4;
        }

        p_counter++;
        // Return the numbers to be sorted
        return array;
    }

    // function to perform radix sort
    private static void radixsort(int[] num, int[] position, int digit) {
        // initialize array size as 10
        int[] counter = new int[10];
        p_counter += 2;

        // Count the occurences of every numbers
        p_counter++;
        for (int i = 0; i < num.length; i++) {
            int x = (num[i] / digit) % 10;

            // x will determine the position of the numbers
            counter[x]++;
            p_counter += 9;
        }

        // Store the cumulative count of the numbers
        p_counter++;
        for (int i = 1; i < 10; i++) {
            counter[i] = counter[i] + counter[i - 1];
            p_counter += 6;
        }

        // Arrange the position
        p_counter++;
        for (int i = num.length - 1; i >= 0; i--) {
            int x = (num[i] / digit) % 10;
            position[--counter[x]] = num[i];
            p_counter += 9;
        }
    }

    // function to get the maximum value of array
    private static int getMaxValue(int[] array) {

        // Declare the first number as the first index
        int maxValue = array[0];
        p_counter++;

        // Compare the auto-generated numbers with the max number
        p_counter++;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
                p_counter += 5;
            }
        }

        // Return current max number
        p_counter++;
        return maxValue;
    }

    // function to print the result of radix sort
    private static void printResult(int[] array) {
        p_counter++;
        for (int value : array) {
            System.out.print(value + " ");
            p_counter += 2;
        }
        System.out.println();
        p_counter++;
    }
}