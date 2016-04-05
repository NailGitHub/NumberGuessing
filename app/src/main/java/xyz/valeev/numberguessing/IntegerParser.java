package xyz.valeev.numberguessing;

import java.util.Scanner;

/**
 * Created by HomeUser008 on 2016-03-31.
 */
public class IntegerParser {

    int parsedNumber = -1;

    public int parseNumber(String userString, int maxValue){

        // Trimming of possible space teckens
        String trimmedString = userString.trim();

        Scanner intScanner = new Scanner(trimmedString);

        if (intScanner.hasNextInt()) {
            parsedNumber = intScanner.nextInt();
        }

        if (parsedNumber<0|| parsedNumber >maxValue){

            parsedNumber = -1;
        }

        return parsedNumber;

    }

}

