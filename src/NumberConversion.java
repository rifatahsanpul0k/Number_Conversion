import java.util.ArrayList;
import java.util.Scanner;

class NumberConversion {
    // Convert a decimal number to a hexadecimal digit
    public static String Hexadecimal(int number) {
        if (number <= 9) {
            return Integer.toString(number); // If it's a digit 0-9, return the number as a string
        } else {
            // If it's 10 or greater, convert it to A-F using character mapping
            return Character.toString((char) ('A' + number - 10));
        }
    }

    // Convert an ArrayList of integers to hexadecimal digits
    public static ArrayList<String> ArrayToHexadecimal(ArrayList<Integer> array) {
        ArrayList<String> HexArray = new ArrayList<>();
        for (int num : array) {
            HexArray.add(Hexadecimal(num));
        }
        return HexArray;
    }

    // Perform decimal to binary, octal, or hexadecimal conversion
    public static ArrayList<Integer> conversion(double number, int selectNumber) {
        int real = (int) number; // Extract the integer part
        double fractional = number - real; // Extract the fractional part
        ArrayList<Integer> result = new ArrayList<>();

        int div;
        switch (selectNumber) {
            case 1:
                div = 2; // Binary conversion
                break;
            case 2:
                div = 8; // Octal conversion
                break;
            case 3:
                div = 16; // Hexadecimal conversion
                break;
            default:
                System.out.println("Enter between 1 to 3");
                return result; // Return an empty list if the input is invalid.
        }

        // Integer part conversion
        while (real > 0) {
            result.add(0, real % div);
            real = real / div;
        }

        // Fractional part conversion
        if (number > (int) number) {
            result.add(-1); // Add the decimal point indicator
            int count = 0;
            while (count <= 4) { // Convert up to 4 decimal places
                double newNum = fractional * div;
                if (newNum > 1) {
                    int newNum2 = (int) newNum;
                    result.add(newNum2);
                    fractional = newNum - newNum2;
                } else {
                    result.add(0);
                    fractional = newNum;
                    count++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        double number = input.nextDouble();
        System.out.println("1. Decimal to Binary\n2. Decimal to Octal\n3. Decimal to Hexadecimal\nSelect one from above.");
        int selectNumber = input.nextInt();
        ArrayList<Integer> result = NumberConversion.conversion(number, selectNumber);
        ArrayList<String> result1 = NumberConversion.ArrayToHexadecimal(result);
        if (selectNumber == 1 || selectNumber == 2) {
            if (!result.isEmpty()) {
                System.out.print("Result: ");
                for (int num : result) {
                    if (num == -1) {
                        System.out.print(".");
                    } else {
                        System.out.print(num);
                    }
                }
                System.out.println();
            }
        } else if (selectNumber == 3) {
            StringBuilder result2 = new StringBuilder();
            for (String str : result1) {
                result2.append(str);
            }
            String finalResult = result2.toString();
            System.out.println(finalResult);
        }
    }
}
