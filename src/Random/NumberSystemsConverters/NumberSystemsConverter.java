package Random.NumberSystemsConverters;

public class NumberSystemsConverter {

    public static void run() {
        System.out.println("Number systems\n");

        int decimal = 894;
        decimalToHexadecimal(decimal);
        System.out.println("Decimal to hexadecimal: " + decimal + " -> " + hexadecimal);
    }

    private static String hexadecimal = "";
    private static void decimalToHexadecimal(int decimal) {
        if (decimal == 0) return;
        double result = decimal / 16.0;
        int base = (int) result;
        double remainder = result - base;
        int newMsd = (int) (remainder * 16);
        String msd = "";
        if (newMsd < 10) {
            msd = String.valueOf(newMsd);
        } else {
            switch (newMsd) {
                case 10: msd = "A"; break;
                case 11: msd = "B"; break;
                case 12: msd = "C"; break;
                case 13: msd = "D"; break;
                case 14: msd = "E"; break;
                case 15: msd = "F"; break;
            }
        }
        hexadecimal = msd + hexadecimal;
        decimalToHexadecimal(base);
    }

}
