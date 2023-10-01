package Lab2.Exo1.Bouchrika;

public class Converter {
    
    // Function to convert a decimal number to binary as a string
    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal /= 2;
        }
        
        return binary.toString();
    }
    
    // Function to convert a binary number (as a string) to decimal
    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 0;
        
        for (int i = binary.length() - 1; i >= 0; i--) {
            char digit = binary.charAt(i);
            if (digit == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        
        return decimal;
    }
}

class ConverterMain {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: program -b <decimal> (to convert decimal to binary)");
            System.out.println("       program -d <binary> (to convert binary to decimal)");
            System.out.println("       program -h (to show this help message)");
            return;
        }

        String option = args[0];

        if (option.equals("-b")) {
            int decimal = Integer.parseInt(args[1]);
            String binaryResult = Converter.decimalToBinary(decimal);
            System.out.println("Decimal to Binary: " + binaryResult);
        } else if (option.equals("-d")) {
            String binary = args[1];
            int decimalResult = Converter.binaryToDecimal(binary);
            System.out.println("Binary to Decimal: " + decimalResult);
        } else if (option.equals("-h")) {
            System.out.println("Usage: program -b <decimal> (to convert decimal to binary)");
            System.out.println("       program -d <binary> (to convert binary to decimal)");
        } else {
            System.out.println("Invalid usage. Use 'program -h' for help.");
        }
    }
}
