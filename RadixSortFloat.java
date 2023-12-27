import java.util.Random;

//This program contains two 1D arrays
public class RadixSortFloat {
    // declare counter to count number of operations
    static int p_counter = 0;
    // number of input need to be generated
    private static int no_of_input = 8;
    // maximum value of input to be generated
    private static int MAX_VALUE = 1000;

    // main function
    public static void main(String[] args) {
        // The floating numbers are automatically generated & saved in initial array
        float[] initialArray = randomNum(MAX_VALUE, no_of_input);
        p_counter += 5;

        // declare integer array
        int[] intArray = new int[initialArray.length];
        p_counter += 4;

        p_counter += 2;
        // convert floating number of initial array to integer
        for (int i = 0; i < initialArray.length; i++) {
            intArray[i] = Float.floatToIntBits(initialArray[i]);
            p_counter += 7;
        }

        // Second array doesnt contains any numbers at the beginning
        int[] secondArray = new int[no_of_input];
        p_counter++;

        // The random generated floating number which is saved by initial array will be
        // printed
        System.out.print("Initial floating points:\t");
        printFloatResult(initialArray);
        p_counter++;

        // The int number convert from float number which is saved by integer array will
        // be printed
        System.out.print("Initial integers:\t");
        printResult(intArray);
        p_counter++;

        // Get the maximum value of integer array
        int maxValue = getMaxValue(intArray);
        p_counter += 4;

        // Initial the pass number as one
        int pass = 1;
        p_counter++;

        // Digit indicates the position of the numbers(1,10,100)
        // The looping wont be stopped unless the maximum value divide by number equal
        // to zero
        // Alternative sorting between integer array and second arrays
        p_counter++;
        for (int digit = 1; maxValue / digit > 0; digit *= 10) {
            p_counter += 3;

            // Integer array will sort the numbers, but the result will be saved in second
            // array
            if (pass % 2 == 1) {
                p_counter += 2;
                radixSort(intArray, secondArray, digit);
                System.out.print("\nAfter pass " + pass + ":");
                System.out.print("\nInteger:\t\t");
                printResult(secondArray);
                System.out.print("Floating Points:\t");
                printFloatResult(convertToFloatArray(secondArray));
                p_counter += 15;
            }

            // Second array will sort the numbers, but the result will be saved in integer
            // array
            else {
                radixSort(secondArray, intArray, digit);
                System.out.print("\nAfter pass " + pass + ":");
                System.out.print("\nInteger:\t\t");
                printResult(intArray);
                System.out.print("Floating Points:\t");
                printFloatResult(convertToFloatArray(intArray));
                p_counter += 15;
            }
            pass++;
            p_counter++;
        }

        // display sorted floating array
        System.out.println("\nSorted floating array:\t");
        printFloatResult(convertToFloatArray(intArray));
        p_counter += 6;

        // display number of primitive operations done
        System.out.println("Total primitive operations: " + p_counter);
    }

    // function to randomly generate a list of floating numbers
    private static float[] randomNum(float maxNum, int size) {
        Random random = new Random();
        float[] array = new float[size];
        p_counter += 2;

        p_counter++;
        for (int i = 0; i < size; i++) {
            // random generate a floating number to ith index
            // the numbers is generated between 0 and a max value
            array[i] = random.nextFloat() * maxNum;
            p_counter += 5;
        }
        p_counter++;
        // Return the floating numbers to be sorted
        return array;
    }

    // function to perform radix sort
    private static void radixSort(int[] num, int[] position, int digit) {
        // initialize array size as 10
        int[] counter = new int[10];
        p_counter += 2;

        // Count the occurences of every numbers
        p_counter++;
        for (int i = 0; i < num.length; i++) {
            int x = (num[i] / digit) % 10;

            // x will determine the position of the numbers
            counter[x]++;
            p_counter += 8;
        }

        // Store the cumulative count of the numbers
        p_counter++;
        for (int i = 1; i < 10; i++) {
            counter[i] += counter[i - 1];
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

    // function to print the result after converting to floating number
    private static void printFloatResult(float[] array) {
        p_counter++;
        for (float value : array) {
            System.out.print(value + " ");
            p_counter += 2;
        }
        System.out.println();
        p_counter++;
    }

    // function to convert the integer to floating number
    private static float[] convertToFloatArray(int[] array) {

        float[] floatArray = new float[array.length];
        p_counter++;

        p_counter++;
        for (int i = 0; i < array.length; i++) {
            floatArray[i] = Float.intBitsToFloat(array[i]);
            p_counter += 3;
        }
        p_counter++;
        return floatArray;
    }
}
