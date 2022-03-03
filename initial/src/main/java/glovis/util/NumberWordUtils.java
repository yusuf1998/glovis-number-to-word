package glovis.util;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class NumberWordUtils {

    private static NumberWordUtils nw;
    public static String BLANK_SPACE = " ";
    public static String QUINTILLION = "quintillion";
    public static String QUADRILLION = "quadrillion";
    public static String TRILLION = "trillion";
    public static String BILLION = "billion";
    public static String MILLION = "million";
    public static String THOUSAND = "thousand";
    public static String HUNDRED = "hundred";

    public static Map<Integer, String> largeNumber =  new HashMap<Integer, String>() {{
        put(3, THOUSAND);
        put(6, MILLION);
        put(9, BILLION);
        put(12,TRILLION);
        put(15, QUADRILLION);
        put(18, QUINTILLION);
    }};

    public static String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    public static String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    public static NumberWordUtils getInstance() {
        if (nw == null) nw = new NumberWordUtils();

        return nw;
    }

    public String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20){
            soFar = numNames[number % 100];
            number /= 100;
        }
        else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + BLANK_SPACE + HUNDRED + soFar;
    }

    public boolean isNumeric(String string) {
        double decimalValue;

        System.out.println(String.format("Parsing string: \"%s\"", string));

        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            decimalValue = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

}
