import java.util.ArrayList;
import java.util.Scanner;

class NumberConversion {
    public static String Hexadecimal(int number) {
        if (number <= 9) {
            return Integer.toString(number);
            //type casting the integer to character then applying the logic to find the hexadecimal value;
        } else {
            return Character.toString((char) ('A' + number - 10));
        }
    }

    public static ArrayList<String> ArrayToHexadecimal(ArrayList<Integer> array) {
        ArrayList<String> HexArray = new ArrayList<>();
        for (int num : array) {
            HexArray.add(Hexadecimal(num));
        }
        return HexArray;
    }

    public static ArrayList<Integer> conversion(double number, int selectNumber) {
        int real = (int) number;
        double fractional = number - real;
        ArrayList<Integer> result = new ArrayList<>();

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
                System.out.println("Enter between 1 to 3");
                return result; // Return an empty list if the input is invalid.
        }

        while (real > 0) {
            result.add(0, real % div);
            real = real / div;
        }
        if (number>(int)number) {
            result.add(-1); // Add the decimal point indicator
            int count = 0;
            while (count <= 4) {
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
               for (String str : result1){
                   result2.append(str);
               }
               String finalResult = result2.toString();
            System.out.println(finalResult);
        }
    }
}