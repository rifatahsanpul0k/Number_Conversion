import java.util.Arrays;
import java.util.Scanner;

public class NumberConversion {
    public static int[] conversion(double number, int selectNumber) {
        int div;
        switch (selectNumber) {
            case 1:
                div = 2;
                break;
            case 2:
                div = 8;
                break;
            case 3:
                div = 16;
                break;
            default:
                div = 2; // Default to binary if an invalid option is chosen
        }

        int duplicate = (int) number;
        int i = duplicate;
        int index = 0;
        int[] sum = new int[100]; // Initialize the sum array with a size

        while (i > 0) {
            sum[index] = i % div;
            i /= div;
            index++;
        }
        // Reverse the array
        for (i = 0; i < index / 2; i++) {
            int temp = sum[i];
            sum[i] = sum[index - i - 1];
            sum[index - i - 1] = temp;
        }

        index++;
        // Separate the fractional number
        double fractionalNumber = number - duplicate;
        int count = 0;
        while (count <= 3) {
            fractionalNumber *= div;
            sum[index] = (int) fractionalNumber;
            fractionalNumber -= sum[index];
            index++;
            count++;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Decimal Number to Convert: ");
        double number = input.nextDouble();
        System.out.println("Press any number: \n1. Decimal to Binary\n2. Decimal to Octal\n3. Decimal to Hexadecimal");
        int selectNumber = input.nextInt();
        int[] numbers = conversion(number, selectNumber);

        // Print the result
        System.out.println("Converted number: " + Arrays.toString(numbers));
    }
}
