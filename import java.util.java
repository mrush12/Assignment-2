import java.util.Scanner;

public class CreditCard {

    /** Return true if the card number is valid */
    public static boolean isValid(long number) {
        if (getSize(number) == 16) {
            int evenSum = sumOfDoubleEvenPlace(number);
            int oddSum = sumOfOddPlace(number);
            int total = oddSum + evenSum;
            return total % 10 == 0;
        }
        return false;
    }

    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0, count = 0;
        while (number > 0) {
            ++count;
            if (count % 2 == 0) {
                sum += getDigit((int) (2 * (number % 10)));
            }
            number /= 10;
        }
        return sum;
    }

    /**
     * Return this number if it is a single digit, otherwise,
     * return the sum of the two digits
     */
    public static int getDigit(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number) {
        int sum = 0, count = 0;
        while (number > 0) {
            ++count;
            if (count % 2 == 1) {
                sum += number % 10;
            }
            number /= 10;
        }
        return sum;
    }

    /** Return true if the digit d is a prefix for number */
    public static boolean prefixMatched(long number, int d) {
        int l1 = getSize(number);
        int l2 = getSize(d);
        return Math.floor(number / (Math.pow(10, l1 - l2))) == d;
    }

    /** Return the number of digits in d */
    public static int getSize(long d) {
        int count = 0;
        while (d > 9) {
            ++count;
            d /= 10;
        }
        return count + 1;
    }

    /**
     * Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number.
     */
    public static long getPrefix(long number, int k) {
        if (getSize(number) < k) {
            return number;
        } else {
            int l = getSize(number);
            return (long) Math.floor(number / (Math.pow(10, l - k)));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long number;
        System.out.print("Enter a credit card number as a long integer: ");
        number = in.nextLong();
        if (isValid(number)) {
            System.out.println(number + " is valid");
        } else {
            System.out.println(number + " is invalid");
        }
    }

}