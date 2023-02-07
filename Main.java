import java.lang.Integer;
import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


class Main {
    public static String calc(String input) throws Exception {
        String rim[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String[] str;
        if (input.matches("([1-9]|10)\\s[-+*/]\\s([1-9]|10)")) {
            str = input.split("\\s");
            return String.valueOf(Main.sumOp(Integer.parseInt(str[0]), Integer.parseInt(str[2]), str[1].charAt(0)));
        } else if (input.matches("[IVX]+\\s[-+*/]\\s[IVX]+")) {
            str = input.split("\\s");
            int op1 = 0, op2 = 0;
            for (int i = 1; i < 11; i++) {
                if (str[0].equals(rim[i]))
                    op1 = i;
                if (str[2].equals(rim[i]))
                    op2 = i;
            }
            if (op1 == 0 || op2 == 0) {
                throw new Exception();
            }
            int res = Main.sumOp(op1, op2, str[1].charAt(0));
            if (res > 0) {
                return rim[res];
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }
    
    public static int sumOp(int op1, int op2, char sign) {
        switch(sign) {
            case '+': return op1 + op2;
            case '-': return op1 - op2;
            case '*': return op1 * op2;
            case '/': return op1 / op2;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            System.out.println(Main.calc(str));
        } catch (Exception exc) {
            System.out.println("throws Exception");
        }
    }
}
