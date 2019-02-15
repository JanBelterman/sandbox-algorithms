package Random.NumberSystemsConverters;

public class RecursiveBinaryToDecimal {

    public static void run() {
        System.out.println("Recursive binary to decimal\n");

        System.out.println(bin2decCutOffEnd("100111101110100"));
        System.out.println(bin2decCutOffBeginningSlow("100111101110100"));

        System.out.println(binaryToDecimalCutOffEnd("100111101110100"));
        System.out.println(binaryToDecimalCutOffBeginningSlow("100111101110100"));
        System.out.println(binaryToDecimalCutOffBeginningFast("100111101110100", 0));

        decimalToBinaryPrint(564789);
        System.out.println(s);
        System.out.println(decimalToBinary(10, 0b0));
    }

    private static int bin2decCutOffEnd(String binary) {
        if (binary.length() <= 0) return 0; // Stop criteria
        String now = binary.substring(binary.length() - 1, binary.length()); // Get last digit
        String later = binary.substring(0, binary.length() - 1); // Get other digits
        return Integer.parseInt(now) + (2 * bin2decCutOffEnd(later)); // Recursive calculation
    }

    private static int bin2decCutOffBeginningSlow(String binary) {
        int length = binary.length();
        if (length <= 0) return 0; // Stop criteria
        String now = binary.substring(0, 1); // Get first digit
        String later = binary.substring(1); // Get other digits
        return Integer.parseInt(now) * (int)Math.pow(2, length - 1) + bin2decCutOffBeginningSlow(later); // Recursive calculation
    }

    private static int binaryToDecimalCutOffEnd(String binary) {
        if (binary.length() == 0) return 0;
        return Integer.parseInt(binary.substring(binary.length() - 1)) + 2 * binaryToDecimalCutOffEnd(binary.substring(0, binary.length() - 1));
    }

    private static int binaryToDecimalCutOffBeginningSlow(String binary) {
        if (binary.length() == 0) return 0;
        return Integer.parseInt(binary.substring(0, 1)) * (int) Math.pow(2, binary.length() - 1) + binaryToDecimalCutOffBeginningSlow(binary.substring(1));
    }

    private static int binaryToDecimalCutOffBeginningFast(String binary, int result) {
        result = result * 2 + Integer.parseInt(binary.substring(0, 1));
        if (binary.length() > 1) return binaryToDecimalCutOffBeginningFast(binary.substring(1), result);
        return result;
    }

    private static String s = "";
    private static void decimalToBinaryPrint(int value) {
        if (value == 0) return;
        int quotient = value / 2;
        int rest = value % 2;
        s = rest + s;
        decimalToBinaryPrint(quotient);
    }

    private static int decimalToBinary(int value, int binary) {
        if (value == 0) return binary;
        int quotient = value / 2;
        int rest = value % 2;
        if (rest == 1) {
            binary += 0b1;
        }
        binary = binary * 10;
        return decimalToBinary(quotient, binary);
    }

}
